/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.lists;

import de.audi.atip.hmi.model.list.DefaultBaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tv.app.lists.AbstractTVStationRow;
import de.audi.tv.app.lists.TVStationList;
import de.audi.tv.app.lists.TVStationList$1;

class TVStationList$ListListener
extends DefaultBaseListModelListener {
    private final /* synthetic */ TVStationList this$0;

    private TVStationList$ListListener(TVStationList tVStationList) {
        this.this$0 = tVStationList;
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        this.this$0.env.lcHMI.log(-2137614336, "[TVStationList.itemSelected] [%2] %1", (Object)evoListRow, (long)n2);
        if (TVStationList.access$800(this.this$0).isAddToFavorites(evoListRow, n, n2, n3)) {
            TVStationList.access$900(this.this$0, ((AbstractTVStationRow)evoListRow).service);
        } else {
            this.this$0.dsi.changeService(((AbstractTVStationRow)evoListRow).service, true);
            this.this$0.stationList.fireEvent(n4);
        }
    }

    @Override
    public void itemLongSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        if (TVStationList.access$800(this.this$0).isTuneBeforeAddingToFavoritesRequired()) {
            this.this$0.dsi.changeService(((AbstractTVStationRow)evoListRow).service, true);
        }
        TVStationList.access$900(this.this$0, ((AbstractTVStationRow)evoListRow).service);
    }

    /* synthetic */ TVStationList$ListListener(TVStationList tVStationList, TVStationList$1 tVStationList$1) {
        this(tVStationList);
    }
}

