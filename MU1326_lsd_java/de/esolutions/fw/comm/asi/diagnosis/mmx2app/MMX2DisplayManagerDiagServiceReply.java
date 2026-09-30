/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app;

import de.esolutions.fw.comm.core.method.MethodException;

public interface MMX2DisplayManagerDiagServiceReply {
    public static final String IPL_COMM_UUID = "900f45af-5513-436c-bd60-0747c447c61f";
    public static final String IPL_COMM_INTERFACE_KEY = "e2f5022d-4f99-5bb8-b4a4-a30a4c93d62a";
    public static final String IPL_COMM_INTERFACE_VERSION = "1.3.0";
    public static final String IPL_COMM_MODULE_VERSION = "2.8.0";

    public void requestVideoInputState(long var1) throws MethodException;

    public void requestTrunkOfferFBAS(long var1, int var3, int var4, short var5) throws MethodException;
}

