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
    public void updateCurrentTrackInfo(TrackInfoContainer var1);

    public void updateMediaPlayInfo(MediaPlayInfoContainer var1);

    public void updateMediaPlayMode(MediaPlayModeContainer var1);

    public void updateAvailableMediaSources(MediaSourcesContainer var1);

    public void updateMediaBrowserList(ListStateContainer var1);

    public void updateMediaBrowserFollowMode(FollowModeContainer var1);

    public void updateMediaBrowserFolder(MediaBrowserPathContainer var1);

    public void updateCurrentTrackPath(MediaBrowserPathContainer var1);

    public void updateAppConnectDevice(AppConnectDeviceContainer var1);
}

