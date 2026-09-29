/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.service;

import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.ListenerIterator;
import de.audi.tghu.exlap.ifc.listener.ExlapMediaListener;
import de.audi.tghu.exlap.impl.container.MediaBrowserPathContainer;
import de.audi.tghu.exlap.impl.service.ExlapAbstractMediaService;

class ExlapAbstractMediaService$8
implements ListenerIterator {
    private final /* synthetic */ MediaBrowserPathContainer val$currentTrackPathProperty;
    private final /* synthetic */ ExlapAbstractMediaService this$0;

    ExlapAbstractMediaService$8(ExlapAbstractMediaService exlapAbstractMediaService, MediaBrowserPathContainer mediaBrowserPathContainer) {
        this.this$0 = exlapAbstractMediaService;
        this.val$currentTrackPathProperty = mediaBrowserPathContainer;
    }

    @Override
    public void processListener(ExlapListener exlapListener) {
        ((ExlapMediaListener)exlapListener).updateCurrentTrackPath(this.val$currentTrackPathProperty);
    }
}

