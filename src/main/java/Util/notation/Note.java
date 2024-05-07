package Util.notation;

import Util.Flag;
import Util.PlaybackHandler;

import javax.sound.midi.ShortMessage;

public class Note extends Notation {
    private final int tone;

    public Note(int tone, int lengthInBeats) {
        this.tone = tone;
        this.setLengthInBeats(lengthInBeats);
        this.buildFlag();
    }

    @Override
    protected void buildFlag() {
        this.setFlag(new Flag() {
            private int channel;
            @Override
            public void play(PlaybackHandler playbackHandler, String trackName) {
                try {
                    channel = playbackHandler.requestChannel();
                    playbackHandler.registerFlag(this);

                    ShortMessage startMessage = new ShortMessage();
                    startMessage.setMessage(ShortMessage.NOTE_ON, this.channel, tone, 100);
                    playbackHandler.passToReceiver(startMessage);

                    Thread.sleep(this.getDuration());

                    ShortMessage endMessage = new ShortMessage();
                    endMessage.setMessage(ShortMessage.NOTE_OFF, this.channel, tone, 0);
                    playbackHandler.passToReceiver(endMessage);

                    playbackHandler.unregisterFlag(this);
                    playbackHandler.freeChannel(this.channel);
                    playbackHandler.resumePlayback(trackName);
                } catch (Exception e) {
                    System.out.println("Yep. That wasn't supposed to happen. (Error in Notation) " + e.getMessage());
                }
            }

            @Override
            public String toString() {
                return "Note  | T: " + tone + " | L: " + getLengthInBeats();
            }
        });
    }
}