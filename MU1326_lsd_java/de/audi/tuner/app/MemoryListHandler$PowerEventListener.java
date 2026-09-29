/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.tuner.app.MemoryListHandler;
import de.audi.tuner.app.MemoryListHandler$1;
import de.audi.tuner.ifc.IPowerEvent;

class MemoryListHandler$PowerEventListener
implements IPowerEvent {
    private final /* synthetic */ MemoryListHandler this$0;

    private MemoryListHandler$PowerEventListener(MemoryListHandler memoryListHandler) {
        this.this$0 = memoryListHandler;
    }

    @Override
    public void notifyPowerEvent(int n, int n2) {
        if (n == 2) {
            this.this$0.cancelActions();
        }
    }

    /* synthetic */ MemoryListHandler$PowerEventListener(MemoryListHandler memoryListHandler, MemoryListHandler$1 memoryListHandler$1) {
        this(memoryListHandler);
    }
}

