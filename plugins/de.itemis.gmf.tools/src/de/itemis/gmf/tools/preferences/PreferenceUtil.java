/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.itemis.gmf.tools.preferences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.preference.IPreferenceStore;

import de.itemis.gmf.tools.Activator;

/**
 * Constant definitions for plug-in preferences
 */
public class PreferenceUtil {

	public static final String GMF_GEN_MODELS = "gmfGenModels";
	public static final String GMF_DELETE_GMFGEN = "deleteGmfGenModel";
	public static final String GMF_TRANSFORM_MAP_2_GMFGEN = "transformMapping2GmfGenModel";
	public static final String GMF_TRANSFORM_GMFGEN = "transformGmfGenModels";
	public static final String GMF_FIX_TYPE_REGISTRY = "fixRegisteredTypes";
	public static final String GMF_DELETE_GENERATED_PLUGIN = "deletegeGeneratedDiagramPlugin";
	public static final String GMF_GENERATE_DIAGRAM_PLUGIN = "generateDiagramPlugin";

	public static void addGmfGenModel(IFile gmfGenModelFile) {
		IPreferenceStore store = getPreferenceStore();
		String gmfGenModelUris = getGmfGenModelUris(store);
		List<String> names = Arrays.asList(gmfGenModelUris.split(":"));
		String path = gmfGenModelFile.getFullPath().toString();
		if (!names.contains(path)) {
			String value = ((gmfGenModelUris != "") ? (gmfGenModelUris + ":") : "")
					+ path;
			store.putValue(PreferenceUtil.GMF_GEN_MODELS, value);
		}
	}

	public static void removeGmfGenModel(IFile gmfGenModelFile) {
		IPreferenceStore store = getPreferenceStore();
		String gmfGenModelUris = getGmfGenModelUris(store);
		List<String> names = Arrays.asList(gmfGenModelUris.split(":"));
		String path = gmfGenModelFile.getFullPath().toString();
		if (names.remove(path)) {
			StringBuffer newGmfGenModelUris = new StringBuffer();
			boolean isFirst = true;
			for (String name : names) {
				if (!isFirst) {
					newGmfGenModelUris.append(":");
				}
				newGmfGenModelUris.append(name);
				isFirst = false;
			}
			store.putValue(PreferenceUtil.GMF_GEN_MODELS, newGmfGenModelUris
					.toString());
		}
	}

	private static String getGmfGenModelUris(IPreferenceStore store) {
		return store.getString(PreferenceUtil.GMF_GEN_MODELS);
	}

	private static IPreferenceStore getPreferenceStore() {
		return Activator.getDefault().getPreferenceStore();
	}

	public static List<URI> getGmfGenModels() {
		IPreferenceStore store = getPreferenceStore();
		String gmfGenModelFiles = getGmfGenModelUris(store);
		List<String> names = Arrays.asList(gmfGenModelFiles.split(":"));
		List<URI> gmfGenModelURIs = new ArrayList<URI>(names.size());
		for (String gmfGenModelFileName : names) {
			gmfGenModelURIs.add(URI.createPlatformResourceURI(
					gmfGenModelFileName, true));
		}
		return gmfGenModelURIs;
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
