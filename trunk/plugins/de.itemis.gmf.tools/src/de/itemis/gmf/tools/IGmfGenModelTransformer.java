package de.itemis.gmf.tools;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;

public interface IGmfGenModelTransformer {

	public static final String EXTENSION_POINT_ID = "de.itemis.gmf.tools.transformer";
	public static final String CLASS = "class";

	public static class Registry {
		private static IGmfGenModelTransformer INSTANCE;

		public static IGmfGenModelTransformer create() {
			if (INSTANCE != null) {
				return INSTANCE;
			} else {
				IConfigurationElement[] configurationElements = Platform
						.getExtensionRegistry().getConfigurationElementsFor(
								EXTENSION_POINT_ID);
				for (IConfigurationElement configurationElement : configurationElements) {
					try {
						IGmfGenModelTransformer transformer = (IGmfGenModelTransformer) configurationElement
								.createExecutableExtension(CLASS);
						INSTANCE = transformer;
						return transformer;
					} catch (Exception exc) {
						// ignore
					}
				}
			}
			throw new IllegalStateException("No transformer registered");
		}
	}

	List<EObject> transformGmfGenModel(IFile gmfGenModelFile,
			IFile transformationFile, ResourceSet resourceSet) throws Exception;

}
