/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.tghu.exlap.impl.container.ContextStatesContainer;
import de.audi.tghu.exlap.impl.listener.ExlapExlapEmptyListener;
import de.audi.tghu.exlap.impl.worker.ExlapContextStatesWorker;

class ExlapContextStatesWorker$1
extends ExlapExlapEmptyListener {
    private final /* synthetic */ ExlapContextStatesWorker this$0;

    ExlapContextStatesWorker$1(ExlapContextStatesWorker exlapContextStatesWorker) {
        this.this$0 = exlapContextStatesWorker;
    }

    @Override
    public void updateContextStates(ContextStatesContainer contextStatesContainer) {
        ExlapContextStatesWorker.access$000(this.this$0).log(-2137614336, "[new ExlapExlapEmptyListener#updateContextStates] received new container: %1", (Object)contextStatesContainer);
        ExlapContextStatesWorker.access$102(this.this$0, contextStatesContainer);
        if (ExlapContextStatesWorker.access$200(this.this$0) != -1) {
            ExlapContextStatesWorker.access$300(this.this$0);
        }
    }
}

