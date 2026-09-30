/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.connectivity.networking;

import de.esolutions.fw.comm.asi.connectivity.networking.WlanDevice;
import de.esolutions.fw.comm.core.method.MethodException;

public interface WlanServiceReply {
    public static final String IPL_COMM_UUID = "24fd4522-b997-4cd5-b2f8-890d6c224eb0";
    public static final String IPL_COMM_INTERFACE_KEY = "7475049f-9ea8-5f56-ab00-5c258cd1be7f";
    public static final String IPL_COMM_INTERFACE_VERSION = "1.1.0";
    public static final String IPL_COMM_MODULE_VERSION = "1.0.0";

    public void updateWlanReady(boolean var1, String var2) throws MethodException;

    public void updateWLANDevice(WlanDevice var1) throws MethodException;
}

