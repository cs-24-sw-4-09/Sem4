package Util.notation;

import Util.PlaybackHandler;
import Util.Flag;

import javax.sound.midi.ShortMessage;

public class Chord extends Notation {
    private Flag flag;

    public Chord(int[] tones, int lengthInMilli, int velocity) {
        this.flag = new Flag() {
            @Override
            public void play(PlaybackHandler playbackHandler, String trackName) {
                try {
                    ShortMessage[] startMessages = new ShortMessage[tones.length];
                    ShortMessage[] endMessages = new ShortMessage[tones.length];

                    playbackHandler.registerFlag(this);

                    for (int i = 0; i < tones.length; i++) {
                        int channel = playbackHandler.requestChannel();

                        ShortMessage startMessage = new ShortMessage();
                        startMessage.setMessage(ShortMessage.NOTE_ON, channel, tones[i], velocity);
                        startMessages[i] = startMessage;

                        ShortMessage endMessage = new ShortMessage();
                        endMessage.setMessage(ShortMessage.NOTE_OFF, channel, tones[i], 0);
                        endMessages[i] = endMessage;
                    }

                    for (ShortMessage message : startMessages) {
                        playbackHandler.passToReceiver(message);
                    }

                    Thread.sleep(lengthInMilli);

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
        };
    }

    @Override
    public Flag getFlag() {
        return flag;
    }
}
