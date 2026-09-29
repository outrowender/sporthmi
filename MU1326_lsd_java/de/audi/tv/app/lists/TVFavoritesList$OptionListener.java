/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.lists;

import de.audi.atip.hmi.model.DefaultOptionListener;
import de.audi.atip.hmi.model.update.ModelTrigger;
import de.audi.tv.app.lists.AbstractTVStationRow;
import de.audi.tv.app.lists.TVFavoritesList;
import de.audi.tv.app.lists.TVFavoritesList$1;

class TVFavoritesList$OptionListener
extends DefaultOptionListener {
    private final /* synthetic */ TVFavoritesList this$0;

    private TVFavoritesList$OptionListener(TVFavoritesList tVFavoritesList) {
        this.this$0 = tVFavoritesList;
    }

    @Override
    public void keyTyped(int n, int n2, int n3, int n4, int n5) {
        if (n == -1683216640) {
            this.this$0.env.lcMain.log(-2137614336, "[TVFavoritesList.itemSelected] entering favorite move mode.");
            TVFavoritesList.access$502(this.this$0, 1);
            TVFavoritesList.access$602(this.this$0, (AbstractTVStationRow)this.this$0.stationList.getRow(n3));
            TVFavoritesList.access$702(this.this$0, this.this$0.stationList.getIndexForUniqueID(TVFavoritesList.access$600(this.this$0).getUniqueID()));
            TVFavoritesList.access$800(this.this$0).enterMoveMode();
            this.this$0.stationList.trigger(ModelTrigger.ACTIVATE_MOVE_MODE);
        }
    }

    /* synthetic */ TVFavoritesList$OptionListener(TVFavoritesList tVFavoritesList, TVFavoritesList$1 tVFavoritesList$1) {
        this(tVFavoritesList);
    }
}

