/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.itemis.gmf.tools.preferences;

import java.io.File;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;

/**
 * @author koehnlein
 */
public class GmfModel implements ObjectListEntry {

	private static final String NO = "no";
	public static final String EXTENSION_FEATURE_SEPARATOR = "|";
	public static final String ADD_TO_SET_OPERATION = "addToSetOperation";
	public static final String GENERATE_RCP = "generateRCP";
	private String displayName;
	private IFile genModelFile;
	private IFile gmfMapModelFile;
	private IFile gmfGenModelFile;
	private IFile gmfTrafoFile;
	private IFile transformedGmfGenModelFile;
	private String addToSetOperation = NO;
	private String generateRCP = NO;

	public void setGenModelFile(IFile genModelFile) {
		this.genModelFile = genModelFile;
	}

	public void setGmfMapModelFile(IFile gmfMapModelFile) {
		this.gmfMapModelFile = gmfMapModelFile;
	}

	public void setGmfGenModelFile(IFile gmfGenModelFile) {
		this.gmfGenModelFile = gmfGenModelFile;
	}

	public void setGmfTrafoFile(IFile gmfTrafoFile) {
		this.gmfTrafoFile = gmfTrafoFile;
	}

	public void setTransformedGmfGenModelFile(IFile transformedGmfGenModelFile) {
		this.transformedGmfGenModelFile = transformedGmfGenModelFile;
	}

	public void setDisplayName(String name) {
		this.displayName = name;
	}

	public void setAddToSetOperation(boolean value) {
		this.addToSetOperation = (value) ? ADD_TO_SET_OPERATION : NO;
	}

	public void setGenerateRCP(boolean value) {
		this.generateRCP = (value) ? GENERATE_RCP : NO;
	}

	public IFile getGenModelFile() {
		return genModelFile;
	}

	public IFile getGmfMapModelFile() {
		return gmfMapModelFile;
	}

	public IFile getGmfGenModelFile() {
		return gmfGenModelFile;
	}

	public IFile getGmfTrafoFile() {
		return gmfTrafoFile;
	}

	public IFile getTransformedGmfGenModelFile() {
		return transformedGmfGenModelFile;
	}

	public String getDisplayName() {
		return displayName;
	}

	public boolean isAddToSetOperation() {
		return ADD_TO_SET_OPERATION.equals(addToSetOperation);
	}

	public boolean isGenerateRCP() {
		return GENERATE_RCP.equals(generateRCP);
	}

	public String getAddToSetOperation() {
		return addToSetOperation;
	}

	public String getGenerateRCP() {
		return generateRCP;
	}

	public boolean hasFile(IFile file) {
		return gmfMapModelFile.equals(file) || gmfGenModelFile.equals(file) || gmfTrafoFile.equals(file)
				|| transformedGmfGenModelFile.equals(file);
	}


	public static class Factory implements ObjectListEntry.Factory {

		public ObjectListEntry create() {
			return new GmfModel();
		}

		public ObjectListEntry deserialize(String source) {
			GmfModel gmfModel = new GmfModel();
			IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
			String[] fileNames = source.split(File.pathSeparator);
			gmfModel.displayName = fileNames[0];
			gmfModel.gmfMapModelFile = getFile(workspaceRoot, fileNames[1]);
			gmfModel.genModelFile = getFile(workspaceRoot, fileNames[2]);
			gmfModel.gmfGenModelFile = getFile(workspaceRoot, fileNames[3]);
			gmfModel.gmfTrafoFile = getFile(workspaceRoot, fileNames[4]);
			gmfModel.transformedGmfGenModelFile = workspaceRoot.getFile(new Path(fileNames[5]));
			if (fileNames.length > 6) {
				gmfModel.addToSetOperation = fileNames[6];
			}
			if (fileNames.length > 7) {
				gmfModel.generateRCP = fileNames[7];
			}

			return gmfModel;
		}

		public String serialize(ObjectListEntry entry) {
			return serialize((GmfModel) entry);
		}

		private String serialize(GmfModel entry) {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append(nullSafe(entry.getDisplayName()));
			stringBuilder.append(File.pathSeparator);
			stringBuilder.append(nullSafe(entry.getGmfMapModelFile()));
			stringBuilder.append(File.pathSeparator);
			stringBuilder.append(nullSafe(entry.getGenModelFile()));
			stringBuilder.append(File.pathSeparator);
			stringBuilder.append(nullSafe(entry.getGmfGenModelFile()));
			stringBuilder.append(File.pathSeparator);
			stringBuilder.append(nullSafe(entry.getGmfTrafoFile()));
			stringBuilder.append(File.pathSeparator);
			stringBuilder.append(nullSafe(entry.getTransformedGmfGenModelFile()));
			stringBuilder.append(File.pathSeparator);
			stringBuilder.append(nullSafe(entry.getAddToSetOperation()));
			stringBuilder.append(File.pathSeparator);
			stringBuilder.append(nullSafe(entry.getGenerateRCP()));

			return stringBuilder.toString();
		}

		private static IFile getFile(IWorkspaceRoot workspaceRoot, String fullPath) {
			return (fullPath == "") ? null : workspaceRoot.getFile(new Path(fullPath));
		}

		private String nullSafe(String s) {
			return (s == null) ? "" : s;
		}

		private String nullSafe(IFile file) {
			return (file == null) ? "" : nullSafe(file.getFullPath().toString());
		}


	}

}
