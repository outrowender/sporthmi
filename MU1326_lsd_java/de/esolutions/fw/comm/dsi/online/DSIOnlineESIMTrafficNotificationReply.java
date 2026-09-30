/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSIOnlineESIMTrafficNotificationReply {
    public static final String IPL_COMM_UUID = "e3bba10c-31d4-5d08-9056-c5f5d5344f28";
    public static final String IPL_COMM_INTERFACE_KEY = "0e21486a-016f-5ff7-8b2b-4794252c2e45";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.42";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.42";

    public void updateESIMNotification(String var1, int var2, int var3) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

