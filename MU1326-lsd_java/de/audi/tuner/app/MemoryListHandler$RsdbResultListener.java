/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.tuner.app.MemoryListHandler;
import de.audi.tuner.app.MemoryListHandler$1;
import de.audi.tuner.app.rsdb.IRSDBResult;

class MemoryListHandler$RsdbResultListener
implements IRSDBResult {
    private final /* synthetic */ MemoryListHandler this$0;

    private MemoryListHandler$RsdbResultListener(MemoryListHandler memoryListHandler) {
        this.this$0 = memoryListHandler;
    }

    @Override
    public void resultAvailable() {
        this.this$0.initMemoryList(this.this$0.logoDb);
    }

    /* synthetic */ MemoryListHandler$RsdbResultListener(MemoryListHandler memoryListHandler, MemoryListHandler$1 memoryListHandler$1) {
        this(memoryListHandler);
    }
}

