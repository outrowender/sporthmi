/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.uni;

import de.audi.atip.hmi.model.list.SelectedItem;
import de.audi.atip.hmi.model.update.ModelTrigger;
import de.audi.tuner.app.uni.UniListRow;
import de.audi.tuner.app.uni.UniStationList;
import de.audi.tuner.app.uni.UniStationList$1;
import de.audi.tuner.app.uni.UnifiedStationExt;
import de.audi.tuner.ifc.IPrevNext;

class UniStationList$PrevNextHandler
implements IPrevNext {
    private final /* synthetic */ UniStationList this$0;

    private UniStationList$PrevNextHandler(UniStationList uniStationList) {
        this.this$0 = uniStationList;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void handlePrevNext(boolean bl) {
        UniListRow uniListRow = null;
        Object object = UniStationList.access$600(this.this$0);
        synchronized (object) {
            SelectedItem selectedItem = UniStationList.access$1600(this.this$0).getSelected();
            int n = UniStationList.access$1600(this.this$0).getLength();
            int n2 = 0;
            if (selectedItem != null) {
                n2 = bl ? ((n2 = selectedItem.getIndex() + 1) >= n ? 0 : n2) : ((n2 = selectedItem.getIndex() - 1) < 0 ? n - 1 : n2);
            }
            UniStationList.access$1700((UniStationList)this.this$0).uniDSI.log(-2137614336, "[UniStationList.handleNextPrev] index %1 -> %2 (length: %3)", (Object)selectedItem, (long)n2, (long)n);
            uniListRow = (UniListRow)UniStationList.access$1600(this.this$0).getRow(n2);
        }
        object = UniStationList.access$400(this.this$0, uniListRow);
        UniStationList.access$1700((UniStationList)this.this$0).uniDSI.log(-2137614336, "[UniStationList.handleNextPrev] stationToSelect: %1 ", object);
        UniStationList.access$500(this.this$0).selectStation((UnifiedStationExt)object, 0);
        if (!UniStationList.access$1800(this.this$0).isDrawerOpen()) {
            UniStationList.access$1900(this.this$0).trigger(ModelTrigger.JOIN_CURSOR);
        }
    }

    /* synthetic */ UniStationList$PrevNextHandler(UniStationList uniStationList, UniStationList$1 uniStationList$1) {
        this(uniStationList);
    }
}

