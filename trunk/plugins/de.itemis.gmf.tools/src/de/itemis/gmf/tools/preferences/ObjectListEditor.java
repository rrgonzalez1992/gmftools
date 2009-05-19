/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package de.itemis.gmf.tools.preferences;

import java.util.ArrayList;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.preference.FieldEditor;
import org.eclipse.jface.preference.ListEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Widget;

/**
 * Mostly copied from {@link ListEditor} which unfortunately did not offer the
 * hooks to have a list of objects rather than a list of strings. </p>
 * 
 * @author koehnlein
 */
public abstract class ObjectListEditor extends FieldEditor {

	public static final String PREFERENCE_ITEM_SEPARATOR = "%;%";

	private List list;

	private ArrayList<ObjectListEntry> contents = new ArrayList<ObjectListEntry>();

	private ObjectListEntry.Factory entryFactory;

	private Composite buttonBox;

	private Button addButton;

	private Button editButton;

	private Button removeButton;

	private Button upButton;

	private Button downButton;

	private SelectionListener selectionListener;

	/**
	 * Creates an object list field editor.
	 * 
	 * @param name
	 *            the name of the preference this field editor works on
	 * @param labelText
	 *            the label text of the field editor
	 * @param factory
	 *            the factory to serialize and deserialize the entries
	 * @param parent
	 *            the parent of the field editor's control
	 */
	protected ObjectListEditor(String name, String labelText,
			ObjectListEntry.Factory factory, Composite parent) {
		init(name, labelText);
		createControl(parent);
		this.entryFactory = factory;
	}

	private void addPressed() {
		setPresentsDefaultValue(false);
		ObjectListEntry input = editEntry(entryFactory.create());

		if (input != null) {
			int index = list.getSelectionIndex();
			if (index >= 0) {
				list.add(input.getDisplayName(), index + 1);
				contents.add(index + 1, input);
			} else {
				list.add(input.getDisplayName(), 0);
				contents.add(0, input);
			}
			selectionChanged();
		}
	}

	private void editPressed() {
		setPresentsDefaultValue(false);
		Assert.isTrue(list.getSelectionCount() == 1);
		int selectionIndex = list.getSelectionIndex();
		editEntry(contents.get(selectionIndex));
	}

	protected abstract ObjectListEntry editEntry(ObjectListEntry entry);

	private void removePressed() {
		setPresentsDefaultValue(false);
		int index = list.getSelectionIndex();
		if (index >= 0) {
			list.remove(index);
			contents.remove(index);
			selectionChanged();
		}
	}

	private void upPressed() {
		swap(true);
	}

	private void downPressed() {
		swap(false);
	}

	/**
	 * Moves the currently selected item up or down.
	 * 
	 * @param up
	 *            <code>true</code> if the item should move up, and
	 *            <code>false</code> if it should move down
	 */
	private void swap(boolean up) {
		setPresentsDefaultValue(false);
		int index = list.getSelectionIndex();
		int target = up ? index - 1 : index + 1;

		if (index >= 0) {
			String[] selection = list.getSelection();
			Assert.isTrue(selection.length == 1);
			list.remove(index);
			ObjectListEntry removedObject = contents.remove(index);
			list.add(selection[0], target);
			contents.add(target, removedObject);
			list.setSelection(target);
		}
		selectionChanged();
	}

	private void createButtons(Composite box) {
		addButton = createPushButton(box, "Add");
		editButton = createPushButton(box, "Edit");
		removeButton = createPushButton(box, "Remove");
		upButton = createPushButton(box, "Up");
		downButton = createPushButton(box, "Down");
	}

	private Button createPushButton(Composite parent, String text) {
		Button button = new Button(parent, SWT.PUSH);
		button.setText(text);
		button.setFont(parent.getFont());
		GridData data = new GridData(GridData.FILL_HORIZONTAL);
		int widthHint = convertHorizontalDLUsToPixels(button,
				IDialogConstants.BUTTON_WIDTH);
		data.widthHint = Math.max(widthHint, button.computeSize(SWT.DEFAULT,
				SWT.DEFAULT, true).x);
		button.setLayoutData(data);
		button.addSelectionListener(getSelectionListener());
		return button;
	}

	public void createSelectionListener() {
		selectionListener = new SelectionAdapter() {
			public void widgetSelected(SelectionEvent event) {
				Widget widget = event.widget;
				if (widget == addButton) {
					addPressed();
				} else if (widget == editButton) {
					editPressed();
				} else if (widget == removeButton) {
					removePressed();
				} else if (widget == upButton) {
					upPressed();
				} else if (widget == downButton) {
					downPressed();
				} else if (widget == list) {
					selectionChanged();
				}
			}

		};
	}

