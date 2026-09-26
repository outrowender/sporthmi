/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.tghu.exlap.impl.container.UnitDistanceContainer;
import de.audi.tghu.exlap.impl.listener.ExlapSystemEmptyListener;
import de.audi.tghu.exlap.impl.worker.ExlapUnitDistanceWorker;

class ExlapUnitDistanceWorker$1
extends ExlapSystemEmptyListener {
    private final /* synthetic */ ExlapUnitDistanceWorker this$0;

    ExlapUnitDistanceWorker$1(ExlapUnitDistanceWorker exlapUnitDistanceWorker) {
        this.this$0 = exlapUnitDistanceWorker;
    }

    @Override
    public void updateUnitDistance(UnitDistanceContainer unitDistanceContainer) {
        ExlapUnitDistanceWorker.access$000(this.this$0).log(-2137614336, "[new ExlapSystemEmptyListener#updateUnitDistance] received new container: %1", (Object)unitDistanceContainer);
        ExlapUnitDistanceWorker.access$102(this.this$0, unitDistanceContainer);
        if (ExlapUnitDistanceWorker.access$200(this.this$0) != -1) {
            ExlapUnitDistanceWorker.access$300(this.this$0);
        }
    }
}

