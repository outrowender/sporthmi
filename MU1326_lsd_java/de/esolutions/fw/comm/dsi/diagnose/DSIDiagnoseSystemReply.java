/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.diagnose;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSIDiagnoseSystemReply {
    public static final String IPL_COMM_UUID = "7128b77d-0ce1-5205-bd4b-a30f854ae2cb";
    public static final String IPL_COMM_INTERFACE_KEY = "7c1fb9de-e446-595e-98c6-4a9038900c37";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.10";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.10";

    public void updateDiagnosticValueChanged(int var1, long var2, int var4) throws MethodException;

    public void requestRoutine(int var1, int var2, int var3, int[] var4) throws MethodException;

    public void requestActuatorTest(int var1, int var2, int var3, int var4, int[] var5) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

