grammar MusicLanguage;

program : statement* EOF;

statement : noteStatement
          | pauseStatement
          | chordStatement
          | bpmStatement
          | timeSignatureStatement
          | sampleStatement
          | playStatement;
          //noteInSampleStatement
          //combinationStatement;
          // combinationStatement;
          // other statements...

noteStatement :  'note' octave=NOTE ';';
//noteInSampleStatement : octave=NOTE;

pauseStatement : 'pause' duration=INT ';';

chordStatement : 'chord' '[' noteList ']' octave=INT';';

bpmStatement : 'bpm' '(' bpm=INT ')'';';

timeSignatureStatement : 'time' '(' time=INT '/' time=INT ')'';';

//durationStatement : 'duration' duration=INT;

sampleStatement : 'sample' sample=STRING '(' instrument ')' '{' statement* '}'';';

playStatement : 'play' '{' sampleStatement* '}' ';';

//combinationStatement : 'combination' combination=STRING '{' sampleList '}' ';';

//sampleList : sample=STRING ('&' sample=STRING)*;

instrument : 'Piano' | 'Guitar' | 'Bass' | 'Drums';

noteList : note (',' note)*;

note : 'A' | 'A#' | 'B' | 'C' | 'C#' | 'D' | 'D#' | 'E' | 'F' | 'F#' | 'G' | 'G#';

INSTRUMENT : 'instrument';

NOTE : [0-9][A-G][0-9]?;

INT : [0-9]+;

STRING : [a-zA-Z0-9_]+;

INDENT : [ \t]+ -> skip;

DEDENT : [ \n]+ -> skip;

WS : [ \t\r\n]+ -> skip;

