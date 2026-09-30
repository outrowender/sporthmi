/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.smartphone.androidauto2;

import de.audi.app.terminalmode.IContext;
import de.audi.atip.log.LogChannel;
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
    private static final String LOGCLASS = "AndroidAuto2ListenerDistributor";
    private final LogChannel logger;
    private final GList<DSIAndroidAuto2Listener> listeners = Generics.newCopyOnWriteArrayList();

    public AndroidAuto2ListenerDistributor(IContext iContext) {
        this.logger = iContext.getLogger().dsi();
    }

    public void addListener(DSIAndroidAuto2Listener[] dSIAndroidAuto2ListenerArray) {
        this.listeners.addAll(Generics.newArrayList(dSIAndroidAuto2ListenerArray));
    }

    public void asyncException(int n, String string, int n2) {
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.asyncException]", (Object)LOGCLASS);
        }
        GIterator<DSIAndroidAuto2Listener> gIterator = this.listeners.iterator();
        while (gIterator.hasNext()) {
            gIterator.next().asyncException(n, string, n2);
        }
    }

    public void videoFocusRequestNotification(int n, int n2) {
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.videoFocusRequestNotification]", (Object)LOGCLASS);
        }
        GIterator<DSIAndroidAuto2Listener> gIterator = this.listeners.iterator();
        while (gIterator.hasNext()) {
            gIterator.next().videoFocusRequestNotification(n, n2);
        }
    }

    public void videoAvailable(boolean bl, int n) {
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.videoAvailable]", (Object)LOGCLASS);
        }
        GIterator<DSIAndroidAuto2Listener> gIterator = this.listeners.iterator();
        while (gIterator.hasNext()) {
            gIterator.next().videoAvailable(bl, n);
        }
    }

    public void audioFocusRequestNotification(int n, int n2) {
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.audioFocusRequestNotification]", (Object)LOGCLASS);
        }
        GIterator<DSIAndroidAuto2Listener> gIterator = this.listeners.iterator();
        while (gIterator.hasNext()) {
            gIterator.next().audioFocusRequestNotification(n, n2);
        }
    }

    public void audioAvailable(int n, boolean bl, int n2) {
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.audioAvailable]", (Object)LOGCLASS);
        }
        GIterator<DSIAndroidAuto2Listener> gIterator = this.listeners.iterator();
        while (gIterator.hasNext()) {
            gIterator.next().audioAvailable(n, bl, n2);
        }
    }

    public void voiceSessionNotification(int n, int n2) {
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.voiceSessionNotification]", (Object)LOGCLASS);
        }
        GIterator<DSIAndroidAuto2Listener> gIterator = this.listeners.iterator();
        while (gIterator.hasNext()) {
            gIterator.next().voiceSessionNotification(n, n2);
        }
    }

    public void microphoneRequestNotification(int n, int n2) {
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.microphoneRequestNotification]", (Object)LOGCLASS);
        }
        GIterator<DSIAndroidAuto2Listener> gIterator = this.listeners.iterator();
        while (gIterator.hasNext()) {
            gIterator.next().microphoneRequestNotification(n, n2);
        }
    }

    public void navFocusRequestNotification(int n, int n2) {
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.navFocusRequestNotification]", (Object)LOGCLASS);
        }
        GIterator<DSIAndroidAuto2Listener> gIterator = this.listeners.iterator();
        while (gIterator.hasNext()) {
            gIterator.next().navFocusRequestNotification(n, n2);
        }
    }

    public void updateCallState(CallState[] callStateArray, int n) {
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.updateCallState]", (Object)LOGCLASS);
        }
        GIterator<DSIAndroidAuto2Listener> gIterator = this.listeners.iterator();
        while (gIterator.hasNext()) {
            gIterator.next().updateCallState(callStateArray, n);
        }
    }

    public void updateTelephonyState(TelephonyState telephonyState, int n) {
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.updateTelephonyState]", (Object)LOGCLASS);
        }
        GIterator<DSIAndroidAuto2Listener> gIterator = this.listeners.iterator();
        while (gIterator.hasNext()) {
            gIterator.next().updateTelephonyState(telephonyState, n);
        }
    }

    public void updateNowPlayingData(TrackData trackData, int n) {
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.updateNowPlayingData]", (Object)LOGCLASS);
        }
        GIterator<DSIAndroidAuto2Listener> gIterator = this.listeners.iterator();
        while (gIterator.hasNext()) {
            gIterator.next().updateNowPlayingData(trackData, n);
        }
    }

    public void updatePlaybackState(PlaybackInfo playbackInfo, int n) {
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.updatePlaybackState]", (Object)LOGCLASS);
        }
        GIterator<DSIAndroidAuto2Listener> gIterator = this.listeners.iterator();
        while (gIterator.hasNext()) {
            gIterator.next().updatePlaybackState(playbackInfo, n);
        }
    }

    public void updatePlayposition(int n, int n2) {
        GIterator<DSIAndroidAuto2Listener> gIterator = this.listeners.iterator();
        while (gIterator.hasNext()) {
            gIterator.next().updatePlayposition(n, n2);
        }
    }

    public void updateCoverArtUrl(ResourceLocator resourceLocator, int n) {
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.updateCoverArtUrl]", (Object)LOGCLASS);
        }
        GIterator<DSIAndroidAuto2Listener> gIterator = this.listeners.iterator();
        while (gIterator.hasNext()) {
            gIterator.next().updateCoverArtUrl(resourceLocator, n);
        }
    }

    public void updateNavigationNextTurnEvent(String string, int n, int n2, int n3, int n4, int n5) {
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.updateNavigationNextTurnEvent]", (Object)LOGCLASS);
        }
        GIterator<DSIAndroidAuto2Listener> gIterator = this.listeners.iterator();
        while (gIterator.hasNext()) {
            gIterator.next().updateNavigationNextTurnEvent(string, n, n2, n3, n4, n5);
        }
    }

    public void updateNavigationNextTurnDistance(int n, int n2, int n3) {
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.updateNavigationNextTurnDistance]", (Object)LOGCLASS);
        }
        GIterator<DSIAndroidAuto2Listener> gIterator = this.listeners.iterator();
        while (gIterator.hasNext()) {
            gIterator.next().updateNavigationNextTurnDistance(n, n2, n3);
        }
    }

    public void setExternalDestination(double d2, double d3, String string, String string2, int n) {
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.setExternalDestination]", (Object)LOGCLASS);
        }
        GIterator<DSIAndroidAuto2Listener> gIterator = this.listeners.iterator();
        while (gIterator.hasNext()) {
            gIterator.next().setExternalDestination(d2, d3, string, string2, n);
        }
    }

    public void bluetoothPairingRequest(String string, int n) {
        if (this.logger.isDebug2()) {
            this.logger.log(100000000, "[%1.bluetoothPairingRequest]", (Object)LOGCLASS);
        }
        GIterator<DSIAndroidAuto2Listener> gIterator = this.listeners.iterator();
        while (gIterator.hasNext()) {
            gIterator.next().bluetoothPairingRequest(string, n);
        }
    }
}

