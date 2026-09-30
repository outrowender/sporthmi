/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.terminalmode;

import de.audi.atip.interapp.terminalmode.AppConnectDeviceContainer;
import de.audi.atip.interapp.terminalmode.MediaPlayInfoContainer;
import de.audi.atip.interapp.terminalmode.TrackInfoContainer;

public interface ITMExlapListener {
    public void updateAppConnectDevice(AppConnectDeviceContainer var1);

    public void updateMediaPlayInfo(MediaPlayInfoContainer var1);

    public void updateCurrentTrackInfo(TrackInfoContainer var1);
}

