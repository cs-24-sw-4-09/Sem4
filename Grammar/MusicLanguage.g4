grammar MusicLanguage;

program : statement* EOF;

statement : noteStatement
          | chordStatement
          | durationStatement
          | bpmStatement
          | timeSignatureStatement;
          // other statements...

noteStatement : 'note' note octave=INT ';';

chordStatement : 'chord' '[' noteList ']' octave=INT';';

bpmStatement : 'bpm' '(' bpm=INT ')'';';

timeSignatureStatement : 'time' '(' time=INT '/' time=INT ')'';';

durationStatement : 'duration' duration=INT;

noteList : note (',' note)*;

note : 'A' | 'B' | 'C' | 'D' | 'E' | 'F' | 'G';

NOTE : [A-G];

INT : [0-9]+;

WS : [ \t\r\n]+ -> skip;