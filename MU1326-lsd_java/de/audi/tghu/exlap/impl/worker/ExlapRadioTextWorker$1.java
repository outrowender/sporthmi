/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.tghu.exlap.impl.container.RadioTextContainer;
import de.audi.tghu.exlap.impl.listener.ExlapRadioEmptyListener;
import de.audi.tghu.exlap.impl.worker.ExlapRadioTextWorker;

class ExlapRadioTextWorker$1
extends ExlapRadioEmptyListener {
    private final /* synthetic */ ExlapRadioTextWorker this$0;

    ExlapRadioTextWorker$1(ExlapRadioTextWorker exlapRadioTextWorker) {
        this.this$0 = exlapRadioTextWorker;
    }

    @Override
    public void updateRadioText(RadioTextContainer radioTextContainer) {
        ExlapRadioTextWorker.access$000(this.this$0).log(-2137614336, "[new ExlapRadioEmptyListener#updateRadioText] received new container: %1", (Object)radioTextContainer);
        ExlapRadioTextWorker.access$102(this.this$0, radioTextContainer);
        if (ExlapRadioTextWorker.access$200(this.this$0) != -1) {
            ExlapRadioTextWorker.access$300(this.this$0);
        }
    }
}

