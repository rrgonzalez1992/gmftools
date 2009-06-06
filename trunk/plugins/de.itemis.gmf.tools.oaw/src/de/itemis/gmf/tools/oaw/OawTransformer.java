/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.itemis.gmf.tools.oaw;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.codegen.gmfgen.GMFGenPackage;
import org.eclipse.m2t.type.emf.EmfRegistryMetaModel;
import org.openarchitectureware.OawPlugin;
import org.openarchitectureware.core.IOawProject;
import org.openarchitectureware.core.IOawResource;
import org.openarchitectureware.expression.ExecutionContextImpl;
import org.openarchitectureware.expression.ResourceManagerDefaultImpl;
import org.openarchitectureware.expression.TypeSystemImpl;
import org.openarchitectureware.xtend.XtendFacade;

import de.itemis.gmf.tools.FileUtil;
import de.itemis.gmf.tools.IGmfGenModelTransformer;

public class OawTransformer implements IGmfGenModelTransformer {

	@SuppressWarnings("unchecked")
	public List<EObject> transformGmfGenModel(IFile gmfGenModelFile,
			IFile transformationFile, ResourceSet resourceSet) {
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
			return (List<EObject>) facade.call(
					"transform", genModelResource.getContents());
	}

	private List<EPackage> findMetaModelPackages(ResourceSet resourceSet) {
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

	/**
	 * Copied from package org.openarchitectureware.emf.editor.oaw
	 */
	private class WorkspaceResourceManager extends ResourceManagerDefaultImpl {
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
