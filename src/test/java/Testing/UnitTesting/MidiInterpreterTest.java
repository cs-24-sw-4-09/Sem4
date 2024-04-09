package Testing.UnitTesting;

import org.junit.Test;
import static org.junit.Assert.*;
import Interpreter.*;
import Grammar.*;
import Models.*;


public class MidiInterpreterTest {

    @Test
    public void testGetInstrument() {
        MidiInterpreter midiInterpreter = new MidiInterpreter();
        int instrumentCode = midiInterpreter.getInstrument("PIANO");
        assertEquals(0, instrumentCode);
    }

    @Test
    public void testNoteToMidi() {
        MidiInterpreter midiInterpreter = new MidiInterpreter();
        int midiValue = midiInterpreter.noteToMidi("3C4");
        assertEquals(60, midiValue);
    }

    @Test
    public void testInterpretNoteStatement() {
        MidiInterpreter midiInterpreter = new MidiInterpreter();
        NoteStatement noteStatement = new NoteStatement("3C4");
        midiInterpreter.interpretAST(noteStatement);
        String result = midiInterpreter.getInterpretationResult();
        assertTrue(result.contains("Played note: 3C4"));
    }


}