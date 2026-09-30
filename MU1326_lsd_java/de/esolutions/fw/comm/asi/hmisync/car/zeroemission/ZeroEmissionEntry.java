/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.zeroemission;

public class ZeroEmissionEntry {
    public short[] values;
    public byte state;

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

    public ZeroEmissionEntry() {
    }

    public ZeroEmissionEntry(short[] sArray, byte by) {
        this.values = sArray;
        this.state = by;
    }

    public String toString() {
        return "ZeroEmissionEntry{" + "values=" + "[" + (this.values == null ? "null" : "size=" + this.values.length) + "]" + ", state=" + this.state + "}";
    }
}

