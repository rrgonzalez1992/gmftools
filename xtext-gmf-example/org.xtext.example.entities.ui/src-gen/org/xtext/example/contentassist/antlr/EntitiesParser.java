/*
* generated by Xtext
*/
package org.xtext.example.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import org.xtext.example.services.EntitiesGrammarAccess;

public class EntitiesParser extends AbstractContentAssistParser {
	
	@Inject
	private EntitiesGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected org.xtext.example.contentassist.antlr.internal.InternalEntitiesParser createParser() {
		org.xtext.example.contentassist.antlr.internal.InternalEntitiesParser result = new org.xtext.example.contentassist.antlr.internal.InternalEntitiesParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getTypeAccess().getAlternatives(), "rule__Type__Alternatives");
					put(grammarAccess.getPropertyAccess().getAlternatives(), "rule__Property__Alternatives");
					put(grammarAccess.getModelAccess().getGroup(), "rule__Model__Group__0");
					put(grammarAccess.getImportAccess().getGroup(), "rule__Import__Group__0");
					put(grammarAccess.getSimpleTypeAccess().getGroup(), "rule__SimpleType__Group__0");
					put(grammarAccess.getEntityAccess().getGroup(), "rule__Entity__Group__0");
					put(grammarAccess.getEntityAccess().getGroup_2(), "rule__Entity__Group_2__0");
					put(grammarAccess.getSimplePropertyAccess().getGroup(), "rule__SimpleProperty__Group__0");
					put(grammarAccess.getSimplePropertyAccess().getGroup_2(), "rule__SimpleProperty__Group_2__0");
					put(grammarAccess.getReferenceAccess().getGroup(), "rule__Reference__Group__0");
					put(grammarAccess.getModelAccess().getImportsAssignment_1(), "rule__Model__ImportsAssignment_1");
					put(grammarAccess.getModelAccess().getElementsAssignment_2(), "rule__Model__ElementsAssignment_2");
					put(grammarAccess.getImportAccess().getImportURIAssignment_1(), "rule__Import__ImportURIAssignment_1");
					put(grammarAccess.getSimpleTypeAccess().getNameAssignment_1(), "rule__SimpleType__NameAssignment_1");
					put(grammarAccess.getEntityAccess().getNameAssignment_1(), "rule__Entity__NameAssignment_1");
					put(grammarAccess.getEntityAccess().getExtendsAssignment_2_1(), "rule__Entity__ExtendsAssignment_2_1");
					put(grammarAccess.getEntityAccess().getPropertiesAssignment_4(), "rule__Entity__PropertiesAssignment_4");
					put(grammarAccess.getSimplePropertyAccess().getNameAssignment_1(), "rule__SimpleProperty__NameAssignment_1");
					put(grammarAccess.getSimplePropertyAccess().getTypeAssignment_2_1(), "rule__SimpleProperty__TypeAssignment_2_1");
					put(grammarAccess.getSimplePropertyAccess().getManyAssignment_2_2(), "rule__SimpleProperty__ManyAssignment_2_2");
					put(grammarAccess.getReferenceAccess().getNameAssignment_1(), "rule__Reference__NameAssignment_1");
					put(grammarAccess.getReferenceAccess().getTypeAssignment_3(), "rule__Reference__TypeAssignment_3");
					put(grammarAccess.getReferenceAccess().getManyAssignment_4(), "rule__Reference__ManyAssignment_4");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			org.xtext.example.contentassist.antlr.internal.InternalEntitiesParser typedParser = (org.xtext.example.contentassist.antlr.internal.InternalEntitiesParser) parser;
			typedParser.entryRuleModel();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}
	
	public EntitiesGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(EntitiesGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
