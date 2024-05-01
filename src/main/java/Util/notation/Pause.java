package Util.notation;

import Util.Flag;
import Util.PlaybackHandler;

public class Pause extends Notation{
    private Flag flag;

    private long duration;
    private final int lengthInBeats;

    public Pause(int lengthInMilli){
        this.lengthInBeats = lengthInMilli;
    }

    @Override
    public void applyBpm(long tickDelay) {
        this.duration = tickDelay * lengthInBeats;
        this.flag = new Flag() {

            @Override
            public void play(PlaybackHandler playbackHandler, String trackName){
                try {
                    playbackHandler.registerFlag(this);

                    Thread.sleep(duration);

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
