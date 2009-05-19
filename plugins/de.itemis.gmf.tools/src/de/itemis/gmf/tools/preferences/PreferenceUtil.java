/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.itemis.gmf.tools.preferences;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.jface.preference.IPreferenceStore;

import de.itemis.gmf.tools.Activator;

/**
 * Constant definitions for plug-in preferences
 */
public class PreferenceUtil {

	public static final String GMF_MODELS = "gmfModels";
	public static final String GMF_DELETE_GMFGEN = "deleteGmfGenModel";
	public static final String GMF_TRANSFORM_MAP_2_GMFGEN = "transformMapping2GmfGenModel";
	public static final String GMF_TRANSFORM_GMFGEN = "transformGmfGenModels";
	public static final String GMF_FIX_TYPE_REGISTRY = "fixRegisteredTypes";
	public static final String GMF_DELETE_GENERATED_PLUGIN = "deletegeGeneratedDiagramPlugin";
	public static final String GMF_GENERATE_DIAGRAM_PLUGIN = "generateDiagramPlugin";

	private static GmfModel.Factory gmfModelFactory = new GmfModel.Factory();
	
	public static List<GmfModel> getGmfModels() {
		IPreferenceStore store = getPreferenceStore();
		String string = store.getString(GMF_MODELS);
		if (string == null || "".equals(string))
			return Collections.emptyList();
		ArrayList<GmfModel> result = new ArrayList<GmfModel>();
		String[] paths = string.split(ObjectListEditor.PREFERENCE_ITEM_SEPARATOR);
		for (String path : paths) {
			if (!"".equals(path)) {
				GmfModel gmfModels = (GmfModel) gmfModelFactory.deserialize(path);
				result.add(gmfModels);
			}
		}
		return result;
	}

	private static IPreferenceStore getPreferenceStore() {
		return Activator.getDefault().getPreferenceStore();
	}

	public static boolean isDeleteGmfGen() {
		return getPreferenceStore().getBoolean(GMF_DELETE_GMFGEN);
	}

	public static boolean isTransformMap2GmfGen() {
		return getPreferenceStore().getBoolean(GMF_TRANSFORM_MAP_2_GMFGEN);
	}

	public static boolean isTransformGmfGen() {
		return getPreferenceStore().getBoolean(GMF_TRANSFORM_GMFGEN);
	}

	public static boolean isFixTypeRegistration() {
		return getPreferenceStore().getBoolean(GMF_FIX_TYPE_REGISTRY);
	}

	public static boolean isDeleteDiagramPlugin() {
		return getPreferenceStore().getBoolean(GMF_DELETE_GENERATED_PLUGIN);
	}

	public static boolean isGenerateDiagramPlugin() {
		return getPreferenceStore().getBoolean(GMF_GENERATE_DIAGRAM_PLUGIN);
	}

}
