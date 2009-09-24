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

	private String displayName;
	private IFile genModelFile;
	private IFile gmfMapModelFile;
	private IFile gmfGenModelFile;
	private IFile gmfTrafoFile;
	private IFile transformedGmfGenModelFile;

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

	public boolean hasFile(IFile file) {
		return gmfMapModelFile.equals(file) || gmfGenModelFile.equals(file) || gmfTrafoFile.equals(file) || transformedGmfGenModelFile.equals(file);
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
			gmfModel.transformedGmfGenModelFile = workspaceRoot.getFile(new Path(
					fileNames[5]));
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
			return stringBuilder.toString();
		}

		private static IFile getFile(IWorkspaceRoot workspaceRoot, String fullPath) {
			return (fullPath == "") ? null : workspaceRoot.getFile(new Path(
					fullPath));
		}

		private String nullSafe(String s) {
			return (s == null) ? "" : s;
		}

		private String nullSafe(IFile file) {
			return (file == null) ? "" : nullSafe(file.getFullPath().toString());
		}

	}
}
