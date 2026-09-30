/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carplay;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.carplay.AppState;
import org.dsi.ifc.carplay.CallState;
import org.dsi.ifc.carplay.DeviceInfo;
import org.dsi.ifc.carplay.PlaybackInfo;
import org.dsi.ifc.carplay.Resource;
import org.dsi.ifc.carplay.TelephonyState;
import org.dsi.ifc.carplay.TrackData;
import org.dsi.ifc.global.ResourceLocator;

public interface DSICarplayReply {
    public static final String IPL_COMM_UUID = "da412c88-5342-52b3-9176-facb675e1711";
    public static final String IPL_COMM_INTERFACE_KEY = "366c0fdd-ac39-51f8-b0d4-a55cea6de432";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.10";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.10";

    public void updateMode(Resource[] var1, AppState[] var2, int var3) throws MethodException;

    public void responseModeChange(Resource[] var1, AppState[] var2, int var3) throws MethodException;

    public void requestBTDeactivation(String var1, int var2) throws MethodException;

    public void updateDeviceInfo(DeviceInfo var1, int var2) throws MethodException;

    public void updateCallState(CallState[] var1, int var2) throws MethodException;

    public void updateTelephonyState(TelephonyState var1, int var2) throws MethodException;

    public void updateNowPlayingData(TrackData var1, int var2) throws MethodException;

    public void updatePlaybackState(PlaybackInfo var1, int var2) throws MethodException;

    public void updatePlayposition(int var1, int var2) throws MethodException;

    public void updateCoverArtUrl(ResourceLocator var1, int var2) throws MethodException;

    public void updateTextInputState(int var1, int var2) throws MethodException;

    public void duckAudio(int var1, double var2) throws MethodException;

    public void unduckAudio(int var1) throws MethodException;

    public void oemAppSelected() throws MethodException;

    public void updateMainAudioType(int var1, int var2) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

