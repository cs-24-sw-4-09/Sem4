grammar MusicLanguage;

program : statement*;

statement : noteStatement
          | chordStatement
          | tempoStatement
          | durationStatement
          // other statements...

noteStatement : 'note' note=NOTE octave=INT;

chordStatement : 'chord' '[' noteList ']' octave=INT;

tempoStatement : 'tempo' tempo=INT;

durationStatement : 'duration' duration=INT;

noteList : note (',' note)*;

note : 'A' | 'B' | 'C' | 'D' | 'E' | 'F' | 'G';

NOTE : [A-G];

INT : [0-9]+;

WS : [ \t\r\n]+ -> skip;