/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.logging;

import de.audi.app.terminalmode.logging.Arrays2;
import de.audi.app.terminalmode.logging.DSIListenerLoggingDecorator;
import de.audi.atip.log.LogChannel;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.carlife.AppState;
import org.dsi.ifc.carlife.CallState;
import org.dsi.ifc.carlife.DSICarlifeListener;
import org.dsi.ifc.carlife.DeviceInfo;
import org.dsi.ifc.carlife.PlaybackInfo;
import org.dsi.ifc.carlife.PlaymodeInfo;
import org.dsi.ifc.carlife.Resource;
import org.dsi.ifc.carlife.TrackData;
import org.dsi.ifc.global.ResourceLocator;

public class DSICarlifeListenerLoggingDecorator
extends DSIListenerLoggingDecorator
implements DSICarlifeListener {
    private final DSICarlifeListener wrappee;

    public DSICarlifeListenerLoggingDecorator(DSICarlifeListener dSICarlifeListener, LogChannel logChannel, int n) {
        super(dSICarlifeListener, logChannel, n, "DSICarlifeListener");
        this.wrappee = dSICarlifeListener;
    }

    public void responseSetMode(Resource[] resourceArray, AppState[] appStateArray) {
        this.lc.log(this.level, "<- [DSICarlifeListener.responseSetMode] %1 %2", (Object)Arrays2.toString(resourceArray), (Object)Arrays2.toString(appStateArray));
        this.wrappee.responseSetMode(resourceArray, appStateArray);
    }

    public void updateCallState(CallState callState, int n) {
        this.lc.log(this.level, "<- [DSICarlifeListener.updateCallState] %1 %2", (Object)callState, (long)n);
        this.wrappee.updateCallState(callState, n);
    }

    public void updateNowPlayingData(TrackData trackData, int n) {
        this.lc.log(this.level, "<- [DSICarlifeListener.updateNowPlayingData] %1 %2", (Object)trackData, (long)n);
        this.wrappee.updateNowPlayingData(trackData, n);
    }

    public void updatePlaybackState(PlaybackInfo playbackInfo, int n) {
        this.lc.log(this.level, "<- [DSICarlifeListener.updatePlaybackState] %1 %2", (Object)playbackInfo, (long)n);
        this.wrappee.updatePlaybackState(playbackInfo, n);
    }

    public void updatePlaymodeState(PlaymodeInfo playmodeInfo, int n) {
        this.lc.log(this.level, "<- [DSICarlifeListener.updatePlaymodeState] %1 %2", (Object)playmodeInfo, (long)n);
        this.wrappee.updatePlaymodeState(playmodeInfo, n);
    }

    public void updatePlayposition(int n, int n2) {
        this.lc.log(this.level, "<- [DSICarlifeListener.updatePlayposition]", (long)n, (long)n2);
        this.wrappee.updatePlayposition(n, n2);
    }

    public void updateCoverArtUrl(ResourceLocator resourceLocator, int n) {
        this.lc.log(this.level, "<- [DSICarlifeListener.updateCoverArtUrl] %1 %2", (Object)resourceLocator, (long)n);
        this.wrappee.updateCoverArtUrl(resourceLocator, n);
    }

    public void updateNavigationNextTurnInfo(String string, int n, int n2, int n3, int n4, int n5) {
        Buffer buffer = new Buffer(100);
        buffer.append("road=");
        buffer.append(string);
        buffer.append(" event=");
        buffer.append(n);
        buffer.append(" turnSide=");
        buffer.append(n2);
        buffer.append(" distance=");
        buffer.append(n3);
        buffer.append(" time=");
        buffer.append(n4);
        buffer.append(" valid=");
        buffer.append(n5);
        this.lc.log(this.level, "<- [DSICarlifeListener.updateNavigationNextTurnInfo] %1", (Object)buffer.toString());
        this.wrappee.updateNavigationNextTurnInfo(string, n, n2, n3, n4, n5);
    }

    public void updateDeviceInfo(DeviceInfo deviceInfo, int n) {
        this.lc.log(this.level, "<- [DSICarlifeListener.updateDeviceInfo] %1 %2", (Object)deviceInfo, (long)n);
        this.wrappee.updateDeviceInfo(deviceInfo, n);
    }

    public void requestModeChange(Resource[] resourceArray, AppState[] appStateArray) {
        this.lc.log(this.level, "<- [DSICarlifeListener.requestModeChange] %1 %2", (Object)Arrays2.toString(resourceArray), (Object)Arrays2.toString(appStateArray));
        this.wrappee.requestModeChange(resourceArray, appStateArray);
    }

    public void updateVideoAvailable(boolean bl, int n) {
        this.lc.log(this.level, "<- [DSICarlifeListener.updateVideoAvailable] %1 %2", bl, (long)n);
        this.wrappee.updateVideoAvailable(bl, n);
    }
}

