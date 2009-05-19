/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.itemis.gmf.tools.contribution;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.codegen.gmfgen.GMFGenPackage;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.m2t.type.emf.EmfRegistryMetaModel;
import org.eclipse.swt.widgets.Display;
import org.openarchitectureware.OawPlugin;
import org.openarchitectureware.core.IOawProject;
import org.openarchitectureware.core.IOawResource;
import org.openarchitectureware.core.builder.OawNature;
import org.openarchitectureware.core.internal.OawProject;
import org.openarchitectureware.expression.ExecutionContextImpl;
import org.openarchitectureware.expression.ResourceManager;
import org.openarchitectureware.expression.ResourceManagerDefaultImpl;
import org.openarchitectureware.expression.ResourceParser;
import org.openarchitectureware.expression.TypeSystemImpl;
import org.openarchitectureware.xtend.XtendFacade;

import de.itemis.gmf.tools.FileUtil;
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

	@SuppressWarnings("unchecked")
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
			final List<EPackage> metaModelPackages = findMetaModelPackages(resourceSet);
			URI genModelResourceURI = FileUtil.getURI(gmfGenModelFile);
			Resource genModelResource = resourceSet.getResource(
					genModelResourceURI, true);
			TypeSystemImpl ts = new TypeSystemImpl();
			ts.registerMetaModel(new EmfRegistryMetaModel() {
				@Override
				protected EPackage[] allPackages() {
					return metaModelPackages
							.toArray(new EPackage[metaModelPackages.size()]);
				}
			});
			ExecutionContextImpl context = new ExecutionContextImpl(
					new WorkspaceResourceManager(OawPlugin.getOawModelManager()
							.findProject(gmfGenModelFile.getProject())), ts,
					null);
			XtendFacade facade = XtendFacade.create(context, FileUtil
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

	private static List<EPackage> findMetaModelPackages(ResourceSet resourceSet) {
		final List<EPackage> metamodels = new ArrayList<EPackage>();
		EcoreUtil.resolveAll(resourceSet);
		for (Resource resource : resourceSet.getResources()) {
			TreeIterator<EObject> allContents = resource.getAllContents();
			if (allContents.hasNext()) {
				EObject rootObject = allContents.next();
				if (rootObject instanceof EPackage)
					metamodels.add((EPackage) rootObject);
			}
		}
		if (!metamodels.contains(GMFGenPackage.eINSTANCE)) {
			metamodels.add(GMFGenPackage.eINSTANCE);
		}
		if (!metamodels.contains(EcorePackage.eINSTANCE)) {
			metamodels.add(EcorePackage.eINSTANCE);
		}
		if (!metamodels.contains(GenModelPackage.eINSTANCE)) {
			metamodels.add(GenModelPackage.eINSTANCE);
		}
		return metamodels;
	}

	public static IOawProject createProject(IProject project) {
		if (project == null)
			return null;
		final IJavaProject asJavaProject = JavaCore.create(project);
		try {
			if (asJavaProject != null
					&& project.getProject().isAccessible()
					&& project.getProject()
							.isNatureEnabled(OawNature.NATURE_ID))
				return new OawProject(asJavaProject);
		} catch (final CoreException e) {
			MessageDialog
					.openError(
							Display.getDefault().getActiveShell(),
							"Error transforming GMF GenModel: Could not instantiate OawProject",
							e.getMessage());
		}
		return null;
	}

	/**
	 * Copied from package org.openarchitectureware.emf.editor.oaw
	 */
	private static class WorkspaceResourceManager extends ResourceManagerDefaultImpl {
		private IOawProject project;

		public WorkspaceResourceManager(IOawProject p) {
			this.project = p;
		}

		public org.openarchitectureware.expression.Resource loadResource(
				String fullyQualifiedName, String extension) {
			IOawResource oawResource = project.findOawResource(
					fullyQualifiedName, extension);
			if (oawResource != null)
				return oawResource.getOawResource();
			return super.loadResource(fullyQualifiedName, extension);
		}

	}

}
