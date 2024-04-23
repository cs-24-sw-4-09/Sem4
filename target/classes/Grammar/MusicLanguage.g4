grammar MusicLanguage;
INSTRUMENT : 'Piano' | 'Guitar' | 'Bass' | 'Drums';
//No octave means standard octave = 4
//No duration means standard duration = 4
NOTE : [0-9]?[A-G][0-9]?;
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

//note, pause and chrod statements changed to be variable changes.
statement //: noteStatement
          //| pauseStatement    
          //| chordStatement
          : bpmStatement
          | sampleStatement
          | playStatement
          | letStatement
          | ifStatement
          | whileStatement
          | repeatStatement
          | expression
          | expressionStatement
          ;

// noteStatement :  'note' octave=NOTE ';';

// pauseStatement : 'pause' duration=INT ';';

// chordStatement : 'chord' '[' NOTE* ']' octave=INT';';

bpmStatement : 'bpm' '(' INT ')'ENDLINE;
    
sampleStatement : 'sample' STRING '(' INSTRUMENT ')' '{' statement* '}'ENDLINE;

playStatement : 'play' '{' statement* '}' ENDLINE;

repeatStatement : 'repeat' '(' INT ')' '{' statement* '}'ENDLINE;

letStatement : 'let' expression ENDLINE;

ifStatement : 'if' '(' expression ')' '{' statement* '}' ('else' '{' statement* '}')?ENDLINE;

whileStatement : 'while' '(' expression ')' '{' statement* '}'ENDLINE;

expressionStatement : expression ENDLINE;

expression : STRING '()' ('&' STRING'()')*                                          #SampleCall
           | STRING '=' expression                                                  #Assignment
           | expression op=( '+' | '-' | '*' | '/' ) expression                     #ArithmeticOperation
           | expression op=( '==' | '!=' | '<' | '<=' | '>=' | '>' ) expression     #Comparison
           | expression op=( '&&' | '||' ) expression                               #LogicalOperation
           | '!' expression                                                         #notOperation 
           | '(' expression ')'                                                     #Parenthesis
           | CHORD                                                                  #Chord
           | NOTE                                                                   #Note
           | PAUSE                                                                  #Pause
           | BOOL                                                                   #Boolean
           | STRING                                                                 #String
           | INT                                                                    #Number
           ;