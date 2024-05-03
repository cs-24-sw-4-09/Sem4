package Util;

import Util.PlaybackHandler;

public abstract class Flag extends Thread{
    private long duration;

    public void play(PlaybackHandler playbackHandler, String key){}

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }
}
