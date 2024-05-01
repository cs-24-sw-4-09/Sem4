package Util.notation;

import Util.Flag;

public abstract class Notation {
    public Flag getFlag(){return null;}

    public void applyBpm(long tickDelay) {}

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
