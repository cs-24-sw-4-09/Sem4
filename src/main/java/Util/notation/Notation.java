package Util.notation;

import Util.Flag;

public abstract class Notation {
    private Flag flag;
    private int lengthInBeats;

    public Flag getFlag(){return this.flag;}
    public void setFlag(Flag flag){this.flag = flag;}

    public int getLengthInBeats() { return lengthInBeats;}
    public void setLengthInBeats(int lengthInBeats) {this.lengthInBeats = lengthInBeats;}

    public void applyBpm(long tickDelay) {
        this.getFlag().setDuration(tickDelay * lengthInBeats);
    }

    protected abstract void buildFlag();

    public enum Length{
        SIXTEENTH(0.25f), EIGHTH(0.5f), FOURTH(1), HALF(2), FULL(4);

        private final float denominator;

        Length(float value) {
            this.denominator = value;
        }

        public float getDenominator() {
            return denominator;
        }
    }
}
