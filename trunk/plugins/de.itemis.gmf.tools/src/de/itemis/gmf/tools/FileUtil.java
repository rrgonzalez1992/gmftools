/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.itemis.gmf.tools;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;

public class FileUtil {

	public static URI getURI(IFile file) {
		return URI.createPlatformResourceURI(file.getFullPath().toString(),
				true);
	}

	public static IFile getIFile(URI uri) {
		return ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(uri.toPlatformString(true)));
	}
	
	public static IFile getSiblingWithExtension(IFile file, String extension) {
		IFolder parent = (IFolder) file.getParent();
		String nameWithoutExtension = getNameWithoutExtension(file.getName());
		if (nameWithoutExtension.endsWith(".transformed")) {
			nameWithoutExtension = getNameWithoutExtension(nameWithoutExtension);
		}
		String siblingName = nameWithoutExtension + "." + extension;
		return parent.getFile(siblingName);
	}

	public static String getLocationWithoutExtension(IFile file) {
		String fileName = file.getRawLocation().toOSString();
		return getNameWithoutExtension(fileName);
	}

	public static String getNameWithoutExtension(String fileName) {
		return fileName.substring(0, fileName.lastIndexOf("."));
	}

	public static final List<EObject> getContents(String resourceURI,
			EObject context) {
		ResourceSet resourceSet;
		try {
			resourceSet = context.eResource().getResourceSet();
		} catch (Exception exc) {
			resourceSet = new ResourceSetImpl();
		}
		Resource resource = resourceSet.getResource(URI.createURI(resourceURI),
				true);
		return resource.getContents();
	}
		
}
