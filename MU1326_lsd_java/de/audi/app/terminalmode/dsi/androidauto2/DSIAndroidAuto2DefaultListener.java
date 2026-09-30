/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.dsi.androidauto2;

import org.dsi.ifc.androidauto2.CallState;
import org.dsi.ifc.androidauto2.DSIAndroidAuto2Listener;
import org.dsi.ifc.androidauto2.PlaybackInfo;
import org.dsi.ifc.androidauto2.TelephonyState;
import org.dsi.ifc.androidauto2.TrackData;
import org.dsi.ifc.global.ResourceLocator;

public class DSIAndroidAuto2DefaultListener
implements DSIAndroidAuto2Listener {
    public void asyncException(int n, String string, int n2) {
    }

    public void videoFocusRequestNotification(int n, int n2) {
    }

    public void videoAvailable(boolean bl, int n) {
    }

    public void audioFocusRequestNotification(int n, int n2) {
    }

    public void audioAvailable(int n, boolean bl, int n2) {
    }

    public void voiceSessionNotification(int n, int n2) {
    }

    public void microphoneRequestNotification(int n, int n2) {
    }

    public void navFocusRequestNotification(int n, int n2) {
    }

    public void updateCallState(CallState[] callStateArray, int n) {
    }

    public void updateTelephonyState(TelephonyState telephonyState, int n) {
    }

    public void updateNowPlayingData(TrackData trackData, int n) {
    }

    public void updatePlaybackState(PlaybackInfo playbackInfo, int n) {
    }

    public void updatePlayposition(int n, int n2) {
    }

    public void updateCoverArtUrl(ResourceLocator resourceLocator, int n) {
    }

    public void updateNavigationNextTurnEvent(String string, int n, int n2, int n3, int n4, int n5) {
    }

    public void updateNavigationNextTurnDistance(int n, int n2, int n3) {
    }

    public void setExternalDestination(double d2, double d3, String string, String string2, int n) {
    }

    public void bluetoothPairingRequest(String string, int n) {
    }
}

