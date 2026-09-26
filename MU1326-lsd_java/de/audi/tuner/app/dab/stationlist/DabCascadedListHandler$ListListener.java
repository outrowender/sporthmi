/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab.stationlist;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.list.SelectedItem;
import de.audi.tuner.app.RadioBaseListModelListener;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.dab.stationlist.DabCascadedListHandler;
import de.audi.tuner.app.dab.stationlist.DabListRow;
import de.audi.tuner.ifc.AbstractRadioListRow;

class DabCascadedListHandler$ListListener
extends RadioBaseListModelListener {
    private final /* synthetic */ DabCascadedListHandler this$0;

    public DabCascadedListHandler$ListListener(DabCascadedListHandler dabCascadedListHandler, TunerModels tunerModels, int n) {
        this.this$0 = dabCascadedListHandler;
        super(tunerModels, n);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        DabCascadedListHandler.access$200(this.this$0).abortScan();
        DabStation dabStation = DabCascadedListHandler.access$300(this.this$0, (DabListRow)evoListRow);
        if (n == 998834432) {
            boolean bl;
            boolean bl2 = bl = n3 == 6;
            if (bl) {
                if (DabCascadedListHandler.access$400(this.this$0) != null) {
                    DabCascadedListHandler.access$400(this.this$0).prepareStore(n4, ((AbstractRadioListRow)evoListRow).getTOContainer());
                }
            } else if (this.isNewSelection(evoListRow, n, n2, n3, n4)) {
                DabCascadedListHandler.access$500(this.this$0).selectStation(dabStation, dabStation.isComponent() ? 3 : 2, n4);
            }
        } else if (n == 1015611648) {
            DabCascadedListHandler.access$602(this.this$0, dabStation);
            Object object = DabCascadedListHandler.access$700(this.this$0);
            synchronized (object) {
                DabCascadedListHandler.access$800(this.this$0, DabCascadedListHandler.access$600((DabCascadedListHandler)this.this$0).ensemble);
            }
            DabCascadedListHandler.access$900(this.this$0).fireEvent(n4);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        DabCascadedListHandler.access$200(this.this$0).abortScan();
        if (n == 998834432) {
            SelectedItem selectedItem = null;
            Object object = DabCascadedListHandler.access$700(this.this$0);
            synchronized (object) {
                selectedItem = DabCascadedListHandler.access$1000(this.this$0).getSelected();
            }
            if (selectedItem == null || n2 != selectedItem.getIndex()) {
                object = ((DabListRow)evoListRow).getDabStation();
                DabCascadedListHandler.access$500(this.this$0).selectStation((DabStation)object, 0, n4);
            }
            if (DabCascadedListHandler.access$400(this.this$0) != null) {
                DabCascadedListHandler.access$400(this.this$0).prepareStore(n4, ((AbstractRadioListRow)evoListRow).getTOContainer());
            }
        }
    }
}

