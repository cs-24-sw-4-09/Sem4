package Testing.UnitTesting;

import org.junit.Test;
import static org.junit.Assert.*;
import Interpreter.*;
import Grammar.*;
import Models.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


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
        int midiValue = midiInterpreter.noteToMidi("C4");
        assertEquals(60, midiValue);
    }

    // @Test
    // public void testInterpretNoteStatement() {
    //     MidiInterpreter midiInterpreter = new MidiInterpreter();
    //     NoteStatement noteStatement = new NoteStatement("3C4");
    //     midiInterpreter.interpretAST(noteStatement);
    //     String result = midiInterpreter.getInterpretationResult();
    //     System.out.println(result);
    //     assertTrue(result.contains("Played note: 3C4"));
    // }

    @Test
    public void testInterpretNoteStatement() {
        MidiInterpreter interpreter = new MidiInterpreter();
        NoteStatement noteStatement = new NoteStatement("3C4");

        // Redirect System.out to a PrintStream to capture the output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        interpreter.interpretAST(noteStatement);

        // Check that the correct note was played
        String expectedOutput = "Played note: 3C4\n";
        assertEquals(expectedOutput, outContent.toString());

        // Reset System.out to its original state
        System.setOut(System.out);
    }


}