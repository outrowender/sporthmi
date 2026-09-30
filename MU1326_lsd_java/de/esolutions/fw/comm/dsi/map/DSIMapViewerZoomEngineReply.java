/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map;

import de.esolutions.fw.comm.core.method.MethodException;

public interface DSIMapViewerZoomEngineReply {
    public static final String IPL_COMM_UUID = "e66e2809-cb0c-5c13-a5a3-2dbaeacc08ce";
    public static final String IPL_COMM_INTERFACE_KEY = "2ff38b18-4828-5546-afad-f644f0526a3d";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.62";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.62";

    public void updateAutoZoomEnabled(boolean var1, int var2) throws MethodException;

    public void updateManoeuvreZoomEnabled(boolean var1, int var2) throws MethodException;

    public void updateRecommendedZoom(float var1, int var2) throws MethodException;

    public void updateZoomEngineState(int var1, int var2) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

