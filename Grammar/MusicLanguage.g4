grammar MusicLanguage;

program : statement* EOF;

statement : noteStatement
          | chordStatement
          | durationStatement
          | bpmStatement
          | timeSignatureStatement
          | sampleStatement;
          // other statements...

noteStatement : 'note' note octave=INT ';';

chordStatement : 'chord' '[' noteList ']' octave=INT';';

bpmStatement : 'bpm' '(' bpm=INT ')'';';

timeSignatureStatement : 'time' '(' time=INT '/' time=INT ')'';';

durationStatement : 'duration' duration=INT;

sampleStatement : 'sample' sample=STRING '(' instrument ')' '{' statement* '}';

instrument : 'Piano' | 'Guitar' | 'Bass' | 'Drums';

noteList : note (',' note)*;

note : 'A' | 'B' | 'C' | 'D' | 'E' | 'F' | 'G';

NOTE : [A-G];

INT : [0-9]+;

STRING : [a-zA-Z0-9_]+;

WS : [ \t\r\n]+ -> skip;