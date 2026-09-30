/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSIMapViewerLandmarkPlayerReply {
    public static final String IPL_COMM_UUID = "092f40d2-a577-5fe4-a881-b0305ea769fd";
    public static final String IPL_COMM_INTERFACE_KEY = "91c9169e-f7a0-5ecf-b7d7-a01090d43d37";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.62";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.62";

    public void showLandmark(float var1) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

