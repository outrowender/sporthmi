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
    @Override
    public void updateCurrentTrackInfo(TrackInfoContainer trackInfoContainer) {
    }

    @Override
    public void updateMediaPlayInfo(MediaPlayInfoContainer mediaPlayInfoContainer) {
    }

    @Override
    public void updateMediaPlayMode(MediaPlayModeContainer mediaPlayModeContainer) {
    }

    @Override
    public void updateAvailableMediaSources(MediaSourcesContainer mediaSourcesContainer) {
    }

    @Override
    public void updateMediaBrowserList(ListStateContainer listStateContainer) {
    }

    @Override
    public void updateMediaBrowserFollowMode(FollowModeContainer followModeContainer) {
    }

    @Override
    public void updateMediaBrowserFolder(MediaBrowserPathContainer mediaBrowserPathContainer) {
    }

    @Override
    public void updateCurrentTrackPath(MediaBrowserPathContainer mediaBrowserPathContainer) {
    }

    @Override
    public void updateAppConnectDevice(AppConnectDeviceContainer appConnectDeviceContainer) {
    }
}

