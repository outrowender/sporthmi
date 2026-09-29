/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.interapp;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController$IUpdateOperation;

class NaviServiceListenerController$41
implements NaviServiceListenerController$IUpdateOperation {
    private final /* synthetic */ byte val$result;
    private final /* synthetic */ int val$numberOfSearchResults;
    private final /* synthetic */ boolean val$navDBSearchEnded;
    private final /* synthetic */ int val$queryID;
    private final /* synthetic */ NaviServiceListenerController this$0;

    NaviServiceListenerController$41(NaviServiceListenerController naviServiceListenerController, byte by, int n, boolean bl, int n2) {
        this.this$0 = naviServiceListenerController;
        this.val$result = by;
        this.val$numberOfSearchResults = n;
        this.val$navDBSearchEnded = bl;
        this.val$queryID = n2;
    }

    @Override
    public void update(NaviServiceListener naviServiceListener) {
        naviServiceListener.updateResponseStartTrufflesSearch(this.val$result, this.val$numberOfSearchResults, this.val$navDBSearchEnded, this.val$queryID);
    }
}

