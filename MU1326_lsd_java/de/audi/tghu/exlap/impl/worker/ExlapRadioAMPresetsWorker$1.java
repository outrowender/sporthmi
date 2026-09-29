/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.tghu.exlap.impl.container.RadioPresetsContainer;
import de.audi.tghu.exlap.impl.listener.ExlapRadioEmptyListener;
import de.audi.tghu.exlap.impl.worker.ExlapRadioAMPresetsWorker;

class ExlapRadioAMPresetsWorker$1
extends ExlapRadioEmptyListener {
    private final /* synthetic */ ExlapRadioAMPresetsWorker this$0;

    ExlapRadioAMPresetsWorker$1(ExlapRadioAMPresetsWorker exlapRadioAMPresetsWorker) {
        this.this$0 = exlapRadioAMPresetsWorker;
    }

    @Override
    public void updateRadioAMPresets(RadioPresetsContainer radioPresetsContainer) {
        ExlapRadioAMPresetsWorker.access$000(this.this$0).log(-2137614336, "[new ExlapRadioEmptyListener#updateRadioAMPresets] received new container: %1", (Object)radioPresetsContainer);
        ExlapRadioAMPresetsWorker.access$102(this.this$0, radioPresetsContainer);
        if (ExlapRadioAMPresetsWorker.access$200(this.this$0) != -1) {
            ExlapRadioAMPresetsWorker.access$300(this.this$0);
        }
    }
}

