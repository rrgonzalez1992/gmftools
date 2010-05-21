package de.itemis.gmf.tools.popup.actions;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.ProgressMonitorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;

import de.itemis.gmf.tools.FileUtil;
import de.itemis.gmf.tools.contribution.GMFToolsGeneration;
import de.itemis.gmf.tools.preferences.GmfModel;
import de.itemis.gmf.tools.preferences.PreferenceUtil;

/**
 * 
 * @author Alexander Ny§en (alexander.nyssen@itemis.de)
 * 
 */
public class GMFToolsGenerationBasedOnDefinitionFileAction implements
		IObjectActionDelegate {

	private static final String EMF_GENMODEL_FILE = "genmodel";
	private static final String GMF_MAP_MODEL_FILE = "gmfmap";
	private static final String GMF_TOOLS_EXT_FILE = "ext";
	private static final String GMF_GEN_MODEL_FILE = "gmfgen";
	private static final String TRANSFORMED_GMF_GENMODEL_FILE = "transformedgmfgen";

	GmfModel gmfModel = null;
	Map<String, String> options = null;

	private Shell shell;

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		shell = targetPart.getSite().getShell();
	}

	public void run(IAction action) {
		try {
			new ProgressMonitorDialog(shell).run(false, true,
					new GMFToolsGeneration(gmfModel, options));
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void selectionChanged(IAction action, ISelection selection) {
		gmfModel = null;
		options = null;
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if (structuredSelection.size() == 1
					&& structuredSelection.getFirstElement() instanceof IFile
					&& ((IFile) structuredSelection.getFirstElement())
							.getFileExtension().equals("def")) {
				IFile definitionFile = (IFile) structuredSelection
						.getFirstElement();
				Properties properties = new Properties();
				try {
					properties.load(definitionFile.getContents());
					gmfModel = propertiesToGmfModel(properties);
					if (gmfModel != null) {
						gmfModel.setDisplayName(definitionFile.getName());
					}
					PreferenceUtil.addGmfModel(gmfModel);
					options = propertiesToOptions(properties);
				} catch (IOException e) {
					e.printStackTrace();
				} catch (CoreException e) {
					e.printStackTrace();
				}
			}
		}
		// enable this action if we could infer the required information
		if (gmfModel != null) {
			action.setEnabled(true);
		} else {
			action.setEnabled(false);
		}
	}

	protected GmfModel propertiesToGmfModel(Properties properties) {
		IFile genModelFile = null;
		IFile gmfMapModelFile = null;
		IFile gmfTrafoFile = null;
		IFile gmfGenModelFile = null;
		IFile transformedGmfGenModelFile = null;

		genModelFile = getFile(properties, EMF_GENMODEL_FILE);
		gmfMapModelFile = getFile(properties, GMF_MAP_MODEL_FILE);
		gmfTrafoFile = getFile(properties, GMF_TOOLS_EXT_FILE);
		gmfGenModelFile = getFile(properties, GMF_GEN_MODEL_FILE);
		transformedGmfGenModelFile = getFile(properties,
				TRANSFORMED_GMF_GENMODEL_FILE);

		// construct a new gmf model with the specified entries
		if (genModelFile != null && gmfMapModelFile != null
				&& gmfTrafoFile != null && gmfGenModelFile != null
				&& transformedGmfGenModelFile != null) {
			GmfModel model = new GmfModel();
			model.setGenModelFile(genModelFile);
			model.setGmfMapModelFile(gmfMapModelFile);
			model.setGmfTrafoFile(gmfTrafoFile);
			model.setGmfGenModelFile(gmfGenModelFile);
			model.setTransformedGmfGenModelFile(transformedGmfGenModelFile);
			return model;
		} else {
			return null;
		}

	}

	protected Map<String, String> propertiesToOptions(Properties properties) {
		// load all known options
		Map<String, String> options = new HashMap<String, String>();
		for (String optionKey : PreferenceUtil.getOptions().keySet()) {
			if (properties.getProperty(optionKey) != null) {
				options.put(optionKey, properties.getProperty(optionKey));
			}
		}
		return options;
	}

	private IFile getFile(Properties properties, String propertyKey) {
		String genModelFilePath = (String) properties.get(propertyKey);
		return FileUtil.getIFile(URI
				.createPlatformResourceURI(genModelFilePath, true));
	}

}
