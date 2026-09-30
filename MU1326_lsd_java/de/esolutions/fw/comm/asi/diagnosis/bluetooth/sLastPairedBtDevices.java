/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.bluetooth;

public class sLastPairedBtDevices {
    public long msg_id;
    public short whichLastPaired;
    public long deviceAdress;
    public String deviceName;
    public String btSupplierName;
    public String btModel;
    public String btSoftwareVersion;
    public int[] btProfilesVersion;

    public long getMsg_id() {
        return this.msg_id;
    }

    public void setMsg_id(long l) {
        this.msg_id = l;
    }

    public short getWhichLastPaired() {
        return this.whichLastPaired;
    }

    public void setWhichLastPaired(short s) {
        this.whichLastPaired = s;
    }

    public long getDeviceAdress() {
        return this.deviceAdress;
    }

    public void setDeviceAdress(long l) {
        this.deviceAdress = l;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public void setDeviceName(String string) {
        this.deviceName = string;
    }

    public String getBtSupplierName() {
        return this.btSupplierName;
    }

    public void setBtSupplierName(String string) {
        this.btSupplierName = string;
    }

    public String getBtModel() {
        return this.btModel;
    }

    public void setBtModel(String string) {
        this.btModel = string;
    }

    public String getBtSoftwareVersion() {
        return this.btSoftwareVersion;
    }

    public void setBtSoftwareVersion(String string) {
        this.btSoftwareVersion = string;
    }

    public int[] getBtProfilesVersion() {
        return this.btProfilesVersion;
    }

    public void setBtProfilesVersion(int[] nArray) {
        this.btProfilesVersion = nArray;
    }

    public sLastPairedBtDevices() {
    }

    public sLastPairedBtDevices(long l, short s, long l2, String string, String string2, String string3, String string4, int[] nArray) {
        this.msg_id = l;
        this.whichLastPaired = s;
        this.deviceAdress = l2;
        this.deviceName = string;
        this.btSupplierName = string2;
        this.btModel = string3;
        this.btSoftwareVersion = string4;
        this.btProfilesVersion = nArray;
    }

    public String toString() {
        return "sLastPairedBtDevices{" + "msg_id=" + this.msg_id + ", whichLastPaired=" + this.whichLastPaired + ", deviceAdress=" + this.deviceAdress + ", deviceName=" + this.deviceName + ", btSupplierName=" + this.btSupplierName + ", btModel=" + this.btModel + ", btSoftwareVersion=" + this.btSoftwareVersion + ", btProfilesVersion=" + "[" + (this.btProfilesVersion == null ? "null" : "size=" + this.btProfilesVersion.length) + "]" + "}";
    }
}

