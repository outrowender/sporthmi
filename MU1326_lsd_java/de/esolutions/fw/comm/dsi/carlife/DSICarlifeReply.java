/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carlife;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.carlife.AppState;
import org.dsi.ifc.carlife.CallState;
import org.dsi.ifc.carlife.DeviceInfo;
import org.dsi.ifc.carlife.PlaybackInfo;
import org.dsi.ifc.carlife.PlaymodeInfo;
import org.dsi.ifc.carlife.Resource;
import org.dsi.ifc.carlife.TrackData;
import org.dsi.ifc.global.ResourceLocator;

public interface DSICarlifeReply {
    public static final String IPL_COMM_UUID = "c032514d-43a6-5c21-9026-4b110dd7075c";
    public static final String IPL_COMM_INTERFACE_KEY = "7fc18f96-446f-5fb2-8dab-8fa8ec3dfd7c";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.2";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.2";

    public void responseSetMode(Resource[] var1, AppState[] var2) throws MethodException;

    public void updateCallState(CallState var1, int var2) throws MethodException;

    public void updateNowPlayingData(TrackData var1, int var2) throws MethodException;

    public void updatePlaybackState(PlaybackInfo var1, int var2) throws MethodException;

    public void updatePlaymodeState(PlaymodeInfo var1, int var2) throws MethodException;

    public void updatePlayposition(int var1, int var2) throws MethodException;

    public void updateCoverArtUrl(ResourceLocator var1, int var2) throws MethodException;

    public void updateNavigationNextTurnInfo(String var1, int var2, int var3, int var4, int var5, int var6) throws MethodException;

    public void updateDeviceInfo(DeviceInfo var1, int var2) throws MethodException;

    public void requestModeChange(Resource[] var1, AppState[] var2) throws MethodException;

    public void updateVideoAvailable(boolean var1, int var2) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

