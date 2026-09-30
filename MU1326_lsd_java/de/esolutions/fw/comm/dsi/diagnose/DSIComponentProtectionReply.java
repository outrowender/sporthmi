/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.diagnose;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSIComponentProtectionReply {
    public static final String IPL_COMM_UUID = "54043ffd-5930-5fd1-b6a9-e318c74a2c35";
    public static final String IPL_COMM_INTERFACE_KEY = "925d4129-9d5f-5cbc-b7b4-c8e3ce749dfb";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.10";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.10";

    public void authStringResponse(String var1, String var2, byte var3) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

