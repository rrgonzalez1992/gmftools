package org.xtext.example.resource;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.linking.impl.SimpleAttributeResolver;
import org.eclipse.xtext.resource.IFragmentProvider;
import org.xtext.example.entities.Property;
import org.xtext.example.entities.Type;

public class EntitiesFragmentProvider implements IFragmentProvider {

	public EObject getEObject(Resource resource, String fragment) {
		for (TreeIterator<EObject> allContents = resource.getAllContents(); allContents
				.hasNext();) {
			EObject next = allContents.next();
			if (fragment.equals(getFragment(next))) {
				return next;
			}
		}
		return null;
	}

	public String getFragment(EObject obj) {
		String name = SimpleAttributeResolver.NAME_RESOLVER.apply(obj);
		if (obj instanceof Property) {
			String containerName = SimpleAttributeResolver.NAME_RESOLVER
					.apply(obj.eContainer());
			return containerName + "." + name;
		} else if(obj instanceof Type) {
			return SimpleAttributeResolver.NAME_RESOLVER.apply(obj);
		}
		return null;
	}

}
