/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.itemis.gmf.tools.preferences;

import java.io.File;

import org.eclipse.jface.preference.PathEditor;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;

public class FileEditor extends PathEditor {

	private String lastPath;

	public FileEditor(String name, String labelText, Composite parent) {
        super(name, labelText, labelText, parent);
    }
	
	/* (non-Javadoc)
     * Method declared on ListEditor.
     * Creates a new path element by means of a directory dialog.
     */
    protected String getNewInputObject() {
        FileDialog dialog = new FileDialog(getShell());
        if (lastPath != null) {
            if (new File(lastPath).exists()) {
				dialog.setFilterPath(lastPath);
			}
        }
        String file = dialog.open();
        if (file != null) {
            file = file.trim();
            if (file.length() == 0) {
				return null;
			}
            lastPath = file;
        }
        return file;
    }
}
