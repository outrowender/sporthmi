/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.interapp;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.atip.interapp.SDSListEntry;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController$IUpdateOperation;

class NaviServiceListenerController$3
implements NaviServiceListenerController$IUpdateOperation {
    private final /* synthetic */ SDSListEntry[] val$destinations;
    private final /* synthetic */ NaviServiceListenerController this$0;

    NaviServiceListenerController$3(NaviServiceListenerController naviServiceListenerController, SDSListEntry[] sDSListEntryArray) {
        this.this$0 = naviServiceListenerController;
        this.val$destinations = sDSListEntryArray;
    }

    @Override
    public void update(NaviServiceListener naviServiceListener) {
        naviServiceListener.updateLastDestinations(this.val$destinations);
    }
}

