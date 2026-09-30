/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.audio;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSIAudioManagementReply {
    public static final String IPL_COMM_UUID = "55183b6f-9e82-5a18-bfde-ed5ae24f6c1c";
    public static final String IPL_COMM_INTERFACE_KEY = "db006bf0-acd2-5747-8415-366ba32075fe";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.45";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.45";

    public void errorConnection(int var1, int var2, int var3) throws MethodException;

    public void fadedIn(int var1, int var2) throws MethodException;

    public void pauseConnection(int var1, int var2) throws MethodException;

    public void updateActiveConnection(int var1, int var2, int var3) throws MethodException;

    public void updateActiveEntertainmentConnection(int var1, int var2, int var3) throws MethodException;

    public void startConnection(int var1, int var2) throws MethodException;

    public void stopConnection(int var1, int var2) throws MethodException;

    public void updateAMAvailable(int var1, int var2, int var3) throws MethodException;

    public void responseVolumelock(int var1, int var2, boolean var3) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

