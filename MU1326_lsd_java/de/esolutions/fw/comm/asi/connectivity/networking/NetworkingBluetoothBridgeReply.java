/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.networking;

import de.esolutions.fw.comm.core.method.MethodException;

public interface NetworkingBluetoothBridgeReply {
    public static final String IPL_COMM_UUID = "455c3e9a-730d-4285-979c-61c4a9648fa2";
    public static final String IPL_COMM_INTERFACE_KEY = "473aed0f-a08a-5fd6-ab32-16d904233133";
    public static final String IPL_COMM_INTERFACE_VERSION = "1.0.0";
    public static final String IPL_COMM_MODULE_VERSION = "1.0.0";

    public void setConnectionState(long var1, int var3, int var4) throws MethodException;

    public void setProfileConnectable(long var1, int var3, boolean var4) throws MethodException;
}

