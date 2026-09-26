/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi;

import de.audi.app.navi.evo.addressinput.poi.PoiWorkFlowManager;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

class PoiWorkFlowManager$5
extends NavCommand {
    private final /* synthetic */ PoiWorkFlowManager this$0;

    PoiWorkFlowManager$5(PoiWorkFlowManager poiWorkFlowManager, String string) {
        this.this$0 = poiWorkFlowManager;
        super(string);
    }

    @Override
    public void execute() {
        if (this.dsiResponseContainer.selectionCriterionAvailable(0x6800000)) {
            this.getCommandList().commandFinishedWithPostSequence(PoiWorkFlowManager.access$200(this.this$0).getPoiParentChildCategoryScreenHmiListener().getStartCommandList());
        } else if (PoiWorkFlowManager.access$300(this.this$0).getInputMode() == 2) {
            NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
            PoiWorkFlowManager.access$400(this.this$0, navLocation);
            this.getCommandList().commandFinished();
        } else if (PoiWorkFlowManager.access$300(this.this$0).getInputMode() == 1) {
            NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
            this.getCommandList().commandFinishedWithPostSequence(PoiWorkFlowManager.access$500(this.this$0, navLocation));
        } else {
            PoiWorkFlowManager.access$200(this.this$0).getStartGuidanceToDestinationSequence().start(this.dsiResponseContainer.getLiCurrentLD());
            this.getCommandList().commandFinished();
        }
    }
}

