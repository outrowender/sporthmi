/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.bap;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSIBAPReply {
    public static final String IPL_COMM_UUID = "187b8dba-bafe-54d9-bd32-ccc4dc6d16c7";
    public static final String IPL_COMM_INTERFACE_KEY = "e99f0395-02b6-5a98-9d51-8714b5fcad80";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.5";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.5";

    public void bapStateStatus(int var1, int var2) throws MethodException;

    public void indication(int var1, int var2, int var3, int var4, int var5) throws MethodException;

    public void indicationVoid(int var1, int var2, int var3) throws MethodException;

    public void indicationByteSequence(int var1, int var2, int var3, byte[] var4) throws MethodException;

    public void indicationError(int var1, int var2, int var3) throws MethodException;

    public void acknowledge(int var1, int var2, int var3) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

