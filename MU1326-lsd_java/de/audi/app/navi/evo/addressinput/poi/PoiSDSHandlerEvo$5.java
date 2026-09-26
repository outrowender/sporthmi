/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi;

import de.audi.app.navi.evo.addressinput.poi.PoiSDSHandlerEvo;
import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.navi.app.sds.NotifySDSCommand;

class PoiSDSHandlerEvo$5
extends NotifySDSCommand {
    private final /* synthetic */ PoiSDSHandlerEvo this$0;

    PoiSDSHandlerEvo$5(PoiSDSHandlerEvo poiSDSHandlerEvo, NaviServiceListener naviServiceListener, String string) {
        this.this$0 = poiSDSHandlerEvo;
        super(naviServiceListener, string);
    }

    @Override
    public void call() {
        this.feedbackNaviServiceListener.responseSelectPOI((byte)1, null);
    }
}

