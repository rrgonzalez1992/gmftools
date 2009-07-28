lexer grammar InternalEntities;
@header {
package org.xtext.cg2009.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : 'entity' ;
T12 : 'extends' ;
T13 : '{' ;
T14 : '}' ;
T15 : 'property' ;
T16 : ':' ;
T17 : 'String' ;
T18 : 'Number' ;
T19 : 'Bool' ;
T20 : 'refs' ;
T21 : 'one' ;
T22 : 'many' ;

// $ANTLR src "../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g" 428
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g" 430
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g" 432
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g" 434
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g" 436
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g" 438
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.xtext.cg2009.exercise1.solution/src-gen/org/xtext/cg2009/parser/antlr/internal/InternalEntities.g" 440
RULE_ANY_OTHER : .;


