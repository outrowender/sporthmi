/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi;

import de.audi.app.navi.evo.addressinput.poi.PoiSDSHandlerEvo;
import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.navi.app.command.NavCommand;

class PoiSDSHandlerEvo$3
extends NavCommand {
    private final /* synthetic */ NaviServiceListener val$naviServiceListener;
    private final /* synthetic */ PoiSDSHandlerEvo this$0;

    PoiSDSHandlerEvo$3(PoiSDSHandlerEvo poiSDSHandlerEvo, NaviServiceListener naviServiceListener) {
        this.this$0 = poiSDSHandlerEvo;
        this.val$naviServiceListener = naviServiceListener;
    }

    @Override
    public void execute() {
        this.val$naviServiceListener.responseSelectPOIbyListIndex((byte)1);
        this.getCommandList().commandFinished();
    }
}

