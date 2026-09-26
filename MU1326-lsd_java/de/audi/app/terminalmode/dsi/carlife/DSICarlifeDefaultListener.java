/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi.carlife;

import org.dsi.ifc.carlife.AppState;
import org.dsi.ifc.carlife.CallState;
import org.dsi.ifc.carlife.DSICarlifeListener;
import org.dsi.ifc.carlife.DeviceInfo;
import org.dsi.ifc.carlife.PlaybackInfo;
import org.dsi.ifc.carlife.PlaymodeInfo;
import org.dsi.ifc.carlife.Resource;
import org.dsi.ifc.carlife.TrackData;
import org.dsi.ifc.global.ResourceLocator;

public class DSICarlifeDefaultListener
implements DSICarlifeListener {
    @Override
    public void asyncException(int n, String string, int n2) {
    }

    @Override
    public void responseSetMode(Resource[] resourceArray, AppState[] appStateArray) {
    }

    @Override
    public void updateCallState(CallState callState, int n) {
    }

    @Override
    public void updateNowPlayingData(TrackData trackData, int n) {
    }

    @Override
    public void updatePlaybackState(PlaybackInfo playbackInfo, int n) {
    }

    @Override
    public void updatePlaymodeState(PlaymodeInfo playmodeInfo, int n) {
    }

    @Override
    public void updatePlayposition(int n, int n2) {
    }

    @Override
    public void updateCoverArtUrl(ResourceLocator resourceLocator, int n) {
    }

    @Override
    public void updateNavigationNextTurnInfo(String string, int n, int n2, int n3, int n4, int n5) {
    }

    @Override
    public void updateDeviceInfo(DeviceInfo deviceInfo, int n) {
    }

    @Override
    public void requestModeChange(Resource[] resourceArray, AppState[] appStateArray) {
    }

    @Override
    public void updateVideoAvailable(boolean bl, int n) {
    }
}

