/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carplay;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carplay.AppState;
import org.dsi.ifc.carplay.CallState;
import org.dsi.ifc.carplay.DeviceInfo;
import org.dsi.ifc.carplay.PlaybackInfo;
import org.dsi.ifc.carplay.Resource;
import org.dsi.ifc.carplay.TelephonyState;
import org.dsi.ifc.carplay.TrackData;
import org.dsi.ifc.global.ResourceLocator;

public interface DSICarplayListener
extends DSIListener {
    public void updateMode(Resource[] var1, AppState[] var2, int var3);

    public void responseModeChange(Resource[] var1, AppState[] var2, int var3);

    public void requestBTDeactivation(String var1, int var2);

    public void updateDeviceInfo(DeviceInfo var1, int var2);

    public void updateCallState(CallState[] var1, int var2);

    public void updateTelephonyState(TelephonyState var1, int var2);

    public void updateNowPlayingData(TrackData var1, int var2);

    public void updatePlaybackState(PlaybackInfo var1, int var2);

    public void updatePlayposition(int var1, int var2);

    public void updateCoverArtUrl(ResourceLocator var1, int var2);

    public void updateTextInputState(int var1, int var2);

    public void duckAudio(int var1, double var2);

    public void unduckAudio(int var1);

    public void oemAppSelected();

    public void updateMainAudioType(int var1, int var2);
}

