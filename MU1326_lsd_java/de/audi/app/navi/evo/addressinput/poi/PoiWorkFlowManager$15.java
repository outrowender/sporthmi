/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi;

import de.audi.app.navi.evo.addressinput.poi.PoiWorkFlowManager;
import de.audi.tghu.navi.app.command.NavCommand;

class PoiWorkFlowManager$15
extends NavCommand {
    private final /* synthetic */ PoiWorkFlowManager this$0;

    PoiWorkFlowManager$15(PoiWorkFlowManager poiWorkFlowManager, String string) {
        this.this$0 = poiWorkFlowManager;
        super(string);
    }

    @Override
    public void execute() {
        byte[] byArray = (byte[])this.getCommandList().get("LOCATION_STREAM");
        PoiWorkFlowManager.access$1500(this.this$0, byArray, this.env);
        this.getCommandList().commandFinished();
    }
}

