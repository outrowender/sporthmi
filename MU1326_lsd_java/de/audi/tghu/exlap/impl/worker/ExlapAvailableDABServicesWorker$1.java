/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.tghu.exlap.impl.container.RadioStationsContainer;
import de.audi.tghu.exlap.impl.listener.ExlapRadioEmptyListener;
import de.audi.tghu.exlap.impl.worker.ExlapAvailableDABServicesWorker;

class ExlapAvailableDABServicesWorker$1
extends ExlapRadioEmptyListener {
    private final /* synthetic */ ExlapAvailableDABServicesWorker this$0;

    ExlapAvailableDABServicesWorker$1(ExlapAvailableDABServicesWorker exlapAvailableDABServicesWorker) {
        this.this$0 = exlapAvailableDABServicesWorker;
    }

    @Override
    public void updateAvailableDABServices(RadioStationsContainer radioStationsContainer) {
        ExlapAvailableDABServicesWorker.access$000(this.this$0).log(-2137614336, "[new ExlapRadioEmptyListener#updateAvailableDABServices] received new container: %1", (Object)radioStationsContainer);
        ExlapAvailableDABServicesWorker.access$102(this.this$0, radioStationsContainer);
        if (ExlapAvailableDABServicesWorker.access$200(this.this$0) != -1) {
            ExlapAvailableDABServicesWorker.access$300(this.this$0);
        }
    }
}

