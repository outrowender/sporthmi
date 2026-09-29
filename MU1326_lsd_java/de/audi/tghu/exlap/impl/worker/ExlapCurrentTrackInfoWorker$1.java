/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.tghu.exlap.impl.container.TrackInfoContainer;
import de.audi.tghu.exlap.impl.listener.ExlapMediaEmptyListener;
import de.audi.tghu.exlap.impl.worker.ExlapCurrentTrackInfoWorker;

class ExlapCurrentTrackInfoWorker$1
extends ExlapMediaEmptyListener {
    private final /* synthetic */ ExlapCurrentTrackInfoWorker this$0;

    ExlapCurrentTrackInfoWorker$1(ExlapCurrentTrackInfoWorker exlapCurrentTrackInfoWorker) {
        this.this$0 = exlapCurrentTrackInfoWorker;
    }

    @Override
    public void updateCurrentTrackInfo(TrackInfoContainer trackInfoContainer) {
        ExlapCurrentTrackInfoWorker.access$000(this.this$0).log(-2137614336, "[new ExlapMediaEmptyListener#updateCurrentTrackInfo] received new container: %1", (Object)trackInfoContainer);
        ExlapCurrentTrackInfoWorker.access$102(this.this$0, trackInfoContainer);
        if (ExlapCurrentTrackInfoWorker.access$200(this.this$0) != -1) {
            ExlapCurrentTrackInfoWorker.access$300(this.this$0);
        }
    }
}

