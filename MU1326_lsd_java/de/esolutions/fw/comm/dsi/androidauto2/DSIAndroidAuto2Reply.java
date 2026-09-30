/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.androidauto2;

import de.esolutions.fw.comm.core.method.MethodException;
import org.dsi.ifc.androidauto2.CallState;
import org.dsi.ifc.androidauto2.PlaybackInfo;
import org.dsi.ifc.androidauto2.TelephonyState;
import org.dsi.ifc.androidauto2.TrackData;
import org.dsi.ifc.global.ResourceLocator;

public interface DSIAndroidAuto2Reply {
    public static final String IPL_COMM_UUID = "1109a8e3-3caa-5724-b33f-de936bc4e076";
    public static final String IPL_COMM_INTERFACE_KEY = "3c1002ff-1bb7-599d-83c3-6670b394036e";
    public static final String IPL_COMM_INTERFACE_VERSION = "2.11.2";
    public static final String IPL_COMM_MODULE_VERSION = "2.11.2";

    public void videoFocusRequestNotification(int var1, int var2) throws MethodException;

    public void videoAvailable(boolean var1, int var2) throws MethodException;

    public void audioFocusRequestNotification(int var1, int var2) throws MethodException;

    public void audioAvailable(int var1, boolean var2, int var3) throws MethodException;

    public void voiceSessionNotification(int var1, int var2) throws MethodException;

    public void microphoneRequestNotification(int var1, int var2) throws MethodException;

    public void navFocusRequestNotification(int var1, int var2) throws MethodException;

    public void updateCallState(CallState[] var1, int var2) throws MethodException;

    public void updateTelephonyState(TelephonyState var1, int var2) throws MethodException;

    public void updateNowPlayingData(TrackData var1, int var2) throws MethodException;

    public void updatePlaybackState(PlaybackInfo var1, int var2) throws MethodException;

    public void updatePlayposition(int var1, int var2) throws MethodException;

    public void updateCoverArtUrl(ResourceLocator var1, int var2) throws MethodException;

    public void updateNavigationNextTurnEvent(String var1, int var2, int var3, int var4, int var5, int var6) throws MethodException;

    public void updateNavigationNextTurnDistance(int var1, int var2, int var3) throws MethodException;

    public void setExternalDestination(double var1, double var3, String var5, String var6, int var7) throws MethodException;

    public void bluetoothPairingRequest(String var1, int var2) throws MethodException;

    public void asyncException(int var1, String var2, int var3) throws MethodException;

    public void yyIndication(String var1, String var2) throws MethodException;
}

