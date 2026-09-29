/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm.stationlist;

import de.audi.atip.hmi.model.list.SelectedItem;
import de.audi.atip.hmi.model.update.ModelTrigger;
import de.audi.tuner.app.amfm.stationlist.AbstractAmFmRow;
import de.audi.tuner.app.amfm.stationlist.AbstractAmFmStationlist;
import de.audi.tuner.app.amfm.stationlist.AbstractAmFmStationlist$1;
import de.audi.tuner.ifc.IPrevNext;

class AbstractAmFmStationlist$PrevNextHandler
implements IPrevNext {
    private final /* synthetic */ AbstractAmFmStationlist this$0;

    private AbstractAmFmStationlist$PrevNextHandler(AbstractAmFmStationlist abstractAmFmStationlist) {
        this.this$0 = abstractAmFmStationlist;
    }

    @Override
    public void handlePrevNext(boolean bl) {
        if (AbstractAmFmStationlist.access$1600(this.this$0).isForcedStationListUpdateRunning()) {
            AbstractAmFmStationlist.access$1700(this.this$0).log(-2137614336, "[AAFS.PNH.handlePrevNext] ignore skip: listupdate running");
            return;
        }
        SelectedItem selectedItem = this.this$0.listModel.getSelected();
        int n = 0;
        if (selectedItem != null) {
            n = bl ? ((n = selectedItem.getIndex() + 1) >= this.this$0.listModel.getLength() ? 0 : n) : ((n = selectedItem.getIndex() - 1) < 0 ? this.this$0.listModel.getLength() - 1 : n);
        }
        AbstractAmFmRow abstractAmFmRow = (AbstractAmFmRow)this.this$0.listModel.getRow(n);
        AbstractAmFmStationlist.access$1600(this.this$0).tuneStation(abstractAmFmRow.getStation(), false, false, 0);
        if (!AbstractAmFmStationlist.access$1900(this.this$0).isDrawerOpen()) {
            this.this$0.menuModel.trigger(ModelTrigger.JOIN_CURSOR);
        }
    }

    /* synthetic */ AbstractAmFmStationlist$PrevNextHandler(AbstractAmFmStationlist abstractAmFmStationlist, AbstractAmFmStationlist$1 abstractAmFmStationlist$1) {
        this(abstractAmFmStationlist);
    }
}

