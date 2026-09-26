/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.tghu.exlap.impl.container.RadioStationsContainer;
import de.audi.tghu.exlap.impl.listener.ExlapRadioEmptyListener;
import de.audi.tghu.exlap.impl.worker.ExlapAvailableDABServiceComponentsWorker;

class ExlapAvailableDABServiceComponentsWorker$1
extends ExlapRadioEmptyListener {
    private final /* synthetic */ ExlapAvailableDABServiceComponentsWorker this$0;

    ExlapAvailableDABServiceComponentsWorker$1(ExlapAvailableDABServiceComponentsWorker exlapAvailableDABServiceComponentsWorker) {
        this.this$0 = exlapAvailableDABServiceComponentsWorker;
    }

    @Override
    public void updateAvailableDABServiceComponents(RadioStationsContainer radioStationsContainer) {
        ExlapAvailableDABServiceComponentsWorker.access$000(this.this$0).log(-2137614336, "[new ExlapRadioEmptyListener#updateAvailableDABServiceComponents] received new container: %1", (Object)radioStationsContainer);
        ExlapAvailableDABServiceComponentsWorker.access$102(this.this$0, radioStationsContainer);
        if (ExlapAvailableDABServiceComponentsWorker.access$200(this.this$0) != -1) {
            ExlapAvailableDABServiceComponentsWorker.access$300(this.this$0);
        }
    }
}

