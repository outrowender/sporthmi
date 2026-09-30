/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.service;

import de.audi.tghu.exlap.ExlapAbstractService;
import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.ListenerIterator;
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

public abstract class ExlapAbstractMediaService
extends ExlapAbstractService
implements ExlapMediaService,
ExlapMediaListener {
    public void updateCurrentTrackInfo(final TrackInfoContainer trackInfoContainer) {
        this.iterateListener(21, new ListenerIterator(){

            public void processListener(ExlapListener exlapListener) {
                ((ExlapMediaListener)exlapListener).updateCurrentTrackInfo(trackInfoContainer);
            }
        });
    }

    public void updateMediaPlayInfo(final MediaPlayInfoContainer mediaPlayInfoContainer) {
        this.iterateListener(22, new ListenerIterator(){

            public void processListener(ExlapListener exlapListener) {
                ((ExlapMediaListener)exlapListener).updateMediaPlayInfo(mediaPlayInfoContainer);
            }
        });
    }

    public void updateMediaPlayMode(final MediaPlayModeContainer mediaPlayModeContainer) {
        this.iterateListener(23, new ListenerIterator(){

            public void processListener(ExlapListener exlapListener) {
                ((ExlapMediaListener)exlapListener).updateMediaPlayMode(mediaPlayModeContainer);
            }
        });
    }

    public void updateAvailableMediaSources(final MediaSourcesContainer mediaSourcesContainer) {
        this.iterateListener(27, new ListenerIterator(){

            public void processListener(ExlapListener exlapListener) {
                ((ExlapMediaListener)exlapListener).updateAvailableMediaSources(mediaSourcesContainer);
            }
        });
    }

    public void updateMediaBrowserList(final ListStateContainer listStateContainer) {
        this.iterateListener(41, new ListenerIterator(){

            public void processListener(ExlapListener exlapListener) {
                ((ExlapMediaListener)exlapListener).updateMediaBrowserList(listStateContainer);
            }
        });
    }

    public void updateMediaBrowserFollowMode(final FollowModeContainer followModeContainer) {
        this.iterateListener(43, new ListenerIterator(){

            public void processListener(ExlapListener exlapListener) {
                ((ExlapMediaListener)exlapListener).updateMediaBrowserFollowMode(followModeContainer);
            }
        });
    }

    public void updateMediaBrowserFolder(final MediaBrowserPathContainer mediaBrowserPathContainer) {
        this.iterateListener(47, new ListenerIterator(){

            public void processListener(ExlapListener exlapListener) {
                ((ExlapMediaListener)exlapListener).updateMediaBrowserFolder(mediaBrowserPathContainer);
            }
        });
    }

    public void updateCurrentTrackPath(final MediaBrowserPathContainer mediaBrowserPathContainer) {
        this.iterateListener(50, new ListenerIterator(){

            public void processListener(ExlapListener exlapListener) {
                ((ExlapMediaListener)exlapListener).updateCurrentTrackPath(mediaBrowserPathContainer);
            }
        });
    }

    public void updateAppConnectDevice(final AppConnectDeviceContainer appConnectDeviceContainer) {
        this.iterateListener(57, new ListenerIterator(){

            public void processListener(ExlapListener exlapListener) {
                ((ExlapMediaListener)exlapListener).updateAppConnectDevice(appConnectDeviceContainer);
            }
        });
    }

    public void resultMediaBrowserList(int n, ListPageDataContainer listPageDataContainer) {
        this.actionResult(n, 29, listPageDataContainer);
    }
}

