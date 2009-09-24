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

	private static final String MENU_URI_PREFIX = "menu:";
	private static final String PULL_DOWN_BUTTON_ID = "de.itemis.gmf.tools.toolbars.generateLatest";
	
	public GMFButtonContributionFactory() {
		super(MENU_URI_PREFIX + PULL_DOWN_BUTTON_ID, Activator.PLUGIN_ID);
	}

	@Override
	public void createContributionItems(IServiceLocator serviceLocator,
			IContributionRoot additions) {
		for(GmfModel gmfModel: PreferenceUtil.getGmfModels()) {
			CommandContributionItemParameter commandParameter = new CommandContributionItemParameter(serviceLocator, null, GMFToolsHandler.GENERATE_PREDEFINED_COMMAND_ID, CommandContributionItem.STYLE_PUSH);
			Map<String, String> parameters = new HashMap<String, String>();
			parameters.put(GMFToolsHandler.GMF_TOOLS_CONFIG_PARAMETER_NAME, new GmfModel.Factory().serialize(gmfModel));
			commandParameter.parameters = parameters;
			commandParameter.label = gmfModel.getDisplayName();
			commandParameter.tooltip = "Generate from GMFTools config " + gmfModel.getDisplayName();
			commandParameter.visibleEnabled = true;
			CommandContributionItem commandContributionItem = new CommandContributionItem(commandParameter);
			additions.addContributionItem(commandContributionItem, null);
		}

	}
}
