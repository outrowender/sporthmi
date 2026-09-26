/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.tghu.exlap.impl.container.BalanceFaderContainer;
import de.audi.tghu.exlap.impl.listener.ExlapSoundEmptyListener;
import de.audi.tghu.exlap.impl.worker.ExlapBalanceFaderWorker;

class ExlapBalanceFaderWorker$1
extends ExlapSoundEmptyListener {
    private final /* synthetic */ ExlapBalanceFaderWorker this$0;

    ExlapBalanceFaderWorker$1(ExlapBalanceFaderWorker exlapBalanceFaderWorker) {
        this.this$0 = exlapBalanceFaderWorker;
    }

    @Override
    public void updateBalanceFader(BalanceFaderContainer balanceFaderContainer) {
        ExlapBalanceFaderWorker.access$000(this.this$0).log(-2137614336, "[new ExlapSoundEmptyListener#updateBalanceFader] received new container: %1", (Object)balanceFaderContainer);
        ExlapBalanceFaderWorker.access$102(this.this$0, balanceFaderContainer);
        if (ExlapBalanceFaderWorker.access$200(this.this$0) != -1) {
            ExlapBalanceFaderWorker.access$300(this.this$0);
        }
    }
}

