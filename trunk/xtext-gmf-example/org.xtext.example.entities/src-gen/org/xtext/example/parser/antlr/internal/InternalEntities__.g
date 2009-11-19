lexer grammar InternalEntities;
@header {
package org.xtext.example.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

T11 : 'import' ;
T12 : 'type' ;
T13 : 'entity' ;
T14 : 'extends' ;
T15 : '{' ;
T16 : '}' ;
T17 : 'property' ;
T18 : ':' ;
T19 : '[]' ;
T20 : 'reference' ;

// $ANTLR src "../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g" 604
RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

// $ANTLR src "../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g" 606
RULE_INT : ('0'..'9')+;

// $ANTLR src "../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g" 608
RULE_STRING : ('"' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'"')))* '"'|'\'' ('\\' ('b'|'t'|'n'|'f'|'r'|'"'|'\''|'\\')|~(('\\'|'\'')))* '\'');

// $ANTLR src "../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g" 610
RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

// $ANTLR src "../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g" 612
RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

// $ANTLR src "../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g" 614
RULE_WS : (' '|'\t'|'\r'|'\n')+;

// $ANTLR src "../org.xtext.example.entities/src-gen/org/xtext/example/parser/antlr/internal/InternalEntities.g" 616
RULE_ANY_OTHER : .;


