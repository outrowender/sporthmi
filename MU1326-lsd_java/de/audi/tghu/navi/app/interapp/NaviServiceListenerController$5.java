/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.interapp;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController$IUpdateOperation;

class NaviServiceListenerController$5
implements NaviServiceListenerController$IUpdateOperation {
    private final /* synthetic */ String val$state;
    private final /* synthetic */ String val$stateAbbreviation;
    private final /* synthetic */ NaviServiceListenerController this$0;

    NaviServiceListenerController$5(NaviServiceListenerController naviServiceListenerController, String string, String string2) {
        this.this$0 = naviServiceListenerController;
        this.val$state = string;
        this.val$stateAbbreviation = string2;
    }

    @Override
    public void update(NaviServiceListener naviServiceListener) {
        naviServiceListener.updateDestinationStateCode(this.val$state, this.val$stateAbbreviation);
    }
}

