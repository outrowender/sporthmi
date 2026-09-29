/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.atip.utils.generics.GCollection
 *  de.audi.atip.utils.generics.GList
 *  de.audi.atip.utils.generics.Generics
 */
package de.audi.app.terminalmode.smartphone.carlife;

import de.audi.app.terminalmode.IContext;
import de.audi.atip.log.LogChannel;
import de.audi.atip.utils.generics.GCollection;
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
    private static final String LOGCLASS;
    private final LogChannel logger;
    private final GList listeners = Generics.newCopyOnWriteArrayList();

    public CarlifeListenerDistributor(IContext iContext) {
        this.logger = iContext.getLogger().dsi();
    }

    public void addListener(DSICarlifeListener[] dSICarlifeListenerArray) {
        this.listeners.addAll((GCollection)Generics.newArrayList((Object[])dSICarlifeListenerArray));
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "[%1.asyncException]", (Object)"CarlifeListenerDistributor");
        }
        GIterator gIterator = this.listeners.iterator();
        while (gIterator.hasNext()) {
            ((DSICarlifeListener)gIterator.next()).asyncException(n, string, n2);
        }
    }

    @Override
    public void responseSetMode(Resource[] resourceArray, AppState[] appStateArray) {
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "[%1.responseSetMode]", (Object)"CarlifeListenerDistributor");
        }
        GIterator gIterator = this.listeners.iterator();
        while (gIterator.hasNext()) {
            ((DSICarlifeListener)gIterator.next()).responseSetMode(resourceArray, appStateArray);
        }
    }

    @Override
    public void updateCallState(CallState callState, int n) {
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "[%1.updateCallState]", (Object)"CarlifeListenerDistributor");
        }
        GIterator gIterator = this.listeners.iterator();
        while (gIterator.hasNext()) {
            ((DSICarlifeListener)gIterator.next()).updateCallState(callState, n);
        }
    }

    @Override
    public void updateNowPlayingData(TrackData trackData, int n) {
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "[%1.updateNowPlayingData]", (Object)"CarlifeListenerDistributor");
        }
        GIterator gIterator = this.listeners.iterator();
        while (gIterator.hasNext()) {
            ((DSICarlifeListener)gIterator.next()).updateNowPlayingData(trackData, n);
        }
    }

    @Override
    public void updatePlaybackState(PlaybackInfo playbackInfo, int n) {
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "[%1.updatePlaybackState]", (Object)"CarlifeListenerDistributor");
        }
        GIterator gIterator = this.listeners.iterator();
        while (gIterator.hasNext()) {
            ((DSICarlifeListener)gIterator.next()).updatePlaybackState(playbackInfo, n);
        }
    }

    @Override
    public void updatePlaymodeState(PlaymodeInfo playmodeInfo, int n) {
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "[%1.updatePlaymodeState]", (Object)"CarlifeListenerDistributor");
        }
        GIterator gIterator = this.listeners.iterator();
        while (gIterator.hasNext()) {
            ((DSICarlifeListener)gIterator.next()).updatePlaymodeState(playmodeInfo, n);
        }
    }

    @Override
    public void updatePlayposition(int n, int n2) {
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "[%1.updatePlayposition]", (Object)"CarlifeListenerDistributor");
        }
        GIterator gIterator = this.listeners.iterator();
        while (gIterator.hasNext()) {
            ((DSICarlifeListener)gIterator.next()).updatePlayposition(n, n2);
        }
    }

    @Override
    public void updateCoverArtUrl(ResourceLocator resourceLocator, int n) {
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "[%1.updateCoverArtUrl]", (Object)"CarlifeListenerDistributor");
        }
        GIterator gIterator = this.listeners.iterator();
        while (gIterator.hasNext()) {
            ((DSICarlifeListener)gIterator.next()).updateCoverArtUrl(resourceLocator, n);
        }
    }

    @Override
    public void updateNavigationNextTurnInfo(String string, int n, int n2, int n3, int n4, int n5) {
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "[%1.updateNavigationNextTurnInfo]", (Object)"CarlifeListenerDistributor");
        }
        GIterator gIterator = this.listeners.iterator();
        while (gIterator.hasNext()) {
            ((DSICarlifeListener)gIterator.next()).updateNavigationNextTurnInfo(string, n, n2, n3, n4, n5);
        }
    }

    @Override
    public void updateDeviceInfo(DeviceInfo deviceInfo, int n) {
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "[%1.updateDeviceInfo]", (Object)"CarlifeListenerDistributor");
        }
        GIterator gIterator = this.listeners.iterator();
        while (gIterator.hasNext()) {
            ((DSICarlifeListener)gIterator.next()).updateDeviceInfo(deviceInfo, n);
        }
    }

    @Override
    public void requestModeChange(Resource[] resourceArray, AppState[] appStateArray) {
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "[%1.requestModeChange]", (Object)"CarlifeListenerDistributor");
        }
        GIterator gIterator = this.listeners.iterator();
        while (gIterator.hasNext()) {
            ((DSICarlifeListener)gIterator.next()).requestModeChange(resourceArray, appStateArray);
        }
    }

    @Override
    public void updateVideoAvailable(boolean bl, int n) {
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "[%1.updateVideoAvailable]", (Object)"CarlifeListenerDistributor");
        }
        GIterator gIterator = this.listeners.iterator();
        while (gIterator.hasNext()) {
            ((DSICarlifeListener)gIterator.next()).updateVideoAvailable(bl, n);
        }
    }
}

