/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.smartphone.carlife;

import de.audi.app.terminalmode.IContext;
import de.audi.atip.log.LogChannel;
import de.audi.atip.utils.generics.GIterator;
import de.audi.atip.utils.generics.GList;
import de.audi.atip.utils.generics.Generics;
import org.dsi.ifc.carlife.AppState;
import org.dsi.ifc.carlife.CallState;
import org.dsi.ifc.carlife.DSICarlifeListener;
import org.dsi.ifc.carlife.DeviceInfo;
import org.dsi.ifc.carlife.PlaybackInfo;
import org.dsi.ifc.carlife.PlaymodeInfo;
import org.dsi.ifc.carlife.Resource;
import org.dsi.ifc.carlife.TrackData;
import org.dsi.ifc.global.ResourceLocator;

public class CarlifeListenerDistributor
implements DSICarlifeListener {
    private static final String LOGCLASS = "CarlifeListenerDistributor";
    private final LogChannel logger;
    private final GList<DSICarlifeListener> listeners = Generics.newCopyOnWriteArrayList();

    public CarlifeListenerDistributor(IContext iContext) {
        this.logger = iContext.getLogger().dsi();
    }

    public void addListener(DSICarlifeListener[] dSICarlifeListenerArray) {
        this.listeners.addAll(Generics.newArrayList(dSICarlifeListenerArray));
    }

    public void asyncException(int n, String string, int n2) {
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.asyncException]", (Object)LOGCLASS);
        }
        GIterator<DSICarlifeListener> gIterator = this.listeners.iterator();
        while (gIterator.hasNext()) {
            gIterator.next().asyncException(n, string, n2);
        }
    }

    public void responseSetMode(Resource[] resourceArray, AppState[] appStateArray) {
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.responseSetMode]", (Object)LOGCLASS);
        }
        GIterator<DSICarlifeListener> gIterator = this.listeners.iterator();
        while (gIterator.hasNext()) {
            gIterator.next().responseSetMode(resourceArray, appStateArray);
        }
    }

    public void updateCallState(CallState callState, int n) {
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.updateCallState]", (Object)LOGCLASS);
        }
        GIterator<DSICarlifeListener> gIterator = this.listeners.iterator();
        while (gIterator.hasNext()) {
            gIterator.next().updateCallState(callState, n);
        }
    }

    public void updateNowPlayingData(TrackData trackData, int n) {
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.updateNowPlayingData]", (Object)LOGCLASS);
        }
        GIterator<DSICarlifeListener> gIterator = this.listeners.iterator();
        while (gIterator.hasNext()) {
            gIterator.next().updateNowPlayingData(trackData, n);
        }
    }

    public void updatePlaybackState(PlaybackInfo playbackInfo, int n) {
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.updatePlaybackState]", (Object)LOGCLASS);
        }
        GIterator<DSICarlifeListener> gIterator = this.listeners.iterator();
        while (gIterator.hasNext()) {
            gIterator.next().updatePlaybackState(playbackInfo, n);
        }
    }

    public void updatePlaymodeState(PlaymodeInfo playmodeInfo, int n) {
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.updatePlaymodeState]", (Object)LOGCLASS);
        }
        GIterator<DSICarlifeListener> gIterator = this.listeners.iterator();
        while (gIterator.hasNext()) {
            gIterator.next().updatePlaymodeState(playmodeInfo, n);
        }
    }

    public void updatePlayposition(int n, int n2) {
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.updatePlayposition]", (Object)LOGCLASS);
        }
        GIterator<DSICarlifeListener> gIterator = this.listeners.iterator();
        while (gIterator.hasNext()) {
            gIterator.next().updatePlayposition(n, n2);
        }
    }

    public void updateCoverArtUrl(ResourceLocator resourceLocator, int n) {
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.updateCoverArtUrl]", (Object)LOGCLASS);
        }
        GIterator<DSICarlifeListener> gIterator = this.listeners.iterator();
        while (gIterator.hasNext()) {
            gIterator.next().updateCoverArtUrl(resourceLocator, n);
        }
    }

    public void updateNavigationNextTurnInfo(String string, int n, int n2, int n3, int n4, int n5) {
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.updateNavigationNextTurnInfo]", (Object)LOGCLASS);
        }
        GIterator<DSICarlifeListener> gIterator = this.listeners.iterator();
        while (gIterator.hasNext()) {
            gIterator.next().updateNavigationNextTurnInfo(string, n, n2, n3, n4, n5);
        }
    }

    public void updateDeviceInfo(DeviceInfo deviceInfo, int n) {
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.updateDeviceInfo]", (Object)LOGCLASS);
        }
        GIterator<DSICarlifeListener> gIterator = this.listeners.iterator();
        while (gIterator.hasNext()) {
            gIterator.next().updateDeviceInfo(deviceInfo, n);
        }
    }

    public void requestModeChange(Resource[] resourceArray, AppState[] appStateArray) {
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.requestModeChange]", (Object)LOGCLASS);
        }
        GIterator<DSICarlifeListener> gIterator = this.listeners.iterator();
        while (gIterator.hasNext()) {
            gIterator.next().requestModeChange(resourceArray, appStateArray);
        }
    }

    public void updateVideoAvailable(boolean bl, int n) {
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.updateVideoAvailable]", (Object)LOGCLASS);
        }
        GIterator<DSICarlifeListener> gIterator = this.listeners.iterator();
        while (gIterator.hasNext()) {
            gIterator.next().updateVideoAvailable(bl, n);
        }
    }
}

