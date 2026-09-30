/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.fec;

import de.esolutions.fw.comm.asi.fec.SFecState;
import de.esolutions.fw.comm.core.method.MethodException;

public interface FecAppMMXReply {
    public static final String IPL_COMM_UUID = "3a7a576a-0b38-45fc-9ad4-1eab302e4f5b";
    public static final String IPL_COMM_INTERFACE_KEY = "25185772-f55e-575f-a737-9ae88d532512";
    public static final String IPL_COMM_INTERFACE_VERSION = "0.0.3";
    public static final String IPL_COMM_MODULE_VERSION = "1.1.5";

    public void reportError(int var1) throws MethodException;

    public void updateFECs(SFecState[] var1) throws MethodException;

    public void checkPkgSignature(String var1, boolean var2) throws MethodException;
}

