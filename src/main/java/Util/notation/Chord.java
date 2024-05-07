package Util.notation;

import Util.PlaybackHandler;
import Util.Flag;

import javax.sound.midi.ShortMessage;
import java.util.Arrays;

public class Chord extends Notation {
    int[] tones;

    public Chord(int[] tones, int lengthInBeats) {
        this.setLengthInBeats(lengthInBeats);
        this.tones = tones;
        buildFlag();
    }

    @Override
    protected void buildFlag(){
        this.setFlag(new Flag() {
            private int[] channels;

            @Override
            public void play(PlaybackHandler playbackHandler, String trackName) {
                try {
                    ShortMessage[] startMessages = new ShortMessage[tones.length];
                    ShortMessage[] endMessages = new ShortMessage[tones.length];
                    channels = new int[tones.length];

                    playbackHandler.registerFlag(this);

                    for (int i = 0; i < tones.length; i++) {
                        this.channels[i] = playbackHandler.requestChannel();

                        ShortMessage startMessage = new ShortMessage();
                        startMessage.setMessage(ShortMessage.NOTE_ON, this.channels[i], tones[i], 100);
                        startMessages[i] = startMessage;

                        ShortMessage endMessage = new ShortMessage();
                        endMessage.setMessage(ShortMessage.NOTE_OFF, this.channels[i], tones[i], 0);
                        endMessages[i] = endMessage;
                    }

                    for (ShortMessage message : startMessages) {
                        playbackHandler.passToReceiver(message);
                    }

                    Thread.sleep(this.getDuration());

                    for (ShortMessage message : endMessages) {
                        playbackHandler.passToReceiver(message);
                        playbackHandler.freeChannel(message.getChannel());
                    }

                    playbackHandler.unregisterFlag(this);
                    playbackHandler.resumePlayback(trackName);
                } catch (Exception e) {
                    System.out.println("Yep. That wasn't supposed to happen. (Error in Notation) " + e.getMessage());
                }
            }

            @Override
            public String toString() {
                return "Chord" + " | T: " + Arrays.toString(tones).replace("[", "").replace("]", "") + " | L: " + getLengthInBeats();
            }
        });
    }
}
