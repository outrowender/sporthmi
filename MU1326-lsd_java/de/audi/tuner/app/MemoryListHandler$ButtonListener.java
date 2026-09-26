/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.tuner.app.MemoryListHandler;
import de.audi.tuner.app.MemoryListHandler$1;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.memory.AbstractMemoryRow;

class MemoryListHandler$ButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ MemoryListHandler this$0;

    private MemoryListHandler$ButtonListener(MemoryListHandler memoryListHandler) {
        this.this$0 = memoryListHandler;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        switch (n) {
            case 100617: {
                if (MemoryListHandler.access$2700(this.this$0) != 2 || MemoryListHandler.access$2900(this.this$0) == -1) break;
                TunerObjectContainer tunerObjectContainer = MemoryListHandler.access$4900(this.this$0);
                AbstractMemoryRow abstractMemoryRow = MemoryListHandler.access$5000(this.this$0, tunerObjectContainer, MemoryListHandler.access$2900(this.this$0) + 1);
                MemoryListHandler.access$1700(this.this$0).setRow(MemoryListHandler.access$2900(this.this$0), abstractMemoryRow);
                MemoryListHandler.access$2000(this.this$0).memoryListPresetIndexChanged(MemoryListHandler.access$2900(this.this$0), tunerObjectContainer);
                MemoryListHandler.access$2902(this.this$0, -1);
                MemoryListHandler.access$2702(this.this$0, 0);
                MemoryListHandler.access$2800(this.this$0).getChoiceModel(2022244608).setValue(0);
                MemoryListHandler.access$1800(this.this$0);
                MemoryListHandler.access$2800(this.this$0).getButtonModel(n).fireEvent(n3);
                break;
            }
            case 100331: {
                MemoryListHandler.access$4500(this.this$0);
                MemoryListHandler.access$2800(this.this$0).getButtonModel(-343473920).fireEvent(0);
                break;
            }
        }
    }

    /* synthetic */ MemoryListHandler$ButtonListener(MemoryListHandler memoryListHandler, MemoryListHandler$1 memoryListHandler$1) {
        this(memoryListHandler);
    }
}

