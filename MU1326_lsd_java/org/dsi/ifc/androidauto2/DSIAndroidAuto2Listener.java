/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.androidauto2;

import org.dsi.ifc.androidauto2.CallState;
import org.dsi.ifc.androidauto2.PlaybackInfo;
import org.dsi.ifc.androidauto2.TelephonyState;
import org.dsi.ifc.androidauto2.TrackData;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.ResourceLocator;

public interface DSIAndroidAuto2Listener
extends DSIListener {
    public void videoFocusRequestNotification(int var1, int var2);

    public void videoAvailable(boolean var1, int var2);

    public void audioFocusRequestNotification(int var1, int var2);

    public void audioAvailable(int var1, boolean var2, int var3);

    public void voiceSessionNotification(int var1, int var2);

    public void microphoneRequestNotification(int var1, int var2);

    public void navFocusRequestNotification(int var1, int var2);

    public void updateCallState(CallState[] var1, int var2);

    public void updateTelephonyState(TelephonyState var1, int var2);

    public void updateNowPlayingData(TrackData var1, int var2);

    public void updatePlaybackState(PlaybackInfo var1, int var2);

    public void updatePlayposition(int var1, int var2);

    public void updateCoverArtUrl(ResourceLocator var1, int var2);

    public void updateNavigationNextTurnEvent(String var1, int var2, int var3, int var4, int var5, int var6);

    public void updateNavigationNextTurnDistance(int var1, int var2, int var3);

    public void setExternalDestination(double var1, double var3, String var5, String var6, int var7);

    public void bluetoothPairingRequest(String var1, int var2);
}

