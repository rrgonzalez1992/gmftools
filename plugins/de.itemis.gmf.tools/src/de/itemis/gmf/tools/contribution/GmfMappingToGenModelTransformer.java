/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.itemis.gmf.tools.contribution;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gmf.internal.bridge.transform.TransformOptions;
import org.eclipse.gmf.internal.bridge.transform.TransformToGenModelOperation;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;

import de.itemis.gmf.tools.FileUtil;
import de.itemis.gmf.tools.preferences.GmfModel;

@SuppressWarnings("restriction")
public class GmfMappingToGenModelTransformer {

	public static boolean transformMapToGmfGenModel(GmfModel gmfModel,
			boolean deleteGmfGenModel, IProgressMonitor monitor) {
		try {
			IFile gmfGenModel = gmfModel.getGmfGenModelFile();
			IFile gmfMapModel = gmfModel.getGmfMapModelFile();
			IFile emfGenModel = gmfModel.getGenModelFile();
			if (emfGenModel == null || gmfMapModel == null
					|| gmfGenModel == null)
				return false;
			monitor
					.subTask("Creating GMF generator model from GMF mapping model");
			gmfMapModel.getParent().refreshLocal(IResource.DEPTH_ONE, monitor);
			if (deleteGmfGenModel && gmfGenModel.exists()) {
				gmfGenModel.delete(true, monitor);
			}
			final ResourceSet rs = new ResourceSetImpl();
			TransformToGenModelOperation op = new TransformToGenModelOperation(
					rs);
			configureOptions(op.getOptions());
			op.loadMappingModel(FileUtil.getURI(gmfMapModel),
					new NullProgressMonitor());
			op.loadGenModel(FileUtil.getURI(emfGenModel),
					new NullProgressMonitor());
			op.setGenURI(FileUtil.getURI(gmfGenModel));
			IStatus status = op
					.executeTransformation(new NullProgressMonitor());
			if (!status.isOK()) {
				throw new CoreException(status);
			}
			gmfGenModel.refreshLocal(IResource.DEPTH_ONE,
					new NullProgressMonitor());
			monitor.worked(1);
			return true;
		} catch (CoreException ce) {
			MessageDialog.openError(Display.getDefault().getActiveShell(),
					"Error transforming map model", ce.getMessage());
		}
		return false;
	}

	protected static void configureOptions(TransformOptions options) {
		options.setUseRuntimeFigures(true);
		options.setUseMapMode(true);
		options.setGenerateRCP(false);
	}
}
