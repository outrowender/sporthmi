/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.SelectedItem;
import de.audi.atip.hmi.model.update.ModelTrigger;
import de.audi.tuner.app.MemoryListHandler;
import de.audi.tuner.app.RadioBaseListModelListener;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.TunerProxyManager;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.memory.AbstractMemoryRow;
import de.audi.tuner.app.sdars.StationInfoExt;

class MemoryListHandler$ListListener
extends RadioBaseListModelListener {
    private final /* synthetic */ MemoryListHandler this$0;

    public MemoryListHandler$ListListener(MemoryListHandler memoryListHandler, TunerModels tunerModels, int n) {
        this.this$0 = memoryListHandler;
        super(tunerModels, n);
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        if (n == -1970732800) {
            n2 = MemoryListHandler.access$1700(this.this$0).getIndexForUniqueID(evoListRow.getUniqueID());
            n = 1938292992;
        }
        MemoryListHandler.access$2600(this.this$0).abortScan();
        if (((AbstractMemoryRow)evoListRow).isEmpty() && MemoryListHandler.access$2700(this.this$0) != 1) {
            MemoryListHandler.access$2702(this.this$0, 2);
            MemoryListHandler.access$2800(this.this$0).getChoiceModel(2022244608).setValue(1);
            MemoryListHandler.access$2902(this.this$0, n2);
            MemoryListHandler.access$1700(this.this$0).fireEvent(n4);
        } else if (MemoryListHandler.access$2700(this.this$0) == 0) {
            boolean bl = this.isNewSelection(evoListRow, n, n2, n3, n4);
            if (bl) {
                int n5 = ((AbstractMemoryRow)evoListRow).getState();
                TunerObjectContainer tunerObjectContainer = ((AbstractMemoryRow)evoListRow).getTOContainer();
                if (TunerProxyManager.getInstance().isTuneForbidden(n5, tunerObjectContainer)) {
                    return;
                }
                SelectedItem selectedItem = MemoryListHandler.access$1700(this.this$0).getSelected();
                int n6 = selectedItem != null ? selectedItem.getIndex() : -1;
                MemoryListHandler.access$3000(this.this$0, n6, n2);
                MemoryListHandler.access$3100(this.this$0, n2);
                MemoryListHandler.access$3200(this.this$0, (AbstractMemoryRow)evoListRow, n2, n4);
            }
            MemoryListHandler.access$2800(this.this$0).getChoiceModel(-494403328).setValue(0);
        } else {
            if (Utilities.isNARBuild()) {
                int n7;
                BaseListModelApp baseListModelApp = MemoryListHandler.access$2800(this.this$0).getBaseListModel(n).getCopy();
                if (n2 != MemoryListHandler.access$3300(this.this$0)) {
                    baseListModelApp.setRow(MemoryListHandler.access$3300(this.this$0), MemoryListHandler.access$3400(this.this$0).getEmptyFavRow(MemoryListHandler.access$3300(this.this$0)));
                }
                MemoryListHandler.access$3500(this.this$0).setPresetIndex(n2);
                baseListModelApp.setRow(n2, MemoryListHandler.access$3500(this.this$0));
                SelectedItem selectedItem = baseListModelApp.getSelected();
                if (selectedItem != null && ((n7 = selectedItem.getIndex()) == MemoryListHandler.access$3300(this.this$0) || n7 == n2)) {
                    baseListModelApp.setSelectedIndex(-1);
                }
                baseListModelApp.trigger(ModelTrigger.DEACTIVATE_MOVE_MODE);
                MemoryListHandler.access$2800(this.this$0).getBaseListModel(n).update(baseListModelApp);
                MemoryListHandler.access$2000(this.this$0).memoryListPresetIndexChanged(MemoryListHandler.access$3300(this.this$0), null);
                MemoryListHandler.access$2000(this.this$0).memoryListPresetIndexChanged(n2, MemoryListHandler.access$3500(this.this$0).getTOContainer());
                MemoryListHandler.access$1800(this.this$0);
            } else if (n2 != MemoryListHandler.access$3300(this.this$0)) {
                BaseListModelApp baseListModelApp = MemoryListHandler.access$2800(this.this$0).getBaseListModel(n).getCopy();
                long l = evoListRow.getUniqueID();
                if (n2 < MemoryListHandler.access$3300(this.this$0)) {
                    baseListModelApp.remove(MemoryListHandler.access$3500(this.this$0));
                    baseListModelApp.insertBefore(l, MemoryListHandler.access$3500(this.this$0));
                } else if (n2 > MemoryListHandler.access$3300(this.this$0)) {
                    baseListModelApp.remove(MemoryListHandler.access$3500(this.this$0));
                    baseListModelApp.insertAfter(l, MemoryListHandler.access$3500(this.this$0));
                }
                baseListModelApp.trigger(ModelTrigger.DEACTIVATE_MOVE_MODE);
                MemoryListHandler.access$2800(this.this$0).getBaseListModel(n).update(baseListModelApp);
                MemoryListHandler.access$1800(this.this$0);
            } else {
                MemoryListHandler.access$2800(this.this$0).getBaseListModel(n).trigger(ModelTrigger.DEACTIVATE_MOVE_MODE);
            }
            MemoryListHandler.access$2702(this.this$0, 0);
            MemoryListHandler.access$2800(this.this$0).getChoiceModel(-494403328).setValue(0);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        AbstractMemoryRow abstractMemoryRow = (AbstractMemoryRow)evoListRow;
        if (abstractMemoryRow.isEmpty() && !MemoryListHandler.access$2600(this.this$0).isScanActive()) {
            Object object = MemoryListHandler.access$3600(this.this$0);
            synchronized (object) {
                if (MemoryListHandler.access$3700(this.this$0) != -1) {
                    MemoryListHandler.access$3800(this.this$0);
                }
                MemoryListHandler.access$3702(this.this$0, n2);
            }
            MemoryListHandler.access$3900(this.this$0).restart();
        } else {
            MemoryListHandler.access$3800(this.this$0);
            MemoryListHandler.access$4002(this.this$0, evoListRow.getUniqueID());
            int n5 = -1;
            if (abstractMemoryRow.isSDARS()) {
                StationInfoExt stationInfoExt = abstractMemoryRow.getTOContainer().getSDARSService();
                n5 = stationInfoExt.sID;
                boolean bl = TunerProxyManager.getInstance().getSdarsEpgHandler().isEPGAvailableFor(stationInfoExt, MemoryListHandler.access$4100(this.this$0));
                MemoryListHandler.access$4100(this.this$0).epgAvailibiltyChanged(stationInfoExt, bl);
            }
            MemoryListHandler.access$4200(this.this$0, n5);
        }
    }
}

