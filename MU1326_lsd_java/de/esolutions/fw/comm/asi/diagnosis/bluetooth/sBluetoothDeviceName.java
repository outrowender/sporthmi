/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.bluetooth;

public class sBluetoothDeviceName {
    public long mac;
    public String name;

    public long getMac() {
        return this.mac;
    }

    public void setMac(long l) {
        this.mac = l;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String string) {
        this.name = string;
    }

    public sBluetoothDeviceName() {
    }

    public sBluetoothDeviceName(long l, String string) {
        this.mac = l;
        this.name = string;
    }

    public String toString() {
        return "sBluetoothDeviceName{" + "mac=" + this.mac + ", name=" + this.name + "}";
    }
}

