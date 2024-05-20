package Util;

import Util.notation.Notation;

import javax.sound.midi.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class PlaybackHandler extends Thread {
    private long tickDelay;

    private final HashMap<String, ArrayList<Flag>> trackList = new HashMap<>();

    private final ArrayList<Integer> freeChannels = new ArrayList<>();
    private final ArrayList<Flag> activeFlags = new ArrayList<>();

    private final Receiver receiver;

    @Override
    public void run() {
        for (Map.Entry<String, ArrayList<Flag>> entry : trackList.entrySet()) {
            String trackName = entry.getKey();

            new Thread(() -> entry.getValue().get(0).play(this, trackName)).start();
            // Iterates through all tracks and starts playback on the first entry of all tracks, from where the playback then cascades through resumePlayback()
        }
    }

    public PlaybackHandler(int bpm) throws Exception{
        try {
            Synthesizer synthesizer = MidiSystem.getSynthesizer();
            synthesizer.open();

            this.receiver = synthesizer.getReceiver();
            this.setBpm(bpm);

            for (int value : new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15}) {
                freeChannels.add(value);
            }
        } catch (Exception e) {
            throw new Exception("Unable to create Synthesizer. Please fix that.");
        }
    }

    public void setBpm(long bpm) {
        /**
         * This function sets the bpm of the sheet and the delay between ticks
         * @param bpm The desired (new) bpm
         */
        System.out.println("Set BPM: " + bpm);
        this.tickDelay = 240000 / bpm;
    }

    public void startPlayback() {
        /**
         * This function starts the playback across all tracks.
         */
        this.start();
    }

    public void resumePlayback(String trackName) {
        /**
         * This function instantiates a new Thread for a tone to be played based on the next entry in the track with the specified name
         * @param trackName the name of the Track whose next flag should be played.
         */
        this.trackList.get(trackName).remove(0);
        if (!this.trackList.get(trackName).isEmpty()) {
            new Thread(() -> this.trackList.get(trackName).get(0).play(this, trackName)).start();
            // Creates a new Thread to play the next flag in the track
        }
    }

    public void passToReceiver(ShortMessage message) {
        /**
         * Auxiliary function for Threads to pass messages to the receiver to be played by the synthesizer.
         * @param message The message to be passed to the receiver
         */

        // System.out.println("Passed message: " + message.getCommand() + ", channel: " + message.getChannel() + " Data1: " + message.getData1());
        this.receiver.send(message, 0);
    }

    public void registerFlag(Flag flag) {
        /**
         * Adds a flag to the list of active flags.
         * @param flag The flag to be registered
         */
        System.out.println(flag);
        this.activeFlags.add(flag);
    }

    public void unregisterFlag(Flag flag) {
        /**
         * Removes a flag from the list of active flags.
         * @param flag The flag to be registered
         */
        //System.out.println("Unregistered: " + flag);
        this.activeFlags.remove(flag);
    }

    public int requestChannel() throws Exception {
        /**
         * Returns the channel of lowest order with no active playback.
         */

        try {
            int channel = this.freeChannels.get(0);
            this.freeChannels.remove(0);
            // System.out.println("Requested Channel: " + channel);
            return channel;
        } catch (Exception e){
            throw new Exception("No further channels are available for playback.");
        }
    }

    public void freeChannel(int channel) {
        /**
         * Adds a channel back to the pool of channels with no playback.
         * @param channel The channel to be added back to the pool
         */

        // System.out.println("Freed Channel: " + channel);
        this.freeChannels.add(channel, channel);
    }

    public void addNotation(String trackName, Notation notation) {
        /**
         * Adds a notation to a track.
         * @param trackName The name of the track
         * @param notation The notation to be added to the track
         */
        System.out.println("Added: " + notation.getClass() + " | " + trackName);
        notation.applyBpm(tickDelay);

        this.trackList.putIfAbsent(trackName, new ArrayList<>());
        this.trackList.get(trackName).add(notation.getFlag());
    }
}
