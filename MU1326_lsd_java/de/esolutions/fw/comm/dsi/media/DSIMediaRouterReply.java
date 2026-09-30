/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.media;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.media.AudioRoute;

public interface DSIMediaRouterReply {
    public static final String IPL_COMM_UUID = "98796422-df67-5127-a3f4-765a519018ce";
    public static final String IPL_COMM_INTERFACE_KEY = "ab64d699-baa3-575a-9486-0e4b0bfe3b6d";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.52";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.52";

    public void responseConfiguration(int var1, int var2) throws MethodException;

    public void responseClientStatus(int var1, int var2) throws MethodException;

    public void updateStreamingStatus(int var1, int var2, int var3) throws MethodException;

    public void updateActiveAudioRoutes(AudioRoute[] var1, int var2) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

