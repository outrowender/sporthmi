/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.terminalmode;

import de.audi.atip.interapp.terminalmode.AppConnectDeviceContainer;
import de.audi.atip.interapp.terminalmode.MediaPlayInfoContainer;
import de.audi.atip.interapp.terminalmode.TrackInfoContainer;

public interface ITMExlapListener {
    default public void updateAppConnectDevice(AppConnectDeviceContainer appConnectDeviceContainer) {
    }

    default public void updateMediaPlayInfo(MediaPlayInfoContainer mediaPlayInfoContainer) {
    }

    default public void updateCurrentTrackInfo(TrackInfoContainer trackInfoContainer) {
    }
}

