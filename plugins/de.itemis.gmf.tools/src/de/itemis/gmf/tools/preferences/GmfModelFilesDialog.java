/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.itemis.gmf.tools.preferences;

import java.util.ArrayList;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import de.itemis.gmf.tools.FileUtil;

/**
 * @author koehnlein
 */
public class GmfModelFilesDialog extends Dialog {

	private GmfModel gmfModels;
	private Text nameField;
	private java.util.List<GmfModelFileSelector> selectors = new ArrayList<GmfModelFileSelector>();

	public GmfModelFilesDialog(Shell parentShell) {
		super(parentShell);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		dialogArea = super.createDialogArea(parent);
		GridLayout layout = new GridLayout(3, false);
		((Composite)dialogArea).setLayout(layout);
		Label title = new Label((Composite) dialogArea, SWT.NONE);
		title.setText("Name");
		title.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, true, 1, 1));
		nameField = new Text((Composite) dialogArea, SWT.BORDER);
		nameField.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false,
				2, 1));
		nameField.setText((gmfModels.getDisplayName() == null) ? "" : gmfModels.getDisplayName());
		nameField.addModifyListener(new ModifyListener() {
			public void modifyText(ModifyEvent e) {
				String name = ((Text) e.widget).getText();
				gmfModels.setDisplayName(name);
				getButton(OK).setEnabled(name != null && !"".equals(name));
			}
		});
		selectors.add(new GmfModelFileSelector(this, "Mapping Model") {
			@Override
			public void setFile(IFile file) {
				gmfModels.setGmfMapModelFile(file);
			}

			@Override
			public IFile getFile() {
				return gmfModels.getGmfMapModelFile();
			}

			@Override
			public String getFileExtension() {
				return "gmfmap";
			}
		});
		selectors.add(new GmfModelFileSelector(this, "EMF GenModel") {
			@Override
			public void setFile(IFile file) {
				gmfModels.setGenModelFile(file);
			}

			@Override
			public IFile getFile() {
				return gmfModels.getGenModelFile();
			}

			@Override
			public String getFileExtension() {
				return "genmodel";
			}
		});
		selectors.add(new GmfModelFileSelector(this, "GMF GenModel") {
			@Override
			public void setFile(IFile file) {
				gmfModels.setGmfGenModelFile(file);
			}

			@Override
			public IFile getFile() {
				return gmfModels.getGmfGenModelFile();
			}

			@Override
			public String getFileExtension() {
				return "gmfgen";
			}
		});
		selectors.add(new GmfModelFileSelector(this, "GMF GenModel Transformation") {
			@Override
			public void setFile(IFile file) {
				gmfModels.setGmfTrafoFile(file);
			}

			@Override
			public IFile getFile() {
				return gmfModels.getGmfTrafoFile();
			}

			@Override
			public String getFileExtension() {
				return "ext";
			}
		});
		selectors.add(new GmfModelFileSelector(this, "Transformed GMF GenModel") {
			@Override
			public void setFile(IFile file) {
				gmfModels.setTransformedGmfGenModelFile(file);
			}

			@Override
			public IFile getFile() {
				return gmfModels.getTransformedGmfGenModelFile();
			}

			@Override
			public String getFileExtension() {
				return "transformed.gmfgen";
			}
		});
		getShell().setText("Choose the set of GMF files for one editor");
		return dialogArea;
	}

	@Override 
	public Control getDialogArea() {
		return super.getDialogArea();
	}
	
	public void setGmfModelFiles(GmfModel gmfModelFiles) {
		this.gmfModels = gmfModelFiles;
	}

	public GmfModel getGmfModelFiles() {
		return gmfModels;
	}

	public void handleFileSet(IFile file) {
		for (GmfModelFileSelector selector : selectors) {
			selector.setDefault(file);
		}
		if(gmfModels.getDisplayName() == null) {
			String newName = FileUtil.getNameWithoutExtension(file.getName());
			gmfModels.setDisplayName(newName);
			nameField.setText(newName);
		}
	}
	
}