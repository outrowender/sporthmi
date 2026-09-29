/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.lists;

import de.audi.tv.app.dsi.DefaultTVListener;
import de.audi.tv.app.lists.TVStationList;
import de.audi.tv.app.lists.TVStationList$1;

class TVStationList$TVListenerImpl
extends DefaultTVListener {
    private final /* synthetic */ TVStationList this$0;

    private TVStationList$TVListenerImpl(TVStationList tVStationList) {
        this.this$0 = tVStationList;
    }

    @Override
    public void updateMuteState(int n) {
        this.this$0.setMuteStatus(n);
    }

    /* synthetic */ TVStationList$TVListenerImpl(TVStationList tVStationList, TVStationList$1 tVStationList$1) {
        this(tVStationList);
    }
}

