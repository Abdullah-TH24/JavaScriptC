grammar JavaScript;

// ---------- PARSER RULES ----------
program: stmt* EOF;

stmt:
	variableDecl
	| functionDecl
	| ifStatement
	| forStatement
	| whileStatement
	| returnStatement
	| expressionStatement
	| block;

block: '{' stmt* '}';

variableDecl: ('let' | 'const' | 'var') Identifier (
		'=' expression
	)? ';';

functionDecl:
	'function' Identifier '(' parameterList? ')' block;

parameterList: Identifier (',' Identifier)*;

ifStatement: 'if' '(' expression ')' stmt ('else' stmt)?;

forStatement:
	'for' '(' (variableDecl | expressionStatement | ';') expression? ';' expression? ';' ')' stmt;

whileStatement: 'while' '(' expression ')' stmt;

returnStatement: 'return' expression? ';';

expressionStatement: expression ';';

// ---------- EXPRESSIONS ----------
expression: assignmentExpression;

assignmentExpression:
	leftHandSide '=' assignmentExpression
	| logicalOrExpression;

leftHandSide:
	Identifier (('.' Identifier) | ('[' expression ']'))*;

logicalOrExpression:
	logicalAndExpression ('||' logicalAndExpression)*;

logicalAndExpression:
	equalityExpression ('&&' equalityExpression)*;

equalityExpression:
	relationalExpression (
		('==' | '!=' | '===') relationalExpression
	)*;

relationalExpression:
	additiveExpression (
		('>' | '<' | '>=' | '<=') additiveExpression
	)*;

additiveExpression:
	multiplicativeExpression (
		('+' | '-') multiplicativeExpression
	)*;

multiplicativeExpression:
	unaryExpression (('*' | '/' | '%') unaryExpression)*;

unaryExpression: ('!' | '-' | '+') unaryExpression
	| primaryExpression;

primaryExpression:
	'(' expression ')'
	| literal
	| leftHandSide
	| functionCall
	| objectLiteral
	| arrayLiteral;

functionCall: leftHandSide '(' argumentList? ')';

argumentList: expression (',' expression)*;

objectLiteral: '{' (property (',' property)*)? '}';

property: Identifier ':' expression;

arrayLiteral: '[' (expression (',' expression)*)? ']';

// ---------- LITERALS ----------
literal:
	BooleanLiteral
	| StringLiteral
	| NumberLiteral
	| 'null';

// ---------- LEXER RULES ----------
BooleanLiteral: 'true' | 'false';
StringLiteral: '"' (~["\\\r\n])* '"' | '\'' (~['\\\r\n])* '\'';
NumberLiteral: [0-9]+ ('.' [0-9]+)?;
Identifier: [a-zA-Z_$][a-zA-Z0-9_$]*;

WS: [ \t\r\n]+ -> skip;
LINE_COMMENT: '//' ~[\r\n]* -> skip;
BLOCK_COMMENT: '/*' .*? '*/' -> skip;