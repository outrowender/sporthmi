/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.tghu.exlap.impl.container.RadioBandsContainer;
import de.audi.tghu.exlap.impl.listener.ExlapRadioEmptyListener;
import de.audi.tghu.exlap.impl.worker.ExlapAvailableRadioBandsWorker;

class ExlapAvailableRadioBandsWorker$1
extends ExlapRadioEmptyListener {
    private final /* synthetic */ ExlapAvailableRadioBandsWorker this$0;

    ExlapAvailableRadioBandsWorker$1(ExlapAvailableRadioBandsWorker exlapAvailableRadioBandsWorker) {
        this.this$0 = exlapAvailableRadioBandsWorker;
    }

    @Override
    public void updateAvailableRadioBands(RadioBandsContainer radioBandsContainer) {
        ExlapAvailableRadioBandsWorker.access$000(this.this$0).log(-2137614336, "[new ExlapRadioEmptyListener#updateAvailableRadioBands] received new container: %1", (Object)radioBandsContainer);
        ExlapAvailableRadioBandsWorker.access$102(this.this$0, radioBandsContainer);
        if (ExlapAvailableRadioBandsWorker.access$200(this.this$0) != -1) {
            ExlapAvailableRadioBandsWorker.access$300(this.this$0);
        }
    }
}

