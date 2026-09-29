/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.arrays;

public interface IArrayHeader {
    default public void setStart(int n) {
    }

    default public int getStart() {
    }

    default public int getStartOffset() {
    }

    default public int getNumberOfElements() {
    }

    default public boolean isModeShift() {
    }

    default public boolean isModeArrayDirectionBackward() {
    }

    default public boolean isModePositionTransmitted() {
    }

    default public boolean isModeIndexSize16Bit() {
    }

    default public int getRecordAddress() {
    }

    default public void setRecordAddress(int n) {
    }

    default public int getJobID() {
    }

    default public int hashCode() {
    }

    default public boolean equals(Object object) {
    }
}

