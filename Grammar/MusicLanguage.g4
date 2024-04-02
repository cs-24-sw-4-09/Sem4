grammar MusicLanguage;

program : statement* EOF;

statement : noteStatement
          | chordStatement
          | durationStatement
          | bpmStatement
          | timeSignatureStatement
          | sampleStatement
          | playStatement;
          // combinationStatement;
          // other statements...

noteStatement : 'note' octave=NOTE ';';

chordStatement : 'chord' '[' noteList ']' octave=INT';';

bpmStatement : 'bpm' '(' bpm=INT ')'';';

timeSignatureStatement : 'time' '(' time=INT '/' time=INT ')'';';

durationStatement : 'duration' duration=INT;

sampleStatement : 'sample' sample=STRING '(' instrument ')' '{' statement* '}'';';

playStatement : 'play' sample=STRING '{'  '}';

// TODO
//combinationStatement : 'combination' combination=STRING '{' sample1=STRING '&' sample2=STRING '}';

instrument : 'Piano' | 'Guitar' | 'Bass' | 'Drums';

noteList : note (',' note)*;

note : 'A' | 'B' | 'C' | 'D' | 'E' | 'F' | 'G';

INSTRUMENT : 'instrument';

NOTE : [A-G][0-9]?;

INT : [0-9]+;

STRING : [a-zA-Z0-9_]+;

INDENT : [ \t]+ -> skip;

DEDENT : [ \n]+ -> skip;

WS : [ \t\r\n]+ -> skip;