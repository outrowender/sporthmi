/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app;

import de.esolutions.fw.comm.core.method.MethodException;

public interface MMX2SwdlDiagServiceReply {
    public static final String IPL_COMM_UUID = "26548633-0750-4d14-a851-46e73b79a1c8";
    public static final String IPL_COMM_INTERFACE_KEY = "ab446ad8-f728-5ed0-a70c-e5dcfab87f63";
    public static final String IPL_COMM_INTERFACE_VERSION = "1.0.0";
    public static final String IPL_COMM_MODULE_VERSION = "2.8.0";

    public void requestModuleVersionNumbers(long var1) throws MethodException;
}

