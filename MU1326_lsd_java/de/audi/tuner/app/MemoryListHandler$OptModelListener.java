/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.atip.hmi.model.DefaultOptionListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.SelectedItem;
import de.audi.atip.hmi.model.update.ModelTrigger;
import de.audi.tuner.app.MemoryListHandler;
import de.audi.tuner.app.MemoryListHandler$1;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.memory.AbstractMemoryRow;
import de.audi.tuner.ifc.AbstractRadioListRow;

class MemoryListHandler$OptModelListener
extends DefaultOptionListener {
    private final /* synthetic */ MemoryListHandler this$0;

    private MemoryListHandler$OptModelListener(MemoryListHandler memoryListHandler) {
        this.this$0 = memoryListHandler;
    }

    @Override
    public void keyTyped(int n, int n2, int n3, int n4, int n5) {
        MemoryListHandler.access$1500((MemoryListHandler)this.this$0).main.log(-2137614336, "[MLH.keyTyped] targetModelID %1, targetRow %2", (long)n2, (long)n3);
        switch (n) {
            case 100268: {
                try {
                    AbstractRadioListRow abstractRadioListRow = (AbstractRadioListRow)MemoryListHandler.access$2800(this.this$0).getBaseListModel(n2).getRow(n3);
                    MemoryListHandler.access$4300(this.this$0, abstractRadioListRow.getTOContainer());
                    int n6 = Utilities.isNARBuild() ? 2 : 1;
                    MemoryListHandler.access$4400(this.this$0).showPartialPopup(n6);
                    MemoryListHandler.access$2800(this.this$0).getOptionModel(-1400438528).fireEvent(n5);
                }
                catch (Exception exception) {
                    MemoryListHandler.access$1500((MemoryListHandler)this.this$0).main.log(10000, "%1", (Throwable)exception);
                }
                break;
            }
            case 100470: {
                if (MemoryListHandler.access$1700(this.this$0).getLength() == 1) {
                    MemoryListHandler.access$4500(this.this$0);
                    return;
                }
                if (MemoryListHandler.access$1700(this.this$0).getID() == n2) {
                    EvoListRow evoListRow = MemoryListHandler.access$1700(this.this$0).getRow(n3);
                    TunerObjectContainer tunerObjectContainer = null;
                    SelectedItem selectedItem = MemoryListHandler.access$1700(this.this$0).getSelected();
                    if (selectedItem != null && selectedItem.getUniqueID() == evoListRow.getUniqueID()) {
                        tunerObjectContainer = ((AbstractMemoryRow)evoListRow).getTOContainer();
                    }
                    if (Utilities.isNARBuild()) {
                        int n7 = MemoryListHandler.access$1700(this.this$0).getIndexForUniqueID(evoListRow.getUniqueID());
                        MemoryListHandler.access$1700(this.this$0).setRow(n7, MemoryListHandler.access$3400(this.this$0).getEmptyFavRow(n7));
                        MemoryListHandler.access$2000(this.this$0).memoryListPresetIndexChanged(n7, null);
                    } else {
                        MemoryListHandler.access$1700(this.this$0).remove(evoListRow);
                    }
                    if (tunerObjectContainer != null) {
                        MemoryListHandler.access$4600(this.this$0, tunerObjectContainer.getBand(), n5);
                    }
                }
                MemoryListHandler.access$1800(this.this$0);
                break;
            }
            case 100531: {
                MemoryListHandler.access$2702(this.this$0, 1);
                MemoryListHandler.access$2800(this.this$0).getChoiceModel(2022244608).setValue(0);
                MemoryListHandler.access$3502(this.this$0, (AbstractMemoryRow)MemoryListHandler.access$2800(this.this$0).getBaseListModel(n2).getRow(n3));
                MemoryListHandler.access$3302(this.this$0, MemoryListHandler.access$2800(this.this$0).getBaseListModel(n2).getIndexForUniqueID(MemoryListHandler.access$3500(this.this$0).getUniqueID()));
                MemoryListHandler.access$2800(this.this$0).getBaseListModel(n2).trigger(ModelTrigger.ACTIVATE_MOVE_MODE);
                MemoryListHandler.access$2800(this.this$0).getChoiceModel(-494403328).setValue(1);
                break;
            }
        }
    }

    /* synthetic */ MemoryListHandler$OptModelListener(MemoryListHandler memoryListHandler, MemoryListHandler$1 memoryListHandler$1) {
        this(memoryListHandler);
    }
}

