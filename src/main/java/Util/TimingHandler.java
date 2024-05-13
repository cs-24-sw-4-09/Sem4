package Util;

import javax.sound.midi.*;
import java.util.Dictionary;
import java.util.Hashtable;

public class TimingHandler { // Name is up for debate, pls
  private final Sequencer sequencer = MidiSystem.getSequencer();
  private final Sequence sequence;
  private final Dictionary<String, Track> tracks = new Hashtable<>();
  private final Dictionary<String, Long> pauses = new Hashtable<>();

  public TimingHandler(int signature, int bpm) throws InvalidMidiDataException, MidiUnavailableException {
    this.sequencer.setTempoInBPM(bpm);
    this.sequence = new Sequence(Sequence.PPQ, signature);
  }

  public void addPause(long duration, String trackName) {
    if (pauses.get(trackName) == null) {
      pauses.put(trackName, duration);
    } else {
      pauses.put(trackName, pauses.get(trackName) + duration);
    }
  }

  public void addNote(Note note, String trackName, int channel) {
    long eventDelay;

    if (pauses.get(trackName) == null) {
        eventDelay = 0;
    } else {
        eventDelay = pauses.get(trackName);
        System.out.println("Added pause: " + eventDelay);
    }

    try {
        Track track = tracks.get(trackName);
        track.add(note.getStartEvent(track.ticks() + eventDelay, channel));
        track.add(note.getEndEvent());
    } catch (Exception e) {
        System.out.println("Created Track: " + trackName);
        tracks.put(trackName, sequence.createTrack());
        Track track = tracks.get(trackName);
        track.add(note.getStartEvent(0 + eventDelay, channel));
        track.add(note.getEndEvent());
    } finally {
        if (eventDelay != 0) {
            pauses.put(trackName, 0L);
        }
    }
}

public void playChord(Note[] notes, String trackName) {
  for (int i = 0; i < notes.length; i++) {
      addNote(notes[i], trackName+i, i % 16);
      System.out.println("Added note: " + notes[i] + " to track: " + trackName+ " on channel: " + (i % 16));
  }
}

  public void addNote(Note[] notes, String trackName) { // USED EXCLUSIVELY FOR RICKROLL; DO NOT ASK ABOUT IT
    for (Note note : notes) {
      try {
        Track track = tracks.get(trackName);
        track.add(note.getStartEvent(track.ticks(), tracks.size() - 1));
        track.add(note.getEndEvent());
      } catch (Exception e) {
        tracks.put(trackName, sequence.createTrack());
        Track track = tracks.get(trackName);
        track.add(note.getStartEvent(0, tracks.size() - 1));
        track.add(note.getEndEvent());
      }
    }
  }

  public void play() throws InterruptedException, InvalidMidiDataException, MidiUnavailableException {
    sequencer.open();
    try {
    Thread.sleep(100);
    } catch (InterruptedException e) {
      throw new InterruptedException("Thread was interrupted while sleeping.");
    }
    // Set the sequence in the sequencer and start playback
    sequencer.setSequence(sequence);
    sequencer.start();

    // Wait for the sequence to finish playing
    while (sequencer.isRunning()) {
      Thread.sleep(90);
    }

    // Close the sequencer
    sequencer.close();
  }

}