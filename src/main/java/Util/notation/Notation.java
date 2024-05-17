package Util.notation;

import Util.Flag;

public abstract class Notation {
    private Flag flag;
    private int lengthInBeats;
    private Instrument instrument;

    public Flag getFlag() {
        return this.flag;
    }

    public void setFlag(Flag flag) {
        this.flag = flag;
    }

    public int getLengthInBeats() {
        return lengthInBeats;
    }

    public void setLengthInBeats(int lengthInBeats) {
        this.lengthInBeats = lengthInBeats;
    }

    public Instrument getInstrument() {
        return instrument;
    }

    public void setInstrument(Instrument instrument) {
        this.instrument = instrument;
    }

    public void applyBpm(long tickDelay) {
        this.getFlag().setDuration(tickDelay * lengthInBeats);
    }

    protected abstract void buildFlag();

    public enum Length {
        SIXTEENTH(0.25f), EIGHTH(0.5f), FOURTH(1), HALF(2), FULL(4);

        private final float denominator;

        Length(float value) {
            this.denominator = value;
        }

        public float getDenominator() {
            return denominator;
        }
    }

    public enum Instrument {
        PIANO(0), GLOCKENSPIEL(9), ORGAN(16), GUITAR(24),
        VIOLIN(40), HARP(46), TRUMPET(56), SAXOPHONE(65),
        FLUTE(73), RECORDER(74), SYNTH(90), BAGPIPE(109);

        private final int value;

        Instrument(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static Instrument parse(String string) {
            try {
                return (Enum.valueOf(Instrument.class, string.toUpperCase()));
            } catch (IllegalArgumentException e) {
                return (Instrument.PIANO);
            }
        }
    }
}
