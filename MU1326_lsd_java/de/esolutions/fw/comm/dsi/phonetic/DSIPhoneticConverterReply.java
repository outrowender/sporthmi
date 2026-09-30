/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.phonetic;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSIPhoneticConverterReply {
    public static final String IPL_COMM_UUID = "2830ffad-3726-5f2c-8fb8-4730a2dbf5e6";
    public static final String IPL_COMM_INTERFACE_KEY = "830cce88-feab-5c78-a8ed-3525b9be8eaa";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.1";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.1";

    public void hanziToPinYinResult(String var1, String var2, String var3, String var4) throws MethodException;

    public void hanziToZhuYinResult(String var1, String var2, String var3, String var4) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

