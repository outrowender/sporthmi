/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app;

import de.esolutions.fw.comm.core.method.MethodException;

public interface MMX2SSEDiagServiceReply {
    public static final String IPL_COMM_UUID = "24b0b774-1310-11e4-8dc2-17f19a7b4b74";
    public static final String IPL_COMM_INTERFACE_KEY = "d68f008c-dad8-5ab1-bd45-f09f0f019586";
    public static final String IPL_COMM_INTERFACE_VERSION = "1.0.0";
    public static final String IPL_COMM_MODULE_VERSION = "2.8.0";

    public void requestClippingCounterMic1(long var1) throws MethodException;
}

