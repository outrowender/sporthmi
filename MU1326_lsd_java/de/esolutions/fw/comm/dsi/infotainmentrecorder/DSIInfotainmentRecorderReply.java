/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.infotainmentrecorder;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSIInfotainmentRecorderReply {
    public static final String IPL_COMM_UUID = "b7c0adff-d9c2-57cd-9bc6-fcd6ec0a9162";
    public static final String IPL_COMM_INTERFACE_KEY = "c3f2ee01-f399-56d7-9269-5fc24f1e45db";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.0";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.0";

    public void updateEnabledTriggers(boolean[] var1, int var2) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

