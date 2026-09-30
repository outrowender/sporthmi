/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.car.sportchrono;

public class SCRefLapData {
    public long uid;
    public byte[] data;

    public long getUid() {
        return this.uid;
    }

    public void setUid(long l) {
        this.uid = l;
    }

    public byte[] getData() {
        return this.data;
    }

    public void setData(byte[] byArray) {
        this.data = byArray;
    }

    public SCRefLapData() {
    }

    public SCRefLapData(long l, byte[] byArray) {
        this.uid = l;
        this.data = byArray;
    }

    public String toString() {
        return "SCRefLapData{" + "uid=" + this.uid + ", data=" + "[" + (this.data == null ? "null" : "size=" + this.data.length) + "]" + "}";
    }
}

