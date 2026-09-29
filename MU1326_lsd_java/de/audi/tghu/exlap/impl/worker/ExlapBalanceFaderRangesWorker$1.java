/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.tghu.exlap.impl.container.BalanceFaderRangesContainer;
import de.audi.tghu.exlap.impl.listener.ExlapSoundEmptyListener;
import de.audi.tghu.exlap.impl.worker.ExlapBalanceFaderRangesWorker;

class ExlapBalanceFaderRangesWorker$1
extends ExlapSoundEmptyListener {
    private final /* synthetic */ ExlapBalanceFaderRangesWorker this$0;

    ExlapBalanceFaderRangesWorker$1(ExlapBalanceFaderRangesWorker exlapBalanceFaderRangesWorker) {
        this.this$0 = exlapBalanceFaderRangesWorker;
    }

    @Override
    public void updateBalanceFaderRanges(BalanceFaderRangesContainer balanceFaderRangesContainer) {
        ExlapBalanceFaderRangesWorker.access$000(this.this$0).log(-2137614336, "[new ExlapSoundEmptyListener#updateBalanceFaderRanges] received new container: %1", (Object)balanceFaderRangesContainer);
        ExlapBalanceFaderRangesWorker.access$102(this.this$0, balanceFaderRangesContainer);
        if (ExlapBalanceFaderRangesWorker.access$200(this.this$0) != -1) {
            ExlapBalanceFaderRangesWorker.access$300(this.this$0);
        }
    }
}

