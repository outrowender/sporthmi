/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm.stationlist;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tuner.app.RadioBaseListModelListener;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.stationlist.AbstractAmFmRow;
import de.audi.tuner.app.amfm.stationlist.AbstractAmFmStationlist;
import de.audi.tuner.app.amfm.stationlist.AmListRow;
import de.audi.tuner.app.amfm.stationlist.FmListRow;
import de.audi.tuner.ifc.AbstractRadioListRow;

public class AbstractAmFmStationlist$ListListener
extends RadioBaseListModelListener {
    private final /* synthetic */ AbstractAmFmStationlist this$0;

    public AbstractAmFmStationlist$ListListener(AbstractAmFmStationlist abstractAmFmStationlist, TunerModels tunerModels, int n) {
        this.this$0 = abstractAmFmStationlist;
        super(tunerModels, n);
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        boolean bl;
        boolean bl2 = evoListRow instanceof FmListRow && n3 == 8;
        boolean bl3 = bl = evoListRow instanceof AmListRow && n3 == 4;
        if (bl2 || bl) {
            if (AbstractAmFmStationlist.access$1300(this.this$0) != null) {
                AbstractAmFmStationlist.access$1300(this.this$0).prepareStore(n4, ((AbstractRadioListRow)evoListRow).getTOContainer());
            }
        } else {
            if (AbstractAmFmStationlist.access$1400(this.this$0).isStoreModeActive()) {
                AbstractAmFmStationlist.access$1400(this.this$0).store((AbstractRadioListRow)evoListRow);
                this.this$0.listModel.fireEvent(n4);
                return;
            }
            AbstractAmFmStationlist.access$1500(this.this$0).abortScan();
            if (this.isNewSelection(evoListRow, n, n2, n3, n4)) {
                AMFMStation aMFMStation = ((AbstractAmFmRow)evoListRow).getStation();
                AbstractAmFmStationlist.access$1600(this.this$0).tuneStation(aMFMStation, false, false, n4);
                this.this$0.propagateUpdatedActiveStation(AbstractAmFmStationlist.access$1200(this.this$0));
            }
        }
    }

    @Override
    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        AbstractAmFmStationlist.access$1500(this.this$0).abortScan();
        if (this.this$0.listModel.getSelected().getIndex() != n2) {
            AMFMStation aMFMStation = ((AbstractAmFmRow)evoListRow).getStation();
            AbstractAmFmStationlist.access$1600(this.this$0).tuneStation(aMFMStation, false, false, n4);
            this.this$0.propagateUpdatedActiveStation(AbstractAmFmStationlist.access$1200(this.this$0));
        }
        if (AbstractAmFmStationlist.access$1300(this.this$0) != null) {
            AbstractAmFmStationlist.access$1300(this.this$0).prepareStore(n4, ((AbstractRadioListRow)evoListRow).getTOContainer());
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        AbstractAmFmStationlist.access$1700(this.this$0).log(14808325, "[BAFS.itemFocused] model %1 index %2", (long)n, (long)n2);
        Object object = this.this$0.mutex;
        synchronized (object) {
            AbstractAmFmStationlist.access$1802(this.this$0, (AbstractAmFmRow)evoListRow);
        }
    }
}

