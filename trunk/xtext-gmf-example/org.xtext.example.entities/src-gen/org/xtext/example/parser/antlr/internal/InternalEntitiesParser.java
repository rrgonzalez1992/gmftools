package org.xtext.example.parser.antlr.internal; 

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
import org.xtext.example.services.EntitiesGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class InternalEntitiesParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'import'", "'type'", "'entity'", "'extends'", "'{'", "'}'", "'property'", "':'", "'[]'", "'reference'"
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
    public String getGrammarFileName() { return "../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g"; }


     
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
        	return classLoader.getResourceAsStream("org/xtext/example/parser/antlr/internal/InternalEntities.tokens");
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "Model";	
       	} 



    // $ANTLR start entryRuleModel
    // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:72:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:72:47: (iv_ruleModel= ruleModel EOF )
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:73:2: iv_ruleModel= ruleModel EOF
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
    // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:80:1: ruleModel returns [EObject current=null] : ( () ( (lv_imports_1_0= ruleImport ) )* ( (lv_elements_2_0= ruleType ) )* ) ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_imports_1_0 = null;

        EObject lv_elements_2_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:85:6: ( ( () ( (lv_imports_1_0= ruleImport ) )* ( (lv_elements_2_0= ruleType ) )* ) )
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:86:1: ( () ( (lv_imports_1_0= ruleImport ) )* ( (lv_elements_2_0= ruleType ) )* )
            {
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:86:1: ( () ( (lv_imports_1_0= ruleImport ) )* ( (lv_elements_2_0= ruleType ) )* )
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:86:2: () ( (lv_imports_1_0= ruleImport ) )* ( (lv_elements_2_0= ruleType ) )*
            {
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:86:2: ()
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:87:5: 
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

            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:97:2: ( (lv_imports_1_0= ruleImport ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:98:1: (lv_imports_1_0= ruleImport )
            	    {
            	    // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:98:1: (lv_imports_1_0= ruleImport )
            	    // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:99:3: lv_imports_1_0= ruleImport
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getImportsImportParserRuleCall_1_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleImport_in_ruleModel138);
            	    lv_imports_1_0=ruleImport();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"imports",
            	    	        		lv_imports_1_0, 
            	    	        		"Import", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:121:3: ( (lv_elements_2_0= ruleType ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>=12 && LA2_0<=13)) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:122:1: (lv_elements_2_0= ruleType )
            	    {
            	    // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:122:1: (lv_elements_2_0= ruleType )
            	    // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:123:3: lv_elements_2_0= ruleType
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getModelAccess().getElementsTypeParserRuleCall_2_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleType_in_ruleModel160);
            	    lv_elements_2_0=ruleType();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getModelRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"elements",
            	    	        		lv_elements_2_0, 
            	    	        		"Type", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
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


    // $ANTLR start entryRuleImport
    // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:152:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:152:48: (iv_ruleImport= ruleImport EOF )
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:153:2: iv_ruleImport= ruleImport EOF
            {
             currentNode = createCompositeNode(grammarAccess.getImportRule(), currentNode); 
            pushFollow(FOLLOW_ruleImport_in_entryRuleImport194);
            iv_ruleImport=ruleImport();
            _fsp--;

             current =iv_ruleImport; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleImport204); 

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
    // $ANTLR end entryRuleImport


    // $ANTLR start ruleImport
    // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:160:1: ruleImport returns [EObject current=null] : ( 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token lv_importURI_1_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:165:6: ( ( 'import' ( (lv_importURI_1_0= RULE_STRING ) ) ) )
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:166:1: ( 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
            {
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:166:1: ( 'import' ( (lv_importURI_1_0= RULE_STRING ) ) )
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:166:2: 'import' ( (lv_importURI_1_0= RULE_STRING ) )
            {
            match(input,11,FOLLOW_11_in_ruleImport238); 

                    createLeafNode(grammarAccess.getImportAccess().getImportKeyword_0(), null); 
                
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:170:1: ( (lv_importURI_1_0= RULE_STRING ) )
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:171:1: (lv_importURI_1_0= RULE_STRING )
            {
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:171:1: (lv_importURI_1_0= RULE_STRING )
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:172:3: lv_importURI_1_0= RULE_STRING
            {
            lv_importURI_1_0=(Token)input.LT(1);
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleImport255); 

            			createLeafNode(grammarAccess.getImportAccess().getImportURISTRINGTerminalRuleCall_1_0(), "importURI"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getImportRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"importURI",
            	        		lv_importURI_1_0, 
            	        		"STRING", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

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
    // $ANTLR end ruleImport


    // $ANTLR start entryRuleType
    // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:201:1: entryRuleType returns [EObject current=null] : iv_ruleType= ruleType EOF ;
    public final EObject entryRuleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleType = null;


        try {
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:201:46: (iv_ruleType= ruleType EOF )
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:202:2: iv_ruleType= ruleType EOF
            {
             currentNode = createCompositeNode(grammarAccess.getTypeRule(), currentNode); 
            pushFollow(FOLLOW_ruleType_in_entryRuleType293);
            iv_ruleType=ruleType();
            _fsp--;

             current =iv_ruleType; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleType303); 

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
    // $ANTLR end entryRuleType


    // $ANTLR start ruleType
    // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:209:1: ruleType returns [EObject current=null] : (this_SimpleType_0= ruleSimpleType | this_Entity_1= ruleEntity ) ;
    public final EObject ruleType() throws RecognitionException {
        EObject current = null;

        EObject this_SimpleType_0 = null;

        EObject this_Entity_1 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:214:6: ( (this_SimpleType_0= ruleSimpleType | this_Entity_1= ruleEntity ) )
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:215:1: (this_SimpleType_0= ruleSimpleType | this_Entity_1= ruleEntity )
            {
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:215:1: (this_SimpleType_0= ruleSimpleType | this_Entity_1= ruleEntity )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==12) ) {
                alt3=1;
            }
            else if ( (LA3_0==13) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("215:1: (this_SimpleType_0= ruleSimpleType | this_Entity_1= ruleEntity )", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:216:5: this_SimpleType_0= ruleSimpleType
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTypeAccess().getSimpleTypeParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleSimpleType_in_ruleType350);
                    this_SimpleType_0=ruleSimpleType();
                    _fsp--;

                     
                            current = this_SimpleType_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:226:5: this_Entity_1= ruleEntity
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getTypeAccess().getEntityParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleEntity_in_ruleType377);
                    this_Entity_1=ruleEntity();
                    _fsp--;

                     
                            current = this_Entity_1; 
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
    // $ANTLR end ruleType


    // $ANTLR start entryRuleSimpleType
    // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:241:1: entryRuleSimpleType returns [EObject current=null] : iv_ruleSimpleType= ruleSimpleType EOF ;
    public final EObject entryRuleSimpleType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleType = null;


        try {
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:241:52: (iv_ruleSimpleType= ruleSimpleType EOF )
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:242:2: iv_ruleSimpleType= ruleSimpleType EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSimpleTypeRule(), currentNode); 
            pushFollow(FOLLOW_ruleSimpleType_in_entryRuleSimpleType409);
            iv_ruleSimpleType=ruleSimpleType();
            _fsp--;

             current =iv_ruleSimpleType; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpleType419); 

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
    // $ANTLR end entryRuleSimpleType


    // $ANTLR start ruleSimpleType
    // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:249:1: ruleSimpleType returns [EObject current=null] : ( 'type' ( (lv_name_1_0= RULE_ID ) ) ) ;
    public final EObject ruleSimpleType() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:254:6: ( ( 'type' ( (lv_name_1_0= RULE_ID ) ) ) )
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:255:1: ( 'type' ( (lv_name_1_0= RULE_ID ) ) )
            {
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:255:1: ( 'type' ( (lv_name_1_0= RULE_ID ) ) )
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:255:2: 'type' ( (lv_name_1_0= RULE_ID ) )
            {
            match(input,12,FOLLOW_12_in_ruleSimpleType453); 

                    createLeafNode(grammarAccess.getSimpleTypeAccess().getTypeKeyword_0(), null); 
                
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:259:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:260:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:260:1: (lv_name_1_0= RULE_ID )
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:261:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSimpleType470); 

            			createLeafNode(grammarAccess.getSimpleTypeAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSimpleTypeRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

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
    // $ANTLR end ruleSimpleType


    // $ANTLR start entryRuleEntity
    // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:290:1: entryRuleEntity returns [EObject current=null] : iv_ruleEntity= ruleEntity EOF ;
    public final EObject entryRuleEntity() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEntity = null;


        try {
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:290:48: (iv_ruleEntity= ruleEntity EOF )
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:291:2: iv_ruleEntity= ruleEntity EOF
            {
             currentNode = createCompositeNode(grammarAccess.getEntityRule(), currentNode); 
            pushFollow(FOLLOW_ruleEntity_in_entryRuleEntity508);
            iv_ruleEntity=ruleEntity();
            _fsp--;

             current =iv_ruleEntity; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEntity518); 

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
    // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:298:1: ruleEntity returns [EObject current=null] : ( 'entity' ( (lv_name_1_0= RULE_ID ) ) ( 'extends' ( ( RULE_ID ) ) )? '{' ( (lv_properties_5_0= ruleProperty ) )* '}' ) ;
    public final EObject ruleEntity() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        EObject lv_properties_5_0 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:303:6: ( ( 'entity' ( (lv_name_1_0= RULE_ID ) ) ( 'extends' ( ( RULE_ID ) ) )? '{' ( (lv_properties_5_0= ruleProperty ) )* '}' ) )
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:304:1: ( 'entity' ( (lv_name_1_0= RULE_ID ) ) ( 'extends' ( ( RULE_ID ) ) )? '{' ( (lv_properties_5_0= ruleProperty ) )* '}' )
            {
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:304:1: ( 'entity' ( (lv_name_1_0= RULE_ID ) ) ( 'extends' ( ( RULE_ID ) ) )? '{' ( (lv_properties_5_0= ruleProperty ) )* '}' )
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:304:2: 'entity' ( (lv_name_1_0= RULE_ID ) ) ( 'extends' ( ( RULE_ID ) ) )? '{' ( (lv_properties_5_0= ruleProperty ) )* '}'
            {
            match(input,13,FOLLOW_13_in_ruleEntity552); 

                    createLeafNode(grammarAccess.getEntityAccess().getEntityKeyword_0(), null); 
                
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:308:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:309:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:309:1: (lv_name_1_0= RULE_ID )
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:310:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEntity569); 

            			createLeafNode(grammarAccess.getEntityAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getEntityRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:332:2: ( 'extends' ( ( RULE_ID ) ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==14) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:332:3: 'extends' ( ( RULE_ID ) )
                    {
                    match(input,14,FOLLOW_14_in_ruleEntity584); 

                            createLeafNode(grammarAccess.getEntityAccess().getExtendsKeyword_2_0(), null); 
                        
                    // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:336:1: ( ( RULE_ID ) )
                    // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:337:1: ( RULE_ID )
                    {
                    // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:337:1: ( RULE_ID )
                    // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:338:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getEntityRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEntity602); 

                    		createLeafNode(grammarAccess.getEntityAccess().getExtendsEntityCrossReference_2_1_0(), "extends"); 
                    	

                    }


                    }


                    }
                    break;

            }

            match(input,15,FOLLOW_15_in_ruleEntity613); 

                    createLeafNode(grammarAccess.getEntityAccess().getLeftCurlyBracketKeyword_3(), null); 
                
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:354:1: ( (lv_properties_5_0= ruleProperty ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==17||LA5_0==20) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:355:1: (lv_properties_5_0= ruleProperty )
            	    {
            	    // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:355:1: (lv_properties_5_0= ruleProperty )
            	    // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:356:3: lv_properties_5_0= ruleProperty
            	    {
            	     
            	    	        currentNode=createCompositeNode(grammarAccess.getEntityAccess().getPropertiesPropertyParserRuleCall_4_0(), currentNode); 
            	    	    
            	    pushFollow(FOLLOW_ruleProperty_in_ruleEntity634);
            	    lv_properties_5_0=ruleProperty();
            	    _fsp--;


            	    	        if (current==null) {
            	    	            current = factory.create(grammarAccess.getEntityRule().getType().getClassifier());
            	    	            associateNodeWithAstElement(currentNode.getParent(), current);
            	    	        }
            	    	        try {
            	    	       		add(
            	    	       			current, 
            	    	       			"properties",
            	    	        		lv_properties_5_0, 
            	    	        		"Property", 
            	    	        		currentNode);
            	    	        } catch (ValueConverterException vce) {
            	    				handleValueConverterException(vce);
            	    	        }
            	    	        currentNode = currentNode.getParent();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            match(input,16,FOLLOW_16_in_ruleEntity644); 

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
    // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:389:1: entryRuleProperty returns [EObject current=null] : iv_ruleProperty= ruleProperty EOF ;
    public final EObject entryRuleProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProperty = null;


        try {
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:389:50: (iv_ruleProperty= ruleProperty EOF )
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:390:2: iv_ruleProperty= ruleProperty EOF
            {
             currentNode = createCompositeNode(grammarAccess.getPropertyRule(), currentNode); 
            pushFollow(FOLLOW_ruleProperty_in_entryRuleProperty677);
            iv_ruleProperty=ruleProperty();
            _fsp--;

             current =iv_ruleProperty; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleProperty687); 

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
    // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:397:1: ruleProperty returns [EObject current=null] : (this_SimpleProperty_0= ruleSimpleProperty | this_Reference_1= ruleReference ) ;
    public final EObject ruleProperty() throws RecognitionException {
        EObject current = null;

        EObject this_SimpleProperty_0 = null;

        EObject this_Reference_1 = null;


         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:402:6: ( (this_SimpleProperty_0= ruleSimpleProperty | this_Reference_1= ruleReference ) )
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:403:1: (this_SimpleProperty_0= ruleSimpleProperty | this_Reference_1= ruleReference )
            {
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:403:1: (this_SimpleProperty_0= ruleSimpleProperty | this_Reference_1= ruleReference )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==17) ) {
                alt6=1;
            }
            else if ( (LA6_0==20) ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("403:1: (this_SimpleProperty_0= ruleSimpleProperty | this_Reference_1= ruleReference )", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:404:5: this_SimpleProperty_0= ruleSimpleProperty
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPropertyAccess().getSimplePropertyParserRuleCall_0(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleSimpleProperty_in_ruleProperty734);
                    this_SimpleProperty_0=ruleSimpleProperty();
                    _fsp--;

                     
                            current = this_SimpleProperty_0; 
                            currentNode = currentNode.getParent();
                        

                    }
                    break;
                case 2 :
                    // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:414:5: this_Reference_1= ruleReference
                    {
                     
                            currentNode=createCompositeNode(grammarAccess.getPropertyAccess().getReferenceParserRuleCall_1(), currentNode); 
                        
                    pushFollow(FOLLOW_ruleReference_in_ruleProperty761);
                    this_Reference_1=ruleReference();
                    _fsp--;

                     
                            current = this_Reference_1; 
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
    // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:429:1: entryRuleSimpleProperty returns [EObject current=null] : iv_ruleSimpleProperty= ruleSimpleProperty EOF ;
    public final EObject entryRuleSimpleProperty() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSimpleProperty = null;


        try {
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:429:56: (iv_ruleSimpleProperty= ruleSimpleProperty EOF )
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:430:2: iv_ruleSimpleProperty= ruleSimpleProperty EOF
            {
             currentNode = createCompositeNode(grammarAccess.getSimplePropertyRule(), currentNode); 
            pushFollow(FOLLOW_ruleSimpleProperty_in_entryRuleSimpleProperty793);
            iv_ruleSimpleProperty=ruleSimpleProperty();
            _fsp--;

             current =iv_ruleSimpleProperty; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSimpleProperty803); 

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
    // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:437:1: ruleSimpleProperty returns [EObject current=null] : ( 'property' ( (lv_name_1_0= RULE_ID ) ) ( ':' ( ( RULE_ID ) ) ( (lv_many_4_0= '[]' ) )? )? ) ;
    public final EObject ruleSimpleProperty() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token lv_many_4_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:442:6: ( ( 'property' ( (lv_name_1_0= RULE_ID ) ) ( ':' ( ( RULE_ID ) ) ( (lv_many_4_0= '[]' ) )? )? ) )
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:443:1: ( 'property' ( (lv_name_1_0= RULE_ID ) ) ( ':' ( ( RULE_ID ) ) ( (lv_many_4_0= '[]' ) )? )? )
            {
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:443:1: ( 'property' ( (lv_name_1_0= RULE_ID ) ) ( ':' ( ( RULE_ID ) ) ( (lv_many_4_0= '[]' ) )? )? )
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:443:2: 'property' ( (lv_name_1_0= RULE_ID ) ) ( ':' ( ( RULE_ID ) ) ( (lv_many_4_0= '[]' ) )? )?
            {
            match(input,17,FOLLOW_17_in_ruleSimpleProperty837); 

                    createLeafNode(grammarAccess.getSimplePropertyAccess().getPropertyKeyword_0(), null); 
                
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:447:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:448:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:448:1: (lv_name_1_0= RULE_ID )
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:449:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSimpleProperty854); 

            			createLeafNode(grammarAccess.getSimplePropertyAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getSimplePropertyRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:471:2: ( ':' ( ( RULE_ID ) ) ( (lv_many_4_0= '[]' ) )? )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==18) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:471:3: ':' ( ( RULE_ID ) ) ( (lv_many_4_0= '[]' ) )?
                    {
                    match(input,18,FOLLOW_18_in_ruleSimpleProperty869); 

                            createLeafNode(grammarAccess.getSimplePropertyAccess().getColonKeyword_2_0(), null); 
                        
                    // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:475:1: ( ( RULE_ID ) )
                    // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:476:1: ( RULE_ID )
                    {
                    // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:476:1: ( RULE_ID )
                    // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:477:3: RULE_ID
                    {

                    			if (current==null) {
                    	            current = factory.create(grammarAccess.getSimplePropertyRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                            
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleSimpleProperty887); 

                    		createLeafNode(grammarAccess.getSimplePropertyAccess().getTypeSimpleTypeCrossReference_2_1_0(), "type"); 
                    	

                    }


                    }

                    // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:489:2: ( (lv_many_4_0= '[]' ) )?
                    int alt7=2;
                    int LA7_0 = input.LA(1);

                    if ( (LA7_0==19) ) {
                        alt7=1;
                    }
                    switch (alt7) {
                        case 1 :
                            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:490:1: (lv_many_4_0= '[]' )
                            {
                            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:490:1: (lv_many_4_0= '[]' )
                            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:491:3: lv_many_4_0= '[]'
                            {
                            lv_many_4_0=(Token)input.LT(1);
                            match(input,19,FOLLOW_19_in_ruleSimpleProperty904); 

                                    createLeafNode(grammarAccess.getSimplePropertyAccess().getManyLeftSquareBracketRightSquareBracketKeyword_2_2_0(), "many"); 
                                

                            	        if (current==null) {
                            	            current = factory.create(grammarAccess.getSimplePropertyRule().getType().getClassifier());
                            	            associateNodeWithAstElement(currentNode, current);
                            	        }
                            	        
                            	        try {
                            	       		set(current, "many", true, "[]", lastConsumedNode);
                            	        } catch (ValueConverterException vce) {
                            				handleValueConverterException(vce);
                            	        }
                            	    

                            }


                            }
                            break;

                    }


                    }
                    break;

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


    // $ANTLR start entryRuleReference
    // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:517:1: entryRuleReference returns [EObject current=null] : iv_ruleReference= ruleReference EOF ;
    public final EObject entryRuleReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReference = null;


        try {
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:517:51: (iv_ruleReference= ruleReference EOF )
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:518:2: iv_ruleReference= ruleReference EOF
            {
             currentNode = createCompositeNode(grammarAccess.getReferenceRule(), currentNode); 
            pushFollow(FOLLOW_ruleReference_in_entryRuleReference953);
            iv_ruleReference=ruleReference();
            _fsp--;

             current =iv_ruleReference; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleReference963); 

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
    // $ANTLR end entryRuleReference


    // $ANTLR start ruleReference
    // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:525:1: ruleReference returns [EObject current=null] : ( 'reference' ( (lv_name_1_0= RULE_ID ) ) ':' ( ( RULE_ID ) ) ( (lv_many_4_0= '[]' ) )? ) ;
    public final EObject ruleReference() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token lv_many_4_0=null;

         @SuppressWarnings("unused") EObject temp=null; setCurrentLookahead(); resetLookahead(); 
            
        try {
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:530:6: ( ( 'reference' ( (lv_name_1_0= RULE_ID ) ) ':' ( ( RULE_ID ) ) ( (lv_many_4_0= '[]' ) )? ) )
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:531:1: ( 'reference' ( (lv_name_1_0= RULE_ID ) ) ':' ( ( RULE_ID ) ) ( (lv_many_4_0= '[]' ) )? )
            {
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:531:1: ( 'reference' ( (lv_name_1_0= RULE_ID ) ) ':' ( ( RULE_ID ) ) ( (lv_many_4_0= '[]' ) )? )
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:531:2: 'reference' ( (lv_name_1_0= RULE_ID ) ) ':' ( ( RULE_ID ) ) ( (lv_many_4_0= '[]' ) )?
            {
            match(input,20,FOLLOW_20_in_ruleReference997); 

                    createLeafNode(grammarAccess.getReferenceAccess().getReferenceKeyword_0(), null); 
                
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:535:1: ( (lv_name_1_0= RULE_ID ) )
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:536:1: (lv_name_1_0= RULE_ID )
            {
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:536:1: (lv_name_1_0= RULE_ID )
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:537:3: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)input.LT(1);
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReference1014); 

            			createLeafNode(grammarAccess.getReferenceAccess().getNameIDTerminalRuleCall_1_0(), "name"); 
            		

            	        if (current==null) {
            	            current = factory.create(grammarAccess.getReferenceRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
            	        try {
            	       		set(
            	       			current, 
            	       			"name",
            	        		lv_name_1_0, 
            	        		"ID", 
            	        		lastConsumedNode);
            	        } catch (ValueConverterException vce) {
            				handleValueConverterException(vce);
            	        }
            	    

            }


            }

            match(input,18,FOLLOW_18_in_ruleReference1028); 

                    createLeafNode(grammarAccess.getReferenceAccess().getColonKeyword_2(), null); 
                
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:563:1: ( ( RULE_ID ) )
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:564:1: ( RULE_ID )
            {
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:564:1: ( RULE_ID )
            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:565:3: RULE_ID
            {

            			if (current==null) {
            	            current = factory.create(grammarAccess.getReferenceRule().getType().getClassifier());
            	            associateNodeWithAstElement(currentNode, current);
            	        }
                    
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleReference1046); 

            		createLeafNode(grammarAccess.getReferenceAccess().getTypeEntityCrossReference_3_0(), "type"); 
            	

            }


            }

            // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:577:2: ( (lv_many_4_0= '[]' ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==19) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:578:1: (lv_many_4_0= '[]' )
                    {
                    // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:578:1: (lv_many_4_0= '[]' )
                    // ../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g:579:3: lv_many_4_0= '[]'
                    {
                    lv_many_4_0=(Token)input.LT(1);
                    match(input,19,FOLLOW_19_in_ruleReference1063); 

                            createLeafNode(grammarAccess.getReferenceAccess().getManyLeftSquareBracketRightSquareBracketKeyword_4_0(), "many"); 
                        

                    	        if (current==null) {
                    	            current = factory.create(grammarAccess.getReferenceRule().getType().getClassifier());
                    	            associateNodeWithAstElement(currentNode, current);
                    	        }
                    	        
                    	        try {
                    	       		set(current, "many", true, "[]", lastConsumedNode);
                    	        } catch (ValueConverterException vce) {
                    				handleValueConverterException(vce);
                    	        }
                    	    

                    }


                    }
                    break;

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
    // $ANTLR end ruleReference


 

    public static final BitSet FOLLOW_ruleModel_in_entryRuleModel73 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModel83 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleImport_in_ruleModel138 = new BitSet(new long[]{0x0000000000003802L});
    public static final BitSet FOLLOW_ruleType_in_ruleModel160 = new BitSet(new long[]{0x0000000000003002L});
    public static final BitSet FOLLOW_ruleImport_in_entryRuleImport194 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleImport204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleImport238 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleImport255 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleType_in_entryRuleType293 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleType303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleType_in_ruleType350 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntity_in_ruleType377 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleType_in_entryRuleSimpleType409 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpleType419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleSimpleType453 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleType470 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEntity_in_entryRuleEntity508 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEntity518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleEntity552 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEntity569 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_14_in_ruleEntity584 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEntity602 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleEntity613 = new BitSet(new long[]{0x0000000000130000L});
    public static final BitSet FOLLOW_ruleProperty_in_ruleEntity634 = new BitSet(new long[]{0x0000000000130000L});
    public static final BitSet FOLLOW_16_in_ruleEntity644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleProperty_in_entryRuleProperty677 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleProperty687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleProperty_in_ruleProperty734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReference_in_ruleProperty761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSimpleProperty_in_entryRuleSimpleProperty793 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSimpleProperty803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleSimpleProperty837 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleProperty854 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleSimpleProperty869 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleSimpleProperty887 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleSimpleProperty904 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleReference_in_entryRuleReference953 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleReference963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleReference997 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReference1014 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleReference1028 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleReference1046 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleReference1063 = new BitSet(new long[]{0x0000000000000002L});

}