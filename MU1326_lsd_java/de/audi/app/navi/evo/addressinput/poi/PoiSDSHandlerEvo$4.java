/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi;

import de.audi.app.navi.evo.addressinput.poi.PoiSDSHandlerEvo;
import de.audi.app.navi.evo.addressinput.poi.sds.SDSPoiScreensEvo;
import de.audi.atip.interapp.NaviService$POISDSListEntry;
import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.navi.app.sds.NotifySDSCommand;

class PoiSDSHandlerEvo$4
extends NotifySDSCommand {
    private final /* synthetic */ PoiSDSHandlerEvo this$0;

    PoiSDSHandlerEvo$4(PoiSDSHandlerEvo poiSDSHandlerEvo, NaviServiceListener naviServiceListener, String string) {
        this.this$0 = poiSDSHandlerEvo;
        super(naviServiceListener, string);
    }

    @Override
    public void call() {
        NaviService$POISDSListEntry[] naviService$POISDSListEntryArray = PoiSDSHandlerEvo.access$400(this.this$0, PoiSDSHandlerEvo.access$300(this.this$0).getBaseListModel(SDSPoiScreensEvo.getPOIResultScreenListModel()));
        this.feedbackNaviServiceListener.responseSelectPOI((byte)0, naviService$POISDSListEntryArray);
    }
}

