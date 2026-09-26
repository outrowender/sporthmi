/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab.stationlist;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tuner.app.RadioBaseListModelListener;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.TunerProxyManager;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.dab.stationlist.DabFolderListHandler;
import de.audi.tuner.app.dab.stationlist.DabListRow;
import de.audi.tuner.ifc.AbstractRadioListRow;

class DabFolderListHandler$ListListener
extends RadioBaseListModelListener {
    private final /* synthetic */ DabFolderListHandler this$0;

    public DabFolderListHandler$ListListener(DabFolderListHandler dabFolderListHandler, TunerModels tunerModels, int n) {
        this.this$0 = dabFolderListHandler;
        super(tunerModels, n);
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        DabFolderListHandler.access$200(this.this$0).abortScan();
        if (this.isNewSelection(evoListRow, n, n2, n3, n4)) {
            DabStation dabStation = DabFolderListHandler.access$300(this.this$0, (DabListRow)evoListRow);
            DabFolderListHandler.access$400(this.this$0).selectStation(dabStation, dabStation.isComponent() ? 3 : 2, n4);
        }
    }

    @Override
    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        DabFolderListHandler.access$200(this.this$0).abortScan();
        if (n2 != DabFolderListHandler.access$500(this.this$0).getSelected()) {
            DabStation dabStation = ((DabListRow)evoListRow).getDabStation();
            TunerProxyManager.getInstance().getDABTuner().selectStation(dabStation, 0, n4);
        }
        if (DabFolderListHandler.access$600(this.this$0) != null) {
            DabFolderListHandler.access$600(this.this$0).prepareStore(n4, ((AbstractRadioListRow)evoListRow).getTOContainer());
        }
    }
}

