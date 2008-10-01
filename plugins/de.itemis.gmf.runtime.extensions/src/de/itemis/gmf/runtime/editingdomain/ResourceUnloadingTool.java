/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.itemis.gmf.runtime.editingdomain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramEditorInput;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;

import de.itemis.gmf.runtime.extensions.DiagramEditorInfoRegistry;

public class ResourceUnloadingTool {

	public static void unloadEditorInput(ResourceSet resourceSet,
			IEditorInput editorInput) {
		Resource diagramResource = getDiagramResource(resourceSet, editorInput);
		if (diagramResource != null) {
			IEditorReference[] editorReferences = PlatformUI.getWorkbench()
					.getActiveWorkbenchWindow().getActivePage()
					.getEditorReferences();
			for (IEditorReference editorReference : editorReferences) {
				try {
					IEditorInput openEditorInput = editorReference
							.getEditorInput();
					if (openEditorInput != editorInput
							&& getDiagramResource(resourceSet, openEditorInput) == diagramResource) {
						return;
					}
				} catch (PartInitException e) {
					// ignore
				}
			}
			diagramResource.unload();
			resourceSet.getResources().remove(diagramResource);
			unloadResourcesNotReferencedByDiagrams(resourceSet);
		}
	}

	private static Resource getDiagramResource(ResourceSet resourceSet,
			IEditorInput editorInput) {
		Resource diagramResource = null;
		if (editorInput instanceof URIEditorInput) {
			URI resourceURI = ((URIEditorInput) editorInput).getURI()
					.trimFragment();
			diagramResource = resourceSet.getResource(resourceURI, false);
		} else if (editorInput instanceof IDiagramEditorInput) {
			Diagram diagram = ((IDiagramEditorInput) editorInput).getDiagram();
			diagramResource = diagram.eResource();
		} else if (editorInput instanceof FileEditorInput) {
			URI resourceURI = URI.createPlatformResourceURI(
					((FileEditorInput) editorInput).getFile().getFullPath()
							.toString(), true);
			diagramResource = resourceSet.getResource(resourceURI, false);
		} 
		return diagramResource;
	}

	@SuppressWarnings("unchecked")
	public static void unloadResourcesNotReferencedByDiagrams(
			ResourceSet resourceSet) {
		List<String> diagramFileExtensions = DiagramEditorInfoRegistry
				.getRegisteredDiagramFileExtensions();
		EList<Resource> resources = resourceSet.getResources();
		List<Resource> resourcesToUnload = new ArrayList<Resource>(resources);
		for (Resource resource : resources) {
			if (diagramFileExtensions.contains(resource.getURI()
					.fileExtension())) {
				resourcesToUnload.remove(resource);
				Collection imports = EMFCoreUtil.getImports(resource);
				resourcesToUnload.removeAll(imports);
			}
		}
		for (Resource unloadResource : resourcesToUnload) {
			unloadResource.unload();
			resources.remove(unloadResource);
		}
	}

}
