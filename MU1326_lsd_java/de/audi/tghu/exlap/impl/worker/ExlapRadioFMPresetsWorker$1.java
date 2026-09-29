/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.tghu.exlap.impl.container.RadioPresetsContainer;
import de.audi.tghu.exlap.impl.listener.ExlapRadioEmptyListener;
import de.audi.tghu.exlap.impl.worker.ExlapRadioFMPresetsWorker;

class ExlapRadioFMPresetsWorker$1
extends ExlapRadioEmptyListener {
    private final /* synthetic */ ExlapRadioFMPresetsWorker this$0;

    ExlapRadioFMPresetsWorker$1(ExlapRadioFMPresetsWorker exlapRadioFMPresetsWorker) {
        this.this$0 = exlapRadioFMPresetsWorker;
    }

    @Override
    public void updateRadioFMPresets(RadioPresetsContainer radioPresetsContainer) {
        ExlapRadioFMPresetsWorker.access$000(this.this$0).log(-2137614336, "[new ExlapRadioEmptyListener#updateRadioFMPresets] received new container: %1", (Object)radioPresetsContainer);
        ExlapRadioFMPresetsWorker.access$102(this.this$0, radioPresetsContainer);
        if (ExlapRadioFMPresetsWorker.access$200(this.this$0) != -1) {
            ExlapRadioFMPresetsWorker.access$300(this.this$0);
        }
    }
}

