/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm.stationlist;

import de.audi.atip.hmi.model.list.SelectedItem;
import de.audi.atip.hmi.model.update.ModelTrigger;
import de.audi.tuner.app.amfm.stationlist.AbstractAmFmRow;
import de.audi.tuner.app.amfm.stationlist.AbstractAmFmStationlistNar;
import de.audi.tuner.app.amfm.stationlist.AbstractAmFmStationlistNar$1;
import de.audi.tuner.ifc.IPrevNext;

class AbstractAmFmStationlistNar$PrevNextHandler
implements IPrevNext {
    private final /* synthetic */ AbstractAmFmStationlistNar this$0;

    private AbstractAmFmStationlistNar$PrevNextHandler(AbstractAmFmStationlistNar abstractAmFmStationlistNar) {
        this.this$0 = abstractAmFmStationlistNar;
    }

    @Override
    public void handlePrevNext(boolean bl) {
        SelectedItem selectedItem = this.this$0.listModel.getSelected();
        int n = 0;
        if (selectedItem != null) {
            n = bl ? ((n = selectedItem.getIndex() + 1) >= this.this$0.listModel.getLength() ? 0 : n) : ((n = selectedItem.getIndex() - 1) < 0 ? this.this$0.listModel.getLength() - 1 : n);
        }
        AbstractAmFmRow abstractAmFmRow = (AbstractAmFmRow)this.this$0.listModel.getRow(n);
        AbstractAmFmStationlistNar.access$1600(this.this$0).tuneStation(abstractAmFmRow.getStation(), false, false, 0);
        if (!AbstractAmFmStationlistNar.access$1900(this.this$0).isDrawerOpen()) {
            this.this$0.listMenuModel.trigger(ModelTrigger.JOIN_CURSOR);
        }
    }

    /* synthetic */ AbstractAmFmStationlistNar$PrevNextHandler(AbstractAmFmStationlistNar abstractAmFmStationlistNar, AbstractAmFmStationlistNar$1 abstractAmFmStationlistNar$1) {
        this(abstractAmFmStationlistNar);
    }
}

