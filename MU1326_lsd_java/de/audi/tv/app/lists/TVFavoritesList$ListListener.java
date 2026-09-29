/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.lists;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.atip.hmi.model.list.DefaultBaseListModelListener;
import de.audi.atip.hmi.model.list.EvoListRow;
import de.audi.tv.app.lists.AbstractTVStationRow;
import de.audi.tv.app.lists.TVFavoritesList;
import de.audi.tv.app.lists.TVFavoritesList$1;

class TVFavoritesList$ListListener
extends DefaultBaseListModelListener {
    private final /* synthetic */ TVFavoritesList this$0;

    private TVFavoritesList$ListListener(TVFavoritesList tVFavoritesList) {
        this.this$0 = tVFavoritesList;
    }

    @Override
    public void itemSelected(EvoListRow evoListRow, int n, int n2, int n3, int n4) {
        if (TVFavoritesList.access$500(this.this$0) == 0) {
            this.this$0.env.lcHMI.log(14808325, "[TVFavoritesList.itemSelected] [%2] %1", (Object)evoListRow, (long)n2);
            this.this$0.dsi.changeService(((AbstractTVStationRow)evoListRow).service, true);
            this.this$0.stationList.fireEvent(n4);
        } else if (n2 != TVFavoritesList.access$700(this.this$0)) {
            this.this$0.env.lcMain.log(-2137614336, "[TVFavoritesList.itemSelected] move favorite from index %1 to index %2 .", (long)TVFavoritesList.access$700(this.this$0), (long)n2);
            BaseListModelApp baseListModelApp = this.this$0.stationList.getCopy();
            long l = evoListRow.getUniqueID();
            if (n2 < TVFavoritesList.access$700(this.this$0)) {
                baseListModelApp.remove(TVFavoritesList.access$600(this.this$0));
                baseListModelApp.insertBefore(l, TVFavoritesList.access$600(this.this$0));
            } else if (n2 > TVFavoritesList.access$700(this.this$0)) {
                baseListModelApp.remove(TVFavoritesList.access$600(this.this$0));
                baseListModelApp.insertAfter(l, TVFavoritesList.access$600(this.this$0));
            }
            TVFavoritesList.access$400(this.this$0, baseListModelApp);
            this.this$0.stationList.update(baseListModelApp);
            this.this$0.updateList();
            TVFavoritesList.access$900(this.this$0).save();
        } else {
            TVFavoritesList.access$400(this.this$0, this.this$0.stationList);
        }
    }

    /* synthetic */ TVFavoritesList$ListListener(TVFavoritesList tVFavoritesList, TVFavoritesList$1 tVFavoritesList$1) {
        this(tVFavoritesList);
    }
}

