package org.xtext.cg2009.parser.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.xtext.parsetree.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.xtext.cg2009.services.EntitiesGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalEntitiesParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'entity'", "'extends'", "'{'", "'}'", "'property'", "':'", "'String'", "'Number'", "'Bool'", "'refs'", "'one'", "'many'"
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
    public String getGrammarFileName() { return "../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g"; }


     
     	private EntitiesGrammarAccess grammarAccess;
     	
        public InternalEntitiesParser(TokenStream input, IAstFactory factory, EntitiesGrammarAccess grammarAccess) {
            this(input);
            this.factory = factory;
            registerRules(grammarAccess.getGrammar());
            this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected InputStream getTokenFile() {
        	ClassLoader classLoader = getClass().getClassLoader();
        	return classLoader.getResourceAsStream("org/xtext/cg2009/parser/antlr/internal/InternalEntities.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	} 



    // $ANTLR start entryRuleModel
    // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:72:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:72:47: (iv_ruleModel= ruleModel EOF )
            // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:73:2: iv_ruleModel= ruleModel EOF
            {
             currentNode = createCompositeNode(grammarAccess.getModelRule(), currentNode); 
            pushFollow(FOLLOW_ruleModel_in_entryRuleModel73);
            iv_ruleModel=ruleModel();
            _fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModel83); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleModel


    // $ANTLR start ruleModel
    // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:80:1: ruleModel returns [EObject current=null] : ( () (lv_entities_1= ruleEntity )* ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_entities_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:85:6: ( ( () (lv_entities_1= ruleEntity )* ) )
            // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:86:1: ( () (lv_entities_1= ruleEntity )* )
            {
            // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:86:1: ( () (lv_entities_1= ruleEntity )* )
            // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:86:2: () (lv_entities_1= ruleEntity )*
            {
            // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:86:2: ()
            // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:87:5: 
            {
             
                    temp=factory.create(grammarAccess.getModelAccess().getModelAction_0().getType().getClassifier());
                    current = temp; 
                    temp = null;
                    CompositeNode newNode = createCompositeNode(grammarAccess.getModelAccess().getModelAction_0(), currentNode.getParent());
                newNode.getChildren().add(currentNode);
                moveLookaheadInfo(currentNode, newNode);
                currentNode = newNode; 
                    associateNodeWithAstElement(currentNode, current); 
                

            }

            // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:97:2: (lv_entities_1= ruleEntity )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:100:6: lv_entities_1= ruleEntity
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getEntitiesEntityParserRuleCall_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleEntity_in_ruleModel151);
            	    lv_entities_1=ruleEntity();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "entities", lv_entities_1, "Entity", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleModel


    // $ANTLR start entryRuleEntity
    // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:125:1: entryRuleEntity returns [EObject current=null] : iv_ruleEntity= ruleEntity EOF ;
    public final EObject entryRuleEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntity = null;


        try {
            // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:125:48: (iv_ruleEntity= ruleEntity EOF )
            // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:126:2: iv_ruleEntity= ruleEntity EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEntityRule(), currentNode); 
            pushFollow(FOLLOW_ruleEntity_in_entryRuleEntity189);
            iv_ruleEntity=ruleEntity();
            _fsp--;

             current =iv_ruleEntity; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEntity199); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleEntity


    // $ANTLR start ruleEntity
    // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:133:1: ruleEntity returns [EObject current=null] : ( 'entity' (lv_name_1= RULE_ID ) ( 'extends' ( RULE_ID ) )? '{' (lv_properties_5= ruleProperty )* '}' ) ;
    public final EObject ruleEntity() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;
        EObject lv_properties_5 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:138:6: ( ( 'entity' (lv_name_1= RULE_ID ) ( 'extends' ( RULE_ID ) )? '{' (lv_properties_5= ruleProperty )* '}' ) )
            // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:139:1: ( 'entity' (lv_name_1= RULE_ID ) ( 'extends' ( RULE_ID ) )? '{' (lv_properties_5= ruleProperty )* '}' )
            {
            // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:139:1: ( 'entity' (lv_name_1= RULE_ID ) ( 'extends' ( RULE_ID ) )? '{' (lv_properties_5= ruleProperty )* '}' )
            // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:139:2: 'entity' (lv_name_1= RULE_ID ) ( 'extends' ( RULE_ID ) )? '{' (lv_properties_5= ruleProperty )* '}'
            {
            match(input,11,FOLLOW_11_in_ruleEntity233); 

                    createLeafNode(grammarAccess.getEntityAccess().getEntityKeyword_0(), null); 
                
            // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:143:1: (lv_name_1= RULE_ID )
            // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:145:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEntity255); 

            		createLeafNode(grammarAccess.getEntityAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEntityRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:163:2: ( 'extends' ( RULE_ID ) )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==12) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:163:3: 'extends' ( RULE_ID )
                    {
                    match(input,12,FOLLOW_12_in_ruleEntity273); 

                            createLeafNode(grammarAccess.getEntityAccess().getExtendsKeyword_2_0(), null); 
                        
                    // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:167:1: ( RULE_ID )
                    // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:170:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getEntityRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEntity295); 

                    		createLeafNode(grammarAccess.getEntityAccess().getSuperTypeEntityCrossReference_2_1_0(), "superType"); 
                    	

                    }


                    }
                    break;

            }

            match(input,13,FOLLOW_13_in_ruleEntity309); 

                    createLeafNode(grammarAccess.getEntityAccess().getLeftCurlyBracketKeyword_3(), null); 
                
            // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:187:1: (lv_properties_5= ruleProperty )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID||LA3_0==15) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:190:6: lv_properties_5= ruleProperty
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getEntityAccess().getPropertiesPropertyParserRuleCall_4_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleProperty_in_ruleEntity343);
            	    lv_properties_5=ruleProperty();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEntityRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        
            	    	        try {
            	    	       		add(current, "properties", lv_properties_5, "Property", currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            match(input,14,FOLLOW_14_in_ruleEntity357); 

                    createLeafNode(grammarAccess.getEntityAccess().getRightCurlyBracketKeyword_5(), null); 
                

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleEntity


    // $ANTLR start entryRuleProperty
    // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:219:1: entryRuleProperty returns [EObject current=null] : iv_ruleProperty= ruleProperty EOF ;
    public final EObject entryRuleProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProperty = null;


        try {
            // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:219:50: (iv_ruleProperty= ruleProperty EOF )
            // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:220:2: iv_ruleProperty= ruleProperty EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPropertyRule(), currentNode); 
            pushFollow(FOLLOW_ruleProperty_in_entryRuleProperty390);
            iv_ruleProperty=ruleProperty();
            _fsp--;

             current =iv_ruleProperty; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleProperty400); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleProperty


    // $ANTLR start ruleProperty
    // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:227:1: ruleProperty returns [EObject current=null] : (this_SimpleProperty_0= ruleSimpleProperty | this_ReferenceProperty_1= ruleReferenceProperty ) ;
    public final EObject ruleProperty() throws RecognitionException {
        EObject current = null;

        EObject this_SimpleProperty_0 = null;

        EObject this_ReferenceProperty_1 = null;


         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:232:6: ( (this_SimpleProperty_0= ruleSimpleProperty | this_ReferenceProperty_1= ruleReferenceProperty ) )
            // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:233:1: (this_SimpleProperty_0= ruleSimpleProperty | this_ReferenceProperty_1= ruleReferenceProperty )
            {
            // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:233:1: (this_SimpleProperty_0= ruleSimpleProperty | this_ReferenceProperty_1= ruleReferenceProperty )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==15) ) {
                alt4=1;
            }
            else if ( (LA4_0==RULE_ID) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("233:1: (this_SimpleProperty_0= ruleSimpleProperty | this_ReferenceProperty_1= ruleReferenceProperty )", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:234:5: this_SimpleProperty_0= ruleSimpleProperty
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPropertyAccess().getSimplePropertyParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleSimpleProperty_in_ruleProperty447);
                    this_SimpleProperty_0=ruleSimpleProperty();
                    _fsp--;

                     
                            current = this_SimpleProperty_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:244:5: this_ReferenceProperty_1= ruleReferenceProperty
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPropertyAccess().getReferencePropertyParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleReferenceProperty_in_ruleProperty474);
                    this_ReferenceProperty_1=ruleReferenceProperty();
                    _fsp--;

                     
                            current = this_ReferenceProperty_1; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;

            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleProperty


    // $ANTLR start entryRuleSimpleProperty
    // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:259:1: entryRuleSimpleProperty returns [EObject current=null] : iv_ruleSimpleProperty= ruleSimpleProperty EOF ;
    public final EObject entryRuleSimpleProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleProperty = null;


        try {
            // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:259:56: (iv_ruleSimpleProperty= ruleSimpleProperty EOF )
            // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:260:2: iv_ruleSimpleProperty= ruleSimpleProperty EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSimplePropertyRule(), currentNode); 
            pushFollow(FOLLOW_ruleSimpleProperty_in_entryRuleSimpleProperty506);
            iv_ruleSimpleProperty=ruleSimpleProperty();
            _fsp--;

             current =iv_ruleSimpleProperty; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpleProperty516); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleSimpleProperty


    // $ANTLR start ruleSimpleProperty
    // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:267:1: ruleSimpleProperty returns [EObject current=null] : ( 'property' (lv_name_1= RULE_ID ) ':' (lv_type_3= ( 'String' | 'Number' | 'Bool' ) ) ) ;
    public final EObject ruleSimpleProperty() throws RecognitionException {
        EObject current = null;

        Token lv_name_1=null;
        Token lv_type_3=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:272:6: ( ( 'property' (lv_name_1= RULE_ID ) ':' (lv_type_3= ( 'String' | 'Number' | 'Bool' ) ) ) )
            // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:273:1: ( 'property' (lv_name_1= RULE_ID ) ':' (lv_type_3= ( 'String' | 'Number' | 'Bool' ) ) )
            {
            // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:273:1: ( 'property' (lv_name_1= RULE_ID ) ':' (lv_type_3= ( 'String' | 'Number' | 'Bool' ) ) )
            // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:273:2: 'property' (lv_name_1= RULE_ID ) ':' (lv_type_3= ( 'String' | 'Number' | 'Bool' ) )
            {
            match(input,15,FOLLOW_15_in_ruleSimpleProperty550); 

                    createLeafNode(grammarAccess.getSimplePropertyAccess().getPropertyKeyword_0(), null); 
                
            // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:277:1: (lv_name_1= RULE_ID )
            // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:279:6: lv_name_1= RULE_ID
            {
            lv_name_1=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSimpleProperty572); 

            		createLeafNode(grammarAccess.getSimplePropertyAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSimplePropertyRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_1, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            match(input,16,FOLLOW_16_in_ruleSimpleProperty589); 

                    createLeafNode(grammarAccess.getSimplePropertyAccess().getColonKeyword_2(), null); 
                
            // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:301:1: (lv_type_3= ( 'String' | 'Number' | 'Bool' ) )
            // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:303:6: lv_type_3= ( 'String' | 'Number' | 'Bool' )
            {
            // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:303:16: ( 'String' | 'Number' | 'Bool' )
            int alt5=3;
            switch ( input.LA(1) ) {
            case 17:
                {
                alt5=1;
                }
                break;
            case 18:
                {
                alt5=2;
                }
                break;
            case 19:
                {
                alt5=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("303:16: ( 'String' | 'Number' | 'Bool' )", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:303:17: 'String'
                    {
                    match(input,17,FOLLOW_17_in_ruleSimpleProperty611); 

                            createLeafNode(grammarAccess.getSimplePropertyAccess().getTypeStringKeyword_3_0_0(), "type"); 
                        

                    }
                    break;
                case 2 :
                    // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:309:6: 'Number'
                    {
                    match(input,18,FOLLOW_18_in_ruleSimpleProperty627); 

                            createLeafNode(grammarAccess.getSimplePropertyAccess().getTypeNumberKeyword_3_0_1(), "type"); 
                        

                    }
                    break;
                case 3 :
                    // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:315:6: 'Bool'
                    {
                    match(input,19,FOLLOW_19_in_ruleSimpleProperty643); 

                            createLeafNode(grammarAccess.getSimplePropertyAccess().getTypeBoolKeyword_3_0_2(), "type"); 
                        

                    }
                    break;

            }


            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSimplePropertyRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "type", /* lv_type_3 */ input.LT(-1), null, lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleSimpleProperty


    // $ANTLR start entryRuleReferenceProperty
    // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:342:1: entryRuleReferenceProperty returns [EObject current=null] : iv_ruleReferenceProperty= ruleReferenceProperty EOF ;
    public final EObject entryRuleReferenceProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceProperty = null;


        try {
            // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:342:59: (iv_ruleReferenceProperty= ruleReferenceProperty EOF )
            // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:343:2: iv_ruleReferenceProperty= ruleReferenceProperty EOF
            {
             currentNode = createCompositeNode(grammarAccess.getReferencePropertyRule(), currentNode); 
            pushFollow(FOLLOW_ruleReferenceProperty_in_entryRuleReferenceProperty691);
            iv_ruleReferenceProperty=ruleReferenceProperty();
            _fsp--;

             current =iv_ruleReferenceProperty; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReferenceProperty701); 

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end entryRuleReferenceProperty


    // $ANTLR start ruleReferenceProperty
    // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:350:1: ruleReferenceProperty returns [EObject current=null] : ( (lv_name_0= RULE_ID ) 'refs' ( 'one' | (lv_many_3= 'many' ) )? ( RULE_ID ) ) ;
    public final EObject ruleReferenceProperty() throws RecognitionException {
        EObject current = null;

        Token lv_name_0=null;
        Token lv_many_3=null;

         EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:355:6: ( ( (lv_name_0= RULE_ID ) 'refs' ( 'one' | (lv_many_3= 'many' ) )? ( RULE_ID ) ) )
            // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:356:1: ( (lv_name_0= RULE_ID ) 'refs' ( 'one' | (lv_many_3= 'many' ) )? ( RULE_ID ) )
            {
            // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:356:1: ( (lv_name_0= RULE_ID ) 'refs' ( 'one' | (lv_many_3= 'many' ) )? ( RULE_ID ) )
            // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:356:2: (lv_name_0= RULE_ID ) 'refs' ( 'one' | (lv_many_3= 'many' ) )? ( RULE_ID )
            {
            // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:356:2: (lv_name_0= RULE_ID )
            // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:358:6: lv_name_0= RULE_ID
            {
            lv_name_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReferenceProperty748); 

            		createLeafNode(grammarAccess.getReferencePropertyAccess().getNameIDTerminalRuleCall_0_0(), "name"); 
            	

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getReferencePropertyRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        
            	        try {
            	       		set(current, "name", lv_name_0, "ID", lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }

            match(input,20,FOLLOW_20_in_ruleReferenceProperty765); 

                    createLeafNode(grammarAccess.getReferencePropertyAccess().getRefsKeyword_1(), null); 
                
            // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:380:1: ( 'one' | (lv_many_3= 'many' ) )?
            int alt6=3;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==21) ) {
                alt6=1;
            }
            else if ( (LA6_0==22) ) {
                alt6=2;
            }
            switch (alt6) {
                case 1 :
                    // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:380:2: 'one'
                    {
                    match(input,21,FOLLOW_21_in_ruleReferenceProperty775); 

                            createLeafNode(grammarAccess.getReferencePropertyAccess().getOneKeyword_2_0(), null); 
                        

                    }
                    break;
                case 2 :
                    // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:385:6: (lv_many_3= 'many' )
                    {
                    // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:385:6: (lv_many_3= 'many' )
                    // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:387:6: lv_many_3= 'many'
                    {
                    lv_many_3=(Token)input.LT(1);
                    match(input,22,FOLLOW_22_in_ruleReferenceProperty802); 

                            createLeafNode(grammarAccess.getReferencePropertyAccess().getManyManyKeyword_2_1_0(), "many"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getReferencePropertyRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "many", true, "many", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

            }

            // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:406:4: ( RULE_ID )
            // ../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g:409:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getReferencePropertyRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReferenceProperty839); 

            		createLeafNode(grammarAccess.getReferencePropertyAccess().getTypeEntityCrossReference_3_0(), "type"); 
            	

            }


            }


            }

             resetLookahead(); 
                	lastConsumedNode = currentNode;
                
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end ruleReferenceProperty


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel73 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntity_in_ruleModel151 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_ruleEntity_in_entryRuleEntity189 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEntity199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleEntity233 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEntity255 = new BitSet(new long[]{0x0000000000003000L});
    public static final BitSet FOLLOW_12_in_ruleEntity273 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEntity295 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleEntity309 = new BitSet(new long[]{0x000000000000C010L});
    public static final BitSet FOLLOW_ruleProperty_in_ruleEntity343 = new BitSet(new long[]{0x000000000000C010L});
    public static final BitSet FOLLOW_14_in_ruleEntity357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProperty_in_entryRuleProperty390 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProperty400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleProperty_in_ruleProperty447 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferenceProperty_in_ruleProperty474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleProperty_in_entryRuleSimpleProperty506 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpleProperty516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleSimpleProperty550 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleProperty572 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleSimpleProperty589 = new BitSet(new long[]{0x00000000000E0000L});
    public static final BitSet FOLLOW_17_in_ruleSimpleProperty611 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleSimpleProperty627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleSimpleProperty643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReferenceProperty_in_entryRuleReferenceProperty691 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReferenceProperty701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReferenceProperty748 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleReferenceProperty765 = new BitSet(new long[]{0x0000000000600010L});
    public static final BitSet FOLLOW_21_in_ruleReferenceProperty775 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_22_in_ruleReferenceProperty802 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReferenceProperty839 = new BitSet(new long[]{0x0000000000000002L});

}