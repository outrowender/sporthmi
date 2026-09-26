/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.car;

public class Car2XObjectCollection$CarZeroEmissionEntry {
    private short[] values;
    private byte state;

    public Car2XObjectCollection$CarZeroEmissionEntry() {
    }

    public Car2XObjectCollection$CarZeroEmissionEntry(short[] sArray, byte by) {
        this.setValues(sArray);
        this.setState(by);
    }

    public short[] getValues() {
        return this.values;
    }

    public void setValues(short[] sArray) {
        this.values = sArray;
    }

    public byte getState() {
        return this.state;
    }

    public void setState(byte by) {
        this.state = by;
    }
}

