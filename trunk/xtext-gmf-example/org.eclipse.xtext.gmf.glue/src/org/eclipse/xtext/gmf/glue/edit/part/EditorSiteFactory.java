package org.eclipse.xtext.gmf.glue.edit.part;

import org.eclipse.ui.IEditorActionBarContributor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorRegistry;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.internal.EditorActionBars;
import org.eclipse.ui.internal.EditorActionBuilder;
import org.eclipse.ui.internal.EditorManager;
import org.eclipse.ui.internal.EditorReference;
import org.eclipse.ui.internal.EditorSite;
import org.eclipse.ui.internal.WorkbenchPage;
import org.eclipse.ui.internal.registry.EditorDescriptor;

/**
 * Creates a new editor site for the in-diagram XtextEditor. Unfortunately, this
 * class heavily uses restricted API, as creating IEditorSites is considered to
 * be responsibility of the framework. To avoid suppression of restriction
 * warnings on everything, this code has been extracted into a separate class.
 * 
 * @author koehnlein
 */
@SuppressWarnings("restriction")
public class EditorSiteFactory {

	public static IEditorSite createEditorSite(final IEditorPart editorPart,
			final IEditorInput editorInput, String editorID) {
		IWorkbench workbench = PlatformUI.getWorkbench();
		IEditorRegistry editorRegistry = workbench.getEditorRegistry();
		EditorDescriptor editorDescriptor = (EditorDescriptor) editorRegistry
				.findEditor(editorID);
		IWorkbenchWindow workbenchWindow = workbench.getActiveWorkbenchWindow();
		WorkbenchPage workbenchPage = (WorkbenchPage) workbenchWindow
				.getActivePage();
		EditorManager editorManager = workbenchPage.getEditorManager();

		EditorSite editorSite = new EditorSite(new EditorReference(
				editorManager, editorInput, editorDescriptor), editorPart,
				workbenchPage, editorDescriptor);
		// editorSite.setActionBars(new EditorActionBars(workbenchPage,
		// workbenchWindow, editorID));
		editorSite.setActionBars(createEditorActionBars(editorDescriptor,
				editorSite, workbenchPage));
		return editorSite;
	}

	/**
	 * copied from {@link EditorManager#createEditorActionBars}
	 */
	private static EditorActionBars createEditorActionBars(
			EditorDescriptor editorDescriptor, final IEditorSite editorSite,
			WorkbenchPage workbenchPage) {
		// Get the editor type.
		String type = editorDescriptor.getId();

		// If an action bar already exists for this editor type return it.
		// EditorActionBars actionBars = (EditorActionBars)
		// actionCache.get(type);
		// if (actionBars != null) {
		// actionBars.addRef();
		// return actionBars;
		// }

		// Create a new action bar set.
		EditorActionBars actionBars = new EditorActionBars(workbenchPage,
				editorSite.getWorkbenchWindow(), type);
		actionBars.addRef();
		// actionCache.put(type, actionBars);

		// Read base contributor.
		IEditorActionBarContributor contr = editorDescriptor
				.createActionBarContributor();
		if (contr != null) {
			actionBars.setEditorContributor(contr);
			contr.init(actionBars, workbenchPage);
		}

		// Read action extensions.
		EditorActionBuilder builder = new EditorActionBuilder();
		contr = builder.readActionExtensions(editorDescriptor);
		if (contr != null) {
			actionBars.setExtensionContributor(contr);
			contr.init(actionBars, workbenchPage);
		}

		// Return action bars.
		return actionBars;
	}

}
