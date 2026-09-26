/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tuner.app.MemoryListHandler;
import de.audi.tuner.app.MemoryListHandler$1;
import de.audi.tuner.app.memory.EmptyMemoryRow;

class MemoryListHandler$TimerListener
extends DefaultTimerListener {
    private final /* synthetic */ MemoryListHandler this$0;

    private MemoryListHandler$TimerListener(MemoryListHandler memoryListHandler) {
        this.this$0 = memoryListHandler;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void fireTimer(Timer timer) {
        Object object = MemoryListHandler.access$3600(this.this$0);
        synchronized (object) {
            if (MemoryListHandler.access$3700(this.this$0) != -1) {
                EmptyMemoryRow emptyMemoryRow = (EmptyMemoryRow)MemoryListHandler.access$1700(this.this$0).getRow(MemoryListHandler.access$3700(this.this$0));
                emptyMemoryRow.setUserAction(true);
                MemoryListHandler.access$1700(this.this$0).setRow(MemoryListHandler.access$3700(this.this$0), emptyMemoryRow);
            }
        }
    }

    /* synthetic */ MemoryListHandler$TimerListener(MemoryListHandler memoryListHandler, MemoryListHandler$1 memoryListHandler$1) {
        this(memoryListHandler);
    }
}

