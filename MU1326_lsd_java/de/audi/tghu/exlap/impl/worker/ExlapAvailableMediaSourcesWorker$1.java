/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.tghu.exlap.impl.container.MediaSourcesContainer;
import de.audi.tghu.exlap.impl.listener.ExlapMediaEmptyListener;
import de.audi.tghu.exlap.impl.worker.ExlapAvailableMediaSourcesWorker;

class ExlapAvailableMediaSourcesWorker$1
extends ExlapMediaEmptyListener {
    private final /* synthetic */ ExlapAvailableMediaSourcesWorker this$0;

    ExlapAvailableMediaSourcesWorker$1(ExlapAvailableMediaSourcesWorker exlapAvailableMediaSourcesWorker) {
        this.this$0 = exlapAvailableMediaSourcesWorker;
    }

    @Override
    public void updateAvailableMediaSources(MediaSourcesContainer mediaSourcesContainer) {
        ExlapAvailableMediaSourcesWorker.access$000(this.this$0).log(-2137614336, "[new ExlapMediaEmptyListener#updateAvailableMediaSources] received new container: %1", (Object)mediaSourcesContainer);
        ExlapAvailableMediaSourcesWorker.access$102(this.this$0, mediaSourcesContainer);
        if (ExlapAvailableMediaSourcesWorker.access$200(this.this$0) != -1) {
            ExlapAvailableMediaSourcesWorker.access$300(this.this$0);
        }
    }
}

