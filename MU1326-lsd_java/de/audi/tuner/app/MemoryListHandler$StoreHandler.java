/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.tuner.app.IStoreHandler;
import de.audi.tuner.app.MemoryListHandler;
import de.audi.tuner.app.MemoryListHandler$1;
import de.audi.tuner.app.memory.AbstractMemoryRow;
import de.audi.tuner.ifc.AbstractRadioListRow;

class MemoryListHandler$StoreHandler
implements IStoreHandler {
    private final /* synthetic */ MemoryListHandler this$0;

    private MemoryListHandler$StoreHandler(MemoryListHandler memoryListHandler) {
        this.this$0 = memoryListHandler;
    }

    @Override
    public boolean isStoreModeActive() {
        return MemoryListHandler.access$2700(this.this$0) == 2;
    }

    @Override
    public void store(AbstractRadioListRow abstractRadioListRow) {
        if (MemoryListHandler.access$2700(this.this$0) == 2 && MemoryListHandler.access$2900(this.this$0) != -1) {
            AbstractMemoryRow abstractMemoryRow = MemoryListHandler.access$5000(this.this$0, abstractRadioListRow.getTOContainer(), MemoryListHandler.access$2900(this.this$0) + 1);
            MemoryListHandler.access$1700(this.this$0).setRow(MemoryListHandler.access$2900(this.this$0), abstractMemoryRow);
            MemoryListHandler.access$2000(this.this$0).memoryListPresetIndexChanged(MemoryListHandler.access$2900(this.this$0), abstractRadioListRow.getTOContainer());
            MemoryListHandler.access$2902(this.this$0, -1);
            MemoryListHandler.access$2702(this.this$0, 0);
            MemoryListHandler.access$2800(this.this$0).getChoiceModel(2022244608).setValue(0);
            MemoryListHandler.access$1800(this.this$0);
        }
    }

    /* synthetic */ MemoryListHandler$StoreHandler(MemoryListHandler memoryListHandler, MemoryListHandler$1 memoryListHandler$1) {
        this(memoryListHandler);
    }
}

