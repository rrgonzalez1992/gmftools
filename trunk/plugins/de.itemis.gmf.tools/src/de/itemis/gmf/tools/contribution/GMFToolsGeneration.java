/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.itemis.gmf.tools.contribution;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;

import de.itemis.gmf.tools.preferences.GmfModel;
import de.itemis.gmf.tools.preferences.PreferenceUtil;

public class GMFToolsGeneration implements IRunnableWithProgress {

	private final GmfModel gmfModel;
	private boolean deleteGmfGenModel = PreferenceUtil.isDeleteGmfGen();
	private boolean transformMapping2GmfGenModel = PreferenceUtil.isTransformMap2GmfGen();
	private boolean transformGmfGenModels = PreferenceUtil.isTransformGmfGen();
	private boolean fixRegisteredTypes = PreferenceUtil.isFixTypeRegistration();
	private boolean deletegeGeneratedDiagramPlugin = PreferenceUtil.isDeleteDiagramPlugin();
	private boolean generateDiagramPlugin = PreferenceUtil.isGenerateDiagramPlugin();
	private String figureTemplatePath = PreferenceUtil.getFigureTemplatePath();

	public GMFToolsGeneration(GmfModel gmfModel, Map<String, String> options) {
		this.gmfModel = gmfModel;
		if (options.containsKey(PreferenceUtil.GMF_DELETE_GMFGEN)) {
			deleteGmfGenModel = new Boolean(options.get(PreferenceUtil.GMF_DELETE_GMFGEN));
		}
		if (options.containsKey(PreferenceUtil.GMF_TRANSFORM_MAP_2_GMFGEN)) {
			transformMapping2GmfGenModel = new Boolean(options.get(PreferenceUtil.GMF_TRANSFORM_MAP_2_GMFGEN));
		}
		if (options.containsKey(PreferenceUtil.GMF_TRANSFORM_GMFGEN)) {
			transformGmfGenModels = new Boolean(options.get(PreferenceUtil.GMF_TRANSFORM_GMFGEN));
		}
		if (options.containsKey(PreferenceUtil.GMF_FIX_TYPE_REGISTRY)) {
			fixRegisteredTypes = new Boolean(options.get(PreferenceUtil.GMF_FIX_TYPE_REGISTRY));
		}
		if (options.containsKey(PreferenceUtil.GMF_DELETE_GENERATED_PLUGIN)) {
			deletegeGeneratedDiagramPlugin = new Boolean(options.get(PreferenceUtil.GMF_DELETE_GENERATED_PLUGIN));
		}
		if (options.containsKey(PreferenceUtil.GMF_GENERATE_DIAGRAM_PLUGIN)) {
			generateDiagramPlugin = new Boolean(options.get(PreferenceUtil.GMF_GENERATE_DIAGRAM_PLUGIN));
		}
		if(options.containsKey(PreferenceUtil.GMF_FIGURE_TEMPLATE_PATH)) {
			figureTemplatePath = options.get(PreferenceUtil.GMF_FIGURE_TEMPLATE_PATH);
		}
	}

	public void run(IProgressMonitor monitor) throws InvocationTargetException, InterruptedException {
		try {
			Set<IFile> changedGmfGenModels = new HashSet<IFile>();
			boolean isOK = false;
			monitor.beginTask("Creating transformed GMF generator model", 5);
			if (transformMapping2GmfGenModel) {
				isOK = GmfMappingToGenModelTransformer
						.transformMapToGmfGenModel(gmfModel, deleteGmfGenModel,
								figureTemplatePath, monitor);
				if (!isOK) {
					return;
				}
				if (!transformGmfGenModels) {
					changedGmfGenModels.add(gmfModel.getGmfGenModelFile());
				}
			}
			if (transformGmfGenModels) {
				isOK = GmfGenModelTransformer.createOrGetTransformationFile(gmfModel, monitor);
				if (!isOK) {
					return;
				}
				isOK = GmfGenModelTransformer.transformGmfGenModelFile(gmfModel, monitor);
				if (!isOK) {
					return;
				}
				changedGmfGenModels.add(gmfModel.getTransformedGmfGenModelFile());
			}
			if (fixRegisteredTypes) {
				isOK = GmfGenModelTypeRegistryHarmonizer.harmonizeTypeRegistration(PreferenceUtil.getGmfModels(), changedGmfGenModels,
						monitor);
				if (!isOK) {
					return;
				}
			}
			if (deletegeGeneratedDiagramPlugin && !changedGmfGenModels.isEmpty()) {
				isOK = GmfGeneratedPluginRemover.deleteGeneratedPlugins(changedGmfGenModels, monitor);
			}
			if (isOK && generateDiagramPlugin) {
				for (IFile gmfGenModel : changedGmfGenModels) {
					GmfDiagramCodeGenerator.generateDiagramCode(gmfGenModel);
				}
			}
		} catch (Exception exc) {
			throw new InvocationTargetException(exc);
		}
	}

}
