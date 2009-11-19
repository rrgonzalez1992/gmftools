package org.xtext.example.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.xtext.example.services.EntitiesGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalEntitiesParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'import'", "'type'", "'entity'", "'{'", "'}'", "'extends'", "'property'", "':'", "'reference'", "'[]'"
    };
    public static final int RULE_ID=5;
    public static final int RULE_STRING=4;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

        public InternalEntitiesParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g"; }


     
     	private EntitiesGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(EntitiesGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }
        
        @Override
        protected String getValueForTokenName(String tokenName) {
        	return tokenName;
        }




    // $ANTLR start entryRuleModel
    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:60:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:60:16: ( ruleModel EOF )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:61:1: ruleModel EOF
            {
             before(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel60);
            ruleModel();
            _fsp--;

             after(grammarAccess.getModelRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel67); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end entryRuleModel


    // $ANTLR start ruleModel
    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:68:1: ruleModel : ( ( rule__Model__Group__0 ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:72:2: ( ( ( rule__Model__Group__0 ) ) )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:73:1: ( ( rule__Model__Group__0 ) )
            {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:73:1: ( ( rule__Model__Group__0 ) )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:74:1: ( rule__Model__Group__0 )
            {
             before(grammarAccess.getModelAccess().getGroup()); 
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:75:1: ( rule__Model__Group__0 )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:75:2: rule__Model__Group__0
            {
            pushFollow(FOLLOW_rule__Model__Group__0_in_ruleModel94);
            rule__Model__Group__0();
            _fsp--;


            }

             after(grammarAccess.getModelAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleModel


    // $ANTLR start entryRuleImport
    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:87:1: entryRuleImport : ruleImport EOF ;
    public final void entryRuleImport() throws RecognitionException {
        try {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:87:17: ( ruleImport EOF )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:88:1: ruleImport EOF
            {
             before(grammarAccess.getImportRule()); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport120);
            ruleImport();
            _fsp--;

             after(grammarAccess.getImportRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport127); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end entryRuleImport


    // $ANTLR start ruleImport
    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:95:1: ruleImport : ( ( rule__Import__Group__0 ) ) ;
    public final void ruleImport() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:99:2: ( ( ( rule__Import__Group__0 ) ) )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:100:1: ( ( rule__Import__Group__0 ) )
            {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:100:1: ( ( rule__Import__Group__0 ) )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:101:1: ( rule__Import__Group__0 )
            {
             before(grammarAccess.getImportAccess().getGroup()); 
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:102:1: ( rule__Import__Group__0 )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:102:2: rule__Import__Group__0
            {
            pushFollow(FOLLOW_rule__Import__Group__0_in_ruleImport154);
            rule__Import__Group__0();
            _fsp--;


            }

             after(grammarAccess.getImportAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleImport


    // $ANTLR start entryRuleType
    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:114:1: entryRuleType : ruleType EOF ;
    public final void entryRuleType() throws RecognitionException {
        try {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:114:15: ( ruleType EOF )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:115:1: ruleType EOF
            {
             before(grammarAccess.getTypeRule()); 
            pushFollow(FOLLOW_ruleType_in_entryRuleType180);
            ruleType();
            _fsp--;

             after(grammarAccess.getTypeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleType187); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end entryRuleType


    // $ANTLR start ruleType
    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:122:1: ruleType : ( ( rule__Type__Alternatives ) ) ;
    public final void ruleType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:126:2: ( ( ( rule__Type__Alternatives ) ) )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:127:1: ( ( rule__Type__Alternatives ) )
            {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:127:1: ( ( rule__Type__Alternatives ) )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:128:1: ( rule__Type__Alternatives )
            {
             before(grammarAccess.getTypeAccess().getAlternatives()); 
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:129:1: ( rule__Type__Alternatives )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:129:2: rule__Type__Alternatives
            {
            pushFollow(FOLLOW_rule__Type__Alternatives_in_ruleType214);
            rule__Type__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getTypeAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleType


    // $ANTLR start entryRuleSimpleType
    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:141:1: entryRuleSimpleType : ruleSimpleType EOF ;
    public final void entryRuleSimpleType() throws RecognitionException {
        try {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:141:21: ( ruleSimpleType EOF )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:142:1: ruleSimpleType EOF
            {
             before(grammarAccess.getSimpleTypeRule()); 
            pushFollow(FOLLOW_ruleSimpleType_in_entryRuleSimpleType240);
            ruleSimpleType();
            _fsp--;

             after(grammarAccess.getSimpleTypeRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpleType247); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end entryRuleSimpleType


    // $ANTLR start ruleSimpleType
    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:149:1: ruleSimpleType : ( ( rule__SimpleType__Group__0 ) ) ;
    public final void ruleSimpleType() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:153:2: ( ( ( rule__SimpleType__Group__0 ) ) )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:154:1: ( ( rule__SimpleType__Group__0 ) )
            {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:154:1: ( ( rule__SimpleType__Group__0 ) )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:155:1: ( rule__SimpleType__Group__0 )
            {
             before(grammarAccess.getSimpleTypeAccess().getGroup()); 
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:156:1: ( rule__SimpleType__Group__0 )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:156:2: rule__SimpleType__Group__0
            {
            pushFollow(FOLLOW_rule__SimpleType__Group__0_in_ruleSimpleType274);
            rule__SimpleType__Group__0();
            _fsp--;


            }

             after(grammarAccess.getSimpleTypeAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleSimpleType


    // $ANTLR start entryRuleEntity
    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:168:1: entryRuleEntity : ruleEntity EOF ;
    public final void entryRuleEntity() throws RecognitionException {
        try {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:168:17: ( ruleEntity EOF )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:169:1: ruleEntity EOF
            {
             before(grammarAccess.getEntityRule()); 
            pushFollow(FOLLOW_ruleEntity_in_entryRuleEntity300);
            ruleEntity();
            _fsp--;

             after(grammarAccess.getEntityRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEntity307); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end entryRuleEntity


    // $ANTLR start ruleEntity
    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:176:1: ruleEntity : ( ( rule__Entity__Group__0 ) ) ;
    public final void ruleEntity() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:180:2: ( ( ( rule__Entity__Group__0 ) ) )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:181:1: ( ( rule__Entity__Group__0 ) )
            {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:181:1: ( ( rule__Entity__Group__0 ) )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:182:1: ( rule__Entity__Group__0 )
            {
             before(grammarAccess.getEntityAccess().getGroup()); 
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:183:1: ( rule__Entity__Group__0 )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:183:2: rule__Entity__Group__0
            {
            pushFollow(FOLLOW_rule__Entity__Group__0_in_ruleEntity334);
            rule__Entity__Group__0();
            _fsp--;


            }

             after(grammarAccess.getEntityAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleEntity


    // $ANTLR start entryRuleProperty
    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:195:1: entryRuleProperty : ruleProperty EOF ;
    public final void entryRuleProperty() throws RecognitionException {
        try {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:195:19: ( ruleProperty EOF )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:196:1: ruleProperty EOF
            {
             before(grammarAccess.getPropertyRule()); 
            pushFollow(FOLLOW_ruleProperty_in_entryRuleProperty360);
            ruleProperty();
            _fsp--;

             after(grammarAccess.getPropertyRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleProperty367); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end entryRuleProperty


    // $ANTLR start ruleProperty
    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:203:1: ruleProperty : ( ( rule__Property__Alternatives ) ) ;
    public final void ruleProperty() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:207:2: ( ( ( rule__Property__Alternatives ) ) )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:208:1: ( ( rule__Property__Alternatives ) )
            {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:208:1: ( ( rule__Property__Alternatives ) )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:209:1: ( rule__Property__Alternatives )
            {
             before(grammarAccess.getPropertyAccess().getAlternatives()); 
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:210:1: ( rule__Property__Alternatives )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:210:2: rule__Property__Alternatives
            {
            pushFollow(FOLLOW_rule__Property__Alternatives_in_ruleProperty394);
            rule__Property__Alternatives();
            _fsp--;


            }

             after(grammarAccess.getPropertyAccess().getAlternatives()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleProperty


    // $ANTLR start entryRuleSimpleProperty
    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:222:1: entryRuleSimpleProperty : ruleSimpleProperty EOF ;
    public final void entryRuleSimpleProperty() throws RecognitionException {
        try {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:222:25: ( ruleSimpleProperty EOF )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:223:1: ruleSimpleProperty EOF
            {
             before(grammarAccess.getSimplePropertyRule()); 
            pushFollow(FOLLOW_ruleSimpleProperty_in_entryRuleSimpleProperty420);
            ruleSimpleProperty();
            _fsp--;

             after(grammarAccess.getSimplePropertyRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpleProperty427); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end entryRuleSimpleProperty


    // $ANTLR start ruleSimpleProperty
    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:230:1: ruleSimpleProperty : ( ( rule__SimpleProperty__Group__0 ) ) ;
    public final void ruleSimpleProperty() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:234:2: ( ( ( rule__SimpleProperty__Group__0 ) ) )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:235:1: ( ( rule__SimpleProperty__Group__0 ) )
            {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:235:1: ( ( rule__SimpleProperty__Group__0 ) )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:236:1: ( rule__SimpleProperty__Group__0 )
            {
             before(grammarAccess.getSimplePropertyAccess().getGroup()); 
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:237:1: ( rule__SimpleProperty__Group__0 )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:237:2: rule__SimpleProperty__Group__0
            {
            pushFollow(FOLLOW_rule__SimpleProperty__Group__0_in_ruleSimpleProperty454);
            rule__SimpleProperty__Group__0();
            _fsp--;


            }

             after(grammarAccess.getSimplePropertyAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleSimpleProperty


    // $ANTLR start entryRuleReference
    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:249:1: entryRuleReference : ruleReference EOF ;
    public final void entryRuleReference() throws RecognitionException {
        try {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:249:20: ( ruleReference EOF )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:250:1: ruleReference EOF
            {
             before(grammarAccess.getReferenceRule()); 
            pushFollow(FOLLOW_ruleReference_in_entryRuleReference480);
            ruleReference();
            _fsp--;

             after(grammarAccess.getReferenceRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReference487); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end entryRuleReference


    // $ANTLR start ruleReference
    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:257:1: ruleReference : ( ( rule__Reference__Group__0 ) ) ;
    public final void ruleReference() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:261:2: ( ( ( rule__Reference__Group__0 ) ) )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:262:1: ( ( rule__Reference__Group__0 ) )
            {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:262:1: ( ( rule__Reference__Group__0 ) )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:263:1: ( rule__Reference__Group__0 )
            {
             before(grammarAccess.getReferenceAccess().getGroup()); 
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:264:1: ( rule__Reference__Group__0 )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:264:2: rule__Reference__Group__0
            {
            pushFollow(FOLLOW_rule__Reference__Group__0_in_ruleReference514);
            rule__Reference__Group__0();
            _fsp--;


            }

             after(grammarAccess.getReferenceAccess().getGroup()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end ruleReference


    // $ANTLR start rule__Type__Alternatives
    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:276:1: rule__Type__Alternatives : ( ( ruleSimpleType ) | ( ruleEntity ) );
    public final void rule__Type__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:280:1: ( ( ruleSimpleType ) | ( ruleEntity ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==12) ) {
                alt1=1;
            }
            else if ( (LA1_0==13) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("276:1: rule__Type__Alternatives : ( ( ruleSimpleType ) | ( ruleEntity ) );", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:281:1: ( ruleSimpleType )
                    {
                    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:281:1: ( ruleSimpleType )
                    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:282:1: ruleSimpleType
                    {
                     before(grammarAccess.getTypeAccess().getSimpleTypeParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleSimpleType_in_rule__Type__Alternatives550);
                    ruleSimpleType();
                    _fsp--;

                     after(grammarAccess.getTypeAccess().getSimpleTypeParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:287:6: ( ruleEntity )
                    {
                    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:287:6: ( ruleEntity )
                    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:288:1: ruleEntity
                    {
                     before(grammarAccess.getTypeAccess().getEntityParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleEntity_in_rule__Type__Alternatives567);
                    ruleEntity();
                    _fsp--;

                     after(grammarAccess.getTypeAccess().getEntityParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Type__Alternatives


    // $ANTLR start rule__Property__Alternatives
    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:298:1: rule__Property__Alternatives : ( ( ruleSimpleProperty ) | ( ruleReference ) );
    public final void rule__Property__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:302:1: ( ( ruleSimpleProperty ) | ( ruleReference ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==17) ) {
                alt2=1;
            }
            else if ( (LA2_0==19) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("298:1: rule__Property__Alternatives : ( ( ruleSimpleProperty ) | ( ruleReference ) );", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:303:1: ( ruleSimpleProperty )
                    {
                    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:303:1: ( ruleSimpleProperty )
                    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:304:1: ruleSimpleProperty
                    {
                     before(grammarAccess.getPropertyAccess().getSimplePropertyParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleSimpleProperty_in_rule__Property__Alternatives599);
                    ruleSimpleProperty();
                    _fsp--;

                     after(grammarAccess.getPropertyAccess().getSimplePropertyParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:309:6: ( ruleReference )
                    {
                    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:309:6: ( ruleReference )
                    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:310:1: ruleReference
                    {
                     before(grammarAccess.getPropertyAccess().getReferenceParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleReference_in_rule__Property__Alternatives616);
                    ruleReference();
                    _fsp--;

                     after(grammarAccess.getPropertyAccess().getReferenceParserRuleCall_1()); 

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Property__Alternatives


    // $ANTLR start rule__Model__Group__0
    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:322:1: rule__Model__Group__0 : ( () ) rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:326:1: ( ( () ) rule__Model__Group__1 )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:327:1: ( () ) rule__Model__Group__1
            {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:327:1: ( () )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:328:1: ()
            {
             before(grammarAccess.getModelAccess().getModelAction_0()); 
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:329:1: ()
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:331:1: 
            {
            }

             after(grammarAccess.getModelAccess().getModelAction_0()); 

            }

            pushFollow(FOLLOW_rule__Model__Group__1_in_rule__Model__Group__0660);
            rule__Model__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__Group__0


    // $ANTLR start rule__Model__Group__1
    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:342:1: rule__Model__Group__1 : ( ( rule__Model__ImportsAssignment_1 )* ) rule__Model__Group__2 ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:346:1: ( ( ( rule__Model__ImportsAssignment_1 )* ) rule__Model__Group__2 )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:347:1: ( ( rule__Model__ImportsAssignment_1 )* ) rule__Model__Group__2
            {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:347:1: ( ( rule__Model__ImportsAssignment_1 )* )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:348:1: ( rule__Model__ImportsAssignment_1 )*
            {
             before(grammarAccess.getModelAccess().getImportsAssignment_1()); 
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:349:1: ( rule__Model__ImportsAssignment_1 )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==11) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:349:2: rule__Model__ImportsAssignment_1
            	    {
            	    pushFollow(FOLLOW_rule__Model__ImportsAssignment_1_in_rule__Model__Group__1688);
            	    rule__Model__ImportsAssignment_1();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getImportsAssignment_1()); 

            }

            pushFollow(FOLLOW_rule__Model__Group__2_in_rule__Model__Group__1698);
            rule__Model__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__Group__1


    // $ANTLR start rule__Model__Group__2
    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:360:1: rule__Model__Group__2 : ( ( rule__Model__ElementsAssignment_2 )* ) ;
    public final void rule__Model__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:364:1: ( ( ( rule__Model__ElementsAssignment_2 )* ) )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:365:1: ( ( rule__Model__ElementsAssignment_2 )* )
            {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:365:1: ( ( rule__Model__ElementsAssignment_2 )* )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:366:1: ( rule__Model__ElementsAssignment_2 )*
            {
             before(grammarAccess.getModelAccess().getElementsAssignment_2()); 
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:367:1: ( rule__Model__ElementsAssignment_2 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>=12 && LA4_0<=13)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:367:2: rule__Model__ElementsAssignment_2
            	    {
            	    pushFollow(FOLLOW_rule__Model__ElementsAssignment_2_in_rule__Model__Group__2726);
            	    rule__Model__ElementsAssignment_2();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getElementsAssignment_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__Group__2


    // $ANTLR start rule__Import__Group__0
    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:383:1: rule__Import__Group__0 : ( 'import' ) rule__Import__Group__1 ;
    public final void rule__Import__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:387:1: ( ( 'import' ) rule__Import__Group__1 )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:388:1: ( 'import' ) rule__Import__Group__1
            {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:388:1: ( 'import' )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:389:1: 'import'
            {
             before(grammarAccess.getImportAccess().getImportKeyword_0()); 
            match(input,11,FOLLOW_11_in_rule__Import__Group__0768); 
             after(grammarAccess.getImportAccess().getImportKeyword_0()); 

            }

            pushFollow(FOLLOW_rule__Import__Group__1_in_rule__Import__Group__0778);
            rule__Import__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Import__Group__0


    // $ANTLR start rule__Import__Group__1
    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:403:1: rule__Import__Group__1 : ( ( rule__Import__ImportURIAssignment_1 ) ) ;
    public final void rule__Import__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:407:1: ( ( ( rule__Import__ImportURIAssignment_1 ) ) )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:408:1: ( ( rule__Import__ImportURIAssignment_1 ) )
            {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:408:1: ( ( rule__Import__ImportURIAssignment_1 ) )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:409:1: ( rule__Import__ImportURIAssignment_1 )
            {
             before(grammarAccess.getImportAccess().getImportURIAssignment_1()); 
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:410:1: ( rule__Import__ImportURIAssignment_1 )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:410:2: rule__Import__ImportURIAssignment_1
            {
            pushFollow(FOLLOW_rule__Import__ImportURIAssignment_1_in_rule__Import__Group__1806);
            rule__Import__ImportURIAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getImportAccess().getImportURIAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Import__Group__1


    // $ANTLR start rule__SimpleType__Group__0
    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:424:1: rule__SimpleType__Group__0 : ( 'type' ) rule__SimpleType__Group__1 ;
    public final void rule__SimpleType__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:428:1: ( ( 'type' ) rule__SimpleType__Group__1 )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:429:1: ( 'type' ) rule__SimpleType__Group__1
            {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:429:1: ( 'type' )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:430:1: 'type'
            {
             before(grammarAccess.getSimpleTypeAccess().getTypeKeyword_0()); 
            match(input,12,FOLLOW_12_in_rule__SimpleType__Group__0845); 
             after(grammarAccess.getSimpleTypeAccess().getTypeKeyword_0()); 

            }

            pushFollow(FOLLOW_rule__SimpleType__Group__1_in_rule__SimpleType__Group__0855);
            rule__SimpleType__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SimpleType__Group__0


    // $ANTLR start rule__SimpleType__Group__1
    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:444:1: rule__SimpleType__Group__1 : ( ( rule__SimpleType__NameAssignment_1 ) ) ;
    public final void rule__SimpleType__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:448:1: ( ( ( rule__SimpleType__NameAssignment_1 ) ) )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:449:1: ( ( rule__SimpleType__NameAssignment_1 ) )
            {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:449:1: ( ( rule__SimpleType__NameAssignment_1 ) )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:450:1: ( rule__SimpleType__NameAssignment_1 )
            {
             before(grammarAccess.getSimpleTypeAccess().getNameAssignment_1()); 
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:451:1: ( rule__SimpleType__NameAssignment_1 )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:451:2: rule__SimpleType__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__SimpleType__NameAssignment_1_in_rule__SimpleType__Group__1883);
            rule__SimpleType__NameAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getSimpleTypeAccess().getNameAssignment_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SimpleType__Group__1


    // $ANTLR start rule__Entity__Group__0
    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:465:1: rule__Entity__Group__0 : ( 'entity' ) rule__Entity__Group__1 ;
    public final void rule__Entity__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:469:1: ( ( 'entity' ) rule__Entity__Group__1 )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:470:1: ( 'entity' ) rule__Entity__Group__1
            {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:470:1: ( 'entity' )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:471:1: 'entity'
            {
             before(grammarAccess.getEntityAccess().getEntityKeyword_0()); 
            match(input,13,FOLLOW_13_in_rule__Entity__Group__0922); 
             after(grammarAccess.getEntityAccess().getEntityKeyword_0()); 

            }

            pushFollow(FOLLOW_rule__Entity__Group__1_in_rule__Entity__Group__0932);
            rule__Entity__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Entity__Group__0


    // $ANTLR start rule__Entity__Group__1
    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:485:1: rule__Entity__Group__1 : ( ( rule__Entity__NameAssignment_1 ) ) rule__Entity__Group__2 ;
    public final void rule__Entity__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:489:1: ( ( ( rule__Entity__NameAssignment_1 ) ) rule__Entity__Group__2 )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:490:1: ( ( rule__Entity__NameAssignment_1 ) ) rule__Entity__Group__2
            {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:490:1: ( ( rule__Entity__NameAssignment_1 ) )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:491:1: ( rule__Entity__NameAssignment_1 )
            {
             before(grammarAccess.getEntityAccess().getNameAssignment_1()); 
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:492:1: ( rule__Entity__NameAssignment_1 )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:492:2: rule__Entity__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Entity__NameAssignment_1_in_rule__Entity__Group__1960);
            rule__Entity__NameAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getEntityAccess().getNameAssignment_1()); 

            }

            pushFollow(FOLLOW_rule__Entity__Group__2_in_rule__Entity__Group__1969);
            rule__Entity__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Entity__Group__1


    // $ANTLR start rule__Entity__Group__2
    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:503:1: rule__Entity__Group__2 : ( ( rule__Entity__Group_2__0 )? ) rule__Entity__Group__3 ;
    public final void rule__Entity__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:507:1: ( ( ( rule__Entity__Group_2__0 )? ) rule__Entity__Group__3 )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:508:1: ( ( rule__Entity__Group_2__0 )? ) rule__Entity__Group__3
            {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:508:1: ( ( rule__Entity__Group_2__0 )? )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:509:1: ( rule__Entity__Group_2__0 )?
            {
             before(grammarAccess.getEntityAccess().getGroup_2()); 
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:510:1: ( rule__Entity__Group_2__0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==16) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:510:2: rule__Entity__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__Entity__Group_2__0_in_rule__Entity__Group__2997);
                    rule__Entity__Group_2__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEntityAccess().getGroup_2()); 

            }

            pushFollow(FOLLOW_rule__Entity__Group__3_in_rule__Entity__Group__21007);
            rule__Entity__Group__3();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Entity__Group__2


    // $ANTLR start rule__Entity__Group__3
    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:521:1: rule__Entity__Group__3 : ( '{' ) rule__Entity__Group__4 ;
    public final void rule__Entity__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:525:1: ( ( '{' ) rule__Entity__Group__4 )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:526:1: ( '{' ) rule__Entity__Group__4
            {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:526:1: ( '{' )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:527:1: '{'
            {
             before(grammarAccess.getEntityAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,14,FOLLOW_14_in_rule__Entity__Group__31036); 
             after(grammarAccess.getEntityAccess().getLeftCurlyBracketKeyword_3()); 

            }

            pushFollow(FOLLOW_rule__Entity__Group__4_in_rule__Entity__Group__31046);
            rule__Entity__Group__4();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Entity__Group__3


    // $ANTLR start rule__Entity__Group__4
    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:541:1: rule__Entity__Group__4 : ( ( rule__Entity__PropertiesAssignment_4 )* ) rule__Entity__Group__5 ;
    public final void rule__Entity__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:545:1: ( ( ( rule__Entity__PropertiesAssignment_4 )* ) rule__Entity__Group__5 )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:546:1: ( ( rule__Entity__PropertiesAssignment_4 )* ) rule__Entity__Group__5
            {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:546:1: ( ( rule__Entity__PropertiesAssignment_4 )* )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:547:1: ( rule__Entity__PropertiesAssignment_4 )*
            {
             before(grammarAccess.getEntityAccess().getPropertiesAssignment_4()); 
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:548:1: ( rule__Entity__PropertiesAssignment_4 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==17||LA6_0==19) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:548:2: rule__Entity__PropertiesAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__Entity__PropertiesAssignment_4_in_rule__Entity__Group__41074);
            	    rule__Entity__PropertiesAssignment_4();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getEntityAccess().getPropertiesAssignment_4()); 

            }

            pushFollow(FOLLOW_rule__Entity__Group__5_in_rule__Entity__Group__41084);
            rule__Entity__Group__5();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Entity__Group__4


    // $ANTLR start rule__Entity__Group__5
    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:559:1: rule__Entity__Group__5 : ( '}' ) ;
    public final void rule__Entity__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:563:1: ( ( '}' ) )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:564:1: ( '}' )
            {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:564:1: ( '}' )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:565:1: '}'
            {
             before(grammarAccess.getEntityAccess().getRightCurlyBracketKeyword_5()); 
            match(input,15,FOLLOW_15_in_rule__Entity__Group__51113); 
             after(grammarAccess.getEntityAccess().getRightCurlyBracketKeyword_5()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Entity__Group__5


    // $ANTLR start rule__Entity__Group_2__0
    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:590:1: rule__Entity__Group_2__0 : ( 'extends' ) rule__Entity__Group_2__1 ;
    public final void rule__Entity__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:594:1: ( ( 'extends' ) rule__Entity__Group_2__1 )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:595:1: ( 'extends' ) rule__Entity__Group_2__1
            {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:595:1: ( 'extends' )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:596:1: 'extends'
            {
             before(grammarAccess.getEntityAccess().getExtendsKeyword_2_0()); 
            match(input,16,FOLLOW_16_in_rule__Entity__Group_2__01161); 
             after(grammarAccess.getEntityAccess().getExtendsKeyword_2_0()); 

            }

            pushFollow(FOLLOW_rule__Entity__Group_2__1_in_rule__Entity__Group_2__01171);
            rule__Entity__Group_2__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Entity__Group_2__0


    // $ANTLR start rule__Entity__Group_2__1
    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:610:1: rule__Entity__Group_2__1 : ( ( rule__Entity__ExtendsAssignment_2_1 ) ) ;
    public final void rule__Entity__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:614:1: ( ( ( rule__Entity__ExtendsAssignment_2_1 ) ) )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:615:1: ( ( rule__Entity__ExtendsAssignment_2_1 ) )
            {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:615:1: ( ( rule__Entity__ExtendsAssignment_2_1 ) )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:616:1: ( rule__Entity__ExtendsAssignment_2_1 )
            {
             before(grammarAccess.getEntityAccess().getExtendsAssignment_2_1()); 
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:617:1: ( rule__Entity__ExtendsAssignment_2_1 )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:617:2: rule__Entity__ExtendsAssignment_2_1
            {
            pushFollow(FOLLOW_rule__Entity__ExtendsAssignment_2_1_in_rule__Entity__Group_2__11199);
            rule__Entity__ExtendsAssignment_2_1();
            _fsp--;


            }

             after(grammarAccess.getEntityAccess().getExtendsAssignment_2_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Entity__Group_2__1


    // $ANTLR start rule__SimpleProperty__Group__0
    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:631:1: rule__SimpleProperty__Group__0 : ( 'property' ) rule__SimpleProperty__Group__1 ;
    public final void rule__SimpleProperty__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:635:1: ( ( 'property' ) rule__SimpleProperty__Group__1 )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:636:1: ( 'property' ) rule__SimpleProperty__Group__1
            {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:636:1: ( 'property' )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:637:1: 'property'
            {
             before(grammarAccess.getSimplePropertyAccess().getPropertyKeyword_0()); 
            match(input,17,FOLLOW_17_in_rule__SimpleProperty__Group__01238); 
             after(grammarAccess.getSimplePropertyAccess().getPropertyKeyword_0()); 

            }

            pushFollow(FOLLOW_rule__SimpleProperty__Group__1_in_rule__SimpleProperty__Group__01248);
            rule__SimpleProperty__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SimpleProperty__Group__0


    // $ANTLR start rule__SimpleProperty__Group__1
    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:651:1: rule__SimpleProperty__Group__1 : ( ( rule__SimpleProperty__NameAssignment_1 ) ) rule__SimpleProperty__Group__2 ;
    public final void rule__SimpleProperty__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:655:1: ( ( ( rule__SimpleProperty__NameAssignment_1 ) ) rule__SimpleProperty__Group__2 )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:656:1: ( ( rule__SimpleProperty__NameAssignment_1 ) ) rule__SimpleProperty__Group__2
            {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:656:1: ( ( rule__SimpleProperty__NameAssignment_1 ) )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:657:1: ( rule__SimpleProperty__NameAssignment_1 )
            {
             before(grammarAccess.getSimplePropertyAccess().getNameAssignment_1()); 
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:658:1: ( rule__SimpleProperty__NameAssignment_1 )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:658:2: rule__SimpleProperty__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__SimpleProperty__NameAssignment_1_in_rule__SimpleProperty__Group__11276);
            rule__SimpleProperty__NameAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getSimplePropertyAccess().getNameAssignment_1()); 

            }

            pushFollow(FOLLOW_rule__SimpleProperty__Group__2_in_rule__SimpleProperty__Group__11285);
            rule__SimpleProperty__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SimpleProperty__Group__1


    // $ANTLR start rule__SimpleProperty__Group__2
    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:669:1: rule__SimpleProperty__Group__2 : ( ( rule__SimpleProperty__Group_2__0 )? ) ;
    public final void rule__SimpleProperty__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:673:1: ( ( ( rule__SimpleProperty__Group_2__0 )? ) )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:674:1: ( ( rule__SimpleProperty__Group_2__0 )? )
            {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:674:1: ( ( rule__SimpleProperty__Group_2__0 )? )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:675:1: ( rule__SimpleProperty__Group_2__0 )?
            {
             before(grammarAccess.getSimplePropertyAccess().getGroup_2()); 
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:676:1: ( rule__SimpleProperty__Group_2__0 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==18) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:676:2: rule__SimpleProperty__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__SimpleProperty__Group_2__0_in_rule__SimpleProperty__Group__21313);
                    rule__SimpleProperty__Group_2__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSimplePropertyAccess().getGroup_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SimpleProperty__Group__2


    // $ANTLR start rule__SimpleProperty__Group_2__0
    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:692:1: rule__SimpleProperty__Group_2__0 : ( ':' ) rule__SimpleProperty__Group_2__1 ;
    public final void rule__SimpleProperty__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:696:1: ( ( ':' ) rule__SimpleProperty__Group_2__1 )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:697:1: ( ':' ) rule__SimpleProperty__Group_2__1
            {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:697:1: ( ':' )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:698:1: ':'
            {
             before(grammarAccess.getSimplePropertyAccess().getColonKeyword_2_0()); 
            match(input,18,FOLLOW_18_in_rule__SimpleProperty__Group_2__01355); 
             after(grammarAccess.getSimplePropertyAccess().getColonKeyword_2_0()); 

            }

            pushFollow(FOLLOW_rule__SimpleProperty__Group_2__1_in_rule__SimpleProperty__Group_2__01365);
            rule__SimpleProperty__Group_2__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SimpleProperty__Group_2__0


    // $ANTLR start rule__SimpleProperty__Group_2__1
    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:712:1: rule__SimpleProperty__Group_2__1 : ( ( rule__SimpleProperty__TypeAssignment_2_1 ) ) rule__SimpleProperty__Group_2__2 ;
    public final void rule__SimpleProperty__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:716:1: ( ( ( rule__SimpleProperty__TypeAssignment_2_1 ) ) rule__SimpleProperty__Group_2__2 )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:717:1: ( ( rule__SimpleProperty__TypeAssignment_2_1 ) ) rule__SimpleProperty__Group_2__2
            {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:717:1: ( ( rule__SimpleProperty__TypeAssignment_2_1 ) )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:718:1: ( rule__SimpleProperty__TypeAssignment_2_1 )
            {
             before(grammarAccess.getSimplePropertyAccess().getTypeAssignment_2_1()); 
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:719:1: ( rule__SimpleProperty__TypeAssignment_2_1 )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:719:2: rule__SimpleProperty__TypeAssignment_2_1
            {
            pushFollow(FOLLOW_rule__SimpleProperty__TypeAssignment_2_1_in_rule__SimpleProperty__Group_2__11393);
            rule__SimpleProperty__TypeAssignment_2_1();
            _fsp--;


            }

             after(grammarAccess.getSimplePropertyAccess().getTypeAssignment_2_1()); 

            }

            pushFollow(FOLLOW_rule__SimpleProperty__Group_2__2_in_rule__SimpleProperty__Group_2__11402);
            rule__SimpleProperty__Group_2__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SimpleProperty__Group_2__1


    // $ANTLR start rule__SimpleProperty__Group_2__2
    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:730:1: rule__SimpleProperty__Group_2__2 : ( ( rule__SimpleProperty__ManyAssignment_2_2 )? ) ;
    public final void rule__SimpleProperty__Group_2__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:734:1: ( ( ( rule__SimpleProperty__ManyAssignment_2_2 )? ) )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:735:1: ( ( rule__SimpleProperty__ManyAssignment_2_2 )? )
            {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:735:1: ( ( rule__SimpleProperty__ManyAssignment_2_2 )? )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:736:1: ( rule__SimpleProperty__ManyAssignment_2_2 )?
            {
             before(grammarAccess.getSimplePropertyAccess().getManyAssignment_2_2()); 
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:737:1: ( rule__SimpleProperty__ManyAssignment_2_2 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==20) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:737:2: rule__SimpleProperty__ManyAssignment_2_2
                    {
                    pushFollow(FOLLOW_rule__SimpleProperty__ManyAssignment_2_2_in_rule__SimpleProperty__Group_2__21430);
                    rule__SimpleProperty__ManyAssignment_2_2();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getSimplePropertyAccess().getManyAssignment_2_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SimpleProperty__Group_2__2


    // $ANTLR start rule__Reference__Group__0
    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:753:1: rule__Reference__Group__0 : ( 'reference' ) rule__Reference__Group__1 ;
    public final void rule__Reference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:757:1: ( ( 'reference' ) rule__Reference__Group__1 )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:758:1: ( 'reference' ) rule__Reference__Group__1
            {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:758:1: ( 'reference' )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:759:1: 'reference'
            {
             before(grammarAccess.getReferenceAccess().getReferenceKeyword_0()); 
            match(input,19,FOLLOW_19_in_rule__Reference__Group__01472); 
             after(grammarAccess.getReferenceAccess().getReferenceKeyword_0()); 

            }

            pushFollow(FOLLOW_rule__Reference__Group__1_in_rule__Reference__Group__01482);
            rule__Reference__Group__1();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Reference__Group__0


    // $ANTLR start rule__Reference__Group__1
    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:773:1: rule__Reference__Group__1 : ( ( rule__Reference__NameAssignment_1 ) ) rule__Reference__Group__2 ;
    public final void rule__Reference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:777:1: ( ( ( rule__Reference__NameAssignment_1 ) ) rule__Reference__Group__2 )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:778:1: ( ( rule__Reference__NameAssignment_1 ) ) rule__Reference__Group__2
            {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:778:1: ( ( rule__Reference__NameAssignment_1 ) )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:779:1: ( rule__Reference__NameAssignment_1 )
            {
             before(grammarAccess.getReferenceAccess().getNameAssignment_1()); 
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:780:1: ( rule__Reference__NameAssignment_1 )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:780:2: rule__Reference__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Reference__NameAssignment_1_in_rule__Reference__Group__11510);
            rule__Reference__NameAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getReferenceAccess().getNameAssignment_1()); 

            }

            pushFollow(FOLLOW_rule__Reference__Group__2_in_rule__Reference__Group__11519);
            rule__Reference__Group__2();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Reference__Group__1


    // $ANTLR start rule__Reference__Group__2
    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:791:1: rule__Reference__Group__2 : ( ':' ) rule__Reference__Group__3 ;
    public final void rule__Reference__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:795:1: ( ( ':' ) rule__Reference__Group__3 )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:796:1: ( ':' ) rule__Reference__Group__3
            {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:796:1: ( ':' )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:797:1: ':'
            {
             before(grammarAccess.getReferenceAccess().getColonKeyword_2()); 
            match(input,18,FOLLOW_18_in_rule__Reference__Group__21548); 
             after(grammarAccess.getReferenceAccess().getColonKeyword_2()); 

            }

            pushFollow(FOLLOW_rule__Reference__Group__3_in_rule__Reference__Group__21558);
            rule__Reference__Group__3();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Reference__Group__2


    // $ANTLR start rule__Reference__Group__3
    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:811:1: rule__Reference__Group__3 : ( ( rule__Reference__TypeAssignment_3 ) ) rule__Reference__Group__4 ;
    public final void rule__Reference__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:815:1: ( ( ( rule__Reference__TypeAssignment_3 ) ) rule__Reference__Group__4 )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:816:1: ( ( rule__Reference__TypeAssignment_3 ) ) rule__Reference__Group__4
            {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:816:1: ( ( rule__Reference__TypeAssignment_3 ) )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:817:1: ( rule__Reference__TypeAssignment_3 )
            {
             before(grammarAccess.getReferenceAccess().getTypeAssignment_3()); 
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:818:1: ( rule__Reference__TypeAssignment_3 )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:818:2: rule__Reference__TypeAssignment_3
            {
            pushFollow(FOLLOW_rule__Reference__TypeAssignment_3_in_rule__Reference__Group__31586);
            rule__Reference__TypeAssignment_3();
            _fsp--;


            }

             after(grammarAccess.getReferenceAccess().getTypeAssignment_3()); 

            }

            pushFollow(FOLLOW_rule__Reference__Group__4_in_rule__Reference__Group__31595);
            rule__Reference__Group__4();
            _fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Reference__Group__3


    // $ANTLR start rule__Reference__Group__4
    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:829:1: rule__Reference__Group__4 : ( ( rule__Reference__ManyAssignment_4 )? ) ;
    public final void rule__Reference__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:833:1: ( ( ( rule__Reference__ManyAssignment_4 )? ) )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:834:1: ( ( rule__Reference__ManyAssignment_4 )? )
            {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:834:1: ( ( rule__Reference__ManyAssignment_4 )? )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:835:1: ( rule__Reference__ManyAssignment_4 )?
            {
             before(grammarAccess.getReferenceAccess().getManyAssignment_4()); 
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:836:1: ( rule__Reference__ManyAssignment_4 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==20) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:836:2: rule__Reference__ManyAssignment_4
                    {
                    pushFollow(FOLLOW_rule__Reference__ManyAssignment_4_in_rule__Reference__Group__41623);
                    rule__Reference__ManyAssignment_4();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getReferenceAccess().getManyAssignment_4()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Reference__Group__4


    // $ANTLR start rule__Model__ImportsAssignment_1
    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:856:1: rule__Model__ImportsAssignment_1 : ( ruleImport ) ;
    public final void rule__Model__ImportsAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:860:1: ( ( ruleImport ) )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:861:1: ( ruleImport )
            {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:861:1: ( ruleImport )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:862:1: ruleImport
            {
             before(grammarAccess.getModelAccess().getImportsImportParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleImport_in_rule__Model__ImportsAssignment_11668);
            ruleImport();
            _fsp--;

             after(grammarAccess.getModelAccess().getImportsImportParserRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__ImportsAssignment_1


    // $ANTLR start rule__Model__ElementsAssignment_2
    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:871:1: rule__Model__ElementsAssignment_2 : ( ruleType ) ;
    public final void rule__Model__ElementsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:875:1: ( ( ruleType ) )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:876:1: ( ruleType )
            {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:876:1: ( ruleType )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:877:1: ruleType
            {
             before(grammarAccess.getModelAccess().getElementsTypeParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleType_in_rule__Model__ElementsAssignment_21699);
            ruleType();
            _fsp--;

             after(grammarAccess.getModelAccess().getElementsTypeParserRuleCall_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Model__ElementsAssignment_2


    // $ANTLR start rule__Import__ImportURIAssignment_1
    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:886:1: rule__Import__ImportURIAssignment_1 : ( RULE_STRING ) ;
    public final void rule__Import__ImportURIAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:890:1: ( ( RULE_STRING ) )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:891:1: ( RULE_STRING )
            {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:891:1: ( RULE_STRING )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:892:1: RULE_STRING
            {
             before(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__Import__ImportURIAssignment_11730); 
             after(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Import__ImportURIAssignment_1


    // $ANTLR start rule__SimpleType__NameAssignment_1
    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:901:1: rule__SimpleType__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__SimpleType__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:905:1: ( ( RULE_ID ) )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:906:1: ( RULE_ID )
            {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:906:1: ( RULE_ID )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:907:1: RULE_ID
            {
             before(grammarAccess.getSimpleTypeAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SimpleType__NameAssignment_11761); 
             after(grammarAccess.getSimpleTypeAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SimpleType__NameAssignment_1


    // $ANTLR start rule__Entity__NameAssignment_1
    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:916:1: rule__Entity__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Entity__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:920:1: ( ( RULE_ID ) )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:921:1: ( RULE_ID )
            {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:921:1: ( RULE_ID )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:922:1: RULE_ID
            {
             before(grammarAccess.getEntityAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Entity__NameAssignment_11792); 
             after(grammarAccess.getEntityAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Entity__NameAssignment_1


    // $ANTLR start rule__Entity__ExtendsAssignment_2_1
    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:931:1: rule__Entity__ExtendsAssignment_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__Entity__ExtendsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:935:1: ( ( ( RULE_ID ) ) )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:936:1: ( ( RULE_ID ) )
            {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:936:1: ( ( RULE_ID ) )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:937:1: ( RULE_ID )
            {
             before(grammarAccess.getEntityAccess().getExtendsEntityCrossReference_2_1_0()); 
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:938:1: ( RULE_ID )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:939:1: RULE_ID
            {
             before(grammarAccess.getEntityAccess().getExtendsEntityIDTerminalRuleCall_2_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Entity__ExtendsAssignment_2_11827); 
             after(grammarAccess.getEntityAccess().getExtendsEntityIDTerminalRuleCall_2_1_0_1()); 

            }

             after(grammarAccess.getEntityAccess().getExtendsEntityCrossReference_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Entity__ExtendsAssignment_2_1


    // $ANTLR start rule__Entity__PropertiesAssignment_4
    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:950:1: rule__Entity__PropertiesAssignment_4 : ( ruleProperty ) ;
    public final void rule__Entity__PropertiesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:954:1: ( ( ruleProperty ) )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:955:1: ( ruleProperty )
            {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:955:1: ( ruleProperty )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:956:1: ruleProperty
            {
             before(grammarAccess.getEntityAccess().getPropertiesPropertyParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleProperty_in_rule__Entity__PropertiesAssignment_41862);
            ruleProperty();
            _fsp--;

             after(grammarAccess.getEntityAccess().getPropertiesPropertyParserRuleCall_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Entity__PropertiesAssignment_4


    // $ANTLR start rule__SimpleProperty__NameAssignment_1
    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:965:1: rule__SimpleProperty__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__SimpleProperty__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:969:1: ( ( RULE_ID ) )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:970:1: ( RULE_ID )
            {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:970:1: ( RULE_ID )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:971:1: RULE_ID
            {
             before(grammarAccess.getSimplePropertyAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SimpleProperty__NameAssignment_11893); 
             after(grammarAccess.getSimplePropertyAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SimpleProperty__NameAssignment_1


    // $ANTLR start rule__SimpleProperty__TypeAssignment_2_1
    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:980:1: rule__SimpleProperty__TypeAssignment_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__SimpleProperty__TypeAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:984:1: ( ( ( RULE_ID ) ) )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:985:1: ( ( RULE_ID ) )
            {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:985:1: ( ( RULE_ID ) )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:986:1: ( RULE_ID )
            {
             before(grammarAccess.getSimplePropertyAccess().getTypeSimpleTypeCrossReference_2_1_0()); 
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:987:1: ( RULE_ID )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:988:1: RULE_ID
            {
             before(grammarAccess.getSimplePropertyAccess().getTypeSimpleTypeIDTerminalRuleCall_2_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SimpleProperty__TypeAssignment_2_11928); 
             after(grammarAccess.getSimplePropertyAccess().getTypeSimpleTypeIDTerminalRuleCall_2_1_0_1()); 

            }

             after(grammarAccess.getSimplePropertyAccess().getTypeSimpleTypeCrossReference_2_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SimpleProperty__TypeAssignment_2_1


    // $ANTLR start rule__SimpleProperty__ManyAssignment_2_2
    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:999:1: rule__SimpleProperty__ManyAssignment_2_2 : ( ( '[]' ) ) ;
    public final void rule__SimpleProperty__ManyAssignment_2_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:1003:1: ( ( ( '[]' ) ) )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:1004:1: ( ( '[]' ) )
            {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:1004:1: ( ( '[]' ) )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:1005:1: ( '[]' )
            {
             before(grammarAccess.getSimplePropertyAccess().getManyLeftSquareBracketRightSquareBracketKeyword_2_2_0()); 
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:1006:1: ( '[]' )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:1007:1: '[]'
            {
             before(grammarAccess.getSimplePropertyAccess().getManyLeftSquareBracketRightSquareBracketKeyword_2_2_0()); 
            match(input,20,FOLLOW_20_in_rule__SimpleProperty__ManyAssignment_2_21968); 
             after(grammarAccess.getSimplePropertyAccess().getManyLeftSquareBracketRightSquareBracketKeyword_2_2_0()); 

            }

             after(grammarAccess.getSimplePropertyAccess().getManyLeftSquareBracketRightSquareBracketKeyword_2_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__SimpleProperty__ManyAssignment_2_2


    // $ANTLR start rule__Reference__NameAssignment_1
    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:1022:1: rule__Reference__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Reference__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:1026:1: ( ( RULE_ID ) )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:1027:1: ( RULE_ID )
            {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:1027:1: ( RULE_ID )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:1028:1: RULE_ID
            {
             before(grammarAccess.getReferenceAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Reference__NameAssignment_12007); 
             after(grammarAccess.getReferenceAccess().getNameIDTerminalRuleCall_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Reference__NameAssignment_1


    // $ANTLR start rule__Reference__TypeAssignment_3
    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:1037:1: rule__Reference__TypeAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__Reference__TypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:1041:1: ( ( ( RULE_ID ) ) )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:1042:1: ( ( RULE_ID ) )
            {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:1042:1: ( ( RULE_ID ) )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:1043:1: ( RULE_ID )
            {
             before(grammarAccess.getReferenceAccess().getTypeEntityCrossReference_3_0()); 
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:1044:1: ( RULE_ID )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:1045:1: RULE_ID
            {
             before(grammarAccess.getReferenceAccess().getTypeEntityIDTerminalRuleCall_3_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Reference__TypeAssignment_32042); 
             after(grammarAccess.getReferenceAccess().getTypeEntityIDTerminalRuleCall_3_0_1()); 

            }

             after(grammarAccess.getReferenceAccess().getTypeEntityCrossReference_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Reference__TypeAssignment_3


    // $ANTLR start rule__Reference__ManyAssignment_4
    // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:1056:1: rule__Reference__ManyAssignment_4 : ( ( '[]' ) ) ;
    public final void rule__Reference__ManyAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:1060:1: ( ( ( '[]' ) ) )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:1061:1: ( ( '[]' ) )
            {
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:1061:1: ( ( '[]' ) )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:1062:1: ( '[]' )
            {
             before(grammarAccess.getReferenceAccess().getManyLeftSquareBracketRightSquareBracketKeyword_4_0()); 
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:1063:1: ( '[]' )
            // ../org.xtext.example.entities.ui/src-gen/org/xtext/example/contentassist/antlr/internal/InternalEntities.g:1064:1: '[]'
            {
             before(grammarAccess.getReferenceAccess().getManyLeftSquareBracketRightSquareBracketKeyword_4_0()); 
            match(input,20,FOLLOW_20_in_rule__Reference__ManyAssignment_42082); 
             after(grammarAccess.getReferenceAccess().getManyLeftSquareBracketRightSquareBracketKeyword_4_0()); 

            }

             after(grammarAccess.getReferenceAccess().getManyLeftSquareBracketRightSquareBracketKeyword_4_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end rule__Reference__ManyAssignment_4


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel60 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel67 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__0_in_ruleModel94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport120 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__Group__0_in_ruleImport154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_entryRuleType180 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleType187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Type__Alternatives_in_ruleType214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleType_in_entryRuleSimpleType240 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpleType247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleType__Group__0_in_ruleSimpleType274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntity_in_entryRuleEntity300 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEntity307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Entity__Group__0_in_ruleEntity334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProperty_in_entryRuleProperty360 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProperty367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Property__Alternatives_in_ruleProperty394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleProperty_in_entryRuleSimpleProperty420 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpleProperty427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleProperty__Group__0_in_ruleSimpleProperty454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReference_in_entryRuleReference480 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReference487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__Group__0_in_ruleReference514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleType_in_rule__Type__Alternatives550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntity_in_rule__Type__Alternatives567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleProperty_in_rule__Property__Alternatives599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReference_in_rule__Property__Alternatives616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__1_in_rule__Model__Group__0660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__ImportsAssignment_1_in_rule__Model__Group__1688 = new BitSet(new long[]{0x0000000000003802L});
    public static final BitSet FOLLOW_rule__Model__Group__2_in_rule__Model__Group__1698 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__ElementsAssignment_2_in_rule__Model__Group__2726 = new BitSet(new long[]{0x0000000000003002L});
    public static final BitSet FOLLOW_11_in_rule__Import__Group__0768 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Import__Group__1_in_rule__Import__Group__0778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Import__ImportURIAssignment_1_in_rule__Import__Group__1806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__SimpleType__Group__0845 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__SimpleType__Group__1_in_rule__SimpleType__Group__0855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleType__NameAssignment_1_in_rule__SimpleType__Group__1883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__Entity__Group__0922 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Entity__Group__1_in_rule__Entity__Group__0932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Entity__NameAssignment_1_in_rule__Entity__Group__1960 = new BitSet(new long[]{0x0000000000014000L});
    public static final BitSet FOLLOW_rule__Entity__Group__2_in_rule__Entity__Group__1969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Entity__Group_2__0_in_rule__Entity__Group__2997 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__Entity__Group__3_in_rule__Entity__Group__21007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Entity__Group__31036 = new BitSet(new long[]{0x00000000000A8000L});
    public static final BitSet FOLLOW_rule__Entity__Group__4_in_rule__Entity__Group__31046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Entity__PropertiesAssignment_4_in_rule__Entity__Group__41074 = new BitSet(new long[]{0x00000000000A8000L});
    public static final BitSet FOLLOW_rule__Entity__Group__5_in_rule__Entity__Group__41084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Entity__Group__51113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Entity__Group_2__01161 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Entity__Group_2__1_in_rule__Entity__Group_2__01171 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Entity__ExtendsAssignment_2_1_in_rule__Entity__Group_2__11199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__SimpleProperty__Group__01238 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__SimpleProperty__Group__1_in_rule__SimpleProperty__Group__01248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleProperty__NameAssignment_1_in_rule__SimpleProperty__Group__11276 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_rule__SimpleProperty__Group__2_in_rule__SimpleProperty__Group__11285 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleProperty__Group_2__0_in_rule__SimpleProperty__Group__21313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__SimpleProperty__Group_2__01355 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__SimpleProperty__Group_2__1_in_rule__SimpleProperty__Group_2__01365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleProperty__TypeAssignment_2_1_in_rule__SimpleProperty__Group_2__11393 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_rule__SimpleProperty__Group_2__2_in_rule__SimpleProperty__Group_2__11402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleProperty__ManyAssignment_2_2_in_rule__SimpleProperty__Group_2__21430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Reference__Group__01472 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Reference__Group__1_in_rule__Reference__Group__01482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__NameAssignment_1_in_rule__Reference__Group__11510 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__Reference__Group__2_in_rule__Reference__Group__11519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Reference__Group__21548 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__Reference__Group__3_in_rule__Reference__Group__21558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__TypeAssignment_3_in_rule__Reference__Group__31586 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_rule__Reference__Group__4_in_rule__Reference__Group__31595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Reference__ManyAssignment_4_in_rule__Reference__Group__41623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_rule__Model__ImportsAssignment_11668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_rule__Model__ElementsAssignment_21699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__Import__ImportURIAssignment_11730 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SimpleType__NameAssignment_11761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Entity__NameAssignment_11792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Entity__ExtendsAssignment_2_11827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProperty_in_rule__Entity__PropertiesAssignment_41862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SimpleProperty__NameAssignment_11893 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SimpleProperty__TypeAssignment_2_11928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__SimpleProperty__ManyAssignment_2_21968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Reference__NameAssignment_12007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Reference__TypeAssignment_32042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__Reference__ManyAssignment_42082 = new BitSet(new long[]{0x0000000000000002L});

}