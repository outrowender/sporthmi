/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.tuner.app.HmiAppListener;
import de.audi.tuner.app.MemoryListHandler;
import de.audi.tuner.app.MemoryListHandler$1;

class MemoryListHandler$HmiAppListenerExt
extends HmiAppListener {
    private final /* synthetic */ MemoryListHandler this$0;

    private MemoryListHandler$HmiAppListenerExt(MemoryListHandler memoryListHandler) {
        this.this$0 = memoryListHandler;
    }

    @Override
    public void screenFadedOut(int n, int n2) {
        if (MemoryListHandler.access$4800(this.this$0) && n == MemoryListHandler.access$4400(this.this$0).getFavoriteScreenId()) {
            this.this$0.clearMemoryList();
            MemoryListHandler.access$4400(this.this$0).showPartialPopup(3);
            MemoryListHandler.access$4802(this.this$0, false);
        }
    }

    /* synthetic */ MemoryListHandler$HmiAppListenerExt(MemoryListHandler memoryListHandler, MemoryListHandler$1 memoryListHandler$1) {
        this(memoryListHandler);
    }
}

