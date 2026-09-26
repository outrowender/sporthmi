/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.tghu.exlap.impl.container.EntertainmentContextContainer;
import de.audi.tghu.exlap.impl.listener.ExlapSoundEmptyListener;
import de.audi.tghu.exlap.impl.worker.ExlapEntertainmentContextWorker;

class ExlapEntertainmentContextWorker$1
extends ExlapSoundEmptyListener {
    private final /* synthetic */ ExlapEntertainmentContextWorker this$0;

    ExlapEntertainmentContextWorker$1(ExlapEntertainmentContextWorker exlapEntertainmentContextWorker) {
        this.this$0 = exlapEntertainmentContextWorker;
    }

    @Override
    public void updateEntertainmentContext(EntertainmentContextContainer entertainmentContextContainer) {
        ExlapEntertainmentContextWorker.access$000(this.this$0).log(-2137614336, "[new ExlapSoundEmptyListener#updateEntertainmentContext] received new container: %1", (Object)entertainmentContextContainer);
        ExlapEntertainmentContextWorker.access$102(this.this$0, entertainmentContextContainer);
        if (ExlapEntertainmentContextWorker.access$200(this.this$0) != -1) {
            ExlapEntertainmentContextWorker.access$300(this.this$0);
        }
    }
}

