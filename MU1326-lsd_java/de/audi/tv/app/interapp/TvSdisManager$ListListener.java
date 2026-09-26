/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tv.app.interapp;

import de.audi.atip.hmi.model.list.BaseListModelApp;
import de.audi.tv.app.interapp.ITVInterappListener$ServiceInfo;
import de.audi.tv.app.interapp.TvSdisManager;
import de.audi.tv.app.interapp.TvSdisManager$1;
import de.audi.tv.app.lists.AbstractTVStationRow;
import de.audi.tv.app.lists.DefaultTVListsListener;
import org.dsi.ifc.tvtuner.ServiceInfo;

class TvSdisManager$ListListener
extends DefaultTVListsListener {
    private final /* synthetic */ TvSdisManager this$0;

    private TvSdisManager$ListListener(TvSdisManager tvSdisManager) {
        this.this$0 = tvSdisManager;
    }

    @Override
    public void updateStationList() {
        BaseListModelApp baseListModelApp = TvSdisManager.access$2000(this.this$0).getBaseListModel(1085024000).getCopy();
        ITVInterappListener$ServiceInfo[] iTVInterappListener$ServiceInfoArray = new ITVInterappListener$ServiceInfo[baseListModelApp.getLength()];
        for (int i2 = 0; i2 < iTVInterappListener$ServiceInfoArray.length; ++i2) {
            AbstractTVStationRow abstractTVStationRow = (AbstractTVStationRow)baseListModelApp.getRow(i2);
            ServiceInfo serviceInfo = abstractTVStationRow.service;
            iTVInterappListener$ServiceInfoArray[i2] = new ITVInterappListener$ServiceInfo(abstractTVStationRow.getUniqueID(), serviceInfo.name, serviceInfo.sType, serviceInfo.getContentGroup());
        }
        TvSdisManager.access$2102(this.this$0, iTVInterappListener$ServiceInfoArray);
        TvSdisManager.access$800(this.this$0).updateTVStationList(iTVInterappListener$ServiceInfoArray);
    }

    /* synthetic */ TvSdisManager$ListListener(TvSdisManager tvSdisManager, TvSdisManager$1 tvSdisManager$1) {
        this(tvSdisManager);
    }
}

