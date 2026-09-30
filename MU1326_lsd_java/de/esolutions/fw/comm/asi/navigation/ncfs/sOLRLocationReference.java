/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.ncfs;

public class sOLRLocationReference {
    public byte[] location;

    public byte[] getLocation() {
        return this.location;
    }

    public void setLocation(byte[] byArray) {
        this.location = byArray;
    }

    public sOLRLocationReference() {
    }

    public sOLRLocationReference(byte[] byArray) {
        this.location = byArray;
    }

    public String toString() {
        return "sOLRLocationReference{" + "location=" + "[" + (this.location == null ? "null" : "size=" + this.location.length) + "]" + "}";
    }
}

