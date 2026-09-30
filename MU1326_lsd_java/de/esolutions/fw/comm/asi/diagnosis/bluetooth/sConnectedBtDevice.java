/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.bluetooth;

public class sConnectedBtDevice {
    public long msg_id;
    public short deviceNumber;
    public short fieldStrengthRSSI;
    public String deviceName;

    public long getMsg_id() {
        return this.msg_id;
    }

    public void setMsg_id(long l) {
        this.msg_id = l;
    }

    public short getDeviceNumber() {
        return this.deviceNumber;
    }

    public void setDeviceNumber(short s) {
        this.deviceNumber = s;
    }

    public short getFieldStrengthRSSI() {
        return this.fieldStrengthRSSI;
    }

    public void setFieldStrengthRSSI(short s) {
        this.fieldStrengthRSSI = s;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public void setDeviceName(String string) {
        this.deviceName = string;
    }

    public sConnectedBtDevice() {
    }

    public sConnectedBtDevice(long l, short s, short s2, String string) {
        this.msg_id = l;
        this.deviceNumber = s;
        this.fieldStrengthRSSI = s2;
        this.deviceName = string;
    }

    public String toString() {
        return "sConnectedBtDevice{" + "msg_id=" + this.msg_id + ", deviceNumber=" + this.deviceNumber + ", fieldStrengthRSSI=" + this.fieldStrengthRSSI + ", deviceName=" + this.deviceName + "}";
    }
}

