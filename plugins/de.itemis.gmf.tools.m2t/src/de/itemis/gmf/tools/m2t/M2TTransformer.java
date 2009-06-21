package de.itemis.gmf.tools.m2t;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.emf.codegen.ecore.genmodel.GenModelPackage;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.codegen.gmfgen.GMFGenPackage;
import org.eclipse.xtend.XtendFacade;
import org.eclipse.xtend.expression.ExecutionContextImpl;
import org.eclipse.xtend.expression.ResourceManagerDefaultImpl;
import org.eclipse.xtend.expression.TypeSystemImpl;
import org.eclipse.xtend.shared.ui.Activator;
import org.eclipse.xtend.shared.ui.core.IXtendXpandProject;
import org.eclipse.xtend.shared.ui.core.IXtendXpandResource;
import org.eclipse.xtend.typesystem.emf.EmfRegistryMetaModel;

import de.itemis.gmf.tools.FileUtil;
import de.itemis.gmf.tools.IGmfGenModelTransformer;

public class M2TTransformer implements IGmfGenModelTransformer {
	
	@SuppressWarnings("unchecked")
	public List<EObject> transformGmfGenModel(IFile gmfGenModelFile,
			IFile transformationFile, ResourceSet resourceSet) {
		final List<EPackage> metaModelPackages = findMetaModelPackages(resourceSet);
		URI genModelResourceURI = FileUtil.getURI(gmfGenModelFile);
		Resource genModelResource = resourceSet.getResource(
				genModelResourceURI, true);
		TypeSystemImpl ts = new TypeSystemImpl();
		ts.registerMetaModel(new EmfRegistryMetaModel() {
			@Override
			protected EPackage[] allPackages() {
				return metaModelPackages.toArray(new EPackage[metaModelPackages
						.size()]);
			}
		});
		IXtendXpandProject oawProject = Activator.getExtXptModelManager()
				.findProject(gmfGenModelFile.getProject());
		if (oawProject == null) {
			throw new IllegalStateException(
					"Project enclosing transformation file does not have an Xpand nature\nPlease add the oaw nature to the project containing the .ext transformation file.");
		}

		ExecutionContextImpl context = new ExecutionContextImpl(
				new WorkspaceResourceManager(oawProject), ts, null);
		XtendFacade facade = XtendFacade.create(context, FileUtil
				.getLocationWithoutExtension(transformationFile));
		List<EObject> transformedGenModel = (List<EObject>) facade.call(
				"transform", (Object) genModelResource.getContents());
		resourceSet.getResources().remove(genModelResource);
		return transformedGenModel;
	}

	private List<EPackage> findMetaModelPackages(ResourceSet resourceSet) {
		final List<EPackage> metamodels = new ArrayList<EPackage>();
		EcoreUtil.resolveAll(resourceSet);
		for (Resource resource : resourceSet.getResources()) {
			TreeIterator<EObject> allContents = resource.getAllContents();
			if (allContents.hasNext()) {
				EObject rootObject = allContents.next();
				if (rootObject instanceof EPackage)
					metamodels.add((EPackage) rootObject);
			}
		}
		if (!metamodels.contains(GMFGenPackage.eINSTANCE)) {
			metamodels.add(GMFGenPackage.eINSTANCE);
		}
		if (!metamodels.contains(EcorePackage.eINSTANCE)) {
			metamodels.add(EcorePackage.eINSTANCE);
		}
		if (!metamodels.contains(GenModelPackage.eINSTANCE)) {
			metamodels.add(GenModelPackage.eINSTANCE);
		}
		return metamodels;
	}

	/**
	 * Copied from package org.openarchitectureware.emf.editor.oaw
	 */
	private class WorkspaceResourceManager extends
			ResourceManagerDefaultImpl {
		private IXtendXpandProject project;

		public WorkspaceResourceManager(IXtendXpandProject p) {
			this.project = p;
		}

		public org.eclipse.xtend.expression.Resource loadResource(
				String fullyQualifiedName, String extension) {
			IXtendXpandResource extXptResource = project.findExtXptResource(
					fullyQualifiedName, extension);
			if (extXptResource != null)
				return extXptResource.getExtXptResource();
			return super.loadResource(fullyQualifiedName, extension);
		}

	}
}
