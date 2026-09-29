/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.tghu.exlap.impl.container.RadioStationsContainer;
import de.audi.tghu.exlap.impl.listener.ExlapRadioEmptyListener;
import de.audi.tghu.exlap.impl.worker.ExlapAvailableDABEnsemblesWorker;

class ExlapAvailableDABEnsemblesWorker$1
extends ExlapRadioEmptyListener {
    private final /* synthetic */ ExlapAvailableDABEnsemblesWorker this$0;

    ExlapAvailableDABEnsemblesWorker$1(ExlapAvailableDABEnsemblesWorker exlapAvailableDABEnsemblesWorker) {
        this.this$0 = exlapAvailableDABEnsemblesWorker;
    }

    @Override
    public void updateAvailableDABEnsembles(RadioStationsContainer radioStationsContainer) {
        ExlapAvailableDABEnsemblesWorker.access$000(this.this$0).log(-2137614336, "[new ExlapRadioEmptyListener#updateAvailableDABEnsembles] received new container: %1", (Object)radioStationsContainer);
        ExlapAvailableDABEnsemblesWorker.access$102(this.this$0, radioStationsContainer);
        if (ExlapAvailableDABEnsemblesWorker.access$200(this.this$0) != -1) {
            ExlapAvailableDABEnsemblesWorker.access$300(this.this$0);
        }
    }
}

