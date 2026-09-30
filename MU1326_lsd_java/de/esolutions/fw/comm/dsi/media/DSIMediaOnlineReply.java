/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.media;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSIMediaOnlineReply {
    public static final String IPL_COMM_UUID = "ccda6cca-562b-5544-9368-aeb30d715a20";
    public static final String IPL_COMM_INTERFACE_KEY = "5c2d5900-eb57-5213-9f61-f1c5d8d4b591";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.52";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.52";

    public void updateBufferState(int var1, int var2) throws MethodException;

    public void updateBufferFillInfo(int var1, int var2, int var3) throws MethodException;

    public void updateAudioSettings(int var1, int var2, int var3) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

