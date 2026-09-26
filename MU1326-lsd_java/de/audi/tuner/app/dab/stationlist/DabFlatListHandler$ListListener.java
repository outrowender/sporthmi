/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab.stationlist;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.menu.MenuModelListener;
import de.audi.tuner.app.RadioBaseListModelListener;
import de.audi.tuner.app.RadioComparators;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.TunerProxyManager;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.dab.stationlist.DabFlatListHandler;
import de.audi.tuner.app.dab.stationlist.DabListRow;
import de.audi.tuner.ifc.AbstractRadioListRow;
import java.util.List;

class DabFlatListHandler$ListListener
extends RadioBaseListModelListener
implements MenuModelListener {
    private final /* synthetic */ DabFlatListHandler this$0;

    public DabFlatListHandler$ListListener(DabFlatListHandler dabFlatListHandler, TunerModels tunerModels, int n) {
        this.this$0 = dabFlatListHandler;
        super(tunerModels, n);
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        boolean bl;
        DabFlatListHandler.access$800(this.this$0).abortScan();
        boolean bl2 = bl = n3 == 6;
        if (bl) {
            if (DabFlatListHandler.access$900(this.this$0) != null) {
                DabFlatListHandler.access$900(this.this$0).prepareStore(n4, ((AbstractRadioListRow)evoListRow).getTOContainer());
            }
        } else if (this.isNewSelection(evoListRow, n, n2, n3, n4)) {
            DabStation dabStation = ((DabListRow)evoListRow).getDabStation();
            DabStation dabStation2 = DabFlatListHandler.access$1000(this.this$0).getActiveStation();
            DabStation dabStation3 = RadioComparators.equals(dabStation2, dabStation) ? dabStation2 : dabStation;
            TunerProxyManager.getInstance().getDABTuner().selectStation(dabStation3, dabStation3.isComponent() ? 3 : 1, n4);
        }
    }

    @Override
    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        DabFlatListHandler.access$800(this.this$0).abortScan();
        if (n2 != DabFlatListHandler.access$1100(this.this$0).getSelected().getIndex()) {
            DabStation dabStation = ((DabListRow)evoListRow).getDabStation();
            TunerProxyManager.getInstance().getDABTuner().selectStation(dabStation, 0, n4);
        }
        if (DabFlatListHandler.access$900(this.this$0) != null) {
            DabFlatListHandler.access$900(this.this$0).prepareStore(n4, ((AbstractRadioListRow)evoListRow).getTOContainer());
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        List list = DabFlatListHandler.access$500(this.this$0);
        synchronized (list) {
            DabFlatListHandler.access$1202(this.this$0, (DabListRow)evoListRow);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void itemFocused(int n, int n2, long l, int n3) {
        if (n != 0x11880100) {
            List list = DabFlatListHandler.access$500(this.this$0);
            synchronized (list) {
                DabFlatListHandler.access$1202(this.this$0, null);
            }
        }
    }
}

