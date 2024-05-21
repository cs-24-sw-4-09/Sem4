grammar MusicLanguage;
INSTRUMENT : 'Piano' | 'Guitar' | 'Bass' | 'Drums';
//No octave means standard octave = 4
//No duration means standard duration = 4
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
          | expressionStatement
          | assignmentStatement
          | soundStatement
          | sampleCallStatement
          ;

// noteStatement :  'note' octave=NOTE ';';

// pauseStatement : 'pause' duration=INT ';';

// chordStatement : 'chord' '[' NOTE* ']' octave=INT';';

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



expression : '(' expression ')'                                                     #Parenthesis
           | '!' expression                                                         #notOperation 
           | expression op=('*' | '/') expression                                   #MultDivOperation
           | expression op=('+' | '-' ) expression                                  #AddSubOperation
           | expression op=( '==' | '!=' | '<' | '<=' | '>=' | '>' ) expression     #Comparison
           | expression op=( '&&' | '||' ) expression                               #LogicalOperation
           | CHORD                                                                  #Chord
           | NOTE                                                                   #Note
           | PAUSE                                                                  #Pause
           | BOOL                                                                   #Boolean
           | STRING                                                                 #String
           | INT                                                                    #Number
           ;