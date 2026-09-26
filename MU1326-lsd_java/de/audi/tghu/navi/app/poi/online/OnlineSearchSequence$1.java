/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.poi.online;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.poi.online.OnlinePOIResultList;
import de.audi.tghu.navi.app.poi.online.OnlineSearchSequence;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.online.PoiOnlineSearchValuelistElement;

class OnlineSearchSequence$1
extends NavCommand {
    private final /* synthetic */ int val$index;
    private final /* synthetic */ OnlinePOIResultList val$resultList;
    private final /* synthetic */ OnlineSearchSequence this$0;

    OnlineSearchSequence$1(OnlineSearchSequence onlineSearchSequence, String string, int n, OnlinePOIResultList onlinePOIResultList) {
        this.this$0 = onlineSearchSequence;
        this.val$index = n;
        this.val$resultList = onlinePOIResultList;
        super(string);
    }

    @Override
    public void execute() {
        OnlineSearchSequence.access$000(this.this$0).log(1078071040, "OnlineSearchRequest#CMD_resolveEntry: resolving index %1", (long)this.val$index);
        PoiOnlineSearchValuelistElement poiOnlineSearchValuelistElement = this.val$resultList.getPOIElementAt(this.val$index);
        NavLocation navLocation = this.val$resultList.getTransformedLocationAt(this.val$index);
        OnlineSearchSequence.access$100(this.this$0).updateSelectedOnlineDetails(this.val$resultList, poiOnlineSearchValuelistElement, navLocation, this.val$index);
        this.getCommandList().commandFinished();
    }
}

