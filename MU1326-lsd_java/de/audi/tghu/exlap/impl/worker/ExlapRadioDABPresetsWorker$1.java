/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.tghu.exlap.impl.container.RadioPresetsContainer;
import de.audi.tghu.exlap.impl.listener.ExlapRadioEmptyListener;
import de.audi.tghu.exlap.impl.worker.ExlapRadioDABPresetsWorker;

class ExlapRadioDABPresetsWorker$1
extends ExlapRadioEmptyListener {
    private final /* synthetic */ ExlapRadioDABPresetsWorker this$0;

    ExlapRadioDABPresetsWorker$1(ExlapRadioDABPresetsWorker exlapRadioDABPresetsWorker) {
        this.this$0 = exlapRadioDABPresetsWorker;
    }

    @Override
    public void updateRadioDABPresets(RadioPresetsContainer radioPresetsContainer) {
        ExlapRadioDABPresetsWorker.access$000(this.this$0).log(-2137614336, "[new ExlapRadioEmptyListener#updateRadioDABPresets] received new container: %1", (Object)radioPresetsContainer);
        ExlapRadioDABPresetsWorker.access$102(this.this$0, radioPresetsContainer);
        if (ExlapRadioDABPresetsWorker.access$200(this.this$0) != -1) {
            ExlapRadioDABPresetsWorker.access$300(this.this$0);
        }
    }
}

