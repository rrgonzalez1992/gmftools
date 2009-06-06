/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.itemis.gmf.tools.contribution;

import java.io.ByteArrayInputStream;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;

import de.itemis.gmf.tools.FileUtil;
import de.itemis.gmf.tools.IGmfGenModelTransformer;
import de.itemis.gmf.tools.preferences.GmfModel;

public class GmfGenModelTransformer {

	public static boolean createOrGetTransformationFile(GmfModel gmfModel,
			IProgressMonitor monitor) {
		try {
			IFile gmfGenModel = gmfModel.getGmfGenModelFile();
			if (gmfGenModel == null)
				return false;
			gmfGenModel.getParent().refreshLocal(IResource.DEPTH_ONE, monitor);
			IFile trafoFile = gmfModel.getGmfTrafoFile();
			if (!trafoFile.exists()) {
				monitor.subTask("Creating Xtend transformation");
				StringBuffer b = new StringBuffer();
				b.append("import gmfgen;\n");
				b.append("import ecore;\n\n");
				b.append("// transforms the given GMFGenModel\n");
				b
						.append("List[emf::EObject] transform(List[emf::EObject] gmfGenModelContents) :\n");
				b
						.append("   gmfGenModelContents.eAllContents.typeSelect(GenPlugin).setPrintingEnabled(true) ->\n");
				b.append("   gmfGenModelContents;\n");

				trafoFile.create(new ByteArrayInputStream(b.toString()
						.getBytes()), true, new NullProgressMonitor());
				trafoFile.getParent().refreshLocal(IResource.DEPTH_ONE,
						new NullProgressMonitor());
			}
			monitor.worked(1);
			return true;
		} catch (Exception exc) {
			MessageDialog.openError(Display.getDefault().getActiveShell(),
					"Error accessing transformation file", exc.getMessage());
		}
		return false;
	}

	public static boolean transformGmfGenModelFile(GmfModel gmfModel,
			IProgressMonitor monitor) {
		try {
			IFile gmfGenModelFile = gmfModel.getGmfGenModelFile();
			IFile transformationFile = gmfModel.getGmfTrafoFile();
			IFile transformedGmfGenModelFile = gmfModel
					.getTransformedGmfGenModelFile();
			if (gmfGenModelFile == null || transformationFile == null
					|| transformedGmfGenModelFile == null) {
				return false;
			}
			gmfGenModelFile.getParent().refreshLocal(IResource.DEPTH_ONE,
					monitor);
			monitor.subTask("Transforming GMF generator model");
			ResourceSet resourceSet = new ResourceSetImpl();
			List<EObject> transformedGenModel = IGmfGenModelTransformer.Registry.create().transformGmfGenModel(
					gmfGenModelFile, transformationFile, resourceSet);

			URI transformedGenModelURI = FileUtil
					.getURI(transformedGmfGenModelFile);
			Resource transformedGenModelResource = resourceSet
					.createResource(transformedGenModelURI);
			transformedGenModelResource.getContents().addAll(
					transformedGenModel);
			transformedGenModelResource.save(null);
			monitor.worked(1);
			return true;
		} catch (Exception exc) {
			MessageDialog.openError(Display.getDefault().getActiveShell(),
					"Error transforming GMF GenModel", exc.getMessage());
		}
		return false;
	}
}
