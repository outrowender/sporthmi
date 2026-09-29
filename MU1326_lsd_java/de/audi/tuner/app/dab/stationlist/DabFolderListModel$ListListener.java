/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab.stationlist;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.BaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.SelectedItem;
import de.audi.atip.hmi.model.menu.focus.FocusAdvice;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.dab.stationlist.DabFolderListModel;
import de.audi.tuner.app.dab.stationlist.DabFolderListModel$1;
import de.audi.tuner.app.dab.stationlist.DabListRow;
import java.util.List;

class DabFolderListModel$ListListener
implements BaseListModelListener {
    private volatile boolean focusSet = false;
    private final /* synthetic */ DabFolderListModel this$0;

    private DabFolderListModel$ListListener(DabFolderListModel dabFolderListModel) {
        this.this$0 = dabFolderListModel;
    }

    @Override
    public void itemReleased(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        if (((DabListRow)evoListRow).isEnsemble()) {
            BaseListModelApp baseListModelApp;
            List list = DabFolderListModel.access$100(this.this$0);
            synchronized (list) {
                baseListModelApp = DabFolderListModel.access$200(this.this$0).getCopy();
                SelectedItem selectedItem = baseListModelApp.getSelected();
                long l = selectedItem != null ? selectedItem.getUniqueID() : 0L;
                DabListRow dabListRow = (DabListRow)DabFolderListModel.access$100(this.this$0).get(this.this$0.getIndexForUniqueID(evoListRow.getUniqueID()));
                DabStation dabStation = DabFolderListModel.access$300(this.this$0).getCurrentStation();
                if (dabListRow.isActive(dabStation)) {
                    baseListModelApp.setSelectedIndex(-1);
                }
                if (DabFolderListModel.access$400(this.this$0, dabListRow)) {
                    int n5 = DabFolderListModel.access$500(this.this$0, dabListRow);
                    baseListModelApp.removeAndClose(evoListRow.getUniqueID(), n5);
                    dabListRow.close(dabStation);
                    if (dabListRow.isActive(dabStation)) {
                        l = dabListRow.getUniqueID();
                    }
                    DabFolderListModel.access$600(this.this$0, dabListRow);
                } else {
                    EvoListRow[] evoListRowArray = DabFolderListModel.access$700(this.this$0, dabListRow);
                    baseListModelApp.insertAfterAndOpen(evoListRow.getUniqueID(), evoListRowArray);
                    if (DabFolderListModel.access$800(this.this$0) != -1L && dabListRow.isActive(dabStation)) {
                        l = DabFolderListModel.access$800(this.this$0);
                    }
                    dabListRow.open(dabStation);
                    DabFolderListModel.access$900(this.this$0, dabListRow);
                }
                baseListModelApp.setRow(n2, dabListRow);
                baseListModelApp.setSelectedUniqueID(l);
            }
            DabFolderListModel.access$200(this.this$0).update(baseListModelApp);
            DabFolderListModel.access$1000(this.this$0).getMenuModel(310903040).setFocusedItem(n, FocusAdvice.KEEP_POSITION, evoListRow.getUniqueID());
            this.focusSet = true;
        } else {
            int n6 = this.this$0.getIndexForUniqueID(evoListRow.getUniqueID());
            DabFolderListModel.access$1100(this.this$0).itemSelected(evoListRow, n, n6, n3, n4);
        }
    }

    @Override
    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        int n5 = this.this$0.getIndexForUniqueID(evoListRow.getUniqueID());
        DabFolderListModel.access$1100(this.this$0).itemLongSelected(evoListRow, n, n5, n3, n4);
    }

    @Override
    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        if (this.focusSet) {
            DabFolderListModel.access$1000(this.this$0).getMenuModel(310903040).resetFocusedItem();
            this.focusSet = false;
        }
    }

    /* synthetic */ DabFolderListModel$ListListener(DabFolderListModel dabFolderListModel, DabFolderListModel$1 dabFolderListModel$1) {
        this(dabFolderListModel);
    }
}

