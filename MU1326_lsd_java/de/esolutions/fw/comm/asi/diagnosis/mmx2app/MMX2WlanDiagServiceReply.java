/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app;

import de.esolutions.fw.comm.core.method.MethodException;

public interface MMX2WlanDiagServiceReply {
    public static final String IPL_COMM_UUID = "989f8f89-44c6-4314-b598-2523e0a7fcbb";
    public static final String IPL_COMM_INTERFACE_KEY = "4c16b9b4-44a6-5f3a-8651-b5a02c1ed480";
    public static final String IPL_COMM_INTERFACE_VERSION = "1.3.0";
    public static final String IPL_COMM_MODULE_VERSION = "2.8.0";

    public void requestWlanProperties(long var1) throws MethodException;

    public void requestSetWlanHotSpotActive(long var1, boolean var3) throws MethodException;

    public void requestWlanHotSpotActive(long var1) throws MethodException;

    public void requestWlanConnectToAP(long var1, boolean var3, String var4, String var5, int var6) throws MethodException;
}

