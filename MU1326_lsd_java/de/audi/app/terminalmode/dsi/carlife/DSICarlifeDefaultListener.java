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
    public void asyncException(int n, String string, int n2) {
    }

    public void responseSetMode(Resource[] resourceArray, AppState[] appStateArray) {
    }

    public void updateCallState(CallState callState, int n) {
    }

    public void updateNowPlayingData(TrackData trackData, int n) {
    }

    public void updatePlaybackState(PlaybackInfo playbackInfo, int n) {
    }

    public void updatePlaymodeState(PlaymodeInfo playmodeInfo, int n) {
    }

    public void updatePlayposition(int n, int n2) {
    }

    public void updateCoverArtUrl(ResourceLocator resourceLocator, int n) {
    }

    public void updateNavigationNextTurnInfo(String string, int n, int n2, int n3, int n4, int n5) {
    }

    public void updateDeviceInfo(DeviceInfo deviceInfo, int n) {
    }

    public void requestModeChange(Resource[] resourceArray, AppState[] appStateArray) {
    }

    public void updateVideoAvailable(boolean bl, int n) {
    }
}

