/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.itemis.gmf.tools.contribution;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.operation.IRunnableWithProgress;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import de.itemis.gmf.tools.Activator;
import de.itemis.gmf.tools.FileUtil;
import de.itemis.gmf.tools.preferences.PreferenceUtil;

public class GMFToolsHandler extends AbstractHandler implements
		IRunnableWithProgress {

	private IFile lastGmfFile;

	private IWorkbenchWindow window;

	private boolean isOK;

	private Set<IFile> changedGmfGenModels;

	public GMFToolsHandler() {
	}

	public Object execute(ExecutionEvent event) throws ExecutionException {
		window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		IFile baseFile = getBaseFile();
		if (baseFile != null) {
			try {
				new ProgressMonitorDialog(window.getShell()).run(false, true,
						this);
				if (isOK) {
					for (IFile gmfGenModel : changedGmfGenModels) {
						GmfDiagramCodeGenerator
								.generateDiagramCode(gmfGenModel);
					}
				}
			} catch (Exception e) {
				reportError(e);
			}
		} else {
			MessageDialog.openInformation(window.getShell(),
					"No GMF file selected",
					"Select a GMF related file and try again.");
		}
		return null;
	}

	public void run(IProgressMonitor monitor) throws InvocationTargetException,
			InterruptedException {
		try {
			IFile baseFile = getBaseFile();
			IFile genModel = getGmfFile("genmodel", baseFile);
			IFile gmfMappingModel = getGmfFile("gmfmap", baseFile);
			IFile generatedGmfGenModel = getGmfFile("gmfgen", baseFile);

			changedGmfGenModels = new HashSet<IFile>();
			isOK = false;
			monitor.beginTask("Creating transformed GMF generator model", 5);
			if (PreferenceUtil.isTransformMap2GmfGen() && genModel != null
					&& gmfMappingModel != null && generatedGmfGenModel != null) {
				generatedGmfGenModel = GmfMappingToGenModelTransformer
						.transformMapToGmfGenModel(gmfMappingModel, genModel,
								generatedGmfGenModel, monitor);
				isOK = generatedGmfGenModel != null;
				if (!isOK) {
					return;
				}
				if (!PreferenceUtil.isTransformGmfGen()) {
					changedGmfGenModels.add(generatedGmfGenModel);
				}
			}
			if (PreferenceUtil.isTransformGmfGen()
					&& generatedGmfGenModel != null) {
				IFile gmfGenTrafoFile = GmfGenModelTransformer
						.createOrGetTransformationFile(generatedGmfGenModel,
								monitor);
				isOK = gmfGenTrafoFile != null;
				if (!isOK) {
					return;
				}
				IFile transformedGmfGenModelFile = getGmfFile(
						"transformed.gmfgen", generatedGmfGenModel);
				isOK = GmfGenModelTransformer.transformGmfGenModelFile(
						generatedGmfGenModel, gmfGenTrafoFile,
						transformedGmfGenModelFile, monitor);
				if (!isOK) {
					return;
				}
				PreferenceUtil.addGmfGenModel(transformedGmfGenModelFile);
				changedGmfGenModels.add(transformedGmfGenModelFile);
			}
			if (PreferenceUtil.isFixTypeRegistration()) {
				isOK = GmfGenModelTypeRegistryHarmonizer
						.harmonizeTypeRegistration(PreferenceUtil
								.getGmfGenModels(), changedGmfGenModels, monitor);
				if (!isOK) {
					return;
				}
			}
			if (PreferenceUtil.isDeleteDiagramPlugin()
					&& !changedGmfGenModels.isEmpty()) {
				isOK = GmfGeneratedPluginRemover.deleteGeneratedPlugins(
						changedGmfGenModels, monitor);
			}
		} catch (Exception exc) {
			reportError(exc);
			isOK = false;
		}
	}

	private void reportError(Exception e) {
		MessageDialog.openError(window.getShell(), "Error", e
				.getMessage());
		Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, "Error executing GMF action", e));
	}

	private IFile getBaseFile() {
		ISelection selection = window.getSelectionService().getSelection();
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if (!structuredSelection.isEmpty()) {
				Object selectedElement = structuredSelection.getFirstElement();
				if (selectedElement instanceof IFile) {
					return (IFile) selectedElement;
				}

			}
		}
		return lastGmfFile;
	}

	private IFile getGmfFile(String extension, IFile baseFile) {
		if (baseFile != null) {
			IFile gmfFile = FileUtil.getSiblingWithExtension(baseFile,
					extension);
			if (gmfFile.exists()) {
				lastGmfFile = gmfFile;
			}
			return gmfFile;
		}
		return null;
	}

}
