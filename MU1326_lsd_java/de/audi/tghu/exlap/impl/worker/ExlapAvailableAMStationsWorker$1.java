/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.tghu.exlap.impl.container.RadioStationsContainer;
import de.audi.tghu.exlap.impl.listener.ExlapRadioEmptyListener;
import de.audi.tghu.exlap.impl.worker.ExlapAvailableAMStationsWorker;

class ExlapAvailableAMStationsWorker$1
extends ExlapRadioEmptyListener {
    private final /* synthetic */ ExlapAvailableAMStationsWorker this$0;

    ExlapAvailableAMStationsWorker$1(ExlapAvailableAMStationsWorker exlapAvailableAMStationsWorker) {
        this.this$0 = exlapAvailableAMStationsWorker;
    }

    @Override
    public void updateAvailableAMStations(RadioStationsContainer radioStationsContainer) {
        ExlapAvailableAMStationsWorker.access$000(this.this$0).log(-2137614336, "[new ExlapRadioEmptyListener#updateAvailableAMStations] received new container: %1", (Object)radioStationsContainer);
        ExlapAvailableAMStationsWorker.access$102(this.this$0, radioStationsContainer);
        if (ExlapAvailableAMStationsWorker.access$200(this.this$0) != -1) {
            ExlapAvailableAMStationsWorker.access$300(this.this$0);
        }
    }
}

