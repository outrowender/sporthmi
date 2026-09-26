/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.tghu.exlap.impl.container.AddressContainer;
import de.audi.tghu.exlap.impl.listener.ExlapNavigationEmptyListener;
import de.audi.tghu.exlap.impl.worker.ExlapGuidanceDestinationWorker;

class ExlapGuidanceDestinationWorker$1
extends ExlapNavigationEmptyListener {
    private final /* synthetic */ ExlapGuidanceDestinationWorker this$0;

    ExlapGuidanceDestinationWorker$1(ExlapGuidanceDestinationWorker exlapGuidanceDestinationWorker) {
        this.this$0 = exlapGuidanceDestinationWorker;
    }

    @Override
    public void updateGuidanceDestination(AddressContainer addressContainer) {
        ExlapGuidanceDestinationWorker.access$000(this.this$0).log(-2137614336, "[new ExlapNavigationEmptyListener#updateGuidanceDestination] received new container: %1", (Object)addressContainer);
        ExlapGuidanceDestinationWorker.access$102(this.this$0, addressContainer);
        if (ExlapGuidanceDestinationWorker.access$200(this.this$0) != -1) {
            ExlapGuidanceDestinationWorker.access$300(this.this$0);
        }
    }
}

