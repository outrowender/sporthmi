/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.tghu.exlap.impl.container.EncodedVehicleTypeContainer;
import de.audi.tghu.exlap.impl.listener.ExlapSystemEmptyListener;
import de.audi.tghu.exlap.impl.worker.ExlapEncodedVehicleTypeWorker;

class ExlapEncodedVehicleTypeWorker$1
extends ExlapSystemEmptyListener {
    private final /* synthetic */ ExlapEncodedVehicleTypeWorker this$0;

    ExlapEncodedVehicleTypeWorker$1(ExlapEncodedVehicleTypeWorker exlapEncodedVehicleTypeWorker) {
        this.this$0 = exlapEncodedVehicleTypeWorker;
    }

    @Override
    public void updateEncodedVehicleType(EncodedVehicleTypeContainer encodedVehicleTypeContainer) {
        ExlapEncodedVehicleTypeWorker.access$000(this.this$0).log(-2137614336, "[new ExlapSystemEmptyListener#updateEncodedVehicleType] received new container: %1", (Object)encodedVehicleTypeContainer);
        ExlapEncodedVehicleTypeWorker.access$102(this.this$0, encodedVehicleTypeContainer);
        if (ExlapEncodedVehicleTypeWorker.access$200(this.this$0) != -1) {
            ExlapEncodedVehicleTypeWorker.access$300(this.this$0);
        }
    }
}

