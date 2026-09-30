/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.uotanaviservice;

import de.esolutions.fw.comm.core.method.MethodException;

public interface UOTANaviServiceReply {
    public static final String IPL_COMM_UUID = "0d894ae4-0f7c-48e6-a7e3-0b9f0d32c51a";
    public static final String IPL_COMM_INTERFACE_KEY = "5e467618-909a-51d8-837e-36f5bbfa36a1";
    public static final String IPL_COMM_INTERFACE_VERSION = "0.0.3";
    public static final String IPL_COMM_MODULE_VERSION = "0.0.3";

    public void getVersionInfo(short var1) throws MethodException;
}

