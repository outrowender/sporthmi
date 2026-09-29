/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.service;

import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.ListenerIterator;
import de.audi.tghu.exlap.ifc.listener.ExlapMediaListener;
import de.audi.tghu.exlap.impl.container.MediaSourcesContainer;
import de.audi.tghu.exlap.impl.service.ExlapAbstractMediaService;

class ExlapAbstractMediaService$4
implements ListenerIterator {
    private final /* synthetic */ MediaSourcesContainer val$availableMediaSourcesProperty;
    private final /* synthetic */ ExlapAbstractMediaService this$0;

    ExlapAbstractMediaService$4(ExlapAbstractMediaService exlapAbstractMediaService, MediaSourcesContainer mediaSourcesContainer) {
        this.this$0 = exlapAbstractMediaService;
        this.val$availableMediaSourcesProperty = mediaSourcesContainer;
    }

    @Override
    public void processListener(ExlapListener exlapListener) {
        ((ExlapMediaListener)exlapListener).updateAvailableMediaSources(this.val$availableMediaSourcesProperty);
    }
}

