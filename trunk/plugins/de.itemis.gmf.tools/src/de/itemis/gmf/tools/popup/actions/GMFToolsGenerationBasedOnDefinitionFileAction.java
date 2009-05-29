package de.itemis.gmf.tools.popup.actions;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
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

public class GMFToolsGenerationBasedOnDefinitionFileAction implements
		IObjectActionDelegate {

	private static final String EMF_GENMODEL_FILE = "genmodel";
	private static final String GMF_MAP_MODEL_FILE = "gmfmap";
	private static final String GMF_TOOLS_EXT_FILE = "ext";
	private static final String GMF_GEN_MODEL_FILE = "gmfgen";
	private static final String TRANSFORMED_GMF_GENMODEL_FILE = "transformedgmfgen";

	GmfModel gmfModel = null;
	private Shell shell;

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		shell = targetPart.getSite().getShell();
	}

	public void run(IAction action) {
		try {
			new ProgressMonitorDialog(shell).run(false, true,
					new GMFToolsGeneration(gmfModel));
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void selectionChanged(IAction action, ISelection selection) {
		gmfModel = null;
		if (selection instanceof IStructuredSelection) {
			IStructuredSelection structuredSelection = (IStructuredSelection) selection;
			if (structuredSelection.size() == 1
					&& structuredSelection.getFirstElement() instanceof IFile
					&& ((IFile) structuredSelection.getFirstElement())
							.getFileExtension().equals("def")) {
				IFile definitionFile = (IFile) structuredSelection
						.getFirstElement();
				gmfModel = propertiesToGmfModel(definitionFile);
			}
		}
		// enable this action if we could infer the required information
		if (gmfModel != null) {
			action.setEnabled(true);
		} else {
			action.setEnabled(false);
		}
	}

	protected GmfModel propertiesToGmfModel(IFile propertiesFile) {
		IFile genModelFile = null;
		IFile gmfMapModelFile = null;
		IFile gmfTrafoFile = null;
		IFile gmfGenModelFile = null;
		IFile transformedGmfGenModelFile = null;

		Properties properties = new Properties();
		try {
			properties.load(propertiesFile.getContents());
			genModelFile = getFile(properties, EMF_GENMODEL_FILE);
			gmfMapModelFile = getFile(properties, GMF_MAP_MODEL_FILE);
			gmfTrafoFile = getFile(properties, GMF_TOOLS_EXT_FILE);
			gmfGenModelFile = getFile(properties, GMF_GEN_MODEL_FILE);
			transformedGmfGenModelFile = getFile(properties,
					TRANSFORMED_GMF_GENMODEL_FILE);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (CoreException e) {
			e.printStackTrace();
		}

		// construct a new gmf model with the specified entries
		if (genModelFile != null && gmfMapModelFile != null
				&& gmfTrafoFile != null && gmfGenModelFile != null
				&& transformedGmfGenModelFile != null) {
			GmfModel model = new GmfModel();
			model.setDisplayName(propertiesFile.getName());
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

	private IFile getFile(Properties properties, String propertyKey) {
		String genModelFilePath = (String) properties.get(propertyKey);
		return FileUtil.getIFile(URI
				.createPlatformResourceURI(genModelFilePath));
	}

}
