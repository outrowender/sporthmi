/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.tghu.exlap.impl.container.ListStateContainer;
import de.audi.tghu.exlap.impl.listener.ExlapMediaEmptyListener;
import de.audi.tghu.exlap.impl.worker.ExlapMediaBrowserListWorker;

class ExlapMediaBrowserListWorker$1
extends ExlapMediaEmptyListener {
    private final /* synthetic */ ExlapMediaBrowserListWorker this$0;

    ExlapMediaBrowserListWorker$1(ExlapMediaBrowserListWorker exlapMediaBrowserListWorker) {
        this.this$0 = exlapMediaBrowserListWorker;
    }

    @Override
    public void updateMediaBrowserList(ListStateContainer listStateContainer) {
        ExlapMediaBrowserListWorker.access$000(this.this$0).log(-2137614336, "[new ExlapMediaEmptyListener#updateMediaBrowserList] received new container: %1", (Object)listStateContainer);
        ExlapMediaBrowserListWorker.access$102(this.this$0, listStateContainer);
        if (ExlapMediaBrowserListWorker.access$200(this.this$0) != -1) {
            ExlapMediaBrowserListWorker.access$300(this.this$0);
        }
    }
}

