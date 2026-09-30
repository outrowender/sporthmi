/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.mmx2app;

import de.esolutions.fw.comm.core.method.MethodException;

public interface MMX2AppDtcTestServiceReply {
    public static final String IPL_COMM_UUID = "9e79c740-f61e-42bd-a575-c0c06d5f623b";
    public static final String IPL_COMM_INTERFACE_KEY = "48e93f98-718a-5f3c-9e06-ed7a0c0371b1";
    public static final String IPL_COMM_INTERFACE_VERSION = "1.1.0";
    public static final String IPL_COMM_MODULE_VERSION = "2.8.0";

    public void registerForDiagnosisAck(int var1) throws MethodException;

    public void performTest(long var1) throws MethodException;

    public void performAllTests() throws MethodException;
}

