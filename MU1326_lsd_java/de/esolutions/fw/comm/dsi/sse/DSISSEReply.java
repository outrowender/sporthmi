/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.sse;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSISSEReply {
    public static final String IPL_COMM_UUID = "5b093971-6a32-577c-b8c2-67ff28ae7835";
    public static final String IPL_COMM_INTERFACE_KEY = "b2203730-012f-5a3b-a9d9-4e3b6fc01483";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.3";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.3";

    public void responseSetMode(int var1) throws MethodException;

    public void updateMode(int var1, int var2) throws MethodException;

    public void updateMicGainLevel(int var1, int var2) throws MethodException;

    public void responseSetMicGainLevel(int var1) throws MethodException;

    public void updateMicMuteState(int var1, int var2) throws MethodException;

    public void responseSetMicMuteState(int var1) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

