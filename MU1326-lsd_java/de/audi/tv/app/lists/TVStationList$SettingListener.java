/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.lists;

import de.audi.tv.app.lists.TVStationList;
import de.audi.tv.app.lists.TVStationList$1;
import de.audi.tv.app.settings.ISettingListener$Stub;

class TVStationList$SettingListener
extends ISettingListener$Stub {
    private final /* synthetic */ TVStationList this$0;

    private TVStationList$SettingListener(TVStationList tVStationList) {
        this.this$0 = tVStationList;
    }

    @Override
    public void updateStationListSorting(int n) {
        TVStationList.access$1002(this.this$0, n);
    }

    /* synthetic */ TVStationList$SettingListener(TVStationList tVStationList, TVStationList$1 tVStationList$1) {
        this(tVStationList);
    }
}

