/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.networking;

import de.esolutions.fw.comm.core.method.MethodException;

public interface NetworkingServiceReply {
    public static final String IPL_COMM_UUID = "54bd523b-eece-4101-9c88-53bb869c6b64";
    public static final String IPL_COMM_INTERFACE_KEY = "9d2b4f14-42b2-506b-aae0-1904af2be1f8";
    public static final String IPL_COMM_INTERFACE_VERSION = "1.2.0";
    public static final String IPL_COMM_MODULE_VERSION = "1.0.0";

    public void updateRoamingState(int var1) throws MethodException;

    public void updateOnlineState(int var1) throws MethodException;

    public void updateThrottlingState(int var1) throws MethodException;

    public void updateServiceIdentifier(String var1) throws MethodException;

    public void updateSimCardType(int var1) throws MethodException;

    public void updateSim(String var1, String var2, String var3, String var4) throws MethodException;
}

