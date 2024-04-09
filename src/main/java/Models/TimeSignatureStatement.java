package Models;

import Interpreter.ASTNode;

public class TimeSignatureStatement extends ASTNode {
    private int numerator;
    private int denominator;

    public TimeSignatureStatement(int numerator, int denominator) {
        super("timeSignatureStatement");
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }
}