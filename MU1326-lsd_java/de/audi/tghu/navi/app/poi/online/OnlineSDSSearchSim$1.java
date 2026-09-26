/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.poi.online;

import de.audi.tghu.navi.app.poi.online.OnlineSDSSearchSim;
import org.dsi.ifc.online.DSIPoiOnlineSearchListener;
import org.dsi.ifc.online.PoiOnlineSearchValuelist;

class OnlineSDSSearchSim$1
extends Thread {
    private final /* synthetic */ DSIPoiOnlineSearchListener val$poiOnlineSearchListener;
    private final /* synthetic */ String val$searchKey;
    private final /* synthetic */ OnlineSDSSearchSim this$0;

    OnlineSDSSearchSim$1(OnlineSDSSearchSim onlineSDSSearchSim, DSIPoiOnlineSearchListener dSIPoiOnlineSearchListener, String string) {
        this.this$0 = onlineSDSSearchSim;
        this.val$poiOnlineSearchListener = dSIPoiOnlineSearchListener;
        this.val$searchKey = string;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(0);
        }
        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
        if (!OnlineSDSSearchSim.access$000(this.this$0)) {
            this.val$poiOnlineSearchListener.poiResult(1, 1, 11);
            PoiOnlineSearchValuelist poiOnlineSearchValuelist = OnlineSDSSearchSim.access$100(this.this$0, this.val$searchKey, 50, 0);
            OnlineSDSSearchSim.access$200(this.this$0).log(-2137614336, "OnlineSDSSearchSim#poiStartSelection: Sending result list!");
            this.val$poiOnlineSearchListener.poiValueList(1, 0, poiOnlineSearchValuelist, 0, 100);
        }
    }
}

