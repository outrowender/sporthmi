/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.androidauto;

import org.dsi.ifc.androidauto.AppState;
import org.dsi.ifc.androidauto.AppStateRequest;
import org.dsi.ifc.androidauto.CallState;
import org.dsi.ifc.androidauto.PlaybackInfo;
import org.dsi.ifc.androidauto.Resource;
import org.dsi.ifc.androidauto.ResourceRequest;
import org.dsi.ifc.androidauto.TelephonyState;
import org.dsi.ifc.androidauto.TrackData;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.ResourceLocator;

public interface DSIAndroidAutoListener
extends DSIListener {
    public void setMode(Resource[] var1, AppState[] var2, int var3);

    public void requestModeChange(ResourceRequest[] var1, AppStateRequest[] var2, int var3);

    public void updateCallState(CallState[] var1, int var2);

    public void updateTelephonyState(TelephonyState var1, int var2);

    public void updateNowPlayingData(TrackData var1, int var2);

    public void updatePlaybackState(PlaybackInfo var1, int var2);

    public void updatePlayposition(int var1, int var2);

    public void updateCoverArtUrl(ResourceLocator var1, int var2);

    public void updateNavigationNextTurnEvent(String var1, int var2, int var3, int var4, int var5, int var6);

    public void updateNavigationNextTurnDistance(int var1, int var2, int var3);

    public void setExternalDestination(double var1, double var3, String var5, String var6);
}

