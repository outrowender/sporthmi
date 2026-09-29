/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.favorite;

import de.audi.app.navi.favorite.NaviFavoriteEvoRow;
import de.audi.app.navi.favorite.NaviFavoriteHandlerEvo;
import de.audi.tghu.navi.app.util.Util;
import org.dsi.ifc.global.NavLocation;

class NaviFavoriteHandlerEvo$2
implements Runnable {
    private final /* synthetic */ NaviFavoriteEvoRow val$editedRow;
    private final /* synthetic */ String val$newName;
    private final /* synthetic */ NaviFavoriteHandlerEvo this$0;

    NaviFavoriteHandlerEvo$2(NaviFavoriteHandlerEvo naviFavoriteHandlerEvo, NaviFavoriteEvoRow naviFavoriteEvoRow, String string) {
        this.this$0 = naviFavoriteHandlerEvo;
        this.val$editedRow = naviFavoriteEvoRow;
        this.val$newName = string;
    }

    @Override
    public void run() {
        NavLocation navLocation = NaviFavoriteHandlerEvo.access$100(this.this$0).streamToLocation(this.val$editedRow.getFavoriteLocation());
        Util.setDescriptionOnLocation(navLocation, this.val$newName);
        this.val$editedRow.setFavoriteLocation(NaviFavoriteHandlerEvo.access$200(this.this$0).locationToStream(navLocation));
        this.val$editedRow.setFavoriteName(this.val$newName);
        NaviFavoriteHandlerEvo.access$400(this.this$0).setRow(NaviFavoriteHandlerEvo.access$300(this.this$0), this.val$editedRow);
        NaviFavoriteHandlerEvo.access$500(this.this$0);
    }
}

