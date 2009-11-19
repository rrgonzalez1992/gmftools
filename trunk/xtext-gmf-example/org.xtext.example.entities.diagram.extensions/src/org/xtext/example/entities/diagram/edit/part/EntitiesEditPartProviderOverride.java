package org.xtext.example.entities.diagram.edit.part;

import org.xtext.example.entities.diagram.providers.EntitiesEditPartProvider;

public class EntitiesEditPartProviderOverride extends EntitiesEditPartProvider {

	public EntitiesEditPartProviderOverride() {
		setFactory(new EntitiesEditPartFactoryOverride());
	}
}
