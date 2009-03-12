/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.itemis.gmf.tools.contribution;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.PlatformUI;

public class GmfDiagramCodeGenerator {

	public static void generateDiagramCode(IFile gmfGenModel)
			throws CoreException {
		IObjectActionDelegate executeTemplateAction = getExecuteTemplateAction();
		if (executeTemplateAction != null) {
			IAction action = new Action() {
			};
			executeTemplateAction.selectionChanged(action,
					new StructuredSelection(gmfGenModel));
			executeTemplateAction
					.setActivePart(action, PlatformUI.getWorkbench()
							.getActiveWorkbenchWindow().getActivePage()
							.getActivePart());
			executeTemplateAction.run(action);
		}
	}

	private static IObjectActionDelegate getExecuteTemplateAction()
			throws CoreException {
		IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();
		IConfigurationElement[] configurationElements = extensionRegistry
				.getConfigurationElementsFor("org.eclipse.ui.popupMenus");
		IObjectActionDelegate executeTemplateAction = null;
		for (IConfigurationElement configurationElement : configurationElements) {
			IConfigurationElement[] children = configurationElement
					.getChildren();
			for (IConfigurationElement child : children) {
				String id = child.getAttribute("id");
				if ("gmf.codegen.ui.executeTemplatesAction".equals(id)) {
					executeTemplateAction = (IObjectActionDelegate) child
							.createExecutableExtension("class");
				}
			}
		}
		return executeTemplateAction;
	}

}
