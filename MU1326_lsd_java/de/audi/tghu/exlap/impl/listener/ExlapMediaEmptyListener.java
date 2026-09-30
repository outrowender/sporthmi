/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.listener;

import de.audi.tghu.exlap.ifc.listener.ExlapMediaListener;
import de.audi.tghu.exlap.impl.container.AppConnectDeviceContainer;
import de.audi.tghu.exlap.impl.container.FollowModeContainer;
import de.audi.tghu.exlap.impl.container.ListStateContainer;
import de.audi.tghu.exlap.impl.container.MediaBrowserPathContainer;
import de.audi.tghu.exlap.impl.container.MediaPlayInfoContainer;
import de.audi.tghu.exlap.impl.container.MediaPlayModeContainer;
import de.audi.tghu.exlap.impl.container.MediaSourcesContainer;
import de.audi.tghu.exlap.impl.container.TrackInfoContainer;

public class ExlapMediaEmptyListener
implements ExlapMediaListener {
    public void updateCurrentTrackInfo(TrackInfoContainer trackInfoContainer) {
    }

    public void updateMediaPlayInfo(MediaPlayInfoContainer mediaPlayInfoContainer) {
    }

    public void updateMediaPlayMode(MediaPlayModeContainer mediaPlayModeContainer) {
    }

    public void updateAvailableMediaSources(MediaSourcesContainer mediaSourcesContainer) {
    }

    public void updateMediaBrowserList(ListStateContainer listStateContainer) {
    }

    public void updateMediaBrowserFollowMode(FollowModeContainer followModeContainer) {
    }

    public void updateMediaBrowserFolder(MediaBrowserPathContainer mediaBrowserPathContainer) {
    }

    public void updateCurrentTrackPath(MediaBrowserPathContainer mediaBrowserPathContainer) {
    }

    public void updateAppConnectDevice(AppConnectDeviceContainer appConnectDeviceContainer) {
    }
}

