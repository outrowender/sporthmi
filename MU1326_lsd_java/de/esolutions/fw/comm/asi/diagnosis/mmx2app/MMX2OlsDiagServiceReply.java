/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app;

import de.esolutions.fw.comm.core.method.MethodException;

public interface MMX2OlsDiagServiceReply {
    public static final String IPL_COMM_UUID = "415815e1-22dc-44f2-8c3e-cc8470ffeaf7";
    public static final String IPL_COMM_INTERFACE_KEY = "612a308a-aae1-5fc9-a4d8-fa53e3ea8080";
    public static final String IPL_COMM_INTERFACE_VERSION = "1.0.0";
    public static final String IPL_COMM_MODULE_VERSION = "2.8.0";

    public void requestConnectionState(long var1) throws MethodException;

    public void requestActivationState(long var1) throws MethodException;
}

