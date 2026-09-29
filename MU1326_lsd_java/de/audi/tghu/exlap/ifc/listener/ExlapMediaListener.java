/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.ifc.listener;

import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.impl.container.AppConnectDeviceContainer;
import de.audi.tghu.exlap.impl.container.FollowModeContainer;
import de.audi.tghu.exlap.impl.container.ListStateContainer;
import de.audi.tghu.exlap.impl.container.MediaBrowserPathContainer;
import de.audi.tghu.exlap.impl.container.MediaPlayInfoContainer;
import de.audi.tghu.exlap.impl.container.MediaPlayModeContainer;
import de.audi.tghu.exlap.impl.container.MediaSourcesContainer;
import de.audi.tghu.exlap.impl.container.TrackInfoContainer;

public interface ExlapMediaListener
extends ExlapListener {
    default public void updateCurrentTrackInfo(TrackInfoContainer trackInfoContainer) {
    }

    default public void updateMediaPlayInfo(MediaPlayInfoContainer mediaPlayInfoContainer) {
    }

    default public void updateMediaPlayMode(MediaPlayModeContainer mediaPlayModeContainer) {
    }

    default public void updateAvailableMediaSources(MediaSourcesContainer mediaSourcesContainer) {
    }

    default public void updateMediaBrowserList(ListStateContainer listStateContainer) {
    }

    default public void updateMediaBrowserFollowMode(FollowModeContainer followModeContainer) {
    }

    default public void updateMediaBrowserFolder(MediaBrowserPathContainer mediaBrowserPathContainer) {
    }

    default public void updateCurrentTrackPath(MediaBrowserPathContainer mediaBrowserPathContainer) {
    }

    default public void updateAppConnectDevice(AppConnectDeviceContainer appConnectDeviceContainer) {
    }
}

