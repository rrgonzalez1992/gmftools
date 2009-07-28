package org.xtext.cg2009.contentassist.antlr.internal; 

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
import org.xtext.cg2009.services.EntitiesGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalEntitiesParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'String'", "'Number'", "'Bool'", "'one'", "'entity'", "'{'", "'}'", "'extends'", "'property'", "':'", "'refs'", "'many'"
    };
    public static final int RULE_ID=4;
    public static final int RULE_STRING=6;
    public static final int RULE_ANY_OTHER=10;
    public static final int RULE_INT=5;
    public static final int RULE_WS=9;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;

        public InternalEntitiesParser(TokenStream input) {
            super(input);
        }
        

    public String[] getTokenNames() { return tokenNames; }
    public String getGrammarFileName() { return "../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g"; }


     
     	private EntitiesGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(EntitiesGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }




    // $ANTLR start entryRuleModel
    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:55:1: entryRuleModel : ruleModel EOF ;
    public final void entryRuleModel() throws RecognitionException {
        try {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:55:16: ( ruleModel EOF )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:56:1: ruleModel EOF
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
    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:63:1: ruleModel : ( ( rule__Model__Group__0 ) ) ;
    public final void ruleModel() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:67:2: ( ( ( rule__Model__Group__0 ) ) )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:68:1: ( ( rule__Model__Group__0 ) )
            {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:68:1: ( ( rule__Model__Group__0 ) )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:69:1: ( rule__Model__Group__0 )
            {
             before(grammarAccess.getModelAccess().getGroup()); 
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:70:1: ( rule__Model__Group__0 )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:70:2: rule__Model__Group__0
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


    // $ANTLR start entryRuleEntity
    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:82:1: entryRuleEntity : ruleEntity EOF ;
    public final void entryRuleEntity() throws RecognitionException {
        try {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:82:17: ( ruleEntity EOF )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:83:1: ruleEntity EOF
            {
             before(grammarAccess.getEntityRule()); 
            pushFollow(FOLLOW_ruleEntity_in_entryRuleEntity120);
            ruleEntity();
            _fsp--;

             after(grammarAccess.getEntityRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEntity127); 

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
    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:90:1: ruleEntity : ( ( rule__Entity__Group__0 ) ) ;
    public final void ruleEntity() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:94:2: ( ( ( rule__Entity__Group__0 ) ) )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:95:1: ( ( rule__Entity__Group__0 ) )
            {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:95:1: ( ( rule__Entity__Group__0 ) )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:96:1: ( rule__Entity__Group__0 )
            {
             before(grammarAccess.getEntityAccess().getGroup()); 
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:97:1: ( rule__Entity__Group__0 )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:97:2: rule__Entity__Group__0
            {
            pushFollow(FOLLOW_rule__Entity__Group__0_in_ruleEntity154);
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
    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:109:1: entryRuleProperty : ruleProperty EOF ;
    public final void entryRuleProperty() throws RecognitionException {
        try {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:109:19: ( ruleProperty EOF )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:110:1: ruleProperty EOF
            {
             before(grammarAccess.getPropertyRule()); 
            pushFollow(FOLLOW_ruleProperty_in_entryRuleProperty180);
            ruleProperty();
            _fsp--;

             after(grammarAccess.getPropertyRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleProperty187); 

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
    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:117:1: ruleProperty : ( ( rule__Property__Alternatives ) ) ;
    public final void ruleProperty() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:121:2: ( ( ( rule__Property__Alternatives ) ) )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:122:1: ( ( rule__Property__Alternatives ) )
            {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:122:1: ( ( rule__Property__Alternatives ) )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:123:1: ( rule__Property__Alternatives )
            {
             before(grammarAccess.getPropertyAccess().getAlternatives()); 
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:124:1: ( rule__Property__Alternatives )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:124:2: rule__Property__Alternatives
            {
            pushFollow(FOLLOW_rule__Property__Alternatives_in_ruleProperty214);
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
    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:136:1: entryRuleSimpleProperty : ruleSimpleProperty EOF ;
    public final void entryRuleSimpleProperty() throws RecognitionException {
        try {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:136:25: ( ruleSimpleProperty EOF )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:137:1: ruleSimpleProperty EOF
            {
             before(grammarAccess.getSimplePropertyRule()); 
            pushFollow(FOLLOW_ruleSimpleProperty_in_entryRuleSimpleProperty240);
            ruleSimpleProperty();
            _fsp--;

             after(grammarAccess.getSimplePropertyRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpleProperty247); 

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
    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:144:1: ruleSimpleProperty : ( ( rule__SimpleProperty__Group__0 ) ) ;
    public final void ruleSimpleProperty() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:148:2: ( ( ( rule__SimpleProperty__Group__0 ) ) )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:149:1: ( ( rule__SimpleProperty__Group__0 ) )
            {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:149:1: ( ( rule__SimpleProperty__Group__0 ) )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:150:1: ( rule__SimpleProperty__Group__0 )
            {
             before(grammarAccess.getSimplePropertyAccess().getGroup()); 
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:151:1: ( rule__SimpleProperty__Group__0 )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:151:2: rule__SimpleProperty__Group__0
            {
            pushFollow(FOLLOW_rule__SimpleProperty__Group__0_in_ruleSimpleProperty274);
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


    // $ANTLR start entryRuleReferenceProperty
    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:163:1: entryRuleReferenceProperty : ruleReferenceProperty EOF ;
    public final void entryRuleReferenceProperty() throws RecognitionException {
        try {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:163:28: ( ruleReferenceProperty EOF )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:164:1: ruleReferenceProperty EOF
            {
             before(grammarAccess.getReferencePropertyRule()); 
            pushFollow(FOLLOW_ruleReferenceProperty_in_entryRuleReferenceProperty300);
            ruleReferenceProperty();
            _fsp--;

             after(grammarAccess.getReferencePropertyRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferenceProperty307); 

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
    // $ANTLR end entryRuleReferenceProperty


    // $ANTLR start ruleReferenceProperty
    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:171:1: ruleReferenceProperty : ( ( rule__ReferenceProperty__Group__0 ) ) ;
    public final void ruleReferenceProperty() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:175:2: ( ( ( rule__ReferenceProperty__Group__0 ) ) )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:176:1: ( ( rule__ReferenceProperty__Group__0 ) )
            {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:176:1: ( ( rule__ReferenceProperty__Group__0 ) )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:177:1: ( rule__ReferenceProperty__Group__0 )
            {
             before(grammarAccess.getReferencePropertyAccess().getGroup()); 
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:178:1: ( rule__ReferenceProperty__Group__0 )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:178:2: rule__ReferenceProperty__Group__0
            {
            pushFollow(FOLLOW_rule__ReferenceProperty__Group__0_in_ruleReferenceProperty334);
            rule__ReferenceProperty__Group__0();
            _fsp--;


            }

             after(grammarAccess.getReferencePropertyAccess().getGroup()); 

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
    // $ANTLR end ruleReferenceProperty


    // $ANTLR start rule__Property__Alternatives
    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:190:1: rule__Property__Alternatives : ( ( ruleSimpleProperty ) | ( ruleReferenceProperty ) );
    public final void rule__Property__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:194:1: ( ( ruleSimpleProperty ) | ( ruleReferenceProperty ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==19) ) {
                alt1=1;
            }
            else if ( (LA1_0==RULE_ID) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("190:1: rule__Property__Alternatives : ( ( ruleSimpleProperty ) | ( ruleReferenceProperty ) );", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:195:1: ( ruleSimpleProperty )
                    {
                    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:195:1: ( ruleSimpleProperty )
                    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:196:1: ruleSimpleProperty
                    {
                     before(grammarAccess.getPropertyAccess().getSimplePropertyParserRuleCall_0()); 
                    pushFollow(FOLLOW_ruleSimpleProperty_in_rule__Property__Alternatives370);
                    ruleSimpleProperty();
                    _fsp--;

                     after(grammarAccess.getPropertyAccess().getSimplePropertyParserRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:201:6: ( ruleReferenceProperty )
                    {
                    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:201:6: ( ruleReferenceProperty )
                    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:202:1: ruleReferenceProperty
                    {
                     before(grammarAccess.getPropertyAccess().getReferencePropertyParserRuleCall_1()); 
                    pushFollow(FOLLOW_ruleReferenceProperty_in_rule__Property__Alternatives387);
                    ruleReferenceProperty();
                    _fsp--;

                     after(grammarAccess.getPropertyAccess().getReferencePropertyParserRuleCall_1()); 

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


    // $ANTLR start rule__SimpleProperty__TypeAlternatives_3_0
    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:212:1: rule__SimpleProperty__TypeAlternatives_3_0 : ( ( 'String' ) | ( 'Number' ) | ( 'Bool' ) );
    public final void rule__SimpleProperty__TypeAlternatives_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:216:1: ( ( 'String' ) | ( 'Number' ) | ( 'Bool' ) )
            int alt2=3;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt2=1;
                }
                break;
            case 12:
                {
                alt2=2;
                }
                break;
            case 13:
                {
                alt2=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("212:1: rule__SimpleProperty__TypeAlternatives_3_0 : ( ( 'String' ) | ( 'Number' ) | ( 'Bool' ) );", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:217:1: ( 'String' )
                    {
                    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:217:1: ( 'String' )
                    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:218:1: 'String'
                    {
                     before(grammarAccess.getSimplePropertyAccess().getTypeStringKeyword_3_0_0()); 
                    match(input,11,FOLLOW_11_in_rule__SimpleProperty__TypeAlternatives_3_0420); 
                     after(grammarAccess.getSimplePropertyAccess().getTypeStringKeyword_3_0_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:225:6: ( 'Number' )
                    {
                    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:225:6: ( 'Number' )
                    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:226:1: 'Number'
                    {
                     before(grammarAccess.getSimplePropertyAccess().getTypeNumberKeyword_3_0_1()); 
                    match(input,12,FOLLOW_12_in_rule__SimpleProperty__TypeAlternatives_3_0440); 
                     after(grammarAccess.getSimplePropertyAccess().getTypeNumberKeyword_3_0_1()); 

                    }


                    }
                    break;
                case 3 :
                    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:233:6: ( 'Bool' )
                    {
                    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:233:6: ( 'Bool' )
                    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:234:1: 'Bool'
                    {
                     before(grammarAccess.getSimplePropertyAccess().getTypeBoolKeyword_3_0_2()); 
                    match(input,13,FOLLOW_13_in_rule__SimpleProperty__TypeAlternatives_3_0460); 
                     after(grammarAccess.getSimplePropertyAccess().getTypeBoolKeyword_3_0_2()); 

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
    // $ANTLR end rule__SimpleProperty__TypeAlternatives_3_0


    // $ANTLR start rule__ReferenceProperty__Alternatives_2
    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:246:1: rule__ReferenceProperty__Alternatives_2 : ( ( 'one' ) | ( ( rule__ReferenceProperty__ManyAssignment_2_1 ) ) );
    public final void rule__ReferenceProperty__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:250:1: ( ( 'one' ) | ( ( rule__ReferenceProperty__ManyAssignment_2_1 ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==14) ) {
                alt3=1;
            }
            else if ( (LA3_0==22) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("246:1: rule__ReferenceProperty__Alternatives_2 : ( ( 'one' ) | ( ( rule__ReferenceProperty__ManyAssignment_2_1 ) ) );", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:251:1: ( 'one' )
                    {
                    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:251:1: ( 'one' )
                    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:252:1: 'one'
                    {
                     before(grammarAccess.getReferencePropertyAccess().getOneKeyword_2_0()); 
                    match(input,14,FOLLOW_14_in_rule__ReferenceProperty__Alternatives_2495); 
                     after(grammarAccess.getReferencePropertyAccess().getOneKeyword_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:259:6: ( ( rule__ReferenceProperty__ManyAssignment_2_1 ) )
                    {
                    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:259:6: ( ( rule__ReferenceProperty__ManyAssignment_2_1 ) )
                    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:260:1: ( rule__ReferenceProperty__ManyAssignment_2_1 )
                    {
                     before(grammarAccess.getReferencePropertyAccess().getManyAssignment_2_1()); 
                    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:261:1: ( rule__ReferenceProperty__ManyAssignment_2_1 )
                    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:261:2: rule__ReferenceProperty__ManyAssignment_2_1
                    {
                    pushFollow(FOLLOW_rule__ReferenceProperty__ManyAssignment_2_1_in_rule__ReferenceProperty__Alternatives_2514);
                    rule__ReferenceProperty__ManyAssignment_2_1();
                    _fsp--;


                    }

                     after(grammarAccess.getReferencePropertyAccess().getManyAssignment_2_1()); 

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
    // $ANTLR end rule__ReferenceProperty__Alternatives_2


    // $ANTLR start rule__Model__Group__0
    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:272:1: rule__Model__Group__0 : ( () ) rule__Model__Group__1 ;
    public final void rule__Model__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:276:1: ( ( () ) rule__Model__Group__1 )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:277:1: ( () ) rule__Model__Group__1
            {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:277:1: ( () )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:278:1: ()
            {
             before(grammarAccess.getModelAccess().getModelAction_0()); 
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:279:1: ()
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:281:1: 
            {
            }

             after(grammarAccess.getModelAccess().getModelAction_0()); 

            }

            pushFollow(FOLLOW_rule__Model__Group__1_in_rule__Model__Group__0559);
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
    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:292:1: rule__Model__Group__1 : ( ( rule__Model__EntitiesAssignment_1 )* ) ;
    public final void rule__Model__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:296:1: ( ( ( rule__Model__EntitiesAssignment_1 )* ) )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:297:1: ( ( rule__Model__EntitiesAssignment_1 )* )
            {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:297:1: ( ( rule__Model__EntitiesAssignment_1 )* )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:298:1: ( rule__Model__EntitiesAssignment_1 )*
            {
             before(grammarAccess.getModelAccess().getEntitiesAssignment_1()); 
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:299:1: ( rule__Model__EntitiesAssignment_1 )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==15) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:299:2: rule__Model__EntitiesAssignment_1
            	    {
            	    pushFollow(FOLLOW_rule__Model__EntitiesAssignment_1_in_rule__Model__Group__1587);
            	    rule__Model__EntitiesAssignment_1();
            	    _fsp--;


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

             after(grammarAccess.getModelAccess().getEntitiesAssignment_1()); 

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
    // $ANTLR end rule__Model__Group__1


    // $ANTLR start rule__Entity__Group__0
    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:313:1: rule__Entity__Group__0 : ( 'entity' ) rule__Entity__Group__1 ;
    public final void rule__Entity__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:317:1: ( ( 'entity' ) rule__Entity__Group__1 )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:318:1: ( 'entity' ) rule__Entity__Group__1
            {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:318:1: ( 'entity' )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:319:1: 'entity'
            {
             before(grammarAccess.getEntityAccess().getEntityKeyword_0()); 
            match(input,15,FOLLOW_15_in_rule__Entity__Group__0627); 
             after(grammarAccess.getEntityAccess().getEntityKeyword_0()); 

            }

            pushFollow(FOLLOW_rule__Entity__Group__1_in_rule__Entity__Group__0637);
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
    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:333:1: rule__Entity__Group__1 : ( ( rule__Entity__NameAssignment_1 ) ) rule__Entity__Group__2 ;
    public final void rule__Entity__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:337:1: ( ( ( rule__Entity__NameAssignment_1 ) ) rule__Entity__Group__2 )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:338:1: ( ( rule__Entity__NameAssignment_1 ) ) rule__Entity__Group__2
            {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:338:1: ( ( rule__Entity__NameAssignment_1 ) )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:339:1: ( rule__Entity__NameAssignment_1 )
            {
             before(grammarAccess.getEntityAccess().getNameAssignment_1()); 
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:340:1: ( rule__Entity__NameAssignment_1 )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:340:2: rule__Entity__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__Entity__NameAssignment_1_in_rule__Entity__Group__1665);
            rule__Entity__NameAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getEntityAccess().getNameAssignment_1()); 

            }

            pushFollow(FOLLOW_rule__Entity__Group__2_in_rule__Entity__Group__1674);
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
    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:351:1: rule__Entity__Group__2 : ( ( rule__Entity__Group_2__0 )? ) rule__Entity__Group__3 ;
    public final void rule__Entity__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:355:1: ( ( ( rule__Entity__Group_2__0 )? ) rule__Entity__Group__3 )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:356:1: ( ( rule__Entity__Group_2__0 )? ) rule__Entity__Group__3
            {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:356:1: ( ( rule__Entity__Group_2__0 )? )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:357:1: ( rule__Entity__Group_2__0 )?
            {
             before(grammarAccess.getEntityAccess().getGroup_2()); 
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:358:1: ( rule__Entity__Group_2__0 )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==18) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:358:2: rule__Entity__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__Entity__Group_2__0_in_rule__Entity__Group__2702);
                    rule__Entity__Group_2__0();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getEntityAccess().getGroup_2()); 

            }

            pushFollow(FOLLOW_rule__Entity__Group__3_in_rule__Entity__Group__2712);
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
    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:369:1: rule__Entity__Group__3 : ( '{' ) rule__Entity__Group__4 ;
    public final void rule__Entity__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:373:1: ( ( '{' ) rule__Entity__Group__4 )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:374:1: ( '{' ) rule__Entity__Group__4
            {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:374:1: ( '{' )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:375:1: '{'
            {
             before(grammarAccess.getEntityAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,16,FOLLOW_16_in_rule__Entity__Group__3741); 
             after(grammarAccess.getEntityAccess().getLeftCurlyBracketKeyword_3()); 

            }

            pushFollow(FOLLOW_rule__Entity__Group__4_in_rule__Entity__Group__3751);
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
    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:389:1: rule__Entity__Group__4 : ( ( rule__Entity__PropertiesAssignment_4 )* ) rule__Entity__Group__5 ;
    public final void rule__Entity__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:393:1: ( ( ( rule__Entity__PropertiesAssignment_4 )* ) rule__Entity__Group__5 )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:394:1: ( ( rule__Entity__PropertiesAssignment_4 )* ) rule__Entity__Group__5
            {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:394:1: ( ( rule__Entity__PropertiesAssignment_4 )* )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:395:1: ( rule__Entity__PropertiesAssignment_4 )*
            {
             before(grammarAccess.getEntityAccess().getPropertiesAssignment_4()); 
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:396:1: ( rule__Entity__PropertiesAssignment_4 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==RULE_ID||LA6_0==19) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:396:2: rule__Entity__PropertiesAssignment_4
            	    {
            	    pushFollow(FOLLOW_rule__Entity__PropertiesAssignment_4_in_rule__Entity__Group__4779);
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

            pushFollow(FOLLOW_rule__Entity__Group__5_in_rule__Entity__Group__4789);
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
    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:407:1: rule__Entity__Group__5 : ( '}' ) ;
    public final void rule__Entity__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:411:1: ( ( '}' ) )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:412:1: ( '}' )
            {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:412:1: ( '}' )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:413:1: '}'
            {
             before(grammarAccess.getEntityAccess().getRightCurlyBracketKeyword_5()); 
            match(input,17,FOLLOW_17_in_rule__Entity__Group__5818); 
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
    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:438:1: rule__Entity__Group_2__0 : ( 'extends' ) rule__Entity__Group_2__1 ;
    public final void rule__Entity__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:442:1: ( ( 'extends' ) rule__Entity__Group_2__1 )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:443:1: ( 'extends' ) rule__Entity__Group_2__1
            {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:443:1: ( 'extends' )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:444:1: 'extends'
            {
             before(grammarAccess.getEntityAccess().getExtendsKeyword_2_0()); 
            match(input,18,FOLLOW_18_in_rule__Entity__Group_2__0866); 
             after(grammarAccess.getEntityAccess().getExtendsKeyword_2_0()); 

            }

            pushFollow(FOLLOW_rule__Entity__Group_2__1_in_rule__Entity__Group_2__0876);
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
    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:458:1: rule__Entity__Group_2__1 : ( ( rule__Entity__SuperTypeAssignment_2_1 ) ) ;
    public final void rule__Entity__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:462:1: ( ( ( rule__Entity__SuperTypeAssignment_2_1 ) ) )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:463:1: ( ( rule__Entity__SuperTypeAssignment_2_1 ) )
            {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:463:1: ( ( rule__Entity__SuperTypeAssignment_2_1 ) )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:464:1: ( rule__Entity__SuperTypeAssignment_2_1 )
            {
             before(grammarAccess.getEntityAccess().getSuperTypeAssignment_2_1()); 
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:465:1: ( rule__Entity__SuperTypeAssignment_2_1 )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:465:2: rule__Entity__SuperTypeAssignment_2_1
            {
            pushFollow(FOLLOW_rule__Entity__SuperTypeAssignment_2_1_in_rule__Entity__Group_2__1904);
            rule__Entity__SuperTypeAssignment_2_1();
            _fsp--;


            }

             after(grammarAccess.getEntityAccess().getSuperTypeAssignment_2_1()); 

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
    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:479:1: rule__SimpleProperty__Group__0 : ( 'property' ) rule__SimpleProperty__Group__1 ;
    public final void rule__SimpleProperty__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:483:1: ( ( 'property' ) rule__SimpleProperty__Group__1 )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:484:1: ( 'property' ) rule__SimpleProperty__Group__1
            {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:484:1: ( 'property' )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:485:1: 'property'
            {
             before(grammarAccess.getSimplePropertyAccess().getPropertyKeyword_0()); 
            match(input,19,FOLLOW_19_in_rule__SimpleProperty__Group__0943); 
             after(grammarAccess.getSimplePropertyAccess().getPropertyKeyword_0()); 

            }

            pushFollow(FOLLOW_rule__SimpleProperty__Group__1_in_rule__SimpleProperty__Group__0953);
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
    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:499:1: rule__SimpleProperty__Group__1 : ( ( rule__SimpleProperty__NameAssignment_1 ) ) rule__SimpleProperty__Group__2 ;
    public final void rule__SimpleProperty__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:503:1: ( ( ( rule__SimpleProperty__NameAssignment_1 ) ) rule__SimpleProperty__Group__2 )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:504:1: ( ( rule__SimpleProperty__NameAssignment_1 ) ) rule__SimpleProperty__Group__2
            {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:504:1: ( ( rule__SimpleProperty__NameAssignment_1 ) )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:505:1: ( rule__SimpleProperty__NameAssignment_1 )
            {
             before(grammarAccess.getSimplePropertyAccess().getNameAssignment_1()); 
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:506:1: ( rule__SimpleProperty__NameAssignment_1 )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:506:2: rule__SimpleProperty__NameAssignment_1
            {
            pushFollow(FOLLOW_rule__SimpleProperty__NameAssignment_1_in_rule__SimpleProperty__Group__1981);
            rule__SimpleProperty__NameAssignment_1();
            _fsp--;


            }

             after(grammarAccess.getSimplePropertyAccess().getNameAssignment_1()); 

            }

            pushFollow(FOLLOW_rule__SimpleProperty__Group__2_in_rule__SimpleProperty__Group__1990);
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
    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:517:1: rule__SimpleProperty__Group__2 : ( ':' ) rule__SimpleProperty__Group__3 ;
    public final void rule__SimpleProperty__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:521:1: ( ( ':' ) rule__SimpleProperty__Group__3 )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:522:1: ( ':' ) rule__SimpleProperty__Group__3
            {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:522:1: ( ':' )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:523:1: ':'
            {
             before(grammarAccess.getSimplePropertyAccess().getColonKeyword_2()); 
            match(input,20,FOLLOW_20_in_rule__SimpleProperty__Group__21019); 
             after(grammarAccess.getSimplePropertyAccess().getColonKeyword_2()); 

            }

            pushFollow(FOLLOW_rule__SimpleProperty__Group__3_in_rule__SimpleProperty__Group__21029);
            rule__SimpleProperty__Group__3();
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
    // $ANTLR end rule__SimpleProperty__Group__2


    // $ANTLR start rule__SimpleProperty__Group__3
    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:537:1: rule__SimpleProperty__Group__3 : ( ( rule__SimpleProperty__TypeAssignment_3 ) ) ;
    public final void rule__SimpleProperty__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:541:1: ( ( ( rule__SimpleProperty__TypeAssignment_3 ) ) )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:542:1: ( ( rule__SimpleProperty__TypeAssignment_3 ) )
            {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:542:1: ( ( rule__SimpleProperty__TypeAssignment_3 ) )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:543:1: ( rule__SimpleProperty__TypeAssignment_3 )
            {
             before(grammarAccess.getSimplePropertyAccess().getTypeAssignment_3()); 
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:544:1: ( rule__SimpleProperty__TypeAssignment_3 )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:544:2: rule__SimpleProperty__TypeAssignment_3
            {
            pushFollow(FOLLOW_rule__SimpleProperty__TypeAssignment_3_in_rule__SimpleProperty__Group__31057);
            rule__SimpleProperty__TypeAssignment_3();
            _fsp--;


            }

             after(grammarAccess.getSimplePropertyAccess().getTypeAssignment_3()); 

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
    // $ANTLR end rule__SimpleProperty__Group__3


    // $ANTLR start rule__ReferenceProperty__Group__0
    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:562:1: rule__ReferenceProperty__Group__0 : ( ( rule__ReferenceProperty__NameAssignment_0 ) ) rule__ReferenceProperty__Group__1 ;
    public final void rule__ReferenceProperty__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:566:1: ( ( ( rule__ReferenceProperty__NameAssignment_0 ) ) rule__ReferenceProperty__Group__1 )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:567:1: ( ( rule__ReferenceProperty__NameAssignment_0 ) ) rule__ReferenceProperty__Group__1
            {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:567:1: ( ( rule__ReferenceProperty__NameAssignment_0 ) )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:568:1: ( rule__ReferenceProperty__NameAssignment_0 )
            {
             before(grammarAccess.getReferencePropertyAccess().getNameAssignment_0()); 
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:569:1: ( rule__ReferenceProperty__NameAssignment_0 )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:569:2: rule__ReferenceProperty__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__ReferenceProperty__NameAssignment_0_in_rule__ReferenceProperty__Group__01099);
            rule__ReferenceProperty__NameAssignment_0();
            _fsp--;


            }

             after(grammarAccess.getReferencePropertyAccess().getNameAssignment_0()); 

            }

            pushFollow(FOLLOW_rule__ReferenceProperty__Group__1_in_rule__ReferenceProperty__Group__01108);
            rule__ReferenceProperty__Group__1();
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
    // $ANTLR end rule__ReferenceProperty__Group__0


    // $ANTLR start rule__ReferenceProperty__Group__1
    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:580:1: rule__ReferenceProperty__Group__1 : ( 'refs' ) rule__ReferenceProperty__Group__2 ;
    public final void rule__ReferenceProperty__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:584:1: ( ( 'refs' ) rule__ReferenceProperty__Group__2 )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:585:1: ( 'refs' ) rule__ReferenceProperty__Group__2
            {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:585:1: ( 'refs' )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:586:1: 'refs'
            {
             before(grammarAccess.getReferencePropertyAccess().getRefsKeyword_1()); 
            match(input,21,FOLLOW_21_in_rule__ReferenceProperty__Group__11137); 
             after(grammarAccess.getReferencePropertyAccess().getRefsKeyword_1()); 

            }

            pushFollow(FOLLOW_rule__ReferenceProperty__Group__2_in_rule__ReferenceProperty__Group__11147);
            rule__ReferenceProperty__Group__2();
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
    // $ANTLR end rule__ReferenceProperty__Group__1


    // $ANTLR start rule__ReferenceProperty__Group__2
    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:600:1: rule__ReferenceProperty__Group__2 : ( ( rule__ReferenceProperty__Alternatives_2 )? ) rule__ReferenceProperty__Group__3 ;
    public final void rule__ReferenceProperty__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:604:1: ( ( ( rule__ReferenceProperty__Alternatives_2 )? ) rule__ReferenceProperty__Group__3 )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:605:1: ( ( rule__ReferenceProperty__Alternatives_2 )? ) rule__ReferenceProperty__Group__3
            {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:605:1: ( ( rule__ReferenceProperty__Alternatives_2 )? )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:606:1: ( rule__ReferenceProperty__Alternatives_2 )?
            {
             before(grammarAccess.getReferencePropertyAccess().getAlternatives_2()); 
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:607:1: ( rule__ReferenceProperty__Alternatives_2 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==14||LA7_0==22) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:607:2: rule__ReferenceProperty__Alternatives_2
                    {
                    pushFollow(FOLLOW_rule__ReferenceProperty__Alternatives_2_in_rule__ReferenceProperty__Group__21175);
                    rule__ReferenceProperty__Alternatives_2();
                    _fsp--;


                    }
                    break;

            }

             after(grammarAccess.getReferencePropertyAccess().getAlternatives_2()); 

            }

            pushFollow(FOLLOW_rule__ReferenceProperty__Group__3_in_rule__ReferenceProperty__Group__21185);
            rule__ReferenceProperty__Group__3();
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
    // $ANTLR end rule__ReferenceProperty__Group__2


    // $ANTLR start rule__ReferenceProperty__Group__3
    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:618:1: rule__ReferenceProperty__Group__3 : ( ( rule__ReferenceProperty__TypeAssignment_3 ) ) ;
    public final void rule__ReferenceProperty__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:622:1: ( ( ( rule__ReferenceProperty__TypeAssignment_3 ) ) )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:623:1: ( ( rule__ReferenceProperty__TypeAssignment_3 ) )
            {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:623:1: ( ( rule__ReferenceProperty__TypeAssignment_3 ) )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:624:1: ( rule__ReferenceProperty__TypeAssignment_3 )
            {
             before(grammarAccess.getReferencePropertyAccess().getTypeAssignment_3()); 
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:625:1: ( rule__ReferenceProperty__TypeAssignment_3 )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:625:2: rule__ReferenceProperty__TypeAssignment_3
            {
            pushFollow(FOLLOW_rule__ReferenceProperty__TypeAssignment_3_in_rule__ReferenceProperty__Group__31213);
            rule__ReferenceProperty__TypeAssignment_3();
            _fsp--;


            }

             after(grammarAccess.getReferencePropertyAccess().getTypeAssignment_3()); 

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
    // $ANTLR end rule__ReferenceProperty__Group__3


    // $ANTLR start rule__Model__EntitiesAssignment_1
    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:643:1: rule__Model__EntitiesAssignment_1 : ( ruleEntity ) ;
    public final void rule__Model__EntitiesAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:647:1: ( ( ruleEntity ) )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:648:1: ( ruleEntity )
            {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:648:1: ( ruleEntity )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:649:1: ruleEntity
            {
             before(grammarAccess.getModelAccess().getEntitiesEntityParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleEntity_in_rule__Model__EntitiesAssignment_11255);
            ruleEntity();
            _fsp--;

             after(grammarAccess.getModelAccess().getEntitiesEntityParserRuleCall_1_0()); 

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
    // $ANTLR end rule__Model__EntitiesAssignment_1


    // $ANTLR start rule__Entity__NameAssignment_1
    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:658:1: rule__Entity__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__Entity__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:662:1: ( ( RULE_ID ) )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:663:1: ( RULE_ID )
            {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:663:1: ( RULE_ID )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:664:1: RULE_ID
            {
             before(grammarAccess.getEntityAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Entity__NameAssignment_11286); 
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


    // $ANTLR start rule__Entity__SuperTypeAssignment_2_1
    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:673:1: rule__Entity__SuperTypeAssignment_2_1 : ( ( RULE_ID ) ) ;
    public final void rule__Entity__SuperTypeAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:677:1: ( ( ( RULE_ID ) ) )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:678:1: ( ( RULE_ID ) )
            {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:678:1: ( ( RULE_ID ) )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:679:1: ( RULE_ID )
            {
             before(grammarAccess.getEntityAccess().getSuperTypeEntityCrossReference_2_1_0()); 
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:680:1: ( RULE_ID )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:681:1: RULE_ID
            {
             before(grammarAccess.getEntityAccess().getSuperTypeEntityIDTerminalRuleCall_2_1_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Entity__SuperTypeAssignment_2_11321); 
             after(grammarAccess.getEntityAccess().getSuperTypeEntityIDTerminalRuleCall_2_1_0_1()); 

            }

             after(grammarAccess.getEntityAccess().getSuperTypeEntityCrossReference_2_1_0()); 

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
    // $ANTLR end rule__Entity__SuperTypeAssignment_2_1


    // $ANTLR start rule__Entity__PropertiesAssignment_4
    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:692:1: rule__Entity__PropertiesAssignment_4 : ( ruleProperty ) ;
    public final void rule__Entity__PropertiesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:696:1: ( ( ruleProperty ) )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:697:1: ( ruleProperty )
            {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:697:1: ( ruleProperty )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:698:1: ruleProperty
            {
             before(grammarAccess.getEntityAccess().getPropertiesPropertyParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleProperty_in_rule__Entity__PropertiesAssignment_41356);
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
    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:707:1: rule__SimpleProperty__NameAssignment_1 : ( RULE_ID ) ;
    public final void rule__SimpleProperty__NameAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:711:1: ( ( RULE_ID ) )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:712:1: ( RULE_ID )
            {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:712:1: ( RULE_ID )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:713:1: RULE_ID
            {
             before(grammarAccess.getSimplePropertyAccess().getNameIDTerminalRuleCall_1_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__SimpleProperty__NameAssignment_11387); 
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


    // $ANTLR start rule__SimpleProperty__TypeAssignment_3
    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:722:1: rule__SimpleProperty__TypeAssignment_3 : ( ( rule__SimpleProperty__TypeAlternatives_3_0 ) ) ;
    public final void rule__SimpleProperty__TypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:726:1: ( ( ( rule__SimpleProperty__TypeAlternatives_3_0 ) ) )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:727:1: ( ( rule__SimpleProperty__TypeAlternatives_3_0 ) )
            {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:727:1: ( ( rule__SimpleProperty__TypeAlternatives_3_0 ) )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:728:1: ( rule__SimpleProperty__TypeAlternatives_3_0 )
            {
             before(grammarAccess.getSimplePropertyAccess().getTypeAlternatives_3_0()); 
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:729:1: ( rule__SimpleProperty__TypeAlternatives_3_0 )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:729:2: rule__SimpleProperty__TypeAlternatives_3_0
            {
            pushFollow(FOLLOW_rule__SimpleProperty__TypeAlternatives_3_0_in_rule__SimpleProperty__TypeAssignment_31418);
            rule__SimpleProperty__TypeAlternatives_3_0();
            _fsp--;


            }

             after(grammarAccess.getSimplePropertyAccess().getTypeAlternatives_3_0()); 

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
    // $ANTLR end rule__SimpleProperty__TypeAssignment_3


    // $ANTLR start rule__ReferenceProperty__NameAssignment_0
    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:738:1: rule__ReferenceProperty__NameAssignment_0 : ( RULE_ID ) ;
    public final void rule__ReferenceProperty__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:742:1: ( ( RULE_ID ) )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:743:1: ( RULE_ID )
            {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:743:1: ( RULE_ID )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:744:1: RULE_ID
            {
             before(grammarAccess.getReferencePropertyAccess().getNameIDTerminalRuleCall_0_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ReferenceProperty__NameAssignment_01451); 
             after(grammarAccess.getReferencePropertyAccess().getNameIDTerminalRuleCall_0_0()); 

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
    // $ANTLR end rule__ReferenceProperty__NameAssignment_0


    // $ANTLR start rule__ReferenceProperty__ManyAssignment_2_1
    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:753:1: rule__ReferenceProperty__ManyAssignment_2_1 : ( ( 'many' ) ) ;
    public final void rule__ReferenceProperty__ManyAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:757:1: ( ( ( 'many' ) ) )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:758:1: ( ( 'many' ) )
            {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:758:1: ( ( 'many' ) )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:759:1: ( 'many' )
            {
             before(grammarAccess.getReferencePropertyAccess().getManyManyKeyword_2_1_0()); 
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:760:1: ( 'many' )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:761:1: 'many'
            {
             before(grammarAccess.getReferencePropertyAccess().getManyManyKeyword_2_1_0()); 
            match(input,22,FOLLOW_22_in_rule__ReferenceProperty__ManyAssignment_2_11487); 
             after(grammarAccess.getReferencePropertyAccess().getManyManyKeyword_2_1_0()); 

            }

             after(grammarAccess.getReferencePropertyAccess().getManyManyKeyword_2_1_0()); 

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
    // $ANTLR end rule__ReferenceProperty__ManyAssignment_2_1


    // $ANTLR start rule__ReferenceProperty__TypeAssignment_3
    // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:776:1: rule__ReferenceProperty__TypeAssignment_3 : ( ( RULE_ID ) ) ;
    public final void rule__ReferenceProperty__TypeAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:780:1: ( ( ( RULE_ID ) ) )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:781:1: ( ( RULE_ID ) )
            {
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:781:1: ( ( RULE_ID ) )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:782:1: ( RULE_ID )
            {
             before(grammarAccess.getReferencePropertyAccess().getTypeEntityCrossReference_3_0()); 
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:783:1: ( RULE_ID )
            // ../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g:784:1: RULE_ID
            {
             before(grammarAccess.getReferencePropertyAccess().getTypeEntityIDTerminalRuleCall_3_0_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__ReferenceProperty__TypeAssignment_31530); 
             after(grammarAccess.getReferencePropertyAccess().getTypeEntityIDTerminalRuleCall_3_0_1()); 

            }

             after(grammarAccess.getReferencePropertyAccess().getTypeEntityCrossReference_3_0()); 

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
    // $ANTLR end rule__ReferenceProperty__TypeAssignment_3


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel60 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel67 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__0_in_ruleModel94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntity_in_entryRuleEntity120 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEntity127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Entity__Group__0_in_ruleEntity154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProperty_in_entryRuleProperty180 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProperty187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Property__Alternatives_in_ruleProperty214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleProperty_in_entryRuleSimpleProperty240 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpleProperty247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleProperty__Group__0_in_ruleSimpleProperty274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferenceProperty_in_entryRuleReferenceProperty300 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferenceProperty307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferenceProperty__Group__0_in_ruleReferenceProperty334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleProperty_in_rule__Property__Alternatives370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferenceProperty_in_rule__Property__Alternatives387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__SimpleProperty__TypeAlternatives_3_0420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__SimpleProperty__TypeAlternatives_3_0440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__SimpleProperty__TypeAlternatives_3_0460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__ReferenceProperty__Alternatives_2495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferenceProperty__ManyAssignment_2_1_in_rule__ReferenceProperty__Alternatives_2514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__Group__1_in_rule__Model__Group__0559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Model__EntitiesAssignment_1_in_rule__Model__Group__1587 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_rule__Entity__Group__0627 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Entity__Group__1_in_rule__Entity__Group__0637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Entity__NameAssignment_1_in_rule__Entity__Group__1665 = new BitSet(new long[]{0x0000000000050000L});
    public static final BitSet FOLLOW_rule__Entity__Group__2_in_rule__Entity__Group__1674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Entity__Group_2__0_in_rule__Entity__Group__2702 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Entity__Group__3_in_rule__Entity__Group__2712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Entity__Group__3741 = new BitSet(new long[]{0x00000000000A0010L});
    public static final BitSet FOLLOW_rule__Entity__Group__4_in_rule__Entity__Group__3751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Entity__PropertiesAssignment_4_in_rule__Entity__Group__4779 = new BitSet(new long[]{0x00000000000A0010L});
    public static final BitSet FOLLOW_rule__Entity__Group__5_in_rule__Entity__Group__4789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Entity__Group__5818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Entity__Group_2__0866 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Entity__Group_2__1_in_rule__Entity__Group_2__0876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Entity__SuperTypeAssignment_2_1_in_rule__Entity__Group_2__1904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__SimpleProperty__Group__0943 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__SimpleProperty__Group__1_in_rule__SimpleProperty__Group__0953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleProperty__NameAssignment_1_in_rule__SimpleProperty__Group__1981 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__SimpleProperty__Group__2_in_rule__SimpleProperty__Group__1990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__SimpleProperty__Group__21019 = new BitSet(new long[]{0x0000000000003800L});
    public static final BitSet FOLLOW_rule__SimpleProperty__Group__3_in_rule__SimpleProperty__Group__21029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleProperty__TypeAssignment_3_in_rule__SimpleProperty__Group__31057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferenceProperty__NameAssignment_0_in_rule__ReferenceProperty__Group__01099 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__ReferenceProperty__Group__1_in_rule__ReferenceProperty__Group__01108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__ReferenceProperty__Group__11137 = new BitSet(new long[]{0x0000000000404010L});
    public static final BitSet FOLLOW_rule__ReferenceProperty__Group__2_in_rule__ReferenceProperty__Group__11147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferenceProperty__Alternatives_2_in_rule__ReferenceProperty__Group__21175 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__ReferenceProperty__Group__3_in_rule__ReferenceProperty__Group__21185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ReferenceProperty__TypeAssignment_3_in_rule__ReferenceProperty__Group__31213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntity_in_rule__Model__EntitiesAssignment_11255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Entity__NameAssignment_11286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Entity__SuperTypeAssignment_2_11321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProperty_in_rule__Entity__PropertiesAssignment_41356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__SimpleProperty__NameAssignment_11387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__SimpleProperty__TypeAlternatives_3_0_in_rule__SimpleProperty__TypeAssignment_31418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ReferenceProperty__NameAssignment_01451 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__ReferenceProperty__ManyAssignment_2_11487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__ReferenceProperty__TypeAssignment_31530 = new BitSet(new long[]{0x0000000000000002L});

}