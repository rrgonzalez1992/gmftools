package org.xtext.example.entities.diagram.edit.part;

import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.xtext.example.entities.diagram.edit.parts.EntitiesEditPartFactory;
import org.xtext.example.entities.diagram.edit.parts.SimplePropertyEditPart;
import org.xtext.example.entities.diagram.part.EntitiesVisualIDRegistry;

public class EntitiesEditPartFactoryOverride extends EntitiesEditPartFactory {

	@Override
	public EditPart createEditPart(EditPart context, Object model) {
		if (model instanceof View) {
			View view = (View) model;
			switch (EntitiesVisualIDRegistry.getVisualID(view)) {

			case SimplePropertyEditPart.VISUAL_ID:
				return new SimplePropertyInDiagramEditorEditPartOverride(view);
//				return new SimplePropertyWrapperEditPartOverride(view);
			}
		}
		return super.createEditPart(context, model);
	}
}
