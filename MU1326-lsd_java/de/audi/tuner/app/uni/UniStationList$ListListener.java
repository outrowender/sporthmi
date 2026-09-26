/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.uni;

import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.atip.hmi.model.menu.MenuModelListener;
import de.audi.tuner.app.RadioBaseListModelListener;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.uni.UniListRow;
import de.audi.tuner.app.uni.UniStationList;
import de.audi.tuner.app.uni.UnifiedStationExt;
import java.util.List;

class UniStationList$ListListener
extends RadioBaseListModelListener
implements MenuModelListener {
    private final /* synthetic */ UniStationList this$0;

    public UniStationList$ListListener(UniStationList uniStationList, TunerModels tunerModels, int n) {
        this.this$0 = uniStationList;
        super(tunerModels, n);
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        if (this.isNewSelection(evoListRow, n, n2, n3, n4)) {
            UnifiedStationExt unifiedStationExt = UniStationList.access$400(this.this$0, (UniListRow)evoListRow);
            UniStationList.access$500(this.this$0).selectStation(unifiedStationExt, n4);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void itemFocused(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        List list = UniStationList.access$600(this.this$0);
        synchronized (list) {
            UniStationList.access$702(this.this$0, (UniListRow)evoListRow);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void itemFocused(int n, int n2, long l, int n3) {
        if (n != -813235968) {
            List list = UniStationList.access$600(this.this$0);
            synchronized (list) {
                UniStationList.access$702(this.this$0, null);
            }
        }
    }
}

