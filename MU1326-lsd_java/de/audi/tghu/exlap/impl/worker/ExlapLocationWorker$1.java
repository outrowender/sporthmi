/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.tghu.exlap.impl.container.AddressContainer;
import de.audi.tghu.exlap.impl.listener.ExlapNavigationEmptyListener;
import de.audi.tghu.exlap.impl.worker.ExlapLocationWorker;

class ExlapLocationWorker$1
extends ExlapNavigationEmptyListener {
    private final /* synthetic */ ExlapLocationWorker this$0;

    ExlapLocationWorker$1(ExlapLocationWorker exlapLocationWorker) {
        this.this$0 = exlapLocationWorker;
    }

    @Override
    public void updateLocation(AddressContainer addressContainer) {
        ExlapLocationWorker.access$000(this.this$0).log(-2137614336, "[new ExlapNavigationEmptyListener#updateLocation] received new container: %1", (Object)addressContainer);
        ExlapLocationWorker.access$102(this.this$0, addressContainer);
        if (ExlapLocationWorker.access$200(this.this$0) != -1) {
            ExlapLocationWorker.access$300(this.this$0);
        }
    }
}

