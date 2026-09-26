/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core.connectivity.connect;

import de.audi.app.bluetooth.core.connectivity.connect.BaseBluetoothConnection;
import de.esolutions.fw.util.commons.Buffer;

public final class BaseBluetoothConnection$ConnectionRequest {
    private final String address;
    public int service;
    private final String deviceName;
    private final int deviceRole;
    private final /* synthetic */ BaseBluetoothConnection this$0;

    BaseBluetoothConnection$ConnectionRequest(BaseBluetoothConnection baseBluetoothConnection, String string, int n, String string2, int n2) {
        this.this$0 = baseBluetoothConnection;
        this.address = string;
        this.service = n;
        this.deviceName = string2;
        this.deviceRole = n2;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("Requesting to connect ");
        buffer.append(this.deviceName);
        buffer.append(' ');
        buffer.append(this.address);
        buffer.append(" with service ");
        buffer.append(this.service);
        buffer.append(" (role: ");
        buffer.append(this.deviceRole);
        buffer.append(")");
        return buffer.toString();
    }

    static /* synthetic */ String access$000(BaseBluetoothConnection$ConnectionRequest baseBluetoothConnection$ConnectionRequest) {
        return baseBluetoothConnection$ConnectionRequest.deviceName;
    }

    static /* synthetic */ String access$100(BaseBluetoothConnection$ConnectionRequest baseBluetoothConnection$ConnectionRequest) {
        return baseBluetoothConnection$ConnectionRequest.address;
    }

    static /* synthetic */ int access$200(BaseBluetoothConnection$ConnectionRequest baseBluetoothConnection$ConnectionRequest) {
        return baseBluetoothConnection$ConnectionRequest.deviceRole;
    }
}

