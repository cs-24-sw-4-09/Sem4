package Util.notation;

import Util.Flag;
import Util.PlaybackHandler;

public class Pause extends Notation {

    public Pause(int lengthInMilli) {
        this.setLengthInBeats(lengthInMilli);
        this.buildFlag();
    }

    @Override
    protected void buildFlag() {
        this.setFlag(new Flag() {
            @Override
            public void play(PlaybackHandler playbackHandler, String trackName) {
                try {
                    playbackHandler.registerFlag(this);

                    Thread.sleep(this.getDuration());

                    playbackHandler.unregisterFlag(this);
                    playbackHandler.resumePlayback(trackName);
                } catch (Exception e) {
                    System.out.println("Yep. That wasn't supposed to happen. (Error in Notation) " + e.getMessage());
                }
            }

            @Override
            public String toString() {
                return "Pause | L: " + getLengthInBeats();
            }
        });
    }
}
