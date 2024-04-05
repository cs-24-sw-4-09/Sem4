package Util;

import javax.sound.midi.*;
import java.util.Dictionary;
import java.util.Hashtable;

public class TimingHandler { // Name is up for debate, pls
  private final Sequencer sequencer = MidiSystem.getSequencer();
  private final Sequence sequence;
  private final Dictionary<String, Track> tracks = new Hashtable<>();

  public TimingHandler(int signature, int bpm) throws InvalidMidiDataException, MidiUnavailableException {
    this.sequencer.setTempoInBPM(bpm);
    this.sequence = new Sequence(Sequence.PPQ, signature);
  }

  public void addNote(Note note, String trackName) {
    // We need an algorithm for determining which channel to use when )=
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

  public void addNote(Note[] notes, String trackName) {
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
    Thread.sleep(100);
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
