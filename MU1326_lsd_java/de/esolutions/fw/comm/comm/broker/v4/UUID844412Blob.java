/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.comm.broker.v4;

public class UUID844412Blob {
    public short[] bytes;

    public short[] getBytes() {
        return this.bytes;
    }

    public void setBytes(short[] sArray) {
        this.bytes = sArray;
    }

    public UUID844412Blob() {
    }

    public UUID844412Blob(short[] sArray) {
        this.bytes = sArray;
    }

    public String toString() {
        return "UUID844412Blob{" + "bytes=" + "[" + (this.bytes == null ? "null" : "size=" + this.bytes.length) + "]" + "}";
    }
}

