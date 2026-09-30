/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.displaycontroller;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSIDisplayControllerReply {
    public static final String IPL_COMM_UUID = "9b27c2ef-4e44-5e8f-b943-3e147e35ce14";
    public static final String IPL_COMM_INTERFACE_KEY = "b2238660-5500-5c27-8846-14f8201a2f0e";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.2";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.2";

    public void getDisplayBrightness(int var1, int var2) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

