/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.bluetooth;

import java.util.Arrays;

public class sPairedBtDevices {
    public long msg_id;
    public short numberPairedDevices;
    public long[] btProfiles;
    public String[] deviceName;

    public long getMsg_id() {
        return this.msg_id;
    }

    public void setMsg_id(long l) {
        this.msg_id = l;
    }

    public short getNumberPairedDevices() {
        return this.numberPairedDevices;
    }

    public void setNumberPairedDevices(short s) {
        this.numberPairedDevices = s;
    }

    public long[] getBtProfiles() {
        return this.btProfiles;
    }

    public void setBtProfiles(long[] lArray) {
        this.btProfiles = lArray;
    }

    public String[] getDeviceName() {
        return this.deviceName;
    }

    public void setDeviceName(String[] stringArray) {
        this.deviceName = stringArray;
    }

    public sPairedBtDevices() {
    }

    public sPairedBtDevices(long l, short s, long[] lArray, String[] stringArray) {
        this.msg_id = l;
        this.numberPairedDevices = s;
        this.btProfiles = lArray;
        this.deviceName = stringArray;
    }

    public String toString() {
        return "sPairedBtDevices{" + "msg_id=" + this.msg_id + ", numberPairedDevices=" + this.numberPairedDevices + ", btProfiles=" + "[" + (this.btProfiles == null ? "null" : "size=" + this.btProfiles.length) + "]" + ", deviceName=" + "[" + (this.deviceName == null ? "null" : Arrays.asList(this.deviceName).toString()) + "]" + "}";
    }
}

