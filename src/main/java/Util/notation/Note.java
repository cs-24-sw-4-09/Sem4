package Util.notation;

import Util.Flag;
import Util.PlaybackHandler;

import javax.sound.midi.ShortMessage;

public class Note extends Notation{
    private final Flag flag;

    public Note(int tone, int lengthInMilli, int velocity){
        this.flag = new Flag() {
            private int channel;

            @Override
            public void play(PlaybackHandler playbackHandler, String trackName){
                try {
                    channel = playbackHandler.requestChannel();
                    playbackHandler.registerFlag(this);

                    ShortMessage startMessage = new ShortMessage();
                    startMessage.setMessage(ShortMessage.NOTE_ON, channel, tone, velocity);
                    playbackHandler.passToReceiver(startMessage);

                    Thread.sleep(lengthInMilli);

                    ShortMessage endMessage = new ShortMessage();
                    endMessage.setMessage(ShortMessage.NOTE_OFF, channel, tone, 0);
                    playbackHandler.passToReceiver(endMessage);

                    playbackHandler.unregisterFlag(this);
                    playbackHandler.freeChannel(channel);
                    playbackHandler.resumePlayback(trackName);
                }catch (Exception e){
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
