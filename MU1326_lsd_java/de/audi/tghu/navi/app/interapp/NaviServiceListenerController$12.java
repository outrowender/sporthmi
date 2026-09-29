/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.interapp;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController;
import de.audi.tghu.navi.app.interapp.NaviServiceListenerController$IUpdateOperation;

class NaviServiceListenerController$12
implements NaviServiceListenerController$IUpdateOperation {
    private final /* synthetic */ byte val$result;
    private final /* synthetic */ String[] val$entries;
    private final /* synthetic */ Object[] val$ids;
    private final /* synthetic */ NaviServiceListenerController this$0;

    NaviServiceListenerController$12(NaviServiceListenerController naviServiceListenerController, byte by, String[] stringArray, Object[] objectArray) {
        this.this$0 = naviServiceListenerController;
        this.val$result = by;
        this.val$entries = stringArray;
        this.val$ids = objectArray;
    }

    @Override
    public void update(NaviServiceListener naviServiceListener) {
        naviServiceListener.responseQuerySpelledLocationPartResultList(this.val$result, this.val$entries, this.val$ids);
    }
}

