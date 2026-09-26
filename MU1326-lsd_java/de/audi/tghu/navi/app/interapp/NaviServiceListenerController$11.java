/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.interapp;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController$IUpdateOperation;

class NaviServiceListenerController$11
implements NaviServiceListenerController$IUpdateOperation {
    private final /* synthetic */ byte val$result;
    private final /* synthetic */ long val$listLength;
    private final /* synthetic */ String[] val$entryNames;
    private final /* synthetic */ NaviServiceListenerController this$0;

    NaviServiceListenerController$11(NaviServiceListenerController naviServiceListenerController, byte by, long l, String[] stringArray) {
        this.this$0 = naviServiceListenerController;
        this.val$result = by;
        this.val$listLength = l;
        this.val$entryNames = stringArray;
    }

    @Override
    public void update(NaviServiceListener naviServiceListener) {
        naviServiceListener.responseQueryLocationPartListLength(this.val$result, this.val$listLength, this.val$entryNames);
    }
}

