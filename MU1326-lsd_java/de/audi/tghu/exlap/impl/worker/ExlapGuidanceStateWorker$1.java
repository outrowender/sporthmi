/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.tghu.exlap.impl.container.GuidanceStateContainer;
import de.audi.tghu.exlap.impl.listener.ExlapNavigationEmptyListener;
import de.audi.tghu.exlap.impl.worker.ExlapGuidanceStateWorker;

class ExlapGuidanceStateWorker$1
extends ExlapNavigationEmptyListener {
    private final /* synthetic */ ExlapGuidanceStateWorker this$0;

    ExlapGuidanceStateWorker$1(ExlapGuidanceStateWorker exlapGuidanceStateWorker) {
        this.this$0 = exlapGuidanceStateWorker;
    }

    @Override
    public void updateGuidanceState(GuidanceStateContainer guidanceStateContainer) {
        ExlapGuidanceStateWorker.access$000(this.this$0).log(-2137614336, "[new ExlapNavigationEmptyListener#updateGuidanceState] received new container: %1", (Object)guidanceStateContainer);
        ExlapGuidanceStateWorker.access$102(this.this$0, guidanceStateContainer);
        if (ExlapGuidanceStateWorker.access$200(this.this$0) != -1) {
            ExlapGuidanceStateWorker.access$300(this.this$0);
        }
    }
}

