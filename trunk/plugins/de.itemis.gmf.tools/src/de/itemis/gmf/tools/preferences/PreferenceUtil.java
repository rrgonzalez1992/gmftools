/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.itemis.gmf.tools.preferences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
		ArrayList<GmfModel> result = new ArrayList<GmfModel>();
		if (string != null && !"".equals(string)) {
			String[] paths = string
					.split(ObjectListEditor.PREFERENCE_ITEM_SEPARATOR);
			for (String path : paths) {
				if (!"".equals(path)) {
					GmfModel gmfModels = (GmfModel) gmfModelFactory
							.deserialize(path);
					result.add(gmfModels);
				}
			}
		}
		return result;
	}

	public static void addGmfModel(GmfModel newModel) {
		List<GmfModel> gmfModels = getGmfModels();
		boolean replaced = false;
		for (int i = 0; i < gmfModels.size(); ++i) {
			if (gmfModels.get(i).getDisplayName().equals(
					newModel.getDisplayName())) {
				gmfModels.set(i, newModel);
				replaced = true;
				break;
			}
		}
		if (!replaced) {
			gmfModels.add(newModel);
		}
		Iterator<GmfModel> i = gmfModels.iterator();
		StringBuilder builder = new StringBuilder(gmfModelFactory.serialize(i
				.next()));
		while (i.hasNext()) {
			builder.append(ObjectListEditor.PREFERENCE_ITEM_SEPARATOR);
			builder.append(gmfModelFactory.serialize(i.next()));
		}
		getPreferenceStore().setValue(GMF_MODELS, builder.toString());
	}

	private static IPreferenceStore getPreferenceStore() {
		return Activator.getDefault().getPreferenceStore();
	}

	public static Map<String, Boolean> getOptions() {
		Map<String, Boolean> options = new HashMap<String, Boolean>();
		options.put(GMF_DELETE_GMFGEN, getPreferenceStore().getBoolean(
				GMF_DELETE_GMFGEN));
		options.put(GMF_TRANSFORM_MAP_2_GMFGEN, getPreferenceStore()
				.getBoolean(GMF_TRANSFORM_MAP_2_GMFGEN));
		options.put(GMF_TRANSFORM_GMFGEN, getPreferenceStore().getBoolean(
				GMF_TRANSFORM_MAP_2_GMFGEN));
		options.put(GMF_FIX_TYPE_REGISTRY, getPreferenceStore().getBoolean(
				GMF_FIX_TYPE_REGISTRY));
		options.put(GMF_DELETE_GENERATED_PLUGIN, getPreferenceStore()
				.getBoolean(GMF_DELETE_GENERATED_PLUGIN));
		options.put(GMF_GENERATE_DIAGRAM_PLUGIN, getPreferenceStore()
				.getBoolean(GMF_GENERATE_DIAGRAM_PLUGIN));
		return options;
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
