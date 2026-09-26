/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.tuner.app.MemoryListHandler;
import de.audi.tuner.app.MemoryListHandler$1;
import de.audi.tuner.app.MemoryListHandler$RsdbResultListener;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.rsdb.IRadioDatabaseListener;
import de.audi.tuner.ifc.ILogoDatabase;

class MemoryListHandler$RsdbStatusListener
implements IRadioDatabaseListener {
    private final /* synthetic */ MemoryListHandler this$0;

    private MemoryListHandler$RsdbStatusListener(MemoryListHandler memoryListHandler) {
        this.this$0 = memoryListHandler;
    }

    @Override
    public void databaseReady(ILogoDatabase iLogoDatabase) {
        if (iLogoDatabase.isRealDatabase()) {
            this.this$0.logoDb = iLogoDatabase;
            TunerObjectContainer[] tunerObjectContainerArray = this.this$0.getList();
            iLogoDatabase.requestDataById(tunerObjectContainerArray, new MemoryListHandler$RsdbResultListener(this.this$0, null));
        } else {
            this.this$0.logoDb = null;
            this.this$0.initMemoryList(null);
        }
    }

    /* synthetic */ MemoryListHandler$RsdbStatusListener(MemoryListHandler memoryListHandler, MemoryListHandler$1 memoryListHandler$1) {
        this(memoryListHandler);
    }
}

