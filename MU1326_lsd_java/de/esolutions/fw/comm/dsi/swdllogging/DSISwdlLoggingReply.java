/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.swdllogging;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSISwdlLoggingReply {
    public static final String IPL_COMM_UUID = "d4701228-4c5f-56da-b0bf-05699002e833";
    public static final String IPL_COMM_INTERFACE_KEY = "b02bd6b4-bef1-5aba-9811-dee9d4328506";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.2";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.2";

    public void getHistory(String[] var1, int[] var2) throws MethodException;

    public void setUpdate(int var1) throws MethodException;

    public void getGeneralInformation(boolean var1, String var2, String var3, boolean var4, String var5, String var6, int[] var7, boolean var8, int var9, int[] var10) throws MethodException;

    public void getUnusualEvents(int[] var1, String[] var2) throws MethodException;

    public void getUnusualEvent(int var1, String var2, String var3, String var4, byte var5, int var6) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

