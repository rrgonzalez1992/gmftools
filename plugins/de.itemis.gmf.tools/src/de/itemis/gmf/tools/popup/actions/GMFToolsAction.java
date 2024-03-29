/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.itemis.gmf.tools.popup.actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IActionDelegate;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import de.itemis.gmf.tools.preferences.GmfModel;
import de.itemis.gmf.tools.preferences.PreferenceUtil;

public abstract class GMFToolsAction implements IObjectActionDelegate {

	protected Shell shell;
	protected List<GmfModel> gmfModels;
	protected String fileExtension;

	/**
	 * Constructor for Action1.
	 */
	public GMFToolsAction(String fileExtension) {
		super();
		gmfModels = new ArrayList<GmfModel>();
		this.fileExtension = fileExtension;
	}

	/**
	 * @see IObjectActionDelegate#setActivePart(IAction, IWorkbenchPart)
	 */
	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		shell = targetPart.getSite().getShell();
	}

	/**
	 * @see IActionDelegate#selectionChanged(IAction, ISelection)
	 */
	public void selectionChanged(IAction action, ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if (!structuredSelection.isEmpty()) {
				gmfModels.clear();
				List<GmfModel> registeredGmfModels = PreferenceUtil
						.getGmfModels();
				for (Iterator<?> iter = structuredSelection.iterator(); iter
						.hasNext();) {
					Object selectedElement = iter.next();
					if (selectedElement instanceof IFile) {
						IFile selectedFile = (IFile) selectedElement;
						String fileExtension = selectedFile.getFileExtension();
						if (!this.fileExtension.equals(fileExtension)) {
							gmfModels.clear();
							action.setEnabled(false);
							return;
						}
						for (GmfModel registeredGmfModel : registeredGmfModels) {
							if (registeredGmfModel.hasFile(selectedFile)) {
								action.setEnabled(true);
								gmfModels.add(registeredGmfModel);
								break;
							}
						}
					}
				}
				if (!gmfModels.isEmpty()) {
					return;
				}
			}
		}
		action.setEnabled(false);
	}

}
