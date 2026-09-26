/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.service;

import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.ListenerIterator;
import de.audi.tghu.exlap.ifc.listener.ExlapMediaListener;
import de.audi.tghu.exlap.impl.container.MediaPlayModeContainer;
import de.audi.tghu.exlap.impl.service.ExlapAbstractMediaService;

class ExlapAbstractMediaService$3
implements ListenerIterator {
    private final /* synthetic */ MediaPlayModeContainer val$mediaPlayModeProperty;
    private final /* synthetic */ ExlapAbstractMediaService this$0;

    ExlapAbstractMediaService$3(ExlapAbstractMediaService exlapAbstractMediaService, MediaPlayModeContainer mediaPlayModeContainer) {
        this.this$0 = exlapAbstractMediaService;
        this.val$mediaPlayModeProperty = mediaPlayModeContainer;
    }

    @Override
    public void processListener(ExlapListener exlapListener) {
        ((ExlapMediaListener)exlapListener).updateMediaPlayMode(this.val$mediaPlayModeProperty);
    }
}

