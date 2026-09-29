/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.atip.utils.generics.GCollection
 *  de.audi.atip.utils.generics.GList
 *  de.audi.atip.utils.generics.Generics
 */
package de.audi.app.terminalmode.smartphone.androidauto2;

import de.audi.app.terminalmode.IContext;
import de.audi.atip.log.LogChannel;
import de.audi.atip.utils.generics.GCollection;
import de.audi.atip.utils.generics.GIterator;
import de.audi.atip.utils.generics.GList;
import de.audi.atip.utils.generics.Generics;
import org.dsi.ifc.androidauto2.CallState;
import org.dsi.ifc.androidauto2.DSIAndroidAuto2Listener;
import org.dsi.ifc.androidauto2.PlaybackInfo;
import org.dsi.ifc.androidauto2.TelephonyState;
import org.dsi.ifc.androidauto2.TrackData;
import org.dsi.ifc.global.ResourceLocator;

public class AndroidAuto2ListenerDistributor
implements DSIAndroidAuto2Listener {
    private static final String LOGCLASS;
    private final LogChannel logger;
    private final GList listeners = Generics.newCopyOnWriteArrayList();

    public AndroidAuto2ListenerDistributor(IContext iContext) {
        this.logger = iContext.getLogger().dsi();
    }

    public void addListener(DSIAndroidAuto2Listener[] dSIAndroidAuto2ListenerArray) {
        this.listeners.addAll((GCollection)Generics.newArrayList((Object[])dSIAndroidAuto2ListenerArray));
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "[%1.asyncException]", (Object)"AndroidAuto2ListenerDistributor");
        }
        GIterator gIterator = this.listeners.iterator();
        while (gIterator.hasNext()) {
            ((DSIAndroidAuto2Listener)gIterator.next()).asyncException(n, string, n2);
        }
    }

    @Override
    public void videoFocusRequestNotification(int n, int n2) {
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "[%1.videoFocusRequestNotification]", (Object)"AndroidAuto2ListenerDistributor");
        }
        GIterator gIterator = this.listeners.iterator();
        while (gIterator.hasNext()) {
            ((DSIAndroidAuto2Listener)gIterator.next()).videoFocusRequestNotification(n, n2);
        }
    }

    @Override
    public void videoAvailable(boolean bl, int n) {
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "[%1.videoAvailable]", (Object)"AndroidAuto2ListenerDistributor");
        }
        GIterator gIterator = this.listeners.iterator();
        while (gIterator.hasNext()) {
            ((DSIAndroidAuto2Listener)gIterator.next()).videoAvailable(bl, n);
        }
    }

    @Override
    public void audioFocusRequestNotification(int n, int n2) {
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "[%1.audioFocusRequestNotification]", (Object)"AndroidAuto2ListenerDistributor");
        }
        GIterator gIterator = this.listeners.iterator();
        while (gIterator.hasNext()) {
            ((DSIAndroidAuto2Listener)gIterator.next()).audioFocusRequestNotification(n, n2);
        }
    }

    @Override
    public void audioAvailable(int n, boolean bl, int n2) {
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "[%1.audioAvailable]", (Object)"AndroidAuto2ListenerDistributor");
        }
        GIterator gIterator = this.listeners.iterator();
        while (gIterator.hasNext()) {
            ((DSIAndroidAuto2Listener)gIterator.next()).audioAvailable(n, bl, n2);
        }
    }

    @Override
    public void voiceSessionNotification(int n, int n2) {
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "[%1.voiceSessionNotification]", (Object)"AndroidAuto2ListenerDistributor");
        }
        GIterator gIterator = this.listeners.iterator();
        while (gIterator.hasNext()) {
            ((DSIAndroidAuto2Listener)gIterator.next()).voiceSessionNotification(n, n2);
        }
    }

    @Override
    public void microphoneRequestNotification(int n, int n2) {
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "[%1.microphoneRequestNotification]", (Object)"AndroidAuto2ListenerDistributor");
        }
        GIterator gIterator = this.listeners.iterator();
        while (gIterator.hasNext()) {
            ((DSIAndroidAuto2Listener)gIterator.next()).microphoneRequestNotification(n, n2);
        }
    }

    @Override
    public void navFocusRequestNotification(int n, int n2) {
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "[%1.navFocusRequestNotification]", (Object)"AndroidAuto2ListenerDistributor");
        }
        GIterator gIterator = this.listeners.iterator();
        while (gIterator.hasNext()) {
            ((DSIAndroidAuto2Listener)gIterator.next()).navFocusRequestNotification(n, n2);
        }
    }

    @Override
    public void updateCallState(CallState[] callStateArray, int n) {
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "[%1.updateCallState]", (Object)"AndroidAuto2ListenerDistributor");
        }
        GIterator gIterator = this.listeners.iterator();
        while (gIterator.hasNext()) {
            ((DSIAndroidAuto2Listener)gIterator.next()).updateCallState(callStateArray, n);
        }
    }

    @Override
    public void updateTelephonyState(TelephonyState telephonyState, int n) {
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "[%1.updateTelephonyState]", (Object)"AndroidAuto2ListenerDistributor");
        }
        GIterator gIterator = this.listeners.iterator();
        while (gIterator.hasNext()) {
            ((DSIAndroidAuto2Listener)gIterator.next()).updateTelephonyState(telephonyState, n);
        }
    }

    @Override
    public void updateNowPlayingData(TrackData trackData, int n) {
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "[%1.updateNowPlayingData]", (Object)"AndroidAuto2ListenerDistributor");
        }
        GIterator gIterator = this.listeners.iterator();
        while (gIterator.hasNext()) {
            ((DSIAndroidAuto2Listener)gIterator.next()).updateNowPlayingData(trackData, n);
        }
    }

    @Override
    public void updatePlaybackState(PlaybackInfo playbackInfo, int n) {
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "[%1.updatePlaybackState]", (Object)"AndroidAuto2ListenerDistributor");
        }
        GIterator gIterator = this.listeners.iterator();
        while (gIterator.hasNext()) {
            ((DSIAndroidAuto2Listener)gIterator.next()).updatePlaybackState(playbackInfo, n);
        }
    }

    @Override
    public void updatePlayposition(int n, int n2) {
        GIterator gIterator = this.listeners.iterator();
        while (gIterator.hasNext()) {
            ((DSIAndroidAuto2Listener)gIterator.next()).updatePlayposition(n, n2);
        }
    }

    @Override
    public void updateCoverArtUrl(ResourceLocator resourceLocator, int n) {
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "[%1.updateCoverArtUrl]", (Object)"AndroidAuto2ListenerDistributor");
        }
        GIterator gIterator = this.listeners.iterator();
        while (gIterator.hasNext()) {
            ((DSIAndroidAuto2Listener)gIterator.next()).updateCoverArtUrl(resourceLocator, n);
        }
    }

    @Override
    public void updateNavigationNextTurnEvent(String string, int n, int n2, int n3, int n4, int n5) {
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "[%1.updateNavigationNextTurnEvent]", (Object)"AndroidAuto2ListenerDistributor");
        }
        GIterator gIterator = this.listeners.iterator();
        while (gIterator.hasNext()) {
            ((DSIAndroidAuto2Listener)gIterator.next()).updateNavigationNextTurnEvent(string, n, n2, n3, n4, n5);
        }
    }

    @Override
    public void updateNavigationNextTurnDistance(int n, int n2, int n3) {
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "[%1.updateNavigationNextTurnDistance]", (Object)"AndroidAuto2ListenerDistributor");
        }
        GIterator gIterator = this.listeners.iterator();
        while (gIterator.hasNext()) {
            ((DSIAndroidAuto2Listener)gIterator.next()).updateNavigationNextTurnDistance(n, n2, n3);
        }
    }

    @Override
    public void setExternalDestination(double d2, double d3, String string, String string2, int n) {
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "[%1.setExternalDestination]", (Object)"AndroidAuto2ListenerDistributor");
        }
        GIterator gIterator = this.listeners.iterator();
        while (gIterator.hasNext()) {
            ((DSIAndroidAuto2Listener)gIterator.next()).setExternalDestination(d2, d3, string, string2, n);
        }
    }

    @Override
    public void bluetoothPairingRequest(String string, int n) {
        if (this.logger.isDebug2()) {
            this.logger.log(14808325, "[%1.bluetoothPairingRequest]", (Object)"AndroidAuto2ListenerDistributor");
        }
        GIterator gIterator = this.listeners.iterator();
        while (gIterator.hasNext()) {
            ((DSIAndroidAuto2Listener)gIterator.next()).bluetoothPairingRequest(string, n);
        }
    }
}

