package de.itemis.gmf.tools.contribution;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.jface.operation.IRunnableWithProgress;

import de.itemis.gmf.tools.preferences.GmfModel;
import de.itemis.gmf.tools.preferences.PreferenceUtil;

public class GMFToolsGeneration implements IRunnableWithProgress {

	private GmfModel gmfModel;

	public GMFToolsGeneration(GmfModel gmfModel) {
		this.gmfModel = gmfModel;
	}

	public void run(IProgressMonitor monitor) throws InvocationTargetException,
			InterruptedException {
		try {
			Set<IFile> changedGmfGenModels = new HashSet<IFile>();
			boolean isOK = false;
			monitor.beginTask("Creating transformed GMF generator model", 5);
			if (PreferenceUtil.isTransformMap2GmfGen()) {
				isOK = GmfMappingToGenModelTransformer
						.transformMapToGmfGenModel(gmfModel, monitor);
				if (!isOK) {
					return;
				}
				if (!PreferenceUtil.isTransformGmfGen()) {
					changedGmfGenModels.add(gmfModel.getGmfGenModelFile());
				}
			}
			if (PreferenceUtil.isTransformGmfGen()) {
				isOK = GmfGenModelTransformer.createOrGetTransformationFile(
						gmfModel, monitor);
				if (!isOK) {
					return;
				}
				isOK = GmfGenModelTransformer.transformGmfGenModelFile(
						gmfModel, monitor);
				if (!isOK) {
					return;
				}
				changedGmfGenModels.add(gmfModel
						.getTransformedGmfGenModelFile());
			}
			if (PreferenceUtil.isFixTypeRegistration()) {
				isOK = GmfGenModelTypeRegistryHarmonizer
						.harmonizeTypeRegistration(PreferenceUtil
								.getGmfModels(), changedGmfGenModels, monitor);
				if (!isOK) {
					return;
				}
			}
			if (PreferenceUtil.isDeleteDiagramPlugin()
					&& !changedGmfGenModels.isEmpty()) {
				isOK = GmfGeneratedPluginRemover.deleteGeneratedPlugins(
						changedGmfGenModels, monitor);
			}
			if (isOK) {
				for (IFile gmfGenModel : changedGmfGenModels) {
					GmfDiagramCodeGenerator.generateDiagramCode(gmfGenModel);
				}
			}
		} catch (Exception exc) {
			throw new InvocationTargetException(exc);
		}
	}

}
