package de.itemis.gmf.tools.popup.actions;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.ui.menus.AbstractContributionFactory;
import org.eclipse.ui.menus.CommandContributionItem;
import org.eclipse.ui.menus.CommandContributionItemParameter;
import org.eclipse.ui.menus.IContributionRoot;
import org.eclipse.ui.services.IServiceLocator;

import de.itemis.gmf.tools.Activator;
import de.itemis.gmf.tools.contribution.GMFToolsHandler;
import de.itemis.gmf.tools.preferences.GmfModel;
import de.itemis.gmf.tools.preferences.PreferenceUtil;

public class GMFButtonContributionFactory extends AbstractContributionFactory {

	public static final String GMF_MODELS_SEPARATOR = ">";
	private static final String MENU_URI_PREFIX = "menu:";
	private static final String PULL_DOWN_BUTTON_ID = "de.itemis.gmf.tools.toolbars.generateLatest";

	public GMFButtonContributionFactory() {
		super(MENU_URI_PREFIX + PULL_DOWN_BUTTON_ID, Activator.PLUGIN_ID);
	}

	@Override
	public void createContributionItems(IServiceLocator serviceLocator, IContributionRoot additions) {
		GmfModel.Factory factory = new GmfModel.Factory();

		CommandContributionItemParameter gmfModelSetCommandParameter = new CommandContributionItemParameter(serviceLocator, null,
				GMFToolsHandler.GENERATE_PREDEFINED_COMMAND_ID, CommandContributionItem.STYLE_PUSH);
		StringBuilder sb = new StringBuilder();
		StringBuilder setCommandToolTip = new StringBuilder();
		boolean first = true;
		for (GmfModel gmfModel : PreferenceUtil.getGmfModels()) {
			if (!gmfModel.isAddToSetOperation()) {
				continue;
			}
			if (first) {
				first = false;
			} else {
				sb = sb.append(GMF_MODELS_SEPARATOR);
				setCommandToolTip = setCommandToolTip.append(", ");
			}
			sb = sb.append(factory.serialize(gmfModel));
			setCommandToolTip = setCommandToolTip.append(gmfModel.getDisplayName());
		}
		if (sb.length() > 0) {
			Map<String, String> gmfModelSetParameters = new HashMap<String, String>();
			gmfModelSetParameters.put(GMFToolsHandler.GMF_TOOLS_CONFIG_SET_PARAMETER_NAME, sb.toString());
			gmfModelSetCommandParameter.parameters = gmfModelSetParameters;
			gmfModelSetCommandParameter.label = "[" + setCommandToolTip.toString() + "]";
			gmfModelSetCommandParameter.tooltip = "Generate from GMFTools config all models that are checked for this action";
			gmfModelSetCommandParameter.visibleEnabled = true;
			CommandContributionItem gmfModelSetCommandContributionItem = new CommandContributionItem(gmfModelSetCommandParameter);
			additions.addContributionItem(gmfModelSetCommandContributionItem, null);
		}

		for (GmfModel gmfModel : PreferenceUtil.getGmfModels()) {
			CommandContributionItemParameter commandParameter = new CommandContributionItemParameter(serviceLocator, null,
					GMFToolsHandler.GENERATE_PREDEFINED_COMMAND_ID, CommandContributionItem.STYLE_PUSH);
			Map<String, String> parameters = new HashMap<String, String>();
			parameters.put(GMFToolsHandler.GMF_TOOLS_CONFIG_PARAMETER_NAME, factory.serialize(gmfModel));
			commandParameter.parameters = parameters;
			commandParameter.label = gmfModel.getDisplayName();
			commandParameter.tooltip = "Generate from GMFTools config " + gmfModel.getDisplayName();
			commandParameter.visibleEnabled = true;
			CommandContributionItem commandContributionItem = new CommandContributionItem(commandParameter);
			additions.addContributionItem(commandContributionItem, null);
		}

	}
}
