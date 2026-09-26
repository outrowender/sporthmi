/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.tghu.exlap.impl.container.RadioStationsContainer;
import de.audi.tghu.exlap.impl.listener.ExlapRadioEmptyListener;
import de.audi.tghu.exlap.impl.worker.ExlapAvailableFMStationsWorker;

class ExlapAvailableFMStationsWorker$1
extends ExlapRadioEmptyListener {
    private final /* synthetic */ ExlapAvailableFMStationsWorker this$0;

    ExlapAvailableFMStationsWorker$1(ExlapAvailableFMStationsWorker exlapAvailableFMStationsWorker) {
        this.this$0 = exlapAvailableFMStationsWorker;
    }

    @Override
    public void updateAvailableFMStations(RadioStationsContainer radioStationsContainer) {
        ExlapAvailableFMStationsWorker.access$000(this.this$0).log(-2137614336, "[new ExlapRadioEmptyListener#updateAvailableFMStations] received new container: %1", (Object)radioStationsContainer);
        ExlapAvailableFMStationsWorker.access$102(this.this$0, radioStationsContainer);
        if (ExlapAvailableFMStationsWorker.access$200(this.this$0) != -1) {
            ExlapAvailableFMStationsWorker.access$300(this.this$0);
        }
    }
}

