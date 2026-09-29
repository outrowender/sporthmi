/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.tuner.app.MemoryListHandler;
import de.audi.tuner.app.MemoryListHandler$1;
import de.audi.tuner.sds.DefaultUpdateListener;

class MemoryListHandler$UpdateListener
extends DefaultUpdateListener {
    private final /* synthetic */ MemoryListHandler this$0;

    private MemoryListHandler$UpdateListener(MemoryListHandler memoryListHandler) {
        this.this$0 = memoryListHandler;
    }

    @Override
    public void updatedMuteStatus(int n, boolean bl) {
        if (n == 5) {
            MemoryListHandler.access$1400(this.this$0).updatedMuteStatus(bl);
        }
    }

    /* synthetic */ MemoryListHandler$UpdateListener(MemoryListHandler memoryListHandler, MemoryListHandler$1 memoryListHandler$1) {
        this(memoryListHandler);
    }
}

