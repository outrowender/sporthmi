/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.tghu.exlap.impl.container.MediaPlayModeContainer;
import de.audi.tghu.exlap.impl.listener.ExlapMediaEmptyListener;
import de.audi.tghu.exlap.impl.worker.ExlapMediaPlayModeWorker;

class ExlapMediaPlayModeWorker$1
extends ExlapMediaEmptyListener {
    private final /* synthetic */ ExlapMediaPlayModeWorker this$0;

    ExlapMediaPlayModeWorker$1(ExlapMediaPlayModeWorker exlapMediaPlayModeWorker) {
        this.this$0 = exlapMediaPlayModeWorker;
    }

    @Override
    public void updateMediaPlayMode(MediaPlayModeContainer mediaPlayModeContainer) {
        ExlapMediaPlayModeWorker.access$000(this.this$0).log(-2137614336, "[new ExlapMediaEmptyListener#updateMediaPlayMode] received new container: %1", (Object)mediaPlayModeContainer);
        ExlapMediaPlayModeWorker.access$102(this.this$0, mediaPlayModeContainer);
        if (ExlapMediaPlayModeWorker.access$200(this.this$0) != -1) {
            ExlapMediaPlayModeWorker.access$300(this.this$0);
        }
    }
}

