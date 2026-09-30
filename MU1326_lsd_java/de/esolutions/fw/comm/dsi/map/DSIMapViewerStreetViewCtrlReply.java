/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.map.PosInfo;
import org.dsi.ifc.map.Rect;
import org.dsi.ifc.map.StreetViewThumbnail;

public interface DSIMapViewerStreetViewCtrlReply {
    public static final String IPL_COMM_UUID = "4c3800c3-44b1-546a-8e1a-10175e766248";
    public static final String IPL_COMM_INTERFACE_KEY = "d48f38d9-e846-5a2d-9a56-a69068d291b5";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.62";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.62";

    public void updateStreetViewLoadStatus(int var1, int var2) throws MethodException;

    public void updateStreetViewAvailable(boolean var1, int var2) throws MethodException;

    public void updateStreetViewZoomListIndex(int var1, int var2) throws MethodException;

    public void updateStreetViewZoomList(float[] var1, int var2) throws MethodException;

    public void updateStreetViewThumbnails(StreetViewThumbnail[] var1, int var2) throws MethodException;

    public void streetViewEnabled(boolean var1) throws MethodException;

    public void streetViewVisible(boolean var1) throws MethodException;

    public void streetViewFreeze(boolean var1) throws MethodException;

    public void updatePosition(NavLocationWgs84 var1, int var2) throws MethodException;

    public void updateRotation(int var1, int var2, int var3) throws MethodException;

    public void getInfoForPosition(PosInfo[] var1) throws MethodException;

    public void snapshotResult(StreetViewThumbnail var1, int var2) throws MethodException;

    public void updateScreenViewPort(Rect var1, int var2) throws MethodException;

    public void updateStreetViewZoomLevel(float var1, int var2) throws MethodException;

    public void updateStreetViewPosition(NavLocationWgs84 var1, boolean var2, int var3) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

