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
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gmf.codegen.gmfgen.GMFGenPackage;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.m2t.type.emf.EmfRegistryMetaModel;
import org.eclipse.swt.widgets.Display;
import org.openarchitectureware.expression.ExecutionContextImpl;
import org.openarchitectureware.xtend.XtendFacade;

import de.itemis.gmf.tools.FileUtil;

public class GmfGenModelTransformer {

	public static IFile createOrGetTransformationFile(IFile gmfGenModel,
			IProgressMonitor monitor) {
		try {
			gmfGenModel.getParent().refreshLocal(IResource.DEPTH_ONE, monitor);
			IFile trafoFile = FileUtil.getSiblingWithExtension(gmfGenModel,
					"ext");
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
			return trafoFile;
		} catch (Exception exc) {
			MessageDialog.openError(Display.getDefault().getActiveShell(),
					"Error accessing transformation file", exc.getMessage());
		}
		return null;

	}

	@SuppressWarnings("unchecked")
	public static boolean transformGmfGenModelFile(IFile gmfGenModelFile,
			IFile transformationFile, IFile transformedGmfGenModelFile, IProgressMonitor monitor) {
		try {
			gmfGenModelFile.getParent().refreshLocal(IResource.DEPTH_ONE,
					monitor);
			monitor.subTask("Transforming GMF generator model");
			ResourceSet resourceSet = new ResourceSetImpl();
			URI genModelResourceURI = FileUtil.getURI(gmfGenModelFile);
			Resource genModelResource = resourceSet.getResource(
					genModelResourceURI, true);
			EmfRegistryMetaModel emfRegistryMetaModel = new EmfRegistryMetaModel() {
				@Override
				protected EPackage[] allPackages() {
					return new EPackage[] { GMFGenPackage.eINSTANCE,
							EcorePackage.eINSTANCE };
				}
			};
			ExecutionContextImpl executionContext = new ExecutionContextImpl();
			executionContext.registerMetaModel(emfRegistryMetaModel);
			XtendFacade facade = XtendFacade.create(executionContext, FileUtil
					.getLocationWithoutExtension(transformationFile));
			List<EObject> transformedGenModel = (List<EObject>) facade.call(
					"transform", genModelResource.getContents());
			
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
