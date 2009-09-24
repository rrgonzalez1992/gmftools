/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.itemis.gmf.tools.contribution;

import java.util.Collections;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import de.itemis.gmf.tools.Activator;
import de.itemis.gmf.tools.preferences.GmfModel;
import de.itemis.gmf.tools.preferences.PreferenceUtil;

public class GMFToolsHandler extends AbstractHandler {

	public static final String GENERATE_LATEST_COMMAND_ID = "de.itemis.gmf.tools.commands.generateLatest";
	public static final String GENERATE_PREDEFINED_COMMAND_ID = "de.itemis.gmf.tools.commands.generatePredefined";

	public static final String GMF_TOOLS_CONFIG_PARAMETER_TYPE_ID = "de.itemis.gmf.tools.commands.parameter.type.gmfConfig";
	public static final String GMF_TOOLS_CONFIG_PARAMETER_ID = "de.itemis.gmf.tools.commands.parameter.gmfConfig";

	public static final String GMF_TOOLS_CONFIG_PARAMETER_NAME = "de.itemis.gmf.tools.commands.parameter.gmfConfig";

	private GmfModel lastGmfModel;

	private IWorkbenchWindow window;

	private GmfModel gmfModel;

	public GMFToolsHandler() {
	}

	public Object execute(ExecutionEvent event) throws ExecutionException {
		window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		try {
			gmfModel = getGmfModel(event);
			if (gmfModel != null) {
				new ProgressMonitorDialog(window.getShell()).run(false, true,
						new GMFToolsGeneration(gmfModel, Collections
								.<String, Boolean> emptyMap()));
			} else {
				MessageDialog
						.openInformation(
								window.getShell(),
								"No GMF file set selected",
								"Go to Preferences -> GMF Tools and create a set of files for the editor first.");
			}
		} catch (Exception e) {
			reportError(e);
		}
		return null;
	}

	private void reportError(Exception e) {
		MessageDialog.openError(window.getShell(), "Error", e.getMessage());
		Activator.getDefault().getLog().log(
				new Status(IStatus.ERROR, Activator.PLUGIN_ID,
						"Error executing GMF action", e));
	}

	private GmfModel getGmfModel(ExecutionEvent event)
			throws ExecutionException {
		if (event != null) {
			String parameter = event
					.getParameter(GMF_TOOLS_CONFIG_PARAMETER_NAME);
			if (parameter != null) {
				return (GmfModel) new GmfModel.Factory().deserialize(parameter);
			}
		}
		ISelection selection = window.getSelectionService().getSelection();
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if (!structuredSelection.isEmpty()) {
				Object selectedElement = structuredSelection.getFirstElement();
				if (selectedElement instanceof IFile) {
					for (GmfModel gmfModels : PreferenceUtil.getGmfModels()) {
						if (gmfModels.hasFile((IFile) selectedElement))
							lastGmfModel = gmfModels;
					}
				}

			}
		}
		return lastGmfModel;
	}

}
