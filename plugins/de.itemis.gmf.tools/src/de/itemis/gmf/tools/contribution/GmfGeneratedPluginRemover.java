/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.itemis.gmf.tools.contribution;

import java.util.Arrays;
import java.util.Collection;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IResourceVisitor;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.SubProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.gmf.codegen.gmfgen.GenEditorGenerator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;

import de.itemis.gmf.tools.FileUtil;

public class GmfGeneratedPluginRemover {

	private static final Collection<String> EXCLUDE_DIR_NAMES = Arrays
			.asList(new String[] { "CVS", ".svn" });

	public static boolean deleteGeneratedPlugins(
			Collection<IFile> gmfGenModels, IProgressMonitor monitor) {
		try {
			monitor = new SubProgressMonitor(monitor, 1);
			monitor.beginTask("Delete generated diagram plug-ins",
					3 * gmfGenModels.size());
			ResourceSet resourceSet = new ResourceSetImpl();
			for (IFile gmfGenModel : gmfGenModels) {
				URI gmfGenModelURI = FileUtil.getURI(gmfGenModel);
				Resource resource = resourceSet.getResource(gmfGenModelURI,
						true);
				GenEditorGenerator editorGenerator = (GenEditorGenerator) resource
						.getContents().get(0);
				String pluginID = editorGenerator.getPlugin().getID();
				IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace()
						.getRoot();
				IProject project = workspaceRoot.getProject(pluginID);
				if (project.exists()) {
					if (!project.isOpen()) {
						project.open(monitor);
						monitor.worked(1);
					}
					project.accept(new DeleteVisitor(monitor));
					monitor.worked(1);
					workspaceRoot.refreshLocal(IResource.DEPTH_ONE, monitor);
					monitor.worked(1);
				}
				monitor.done();
			}
			return true;
		} catch (Exception exc) {
			MessageDialog.openError(Display.getDefault().getActiveShell(),
					"Error deleting diagram plugin", exc.getMessage());
		}
		return false;
	}

	private static class DeleteVisitor implements IResourceVisitor {

		private IProgressMonitor monitor;

		public DeleteVisitor(IProgressMonitor monitor) {
			this.monitor = monitor;
		}

		public boolean visit(IResource resource) throws CoreException {
			if (resource instanceof IContainer) {
				String name = resource.getName();
				return !(EXCLUDE_DIR_NAMES.contains(name));
			}
			resource.delete(true, monitor);
			return false;
		}

	}
	
}
