/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bap.fw.arrays;

public interface IArrayHeader {
    public void setStart(int var1);

    public int getStart();

    public int getStartOffset();

    public int getNumberOfElements();

    public boolean isModeShift();

    public boolean isModeArrayDirectionBackward();

    public boolean isModePositionTransmitted();

    public boolean isModeIndexSize16Bit();

    public int getRecordAddress();

    public void setRecordAddress(int var1);

    public int getJobID();

    public int hashCode();

    public boolean equals(Object var1);
}

