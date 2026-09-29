/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.service;

import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.ListenerIterator;
import de.audi.tghu.exlap.ifc.listener.ExlapMediaListener;
import de.audi.tghu.exlap.impl.container.TrackInfoContainer;
import de.audi.tghu.exlap.impl.service.ExlapAbstractMediaService;

class ExlapAbstractMediaService$1
implements ListenerIterator {
    private final /* synthetic */ TrackInfoContainer val$currentTrackInfoProperty;
    private final /* synthetic */ ExlapAbstractMediaService this$0;

    ExlapAbstractMediaService$1(ExlapAbstractMediaService exlapAbstractMediaService, TrackInfoContainer trackInfoContainer) {
        this.this$0 = exlapAbstractMediaService;
        this.val$currentTrackInfoProperty = trackInfoContainer;
    }

    @Override
    public void processListener(ExlapListener exlapListener) {
        ((ExlapMediaListener)exlapListener).updateCurrentTrackInfo(this.val$currentTrackInfoProperty);
    }
}

