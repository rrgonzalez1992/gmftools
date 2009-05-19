/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.itemis.gmf.tools.preferences;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.widgets.Composite;

/**
 * @author koehnlein
 */
public class MapModelListEditor extends ObjectListEditor {

	public MapModelListEditor(String name, String labelText, Composite parent) {
		super(name, labelText, new GmfModel.Factory(), parent);
	}

	@Override
	protected ObjectListEntry editEntry(ObjectListEntry entry) {
		if (entry instanceof GmfModel) {
			GmfModelFilesDialog dialog = new GmfModelFilesDialog(getShell());
			dialog.setBlockOnOpen(true);
			dialog.setGmfModelFiles((GmfModel) entry);
			int result = dialog.open();
			if (result == Dialog.OK) {
				return entry;
			}
		}
		return null;
	}

}