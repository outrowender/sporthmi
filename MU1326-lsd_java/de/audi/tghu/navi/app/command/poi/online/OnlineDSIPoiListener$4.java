/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command.poi.online;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.command.poi.online.OnlineDSIPoiListener;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.online.DSIPoiOnlineSearchListener;
import org.dsi.ifc.online.OSRServiceState;

class OnlineDSIPoiListener$4
extends CommandResponse {
    private final /* synthetic */ int val$dynamicPoiCategory;
    private final /* synthetic */ OSRServiceState val$state;
    private final /* synthetic */ OnlineDSIPoiListener this$0;

    OnlineDSIPoiListener$4(OnlineDSIPoiListener onlineDSIPoiListener, int n, OSRServiceState oSRServiceState) {
        this.this$0 = onlineDSIPoiListener;
        this.val$dynamicPoiCategory = n;
        this.val$state = oSRServiceState;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIPoiOnlineSearchListener)dSIListener).precheckDynamicPOICategoryResponse(this.val$dynamicPoiCategory, this.val$state);
    }
}

