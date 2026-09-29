/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.tghu.exlap.impl.container.FollowModeContainer;
import de.audi.tghu.exlap.impl.listener.ExlapMediaEmptyListener;
import de.audi.tghu.exlap.impl.worker.ExlapMediaBrowserFollowModeWorker;

class ExlapMediaBrowserFollowModeWorker$1
extends ExlapMediaEmptyListener {
    private final /* synthetic */ ExlapMediaBrowserFollowModeWorker this$0;

    ExlapMediaBrowserFollowModeWorker$1(ExlapMediaBrowserFollowModeWorker exlapMediaBrowserFollowModeWorker) {
        this.this$0 = exlapMediaBrowserFollowModeWorker;
    }

    @Override
    public void updateMediaBrowserFollowMode(FollowModeContainer followModeContainer) {
        ExlapMediaBrowserFollowModeWorker.access$000(this.this$0).log(-2137614336, "[new ExlapMediaEmptyListener#updateMediaBrowserFollowMode] received new container: %1", (Object)followModeContainer);
        ExlapMediaBrowserFollowModeWorker.access$102(this.this$0, followModeContainer);
        if (ExlapMediaBrowserFollowModeWorker.access$200(this.this$0) != -1) {
            ExlapMediaBrowserFollowModeWorker.access$300(this.this$0);
        }
    }
}

