package org.xtext.example.entities.diagram.extensions;

import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.xtext.example.entities.diagram.edit.parts.ModelEditPart;
import org.xtext.example.entities.diagram.part.EntitiesDiagramEditorPlugin;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "org.xtext.example.entities.diagram.extensions";

	// The shared instance
	private static Activator plugin;
	
	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		// Workaround for bug http://bugs.eclipse.org/bugs/show_bug.cgi?id=281014
		ViewService.createDiagram(ModelEditPart.MODEL_ID, EntitiesDiagramEditorPlugin.DIAGRAM_PREFERENCES_HINT);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

}
