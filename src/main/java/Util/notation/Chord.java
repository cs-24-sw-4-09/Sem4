package Util.notation;

import Util.PlaybackHandler;
import Util.Flag;

import javax.sound.midi.ShortMessage;
import java.util.Arrays;

public class Chord extends Notation {
    int[] tones;
    Instrument instrument;

    public Chord(int[] tones, int lengthInBeats, Instrument instrument) {
        this.tones = tones;
        this.setLengthInBeats(lengthInBeats);
        this.setInstrument(instrument);
        buildFlag();
    }

    @Override
    protected void buildFlag(){
        this.setFlag(new Flag() {
            

            @Override
            public void play(PlaybackHandler playbackHandler, String trackName) {
                try {
                    ShortMessage[] startMessages = new ShortMessage[tones.length];
                    ShortMessage[] endMessages = new ShortMessage[tones.length];
                    int[] channels = new int[tones.length];

                    playbackHandler.registerFlag(this);

                    for (int i = 0; i < tones.length; i++) {
                        channels[i] = playbackHandler.requestChannel();

                        startMessages[i] = new ShortMessage(ShortMessage.NOTE_ON, channels[i], tones[i], 100);

                        endMessages[i] = new ShortMessage(ShortMessage.NOTE_OFF, channels[i], tones[i], 0);
                    }

                    for (int i = 0; i < startMessages.length; i++) {
                        playbackHandler.passToReceiver(new ShortMessage(ShortMessage.PROGRAM_CHANGE, channels[i], getInstrument().getValue(), 0));
                        playbackHandler.passToReceiver(startMessages[i]);
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
