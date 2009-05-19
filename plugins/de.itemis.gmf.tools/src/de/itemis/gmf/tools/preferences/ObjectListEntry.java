/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.itemis.gmf.tools.preferences;

/**
 * @author koehnlein
 */
public interface ObjectListEntry {

	String getDisplayName();

	interface Factory {
		ObjectListEntry create();
		
		String serialize(ObjectListEntry entry);

		ObjectListEntry deserialize(String source);
	}
}
