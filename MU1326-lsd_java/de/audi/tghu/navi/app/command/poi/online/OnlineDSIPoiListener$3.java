/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command.poi.online;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.command.poi.online.OnlineDSIPoiListener;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.online.DSIPoiOnlineSearchListener;
import org.dsi.ifc.online.PoiOnlineSearchValuelist;

class OnlineDSIPoiListener$3
extends CommandResponse {
    private final /* synthetic */ int val$type;
    private final /* synthetic */ int val$resultsource;
    private final /* synthetic */ PoiOnlineSearchValuelist val$poiValueList;
    private final /* synthetic */ int val$indexOfFirstItem;
    private final /* synthetic */ int val$totalItems;
    private final /* synthetic */ OnlineDSIPoiListener this$0;

    OnlineDSIPoiListener$3(OnlineDSIPoiListener onlineDSIPoiListener, int n, int n2, PoiOnlineSearchValuelist poiOnlineSearchValuelist, int n3, int n4) {
        this.this$0 = onlineDSIPoiListener;
        this.val$type = n;
        this.val$resultsource = n2;
        this.val$poiValueList = poiOnlineSearchValuelist;
        this.val$indexOfFirstItem = n3;
        this.val$totalItems = n4;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIPoiOnlineSearchListener)dSIListener).poiValueList(this.val$type, this.val$resultsource, this.val$poiValueList, this.val$indexOfFirstItem, this.val$totalItems);
    }
}

