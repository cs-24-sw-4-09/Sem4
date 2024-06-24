grammar MusicLanguage;
INSTRUMENT : 'Piano' | 'Glockenspiel' | 'Organ' | 'Guitar' | 'Violin' | 'Harp' | 'Trumpet' | 'Saxophone' | 'Flute' | 'Recorder' | 'Synth' | 'Bagpipe';

NOTE : [0-9]?[A-G][#]?[0-9]?;
PAUSE : [0-9]+'-';
CHORD : '[' NOTE (',' NOTE)* ']';
INT : [0-9]+;
BOOL : 'true' | 'false';
STRING : [a-zA-Z0-9_]+;
INDENT : [ \t]+ -> skip;
DEDENT : [ \n]+ -> skip;
WS : [ \t\r\n]+ -> skip;
ENDLINE : [;];

program : statement* EOF;


statement : bpmStatement
          | sampleStatement
          | playStatement
          | letStatement
          | ifStatement
          | whileStatement
          | repeatStatement
          | expressionStatement
          | assignmentStatement
          | soundStatement
          | sampleCallStatement
          ;

bpmStatement : 'bpm' '(' INT ')'ENDLINE;
    
sampleStatement : 'sample' STRING '(' INSTRUMENT ')' '{' statement* '}'ENDLINE;

playStatement : 'play' '{' statement* '}' ENDLINE;

repeatStatement : 'repeat' '(' INT ')' '{' statement* '}'ENDLINE;

letStatement : 'let' variable=STRING '=' value=expression ENDLINE;

ifStatement : 'if' '(' expression ')' '{' statement* '}' elseStatement?ENDLINE;

elseStatement : 'else' '{' statement* '}';

whileStatement : 'while' '(' expression ')' '{' statement* '}'ENDLINE;

assignmentStatement : variable=STRING '=' value=expression ENDLINE;

expressionStatement : expression ENDLINE;

soundStatement : 'sound' '(' variable=STRING ')'ENDLINE;

sampleCallStatement : (STRING'()')* ENDLINE;



expression: logical_or_expr;

logical_or_expr
    : logical_or_expr '||' logical_and_expr
    | logical_and_expr
    ;

logical_and_expr
    : logical_and_expr '&&' comparison_expr
    | comparison_expr
    ;

comparison_expr
    : comparison_expr ('==' | '!=' | '<' | '<=' | '>=' | '>') add_sub_expr
    | add_sub_expr
    ;

add_sub_expr
    : add_sub_expr ('+' | '-') mult_div_expr
    | mult_div_expr
    ;

mult_div_expr
    : mult_div_expr ('*' | '/') unary_expr
    | unary_expr
    ;

unary_expr
    : '!' primary_expr
    | primary_expr
    ;

primary_expr
    : '(' expression ')'
    | CHORD
    | NOTE
    | PAUSE
    | BOOL
    | STRING
    | INT
    ;
