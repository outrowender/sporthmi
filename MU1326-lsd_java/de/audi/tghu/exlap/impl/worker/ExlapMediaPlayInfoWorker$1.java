/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.tghu.exlap.impl.container.MediaPlayInfoContainer;
import de.audi.tghu.exlap.impl.listener.ExlapMediaEmptyListener;
import de.audi.tghu.exlap.impl.worker.ExlapMediaPlayInfoWorker;

class ExlapMediaPlayInfoWorker$1
extends ExlapMediaEmptyListener {
    private final /* synthetic */ ExlapMediaPlayInfoWorker this$0;

    ExlapMediaPlayInfoWorker$1(ExlapMediaPlayInfoWorker exlapMediaPlayInfoWorker) {
        this.this$0 = exlapMediaPlayInfoWorker;
    }

    @Override
    public void updateMediaPlayInfo(MediaPlayInfoContainer mediaPlayInfoContainer) {
        ExlapMediaPlayInfoWorker.access$000(this.this$0).log(-2137614336, "[new ExlapMediaEmptyListener#updateMediaPlayInfo] received new container: %1", (Object)mediaPlayInfoContainer);
        ExlapMediaPlayInfoWorker.access$102(this.this$0, mediaPlayInfoContainer);
        if (ExlapMediaPlayInfoWorker.access$200(this.this$0) != -1) {
            ExlapMediaPlayInfoWorker.access$300(this.this$0);
        }
    }
}

