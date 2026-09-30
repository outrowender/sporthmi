/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.system;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSIHMIWatchDogReply {
    public static final String IPL_COMM_UUID = "8c5bbce5-380f-5df5-b19b-5ec1f7e75e4b";
    public static final String IPL_COMM_INTERFACE_KEY = "f66767ae-666c-576d-965d-bc3458fe4188";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.0";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.0";

    public void triggerErrorLogDump() throws MethodException;

    public void updateQueryHeartbeat(int var1, int var2) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

