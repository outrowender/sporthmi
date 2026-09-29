/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.prpframework;

public class RecognizerResult
implements Comparable {
    private int confidence;
    private char character;
    private int origConfidence;

    public RecognizerResult(char c2, int n) {
        this.confidence = n;
        this.origConfidence = n;
        this.character = c2;
    }

    @Override
    public int compareTo(Object object) {
        if (object instanceof RecognizerResult) {
            return this.confidence - ((RecognizerResult)object).getConfidence();
        }
        throw new IllegalArgumentException("Only comparision to objects of the same type are allowed");
    }

    public int getConfidence() {
        return this.confidence;
    }

    public char getCharacter() {
        return this.character;
    }

    public void boost(int n) {
        if (this.confidence != -1) {
            this.confidence += n;
        }
    }

    public int getOriginalConfidence() {
        return this.origConfidence;
    }

    public void resetBoost() {
        this.confidence = this.origConfidence;
    }

    public void setConfidence(int n) {
        this.origConfidence = this.confidence = n;
    }

    public String toString() {
        return new StringBuffer().append(this.character).append(" (").append(this.confidence).append(")").toString();
    }
}

