/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.itemis.gmf.tools.preferences;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;

import de.itemis.gmf.tools.FileUtil;

/**
 * @author koehnlein
 */
public abstract class GmfModelFileSelector {

	private Label label;
	private Button button;

	public GmfModelFileSelector(final GmfModelFilesDialog parent, String name) {
		Composite dialogArea = (Composite) parent.getDialogArea();
		Label title = new Label(dialogArea, SWT.NONE);
		title.setText(name);
		title.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, true, 1, 1));
		final IFile gmfModelFile = getFile();
		label = new Label(dialogArea, SWT.NONE);
		label.setText((gmfModelFile != null) ? gmfModelFile.getFullPath().toString()
				: "<unset>");
		label
				.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, true,
						1, 1));
		button = new Button(dialogArea, SWT.PUSH);
		button.setText("Choose");
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog fileDialog = new FileDialog(parent.getShell(),
						SWT.NONE);
				IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace()
						.getRoot();
				String workspaceDir = workspaceRoot.getLocation().toOSString();
				fileDialog.setFilterPath(workspaceDir);
				fileDialog
						.setFilterExtensions(new String[] { "*." + getFileExtension() });
				if(getFile() != null) {
					String fileName = getFile().getFullPath().toOSString();
					fileDialog.setFileName(fileName);
				}
				String result = fileDialog.open();
				if (result != null) {
					IFile[] files = workspaceRoot
							.findFilesForLocation(new Path(result));
					if (files != null && files.length == 1
							&& !files[0].equals(getFile())) {
						setFile(files[0]);
						label.setText(files[0].getFullPath().toString());
						parent.handleFileSet(files[0]);
						parent.getShell().pack();
					}
				}
			}
		});
		button
				.setLayoutData(new GridData(SWT.END, SWT.CENTER, true, true, 1,
						1));
	}

	public void setDefault(IFile file) {
		if (getFile() == null) {
			setFile(FileUtil.getSiblingWithExtension(file, getFileExtension()));
			label.setText(getFile().getFullPath().toString());
		}
	}

	public abstract void setFile(IFile file);

	public abstract IFile getFile();

	public abstract String getFileExtension();
}