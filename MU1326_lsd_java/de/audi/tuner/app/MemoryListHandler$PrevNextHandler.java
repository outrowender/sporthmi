/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.SelectedItem;
import de.audi.atip.hmi.model.update.ModelTrigger;
import de.audi.tuner.app.MemoryListHandler;
import de.audi.tuner.app.MemoryListHandler$1;
import de.audi.tuner.app.memory.AbstractMemoryRow;
import de.audi.tuner.ifc.IPrevNext;

class MemoryListHandler$PrevNextHandler
implements IPrevNext {
    private final /* synthetic */ MemoryListHandler this$0;

    private MemoryListHandler$PrevNextHandler(MemoryListHandler memoryListHandler) {
        this.this$0 = memoryListHandler;
    }

    private AbstractMemoryRow getNextRow(boolean bl) {
        int[] nArray = this.getIndices(bl);
        for (int i2 = 0; i2 < nArray.length; ++i2) {
            AbstractMemoryRow abstractMemoryRow = (AbstractMemoryRow)MemoryListHandler.access$1700(this.this$0).getRow(nArray[i2]);
            if (!abstractMemoryRow.isOccupied() || abstractMemoryRow.getState() != 0) continue;
            return abstractMemoryRow;
        }
        return null;
    }

    private int[] getIndices(boolean bl) {
        int n;
        int[] nArray = new int[MemoryListHandler.access$1700(this.this$0).getLength()];
        SelectedItem selectedItem = MemoryListHandler.access$1700(this.this$0).getSelected();
        int n2 = n = selectedItem != null ? selectedItem.getIndex() : -1;
        if (bl) {
            if (++n >= MemoryListHandler.access$1700(this.this$0).getLength()) {
                n = 0;
            }
            int n3 = 0;
            int n4 = n;
            while (n4 < MemoryListHandler.access$1700(this.this$0).getLength()) {
                nArray[n3++] = n4++;
            }
            n4 = 0;
            while (n4 < n) {
                nArray[n3++] = n4++;
            }
        } else {
            if (--n < 0) {
                n = MemoryListHandler.access$1700(this.this$0).getLength() - 1;
            }
            int n5 = 0;
            int n6 = n;
            while (n6 >= 0) {
                nArray[n5++] = n6--;
            }
            n6 = MemoryListHandler.access$1700(this.this$0).getLength() - 1;
            while (n6 > n) {
                nArray[n5++] = n6--;
            }
        }
        return nArray;
    }

    @Override
    public void handlePrevNext(boolean bl) {
        Object object;
        if (MemoryListHandler.access$2700(this.this$0) == 1) {
            object = MemoryListHandler.access$2800(this.this$0).getBaseListModel(1938292992);
            object.trigger(ModelTrigger.DEACTIVATE_MOVE_MODE);
            MemoryListHandler.access$3500(this.this$0).setPresetIndex(MemoryListHandler.access$3300(this.this$0));
            object.setRow(MemoryListHandler.access$3300(this.this$0), MemoryListHandler.access$3500(this.this$0));
            MemoryListHandler.access$2702(this.this$0, 0);
            MemoryListHandler.access$2800(this.this$0).getChoiceModel(2022244608).setValue(0);
            MemoryListHandler.access$2800(this.this$0).getChoiceModel(-494403328).setValue(0);
        }
        if ((object = this.getNextRow(bl)) == null) {
            return;
        }
        int n = MemoryListHandler.access$1700(this.this$0).getIndexForUniqueID(((EvoListRow)object).getUniqueID());
        SelectedItem selectedItem = MemoryListHandler.access$1700(this.this$0).getSelected();
        int n2 = selectedItem != null ? selectedItem.getIndex() : -1;
        MemoryListHandler.access$3000(this.this$0, n2, n);
        MemoryListHandler.access$3100(this.this$0, n);
        MemoryListHandler.access$3200(this.this$0, (AbstractMemoryRow)object, n, 0);
        if (!MemoryListHandler.access$4700(this.this$0).isDrawerOpen()) {
            MemoryListHandler.access$2500(this.this$0).trigger(ModelTrigger.JOIN_CURSOR);
        }
    }

    /* synthetic */ MemoryListHandler$PrevNextHandler(MemoryListHandler memoryListHandler, MemoryListHandler$1 memoryListHandler$1) {
        this(memoryListHandler);
    }
}

