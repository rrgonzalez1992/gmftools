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
import de.itemis.gmf.tools.preferences.PreferenceUtil;

public class GmfMappingToGenModelTransformer {

	@SuppressWarnings("restriction")
	public static IFile transformMapToGmfGenModel(IFile gmfMappingModel,
			IFile genModel, IFile gmfGenModel, IProgressMonitor monitor) {
		try {
			monitor
					.subTask("Creating GMF generator model from GMF mapping model");
			gmfMappingModel.getParent().refreshLocal(IResource.DEPTH_ONE,
					monitor);
			if(PreferenceUtil.isDeleteGmfGen() && gmfGenModel.exists()) {
				gmfGenModel.delete(true, monitor);
			}
			final ResourceSet rs = new ResourceSetImpl();
			TransformToGenModelOperation op = new TransformToGenModelOperation(
					rs);
			configureOptions(op.getOptions());
			op.loadMappingModel(FileUtil.getURI(gmfMappingModel),
					new NullProgressMonitor());
			op.loadGenModel(FileUtil.getURI(genModel),
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
			return gmfGenModel;
		} catch (CoreException ce) {
			MessageDialog.openError(Display.getDefault().getActiveShell(),
					"Error transforming map model", ce.getMessage());
		}
		return null;
	}

	@SuppressWarnings("restriction")
	protected static void configureOptions(TransformOptions options) {
		options.setUseRuntimeFigures(true);
		options.setUseMapMode(true);
		options.setGenerateRCP(false);
	}
}