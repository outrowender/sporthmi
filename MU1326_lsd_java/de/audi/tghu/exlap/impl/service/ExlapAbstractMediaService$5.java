/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.service;

import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.ListenerIterator;
import de.audi.tghu.exlap.ifc.listener.ExlapMediaListener;
import de.audi.tghu.exlap.impl.container.ListStateContainer;
import de.audi.tghu.exlap.impl.service.ExlapAbstractMediaService;

class ExlapAbstractMediaService$5
implements ListenerIterator {
    private final /* synthetic */ ListStateContainer val$mediaBrowserListProperty;
    private final /* synthetic */ ExlapAbstractMediaService this$0;

    ExlapAbstractMediaService$5(ExlapAbstractMediaService exlapAbstractMediaService, ListStateContainer listStateContainer) {
        this.this$0 = exlapAbstractMediaService;
        this.val$mediaBrowserListProperty = listStateContainer;
    }

    @Override
    public void processListener(ExlapListener exlapListener) {
        ((ExlapMediaListener)exlapListener).updateMediaBrowserList(this.val$mediaBrowserListProperty);
    }
}

