/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

public class TunerService$TunerSettingResult {
    private final byte resultCode;
    private final long objectID;

    public TunerService$TunerSettingResult(byte by, long l) {
        this.resultCode = by;
        this.objectID = l;
    }

    public byte getResultCode() {
        return this.resultCode;
    }

    public long getObjectID() {
        return this.objectID;
    }

    public String toString() {
        return new StringBuffer().append("resultCode=").append(this.resultCode).append(", objectID=").append(this.objectID).toString();
    }
}

