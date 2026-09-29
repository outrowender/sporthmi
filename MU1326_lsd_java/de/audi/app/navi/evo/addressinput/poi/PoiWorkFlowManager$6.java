/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.addressinput.poi;

import de.audi.app.navi.evo.addressinput.poi.PoiWorkFlowManager;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.addressinput.commands.LIStartSpellerCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.NewModelUpdateResultListCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiModelStartCommand;
import de.audi.tghu.navi.app.addressinput.poi.commands.PoiSetSortOrderCommand;
import de.audi.tghu.navi.app.addressinput.poi.models.IPoiParentChildResultScreenModelAccess;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

class PoiWorkFlowManager$6
extends NavCommand {
    private final /* synthetic */ PoiWorkFlowManager this$0;

    PoiWorkFlowManager$6(PoiWorkFlowManager poiWorkFlowManager, String string) {
        this.this$0 = poiWorkFlowManager;
        super(string);
    }

    @Override
    public void execute() {
        if (this.dsiResponseContainer.selectionCriterionAvailable(0x7800000) && this.dsiResponseContainer.refinementCriterionAvailable(0x7800000)) {
            IPoiParentChildResultScreenModelAccess iPoiParentChildResultScreenModelAccess = PoiWorkFlowManager.access$200(this.this$0).getPoiParentChildResultScreenHmiListener().getParentChildResultScreenInputSequence().getModelAccess();
            CommandList commandList = PoiWorkFlowManager.access$000(this.this$0).createCommandList();
            commandList.add(new PoiSetSortOrderCommand(2));
            commandList.add(new PoiModelStartCommand(iPoiParentChildResultScreenModelAccess));
            commandList.add(new LIStartSpellerCommand(0x7800000, false, false, false));
            commandList.add(new NewModelUpdateResultListCommand(iPoiParentChildResultScreenModelAccess));
            this.getCommandList().commandFinishedWithPostSequence(commandList);
        } else if (PoiWorkFlowManager.access$300(this.this$0).getInputMode() == 2) {
            NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
            PoiWorkFlowManager.access$400(this.this$0, navLocation);
            this.getCommandList().commandFinished();
        } else if (PoiWorkFlowManager.access$300(this.this$0).getInputMode() == 1) {
            NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
            this.getCommandList().commandFinishedWithPostSequence(PoiWorkFlowManager.access$500(this.this$0, navLocation));
        } else {
            this.getCommandList().commandFinishedWithPostSequence(PoiWorkFlowManager.access$200(this.this$0).getStartGuidanceToDestinationSequence().getStartSequence(this.dsiResponseContainer.getLiCurrentLD()));
        }
    }
}

