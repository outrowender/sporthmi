/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.service;

import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.ListenerIterator;
import de.audi.tghu.exlap.ifc.listener.ExlapMediaListener;
import de.audi.tghu.exlap.impl.container.MediaPlayInfoContainer;
import de.audi.tghu.exlap.impl.service.ExlapAbstractMediaService;

class ExlapAbstractMediaService$2
implements ListenerIterator {
    private final /* synthetic */ MediaPlayInfoContainer val$mediaPlayInfoProperty;
    private final /* synthetic */ ExlapAbstractMediaService this$0;

    ExlapAbstractMediaService$2(ExlapAbstractMediaService exlapAbstractMediaService, MediaPlayInfoContainer mediaPlayInfoContainer) {
        this.this$0 = exlapAbstractMediaService;
        this.val$mediaPlayInfoProperty = mediaPlayInfoContainer;
    }

    @Override
    public void processListener(ExlapListener exlapListener) {
        ((ExlapMediaListener)exlapListener).updateMediaPlayInfo(this.val$mediaPlayInfoProperty);
    }
}

