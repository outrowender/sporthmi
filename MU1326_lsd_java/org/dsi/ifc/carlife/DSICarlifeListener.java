/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carlife;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.carlife.AppState;
import org.dsi.ifc.carlife.CallState;
import org.dsi.ifc.carlife.DeviceInfo;
import org.dsi.ifc.carlife.PlaybackInfo;
import org.dsi.ifc.carlife.PlaymodeInfo;
import org.dsi.ifc.carlife.Resource;
import org.dsi.ifc.carlife.TrackData;
import org.dsi.ifc.global.ResourceLocator;

public interface DSICarlifeListener
extends DSIListener {
    public void responseSetMode(Resource[] var1, AppState[] var2);

    public void updateCallState(CallState var1, int var2);

    public void updateNowPlayingData(TrackData var1, int var2);

    public void updatePlaybackState(PlaybackInfo var1, int var2);

    public void updatePlaymodeState(PlaymodeInfo var1, int var2);

    public void updatePlayposition(int var1, int var2);

    public void updateCoverArtUrl(ResourceLocator var1, int var2);

    public void updateNavigationNextTurnInfo(String var1, int var2, int var3, int var4, int var5, int var6);

    public void updateDeviceInfo(DeviceInfo var1, int var2);

    public void requestModeChange(Resource[] var1, AppState[] var2);

    public void updateVideoAvailable(boolean var1, int var2);
}

