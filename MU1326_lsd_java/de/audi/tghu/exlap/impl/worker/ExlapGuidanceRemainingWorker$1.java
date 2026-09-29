/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.tghu.exlap.impl.container.GuidanceRemainingContainer;
import de.audi.tghu.exlap.impl.listener.ExlapNavigationEmptyListener;
import de.audi.tghu.exlap.impl.worker.ExlapGuidanceRemainingWorker;

class ExlapGuidanceRemainingWorker$1
extends ExlapNavigationEmptyListener {
    private final /* synthetic */ ExlapGuidanceRemainingWorker this$0;

    ExlapGuidanceRemainingWorker$1(ExlapGuidanceRemainingWorker exlapGuidanceRemainingWorker) {
        this.this$0 = exlapGuidanceRemainingWorker;
    }

    @Override
    public void updateGuidanceRemaining(GuidanceRemainingContainer guidanceRemainingContainer) {
        ExlapGuidanceRemainingWorker.access$000(this.this$0).log(-2137614336, "[new ExlapNavigationEmptyListener#updateGuidanceRemaining] received new container: %1", (Object)guidanceRemainingContainer);
        ExlapGuidanceRemainingWorker.access$102(this.this$0, guidanceRemainingContainer);
        if (ExlapGuidanceRemainingWorker.access$200(this.this$0) != -1) {
            ExlapGuidanceRemainingWorker.access$300(this.this$0);
        }
    }
}

