/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.itemis.gmf.tools.preferences;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import de.itemis.gmf.tools.Activator;

/**
 * This class represents a preference page that
 * is contributed to the Preferences dialog. By 
 * subclassing <samp>FieldEditorPreferencePage</samp>, we
 * can use the field support built into JFace that allows
 * us to create a page that is small and knows how to 
 * save, restore and apply itself.
 * <p>
 * This page is used to modify preferences only. They
 * are stored in the preference store that belongs to
 * the main plug-in class. That way, preferences can
 * be accessed directly via the preference store.
 */

public class GMFToolsPreferencePage
	extends FieldEditorPreferencePage
	implements IWorkbenchPreferencePage {

	public GMFToolsPreferencePage() {
		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("Preferences for the GMF Tools");
	}
	
	/**
	 * Creates the field editors. Field editors are abstractions of
	 * the common GUI blocks needed to manipulate various types
	 * of preferences. Each field editor knows how to save and
	 * restore itself.
	 */
	public void createFieldEditors() {
		Composite fieldEditorParent = getFieldEditorParent();
		addField(new BooleanFieldEditor(PreferenceUtil.GMF_DELETE_GMFGEN, "Delete old gmfgen model",fieldEditorParent));
		addField(new BooleanFieldEditor(PreferenceUtil.GMF_TRANSFORM_MAP_2_GMFGEN, "Transform mapping model to gmfgen",fieldEditorParent));
		addField(new BooleanFieldEditor(PreferenceUtil.GMF_TRANSFORM_GMFGEN, "Transform gmfgen model",fieldEditorParent));
		addField(new BooleanFieldEditor(PreferenceUtil.GMF_FIX_TYPE_REGISTRY, "Fix type registrations in gmfgen models",fieldEditorParent));
		addField(new FileEditor(PreferenceUtil.GMF_GEN_MODELS, 
				"&GMF Generator models sharing types:",  fieldEditorParent));
		addField(new BooleanFieldEditor(PreferenceUtil.GMF_DELETE_GENERATED_PLUGIN, "Delete generated diagram plug-in",fieldEditorParent));
		addField(new BooleanFieldEditor(PreferenceUtil.GMF_GENERATE_DIAGRAM_PLUGIN, "Generate diagram plug-in",fieldEditorParent));
	}

	/* (non-Javadoc)
	 * @see org.eclipse.ui.IWorkbenchPreferencePage#init(org.eclipse.ui.IWorkbench)
	 */
	public void init(IWorkbench workbench) {
	}
	
}