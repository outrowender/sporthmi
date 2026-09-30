/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app;

import de.esolutions.fw.comm.core.method.MethodException;

public interface MMX2SpeechDiagServiceReply {
    public static final String IPL_COMM_UUID = "4f78da63-d498-4434-ab5e-fa9f885161d9";
    public static final String IPL_COMM_INTERFACE_KEY = "a2d49b2d-4c62-50ff-80c8-74891c1909b9";
    public static final String IPL_COMM_INTERFACE_VERSION = "1.2.0";
    public static final String IPL_COMM_MODULE_VERSION = "2.8.0";

    public void requestCommandSDS(long var1) throws MethodException;

    public void requestCountryRegionVersion(long var1) throws MethodException;
}

