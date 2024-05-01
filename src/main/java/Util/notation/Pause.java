package Util.notation;

import Util.Flag;
import Util.PlaybackHandler;

public class Pause extends Notation{
    private final Flag flag;

    public Pause(int lengthInMilli){
        this.flag = new Flag() {

            @Override
            public void play(PlaybackHandler playbackHandler, String trackName){
                try {
                    playbackHandler.registerFlag(this);

                    Thread.sleep(lengthInMilli);

                    playbackHandler.unregisterFlag(this);
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
