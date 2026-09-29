/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command.poi.online;

import de.audi.tghu.command.CommandResponse;
import de.audi.tghu.navi.app.command.poi.online.OnlineDSIPoiListener;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.online.DSIPoiOnlineSearchListener;

class OnlineDSIPoiListener$1
extends CommandResponse {
    private final /* synthetic */ int val$type;
    private final /* synthetic */ int val$resultsource;
    private final /* synthetic */ int val$returnCode;
    private final /* synthetic */ OnlineDSIPoiListener this$0;

    OnlineDSIPoiListener$1(OnlineDSIPoiListener onlineDSIPoiListener, int n, int n2, int n3) {
        this.this$0 = onlineDSIPoiListener;
        this.val$type = n;
        this.val$resultsource = n2;
        this.val$returnCode = n3;
    }

    @Override
    public void call(DSIListener dSIListener) {
        ((DSIPoiOnlineSearchListener)dSIListener).poiResult(this.val$type, this.val$resultsource, this.val$returnCode);
    }
}

