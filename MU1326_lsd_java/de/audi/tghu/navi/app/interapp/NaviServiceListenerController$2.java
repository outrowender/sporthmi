/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.interapp;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.atip.interapp.SDSListEntry;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController$IUpdateOperation;

class NaviServiceListenerController$2
implements NaviServiceListenerController$IUpdateOperation {
    private final /* synthetic */ SDSListEntry[] val$favorites;
    private final /* synthetic */ NaviServiceListenerController this$0;

    NaviServiceListenerController$2(NaviServiceListenerController naviServiceListenerController, SDSListEntry[] sDSListEntryArray) {
        this.this$0 = naviServiceListenerController;
        this.val$favorites = sDSListEntryArray;
    }

    @Override
    public void update(NaviServiceListener naviServiceListener) {
        naviServiceListener.updateFavoriteDestinations(this.val$favorites);
    }
}

