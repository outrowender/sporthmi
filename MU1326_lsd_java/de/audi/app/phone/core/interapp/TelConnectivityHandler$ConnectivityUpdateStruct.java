/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.interapp;

import de.esolutions.fw.util.commons.Buffer;

class TelConnectivityHandler$ConnectivityUpdateStruct {
    private final int nadMode;
    private final int phoneModuleState;

    TelConnectivityHandler$ConnectivityUpdateStruct(int n, int n2) {
        this.nadMode = n;
        this.phoneModuleState = n2;
    }

    int getNadMode() {
        return this.nadMode;
    }

    int getPhoneModuleState() {
        return this.phoneModuleState;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("ConnectivityUpdate: ");
        buffer.append("nadMode=");
        buffer.append(this.nadMode);
        buffer.append(", ");
        buffer.append("phoneModuleState=");
        buffer.append(this.phoneModuleState);
        return buffer.toString();
    }

    public boolean equals(Object object) {
        if (object instanceof TelConnectivityHandler$ConnectivityUpdateStruct) {
            TelConnectivityHandler$ConnectivityUpdateStruct telConnectivityHandler$ConnectivityUpdateStruct = (TelConnectivityHandler$ConnectivityUpdateStruct)object;
            return telConnectivityHandler$ConnectivityUpdateStruct.nadMode == this.nadMode && telConnectivityHandler$ConnectivityUpdateStruct.phoneModuleState == this.phoneModuleState;
        }
        return false;
    }

    public int hashCode() {
        int n = 17;
        n = 31 * n + this.nadMode;
        n = 31 * n + this.phoneModuleState;
        return n;
    }
}

