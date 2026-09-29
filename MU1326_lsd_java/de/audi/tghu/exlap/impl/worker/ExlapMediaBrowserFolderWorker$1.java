/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.exlap.impl.worker;

import de.audi.tghu.exlap.impl.container.MediaBrowserPathContainer;
import de.audi.tghu.exlap.impl.listener.ExlapMediaEmptyListener;
import de.audi.tghu.exlap.impl.worker.ExlapMediaBrowserFolderWorker;

class ExlapMediaBrowserFolderWorker$1
extends ExlapMediaEmptyListener {
    private final /* synthetic */ ExlapMediaBrowserFolderWorker this$0;

    ExlapMediaBrowserFolderWorker$1(ExlapMediaBrowserFolderWorker exlapMediaBrowserFolderWorker) {
        this.this$0 = exlapMediaBrowserFolderWorker;
    }

    @Override
    public void updateMediaBrowserFolder(MediaBrowserPathContainer mediaBrowserPathContainer) {
        ExlapMediaBrowserFolderWorker.access$000(this.this$0).log(-2137614336, "[new ExlapMediaEmptyListener#updateMediaBrowserFolder] received new container: %1", (Object)mediaBrowserPathContainer);
        ExlapMediaBrowserFolderWorker.access$102(this.this$0, mediaBrowserPathContainer);
        if (ExlapMediaBrowserFolderWorker.access$200(this.this$0) != -1) {
            ExlapMediaBrowserFolderWorker.access$300(this.this$0);
        }
    }
}

