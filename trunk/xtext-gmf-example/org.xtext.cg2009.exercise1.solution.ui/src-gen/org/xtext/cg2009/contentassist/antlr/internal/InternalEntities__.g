lexer grammar InternalEntities;
@header {
package org.xtext.cg2009.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.internal.Lexer;
}

T11 : 'String' ;
T12 : 'Number' ;
T13 : 'Bool' ;
T14 : 'one' ;
T15 : 'entity' ;
T16 : '{' ;
T17 : '}' ;
T18 : 'extends' ;
T19 : 'property' ;
T20 : ':' ;
T21 : 'refs' ;
T22 : 'many' ;

// $ANTLR src "../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g" 796
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g" 798
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g" 800
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g" 802
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g" 804
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g" 806
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.xtext.cg2009.exercise1.solution.ui/src-gen/org/xtext/cg2009/contentassist/antlr/internal/InternalEntities.g" 808
RULE_ANY_OTHER : .;


