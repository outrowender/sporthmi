/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.tghu.exlap.impl.container.LastDestinationsContainer;
import de.audi.tghu.exlap.impl.listener.ExlapNavigationEmptyListener;
import de.audi.tghu.exlap.impl.worker.ExlapLastDestinationsWorker;

class ExlapLastDestinationsWorker$1
extends ExlapNavigationEmptyListener {
    private final /* synthetic */ ExlapLastDestinationsWorker this$0;

    ExlapLastDestinationsWorker$1(ExlapLastDestinationsWorker exlapLastDestinationsWorker) {
        this.this$0 = exlapLastDestinationsWorker;
    }

    @Override
    public void updateLastDestinations(LastDestinationsContainer lastDestinationsContainer) {
        ExlapLastDestinationsWorker.access$000(this.this$0).log(-2137614336, "[new ExlapNavigationEmptyListener#updateLastDestinations] received new container: %1", (Object)lastDestinationsContainer);
        ExlapLastDestinationsWorker.access$102(this.this$0, lastDestinationsContainer);
        if (ExlapLastDestinationsWorker.access$200(this.this$0) != -1) {
            ExlapLastDestinationsWorker.access$300(this.this$0);
        }
    }
}

