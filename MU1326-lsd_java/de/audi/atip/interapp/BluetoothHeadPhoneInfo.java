/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp;

import de.esolutions.fw.util.commons.Buffer;

public class BluetoothHeadPhoneInfo {
    public boolean muHeadphone1;
    public boolean ruHeadphone1;
    public boolean ruHeadphone2;
    public boolean rseHeadphone1;
    public boolean rseHeadphone2;

    public BluetoothHeadPhoneInfo() {
        this.muHeadphone1 = false;
        this.ruHeadphone1 = false;
        this.ruHeadphone2 = false;
        this.rseHeadphone1 = false;
        this.rseHeadphone2 = false;
    }

    public BluetoothHeadPhoneInfo(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        this.muHeadphone1 = bl;
        this.ruHeadphone1 = bl2;
        this.ruHeadphone2 = bl3;
        this.rseHeadphone1 = bl4;
        this.rseHeadphone2 = bl5;
    }

    public boolean isMUHeadphone1() {
        return this.muHeadphone1;
    }

    public boolean isRUHeadphone1() {
        return this.ruHeadphone1;
    }

    public boolean isRUHeadphone2() {
        return this.ruHeadphone2;
    }

    public boolean isRSEHeadphone1() {
        return this.rseHeadphone1;
    }

    public boolean isRSEHeadphone2() {
        return this.rseHeadphone2;
    }

    public String toString() {
        Buffer buffer = new Buffer(100);
        buffer.append("BluetoothHeadPhoneInfo(");
        buffer.append(this.muHeadphone1);
        buffer.append(',');
        buffer.append(this.ruHeadphone1);
        buffer.append(',');
        buffer.append(this.ruHeadphone2);
        buffer.append(',');
        buffer.append(this.rseHeadphone1);
        buffer.append(',');
        buffer.append(this.rseHeadphone2);
        buffer.append(')');
        return buffer.toString();
    }
}

