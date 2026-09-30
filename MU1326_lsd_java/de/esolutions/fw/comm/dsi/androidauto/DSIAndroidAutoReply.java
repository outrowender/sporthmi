/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.androidauto;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.androidauto.AppState;
import org.dsi.ifc.androidauto.AppStateRequest;
import org.dsi.ifc.androidauto.CallState;
import org.dsi.ifc.androidauto.PlaybackInfo;
import org.dsi.ifc.androidauto.Resource;
import org.dsi.ifc.androidauto.ResourceRequest;
import org.dsi.ifc.androidauto.TelephonyState;
import org.dsi.ifc.androidauto.TrackData;
import org.dsi.ifc.global.ResourceLocator;

public interface DSIAndroidAutoReply {
    public static final String IPL_COMM_UUID = "4b8132b6-9c15-536c-897e-0843cc6a6f3d";
    public static final String IPL_COMM_INTERFACE_KEY = "e4cf600b-682a-591f-bebd-4b8ed93ce25d";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.3";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.3";

    public void setMode(Resource[] var1, AppState[] var2, int var3) throws MethodException;

    public void requestModeChange(ResourceRequest[] var1, AppStateRequest[] var2, int var3) throws MethodException;

    public void updateCallState(CallState[] var1, int var2) throws MethodException;

    public void updateTelephonyState(TelephonyState var1, int var2) throws MethodException;

    public void updateNowPlayingData(TrackData var1, int var2) throws MethodException;

    public void updatePlaybackState(PlaybackInfo var1, int var2) throws MethodException;

    public void updatePlayposition(int var1, int var2) throws MethodException;

    public void updateCoverArtUrl(ResourceLocator var1, int var2) throws MethodException;

    public void updateNavigationNextTurnEvent(String var1, int var2, int var3, int var4, int var5, int var6) throws MethodException;

    public void updateNavigationNextTurnDistance(int var1, int var2, int var3) throws MethodException;

    public void setExternalDestination(double var1, double var3, String var5, String var6) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

