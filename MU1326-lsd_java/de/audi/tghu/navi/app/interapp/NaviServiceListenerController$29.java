/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.interapp;

import de.audi.atip.interapp.NaviService$POISDSListEntry;
import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController$IUpdateOperation;

class NaviServiceListenerController$29
implements NaviServiceListenerController$IUpdateOperation {
    private final /* synthetic */ byte val$result;
    private final /* synthetic */ NaviService$POISDSListEntry[] val$entries;
    private final /* synthetic */ NaviServiceListenerController this$0;

    NaviServiceListenerController$29(NaviServiceListenerController naviServiceListenerController, byte by, NaviService$POISDSListEntry[] naviService$POISDSListEntryArray) {
        this.this$0 = naviServiceListenerController;
        this.val$result = by;
        this.val$entries = naviService$POISDSListEntryArray;
    }

    @Override
    public void update(NaviServiceListener naviServiceListener) {
        naviServiceListener.responseSelectPOI(this.val$result, this.val$entries);
    }
}

