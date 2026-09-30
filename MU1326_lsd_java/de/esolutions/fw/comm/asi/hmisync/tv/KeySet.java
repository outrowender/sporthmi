/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.tv;

public class KeySet {
    public byte terminalID;
    public byte[] keyIDs;

    public byte getTerminalID() {
        return this.terminalID;
    }

    public void setTerminalID(byte by) {
        this.terminalID = by;
    }

    public byte[] getKeyIDs() {
        return this.keyIDs;
    }

    public void setKeyIDs(byte[] byArray) {
        this.keyIDs = byArray;
    }

    public KeySet() {
    }

    public KeySet(byte by, byte[] byArray) {
        this.terminalID = by;
        this.keyIDs = byArray;
    }

    public String toString() {
        return "KeySet{" + "terminalID=" + this.terminalID + ", keyIDs=" + "[" + (this.keyIDs == null ? "null" : "size=" + this.keyIDs.length) + "]" + "}";
    }
}

