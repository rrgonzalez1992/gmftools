/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.itemis.gmf.tools.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import de.itemis.gmf.tools.Activator;

/**
 * Class used to initialize default preference values.
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.eclipse.core.runtime.preferences.AbstractPreferenceInitializer#
	 * initializeDefaultPreferences()
	 */
	public void initializeDefaultPreferences() {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		store.setDefault(PreferenceUtil.GMF_GEN_MODELS, "");
		store.setDefault(PreferenceUtil.GMF_DELETE_GMFGEN, true);
		store.setDefault(PreferenceUtil.GMF_TRANSFORM_MAP_2_GMFGEN, true);
		store.setDefault(PreferenceUtil.GMF_TRANSFORM_GMFGEN, true);
		store.setDefault(PreferenceUtil.GMF_FIX_TYPE_REGISTRY, true);
		store.setDefault(PreferenceUtil.GMF_DELETE_GENERATED_PLUGIN, true);
		store.setDefault(PreferenceUtil.GMF_GENERATE_DIAGRAM_PLUGIN, true);
	}

}