	protected void doFillIntoGrid(Composite parent, int numColumns) {
		Control control = getLabelControl(parent);
		GridData gd = new GridData();
		gd.horizontalSpan = numColumns;
		control.setLayoutData(gd);

		list = getListControl(parent);
		gd = new GridData(GridData.FILL_HORIZONTAL);
		gd.verticalAlignment = GridData.FILL;
		gd.horizontalSpan = numColumns - 1;
		gd.grabExcessHorizontalSpace = true;
		list.setLayoutData(gd);

		buttonBox = getButtonBoxControl(parent);
		gd = new GridData();
		gd.verticalAlignment = GridData.BEGINNING;
		buttonBox.setLayoutData(gd);
	}

	protected void doLoad() {
		if (list != null) {
			String s = getPreferenceStore().getString(getPreferenceName());
			populateList(s);
		}
	}

	protected void doLoadDefault() {
		if (list != null) {
			list.removeAll();
			String s = getPreferenceStore().getDefaultString(
					getPreferenceName());
			populateList(s);
		}
	}

	private void populateList(String s) {
		if (s != null && !"".equals(s)) {
			String[] array = s.split(PREFERENCE_ITEM_SEPARATOR);
			for (int i = 0; i < array.length; i++) {
				if (!"".equals(array)) {
					ObjectListEntry entry = entryFactory.deserialize(array[i]);
					list.add(entry.getDisplayName());
					contents.add(entry);
				}
			}
		}
	}

	protected void doStore() {
		StringBuilder builder = new StringBuilder();
		boolean isFirst = true;
		for (ObjectListEntry entry : contents) {
			if (!isFirst)
				builder.append(PREFERENCE_ITEM_SEPARATOR);
			isFirst = false;
			builder.append(entryFactory.serialize(entry));
		}
		String s = builder.toString();
		getPreferenceStore().setValue(getPreferenceName(), s);
	}

	public Composite getButtonBoxControl(Composite parent) {
		if (buttonBox == null) {
			buttonBox = new Composite(parent, SWT.NULL);
			GridLayout layout = new GridLayout();
			layout.marginWidth = 0;
			buttonBox.setLayout(layout);
			createButtons(buttonBox);
			buttonBox.addDisposeListener(new DisposeListener() {
				public void widgetDisposed(DisposeEvent event) {
					addButton = null;
					removeButton = null;
					upButton = null;
					downButton = null;
					buttonBox = null;
				}
			});

		} else {
			checkParent(buttonBox, parent);
		}

		selectionChanged();
		return buttonBox;
	}

	public List getListControl(Composite parent) {
		if (list == null) {
			list = new List(parent, SWT.BORDER | SWT.SINGLE | SWT.V_SCROLL
					| SWT.H_SCROLL);
			list.setFont(parent.getFont());
			list.addSelectionListener(getSelectionListener());
			list.addDisposeListener(new DisposeListener() {
				public void widgetDisposed(DisposeEvent event) {
					list = null;
				}
			});
		} else {
			checkParent(list, parent);
		}
		return list;
	}

	protected void adjustForNumColumns(int numColumns) {
		Control control = getLabelControl();
		((GridData) control.getLayoutData()).horizontalSpan = numColumns;
		((GridData) list.getLayoutData()).horizontalSpan = numColumns - 1;
	}

	public int getNumberOfControls() {
		return 2;
	}

	private SelectionListener getSelectionListener() {
		if (selectionListener == null) {
			createSelectionListener();
		}
		return selectionListener;
	}

	protected Shell getShell() {
		if (addButton == null) {
			return null;
		}
		return addButton.getShell();
	}

	private void selectionChanged() {

		int index = list.getSelectionIndex();
		int size = list.getItemCount();

		editButton.setEnabled(list.getSelectionCount() == 1);
		removeButton.setEnabled(index >= 0);
		upButton.setEnabled(size > 1 && index > 0);
		downButton.setEnabled(size > 1 && index >= 0 && index < size - 1);
	}

	public void setFocus() {
		if (list != null) {
			list.setFocus();
		}
	}

	public void setEnabled(boolean enabled, Composite parent) {
		super.setEnabled(enabled, parent);
		getListControl(parent).setEnabled(enabled);
		addButton.setEnabled(enabled);
		removeButton.setEnabled(enabled);
		upButton.setEnabled(enabled);
		downButton.setEnabled(enabled);
	}
}
