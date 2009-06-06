/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.itemis.gmf.tools.contribution;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature.Setting;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.ECrossReferenceAdapter;
import org.eclipse.gmf.codegen.gmfgen.ElementType;
import org.eclipse.gmf.codegen.gmfgen.GMFGenFactory;
import org.eclipse.gmf.codegen.gmfgen.GenChildNode;
import org.eclipse.gmf.codegen.gmfgen.GenDiagram;
import org.eclipse.gmf.codegen.gmfgen.GenLink;
import org.eclipse.gmf.codegen.gmfgen.GenTopLevelNode;
import org.eclipse.gmf.codegen.gmfgen.MetamodelType;
import org.eclipse.gmf.codegen.gmfgen.SpecializationType;
import org.eclipse.gmf.runtime.emf.core.util.CrossReferenceAdapter;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;

import de.itemis.gmf.tools.FileUtil;
import de.itemis.gmf.tools.preferences.GmfModel;
import de.itemis.gmf.tools.preferences.PreferenceUtil;

public class GmfGenModelTypeRegistryHarmonizer {

	public static boolean harmonizeTypeRegistration(List<GmfModel> gmfModels,
			Set<IFile> changedGmfGenModels, IProgressMonitor monitor) {
		try {
			monitor.subTask("Harmonize type registrations");
			ResourceSet resourceSet = new ResourceSetImpl();
			CrossReferenceAdapter crossReferenceAdapter = new CrossReferenceAdapter();
			resourceSet.eAdapters().add(crossReferenceAdapter);
			List<List<MetamodelType>> elementTypes = new ArrayList<List<MetamodelType>>();
			for (GmfModel gmfModel : gmfModels) {
				IFile usedGmfGenModel = (PreferenceUtil.isTransformGmfGen()) ? gmfModel
						.getTransformedGmfGenModelFile()
						: gmfModel.getGmfGenModelFile();
				URI gmfGenModelURI = FileUtil.getURI(usedGmfGenModel);
				Resource resource = resourceSet.getResource(gmfGenModelURI,
						true);
				elementTypes.add(getMetamodelTypes(resource));
			}
			for (int i = 0; i < elementTypes.size(); ++i) {
				List<MetamodelType> currentElementTypes = elementTypes.get(i);
				for (int j = i + 1; j < elementTypes.size(); ++j) {
					List<MetamodelType> otherElementTypes = elementTypes.get(j);
					for (MetamodelType currentType : currentElementTypes) {
						EClass currentEcoreClass = currentType.getMetaClass()
								.getEcoreClass();
						for (Iterator<MetamodelType> otherTypeIter = otherElementTypes
								.iterator(); otherTypeIter.hasNext();) {
							MetamodelType otherType = otherTypeIter.next();
							EClass otherEcoreClass = otherType.getMetaClass()
									.getEcoreClass();
							if (currentEcoreClass == otherEcoreClass) {
								replaceWithSpecializationType(otherType,
										currentType);
								otherTypeIter.remove();
							}
						}
					}
				}
			}
			for (Resource resource : resourceSet.getResources()) {
				if (resource.isLoaded() && resource.isModified()) {
					resource.save(null);
					changedGmfGenModels.add(FileUtil
							.getIFile(resource.getURI()));
				}
			}
			monitor.worked(1);
			return true;
		} catch (Exception exc) {
			MessageDialog.openError(Display.getDefault().getActiveShell(),
					"Error transforming map model", exc.getMessage());
		}
		return false;
	}

	private static void replaceWithSpecializationType(
			MetamodelType metamodelTypeToBeReplaced,
			MetamodelType referencedType) {
		SpecializationType specializationType = GMFGenFactory.eINSTANCE
				.createSpecializationType();
		specializationType.setDisplayName(metamodelTypeToBeReplaced
				.getDisplayName());
		// specializationType
		// .setEditHelperAdviceClassName("org.eclipse.gmf.runtime.emf.type.core.edithelper.AbstractEditHelperAdvice");
		specializationType.setMetamodelType(referencedType);
		specializationType.setUniqueIdentifier(metamodelTypeToBeReplaced
				.getUniqueIdentifier());
		ECrossReferenceAdapter crossReferenceAdapter = ECrossReferenceAdapter
				.getCrossReferenceAdapter(metamodelTypeToBeReplaced);
		Collection<Setting> inverseReferences = crossReferenceAdapter
				.getInverseReferences(metamodelTypeToBeReplaced);
		for (Setting inverseReference : inverseReferences) {
			if (inverseReference.getEObject() instanceof SpecializationType) {
				inverseReference.set(referencedType);
			} else {
				inverseReference.set(specializationType);
			}
		}
		specializationType.eResource().setModified(true);
	}

	private static GenDiagram findGenDiagram(Resource resource) {
		for (Iterator<EObject> iter = resource.getAllContents(); iter.hasNext();) {
			EObject next = iter.next();
			if (next instanceof GenDiagram) {
				return (GenDiagram) next;
			}
		}
		return null;
	}

	private static List<MetamodelType> getMetamodelTypes(Resource gmfGenResource) {
		List<MetamodelType> elementTypes = new ArrayList<MetamodelType>();
		GenDiagram genDiagram = findGenDiagram(gmfGenResource);
		if (genDiagram != null) {
			addIfMetamodelType(elementTypes, genDiagram.getElementType());
			for (GenTopLevelNode topLevelNode : genDiagram.getTopLevelNodes()) {
				addIfMetamodelType(elementTypes, topLevelNode.getElementType());
			}
			for (GenChildNode childNode : genDiagram.getChildNodes()) {
				addIfMetamodelType(elementTypes, childNode.getElementType());
			}
			for (GenLink link : genDiagram.getLinks()) {
				addIfMetamodelType(elementTypes, link.getElementType());
			}
		}
		return elementTypes;
	}

	private static void addIfMetamodelType(List<MetamodelType> list,
			ElementType o) {
		if (o instanceof MetamodelType) {
			list.add((MetamodelType) o);
		}
	}

}
