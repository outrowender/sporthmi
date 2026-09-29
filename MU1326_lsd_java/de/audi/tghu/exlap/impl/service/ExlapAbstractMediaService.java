/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.service;

import de.audi.tghu.exlap.ExlapAbstractService;
import de.audi.tghu.exlap.ifc.listener.ExlapMediaListener;
import de.audi.tghu.exlap.ifc.service.ExlapMediaService;
import de.audi.tghu.exlap.impl.container.AppConnectDeviceContainer;
import de.audi.tghu.exlap.impl.container.FollowModeContainer;
import de.audi.tghu.exlap.impl.container.ListPageDataContainer;
import de.audi.tghu.exlap.impl.container.ListStateContainer;
import de.audi.tghu.exlap.impl.container.MediaBrowserPathContainer;
import de.audi.tghu.exlap.impl.container.MediaPlayInfoContainer;
import de.audi.tghu.exlap.impl.container.MediaPlayModeContainer;
import de.audi.tghu.exlap.impl.container.MediaSourcesContainer;
import de.audi.tghu.exlap.impl.container.TrackInfoContainer;
import de.audi.tghu.exlap.impl.service.ExlapAbstractMediaService$1;
import de.audi.tghu.exlap.impl.service.ExlapAbstractMediaService$2;
import de.audi.tghu.exlap.impl.service.ExlapAbstractMediaService$3;
import de.audi.tghu.exlap.impl.service.ExlapAbstractMediaService$4;
import de.audi.tghu.exlap.impl.service.ExlapAbstractMediaService$5;
import de.audi.tghu.exlap.impl.service.ExlapAbstractMediaService$6;
import de.audi.tghu.exlap.impl.service.ExlapAbstractMediaService$7;
import de.audi.tghu.exlap.impl.service.ExlapAbstractMediaService$8;
import de.audi.tghu.exlap.impl.service.ExlapAbstractMediaService$9;

public abstract class ExlapAbstractMediaService
extends ExlapAbstractService
implements ExlapMediaService,
ExlapMediaListener {
    @Override
    public void updateCurrentTrackInfo(TrackInfoContainer trackInfoContainer) {
        this.iterateListener(21, new ExlapAbstractMediaService$1(this, trackInfoContainer));
    }

    @Override
    public void updateMediaPlayInfo(MediaPlayInfoContainer mediaPlayInfoContainer) {
        this.iterateListener(22, new ExlapAbstractMediaService$2(this, mediaPlayInfoContainer));
    }

    @Override
    public void updateMediaPlayMode(MediaPlayModeContainer mediaPlayModeContainer) {
        this.iterateListener(23, new ExlapAbstractMediaService$3(this, mediaPlayModeContainer));
    }

    @Override
    public void updateAvailableMediaSources(MediaSourcesContainer mediaSourcesContainer) {
        this.iterateListener(27, new ExlapAbstractMediaService$4(this, mediaSourcesContainer));
    }

    @Override
    public void updateMediaBrowserList(ListStateContainer listStateContainer) {
        this.iterateListener(41, new ExlapAbstractMediaService$5(this, listStateContainer));
    }

    @Override
    public void updateMediaBrowserFollowMode(FollowModeContainer followModeContainer) {
        this.iterateListener(43, new ExlapAbstractMediaService$6(this, followModeContainer));
    }

    @Override
    public void updateMediaBrowserFolder(MediaBrowserPathContainer mediaBrowserPathContainer) {
        this.iterateListener(47, new ExlapAbstractMediaService$7(this, mediaBrowserPathContainer));
    }

    @Override
    public void updateCurrentTrackPath(MediaBrowserPathContainer mediaBrowserPathContainer) {
        this.iterateListener(50, new ExlapAbstractMediaService$8(this, mediaBrowserPathContainer));
    }

    @Override
    public void updateAppConnectDevice(AppConnectDeviceContainer appConnectDeviceContainer) {
        this.iterateListener(57, new ExlapAbstractMediaService$9(this, appConnectDeviceContainer));
    }

    @Override
    public void resultMediaBrowserList(int n, ListPageDataContainer listPageDataContainer) {
        this.actionResult(n, 29, listPageDataContainer);
    }
}

