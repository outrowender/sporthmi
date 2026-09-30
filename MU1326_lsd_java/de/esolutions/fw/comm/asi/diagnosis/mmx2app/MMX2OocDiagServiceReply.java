/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app;

import de.esolutions.fw.comm.core.method.MethodException;

public interface MMX2OocDiagServiceReply {
    public static final String IPL_COMM_UUID = "04ffae27-a8b4-4847-ae17-d9c692c6e219";
    public static final String IPL_COMM_INTERFACE_KEY = "70c9dba5-1723-5b89-8b9c-0e21ad580cf1";
    public static final String IPL_COMM_INTERFACE_VERSION = "1.1.0";
    public static final String IPL_COMM_MODULE_VERSION = "2.8.0";

    public void requestTemperatureMMX(long var1) throws MethodException;

    public void requestDeleteMemory(long var1, int var3) throws MethodException;
}

