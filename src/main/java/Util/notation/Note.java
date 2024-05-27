package Util.notation;

import Util.Flag;
import Util.PlaybackHandler;

import javax.sound.midi.ShortMessage;

public class Note extends Notation {
    private final int tone;

    public Note(int tone, int lengthInBeats, Instrument instrument) {
        this.tone = tone;
        this.setLengthInBeats(lengthInBeats);
        this.setInstrument(instrument);
        this.buildFlag();
    }

    @Override
    protected void buildFlag() {
        this.setFlag(new Flag() {
            
            @Override
            public void play(PlaybackHandler playbackHandler, String trackName) {
                try {
                    int channel = playbackHandler.requestChannel();
                    playbackHandler.registerFlag(this);

                    ShortMessage programChange = new ShortMessage(ShortMessage.PROGRAM_CHANGE, channel, getInstrument().getValue(), 0);
                    playbackHandler.passToReceiver(programChange);

                    ShortMessage startMessage = new ShortMessage(ShortMessage.NOTE_ON, channel, tone, 100);
                    playbackHandler.passToReceiver(startMessage);

                    Thread.sleep(this.getDuration());

                    ShortMessage endMessage = new ShortMessage(ShortMessage.NOTE_OFF, channel, tone, 0);
                    playbackHandler.passToReceiver(endMessage);

                    playbackHandler.unregisterFlag(this);
                    playbackHandler.freeChannel(channel);
                    playbackHandler.resumePlayback(trackName);
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            }

            @Override
            public String toString() {
                return "Note  | T: " + tone + " | L: " + getLengthInBeats();
            }
        });
    }
}
