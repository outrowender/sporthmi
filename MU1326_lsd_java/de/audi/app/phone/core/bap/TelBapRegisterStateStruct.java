/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.bap;

import de.esolutions.fw.util.commons.Buffer;

public class TelBapRegisterStateStruct {
    private final int registerState;
    private final int networkType;
    private final int packetDataNetworkType;

    public TelBapRegisterStateStruct(int n, int n2, int n3) {
        this.registerState = n;
        this.networkType = n2;
        this.packetDataNetworkType = n3;
    }

    public int getRegisterState() {
        return this.registerState;
    }

    public int getNetworkType() {
        return this.networkType;
    }

    public int getPacketDataNetworkType() {
        return this.packetDataNetworkType;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("TelBapRegisterStateStruct(");
        buffer.append("registerState=");
        buffer.append(this.registerState);
        buffer.append(", ");
        buffer.append("networkType=");
        buffer.append(this.networkType);
        buffer.append(", ");
        buffer.append("packetDataNetworkType=");
        buffer.append(this.packetDataNetworkType);
        buffer.append(", ");
        buffer.append(")");
        return buffer.toString();
    }

    public int hashCode() {
        int n = 1;
        n = 31 * (n + this.networkType + this.packetDataNetworkType + this.registerState);
        return n;
    }

    public boolean equals(Object object) {
        if (object instanceof TelBapRegisterStateStruct) {
            TelBapRegisterStateStruct telBapRegisterStateStruct = (TelBapRegisterStateStruct)object;
            return telBapRegisterStateStruct.networkType == this.networkType && telBapRegisterStateStruct.packetDataNetworkType == this.packetDataNetworkType && telBapRegisterStateStruct.registerState == this.registerState;
        }
        return false;
    }
}

