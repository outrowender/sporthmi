/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi;

import de.audi.app.navi.evo.addressinput.poi.PoiWorkFlowManager;
import de.audi.tghu.navi.app.command.NavCommand;

class PoiWorkFlowManager$13
extends NavCommand {
    private final /* synthetic */ PoiWorkFlowManager this$0;

    PoiWorkFlowManager$13(PoiWorkFlowManager poiWorkFlowManager, String string) {
        this.this$0 = poiWorkFlowManager;
        super(string);
    }

    @Override
    public void execute() {
        PoiWorkFlowManager.access$900(this.this$0).updateSearchArea(0, this.dsiResponseContainer.getSelectedLocation());
        this.getCommandList().commandFinished();
    }
}

