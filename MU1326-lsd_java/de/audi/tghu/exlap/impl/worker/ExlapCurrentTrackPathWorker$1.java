/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.tghu.exlap.impl.container.MediaBrowserPathContainer;
import de.audi.tghu.exlap.impl.listener.ExlapMediaEmptyListener;
import de.audi.tghu.exlap.impl.worker.ExlapCurrentTrackPathWorker;

class ExlapCurrentTrackPathWorker$1
extends ExlapMediaEmptyListener {
    private final /* synthetic */ ExlapCurrentTrackPathWorker this$0;

    ExlapCurrentTrackPathWorker$1(ExlapCurrentTrackPathWorker exlapCurrentTrackPathWorker) {
        this.this$0 = exlapCurrentTrackPathWorker;
    }

    @Override
    public void updateCurrentTrackPath(MediaBrowserPathContainer mediaBrowserPathContainer) {
        ExlapCurrentTrackPathWorker.access$000(this.this$0).log(-2137614336, "[new ExlapMediaEmptyListener#updateCurrentTrackPath] received new container: %1", (Object)mediaBrowserPathContainer);
        ExlapCurrentTrackPathWorker.access$102(this.this$0, mediaBrowserPathContainer);
        if (ExlapCurrentTrackPathWorker.access$200(this.this$0) != -1) {
            ExlapCurrentTrackPathWorker.access$300(this.this$0);
        }
    }
}

