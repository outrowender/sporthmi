/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.tghu.exlap.impl.container.RadioFrequencyRangesContainer;
import de.audi.tghu.exlap.impl.listener.ExlapRadioEmptyListener;
import de.audi.tghu.exlap.impl.worker.ExlapRadioFrequencyRangesWorker;

class ExlapRadioFrequencyRangesWorker$1
extends ExlapRadioEmptyListener {
    private final /* synthetic */ ExlapRadioFrequencyRangesWorker this$0;

    ExlapRadioFrequencyRangesWorker$1(ExlapRadioFrequencyRangesWorker exlapRadioFrequencyRangesWorker) {
        this.this$0 = exlapRadioFrequencyRangesWorker;
    }

    @Override
    public void updateRadioFrequencyRanges(RadioFrequencyRangesContainer radioFrequencyRangesContainer) {
        ExlapRadioFrequencyRangesWorker.access$000(this.this$0).log(-2137614336, "[new ExlapRadioEmptyListener#updateRadioFrequencyRanges] received new container: %1", (Object)radioFrequencyRangesContainer);
        ExlapRadioFrequencyRangesWorker.access$102(this.this$0, radioFrequencyRangesContainer);
        if (ExlapRadioFrequencyRangesWorker.access$200(this.this$0) != -1) {
            ExlapRadioFrequencyRangesWorker.access$300(this.this$0);
        }
    }
}

