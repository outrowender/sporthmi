/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.service;

import de.audi.tghu.exlap.ExlapListener;
import de.audi.tghu.exlap.ListenerIterator;
import de.audi.tghu.exlap.ifc.listener.ExlapMediaListener;
import de.audi.tghu.exlap.impl.container.FollowModeContainer;
import de.audi.tghu.exlap.impl.service.ExlapAbstractMediaService;

class ExlapAbstractMediaService$6
implements ListenerIterator {
    private final /* synthetic */ FollowModeContainer val$mediaBrowserFollowModeProperty;
    private final /* synthetic */ ExlapAbstractMediaService this$0;

    ExlapAbstractMediaService$6(ExlapAbstractMediaService exlapAbstractMediaService, FollowModeContainer followModeContainer) {
        this.this$0 = exlapAbstractMediaService;
        this.val$mediaBrowserFollowModeProperty = followModeContainer;
    }

    @Override
    public void processListener(ExlapListener exlapListener) {
        ((ExlapMediaListener)exlapListener).updateMediaBrowserFollowMode(this.val$mediaBrowserFollowModeProperty);
    }
}

