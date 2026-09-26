/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.tghu.exlap.impl.container.RadioStationInfoContainer;
import de.audi.tghu.exlap.impl.listener.ExlapRadioEmptyListener;
import de.audi.tghu.exlap.impl.worker.ExlapRadioTunerWorker;

class ExlapRadioTunerWorker$1
extends ExlapRadioEmptyListener {
    private final /* synthetic */ ExlapRadioTunerWorker this$0;

    ExlapRadioTunerWorker$1(ExlapRadioTunerWorker exlapRadioTunerWorker) {
        this.this$0 = exlapRadioTunerWorker;
    }

    @Override
    public void updateRadioTuner(RadioStationInfoContainer radioStationInfoContainer) {
        ExlapRadioTunerWorker.access$000(this.this$0).log(-2137614336, "[new ExlapRadioEmptyListener#updateRadioTuner] received new container: %1", (Object)radioStationInfoContainer);
        ExlapRadioTunerWorker.access$102(this.this$0, radioStationInfoContainer);
        if (ExlapRadioTunerWorker.access$200(this.this$0) != -1) {
            ExlapRadioTunerWorker.access$300(this.this$0);
        }
    }
}

