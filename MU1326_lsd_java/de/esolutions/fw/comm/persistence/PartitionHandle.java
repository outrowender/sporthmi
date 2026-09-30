/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.persistence;

public class PartitionHandle {
    public long index;

    public long getIndex() {
        return this.index;
    }

    public void setIndex(long l) {
        this.index = l;
    }

    public PartitionHandle() {
    }

    public PartitionHandle(long l) {
        this.index = l;
    }

    public String toString() {
        return "PartitionHandle{" + "index=" + this.index + "}";
    }
}

