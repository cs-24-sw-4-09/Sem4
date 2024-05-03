package Util.notation;

import Util.Flag;
import Util.PlaybackHandler;

import javax.sound.midi.ShortMessage;

public class Note extends Notation {
    private int tone;

    public Note(int tone, int lengthInBeats) {
        this.tone = tone;
        this.setLengthInBeats(lengthInBeats);
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

                    ShortMessage startMessage = new ShortMessage();
                    startMessage.setMessage(ShortMessage.NOTE_ON, channel, tone, 100);
                    playbackHandler.passToReceiver(startMessage);

                    System.out.println("Thread Sleep: " + this.getDuration());
                    Thread.sleep(this.getDuration());
                    System.out.println("Thread Awake");

                    ShortMessage endMessage = new ShortMessage();
                    endMessage.setMessage(ShortMessage.NOTE_OFF, channel, tone, 0);
                    playbackHandler.passToReceiver(endMessage);

                    playbackHandler.unregisterFlag(this);
                    playbackHandler.freeChannel(channel);
                    playbackHandler.resumePlayback(trackName);
                } catch (Exception e) {
                    System.out.println("Yep. That wasn't supposed to happen. (Error in Notation) " + e.getMessage());
                }
            }
        });
    }
}