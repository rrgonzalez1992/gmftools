package org.xtext.example.entities.diagram.edit.part;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.gef.Request;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.xtext.gmf.glue.edit.part.InDiagramXtextEditorHelper;
import org.xtext.example.entities.diagram.edit.parts.SimplePropertyEditPart;
import org.xtext.example.entities.diagram.extensions.Activator;
import org.xtext.example.internal.EntitiesActivator;

public class SimplePropertyInDiagramEditorEditPartOverride extends SimplePropertyEditPart {

	public SimplePropertyInDiagramEditorEditPartOverride(View view) {
		super(view);
	}

	@Override
	protected void performDirectEdit() {
		openInDiagramXtextEditor();
	}

	@Override
	protected void performDirectEdit(Point eventLocation) {
		openInDiagramXtextEditor();
	}
	
	@Override
	protected void performDirectEditRequest(Request request) {
		final Request theRequest = request;
		try {
			getEditingDomain().runExclusive(new Runnable() {

				public void run() {
					if (isActive() && isEditable()) {
						if ((theRequest instanceof DirectEditRequest)
								&& (getEditText().equals(getLabelText()))) {
							DirectEditRequest editRequest = (DirectEditRequest) theRequest;
							performDirectEdit(editRequest.getLocation());
						} else {
							performDirectEdit();
						}
					}
				}
			});
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void openInDiagramXtextEditor() {
		try {
			new InDiagramXtextEditorHelper(this, EntitiesActivator.getInstance().getInjector(
					"org.xtext.example.Entities")).showEditor();
		} catch (Exception e) {
			Activator.getDefault().getLog().log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage(), e));
		}
	}

}
