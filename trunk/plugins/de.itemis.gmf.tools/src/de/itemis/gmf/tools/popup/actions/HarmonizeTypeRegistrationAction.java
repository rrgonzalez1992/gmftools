/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.itemis.gmf.tools.popup.actions;

import java.util.HashSet;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jface.action.IAction;

import de.itemis.gmf.tools.contribution.GmfGenModelTypeRegistryHarmonizer;

public class HarmonizeTypeRegistrationAction extends GMFToolsAction {

	public HarmonizeTypeRegistrationAction() {
		super("gmfgen");
	}

	public void run(IAction action) {
		GmfGenModelTypeRegistryHarmonizer.harmonizeTypeRegistration(gmfModels, new HashSet<IFile>(), new NullProgressMonitor());
	}

}
