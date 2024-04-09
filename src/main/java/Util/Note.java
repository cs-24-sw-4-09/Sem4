package Util;

import javax.sound.midi.InvalidMidiDataException;
import javax.sound.midi.MidiEvent;
import javax.sound.midi.ShortMessage;

public class Note {

    private final int velocity, tone;
    private final long length;
    private MidiEvent startEvent;

    public Note(int velocity, int tone, long length) {
        this.velocity = velocity;
        this.tone = tone;
        this.length = length;
    }

    public MidiEvent getStartEvent(long currTick, int channel) {
        ShortMessage message = new ShortMessage();

        try {
            message.setMessage(ShortMessage.NOTE_ON, channel, this.tone, this.velocity);
        } catch (InvalidMidiDataException e) {
            throw new RuntimeException("Shit hit the fan.");
        }
        this.startEvent = new MidiEvent(message, currTick);
        return this.startEvent;
    }

    public MidiEvent getEndEvent() {
        int channel = this.startEvent.getMessage().getMessage()[0] & 0b00001111; // AND-Bitmask
        long endTick = this.startEvent.getTick() + this.length;

        ShortMessage message = new ShortMessage();

        try {
            message.setMessage(ShortMessage.NOTE_OFF, channel, this.tone, 0);
        } catch (InvalidMidiDataException e) {
            throw new RuntimeException("Shit hit the fan.");
        }
        this.startEvent = new MidiEvent(message, endTick);
        return this.startEvent;
    }
}