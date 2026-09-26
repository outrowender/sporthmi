/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.nar.wfm;

import de.audi.app.navi.evo.di.nar.additionalstate.SaveHousenumberFirstValueStateInfo;
import de.audi.app.navi.evo.di.nar.wfm.AddressInputCityZipScreenWorkFlowManagerNAR;
import de.audi.app.navi.evo.di.nar.wfm.AddressInputCityZipScreenWorkFlowManagerNAR$2$1;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.command.AddStreetAndCityToHistoryCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.li.IAdditionalStateInfo;
import org.dsi.ifc.global.NavLocation;

class AddressInputCityZipScreenWorkFlowManagerNAR$2
extends NavCommand {
    private final /* synthetic */ AddressInputCityZipScreenWorkFlowManagerNAR this$0;

    AddressInputCityZipScreenWorkFlowManagerNAR$2(AddressInputCityZipScreenWorkFlowManagerNAR addressInputCityZipScreenWorkFlowManagerNAR, String string) {
        this.this$0 = addressInputCityZipScreenWorkFlowManagerNAR;
        super(string);
    }

    @Override
    public void execute() {
        if (this.dsiResponseContainer.getLiCurrentLD().isPositionValid()) {
            if (this.dsiResponseContainer.selectionCriterionAvailable(136)) {
                this.getCommandList().commandFinishedWithPostSequence(this.createAddHousenumberCommandList(this.getHouseNumberInput(), this.dsiResponseContainer.getLiCurrentLD()));
            } else {
                this.this$0.logChannel.log(-2137614336, "%1#execute() - The Address is valid but no housenumber selcritdes available", (Object)this.CLASS_NAME);
                this.env.getChoiceModel(-2027878912).setValue(3);
                this.getCommandList().commandFinished();
            }
            return;
        }
        if (this.dsiResponseContainer.selectionCriterionAvailable(135)) {
            this.env.getChoiceModel(-2027878912).setValue(1);
            this.getCommandList().commandFinishedWithPostSequence(this.createAddHousenumberFreetextAndStartRefinement(this.getHouseNumberInput()));
        } else if (this.dsiResponseContainer.selectionCriterionAvailable(127)) {
            this.this$0.logChannel.log(-2137614336, "%1#execute() - Address invalid because no housenumber available (no SELCRITDES_HOUSENUMBER_FREETEXT) -> Refinement is nessesary", (Object)this.CLASS_NAME);
            this.env.getChoiceModel(-2027878912).setValue(1);
            this.getCommandList().commandFinishedWithPostSequence(this.this$0.inputManager.getStreetRefinementScreenListener().getStartCommandList());
        } else {
            this.getCommandList().commandAborted("SELCRITDES_HOUSENUMBER_FREETEXT is not available and no SELCRITDES_REFINEBYASSOCIATION");
        }
    }

    private String getHouseNumberInput() {
        IAdditionalStateInfo[] iAdditionalStateInfoArray = this.this$0.spellerStack.getAdditionalStateForFirstContextFound(65);
        SaveHousenumberFirstValueStateInfo saveHousenumberFirstValueStateInfo = null;
        for (int i2 = 0; i2 < iAdditionalStateInfoArray.length; ++i2) {
            if (!(iAdditionalStateInfoArray[i2] instanceof SaveHousenumberFirstValueStateInfo)) continue;
            saveHousenumberFirstValueStateInfo = (SaveHousenumberFirstValueStateInfo)iAdditionalStateInfoArray[i2];
            break;
        }
        this.this$0.logChannel.log(-2137614336, "%1#getCommandToCheckValidDestinationAndStartFollowSequence stateInfo is available. Try to start housenumberinput", (Object)this.CLASS_NAME);
        return saveHousenumberFirstValueStateInfo != null ? saveHousenumberFirstValueStateInfo.getHousenumberFirstValue() : "";
    }

    private CommandList createAddHousenumberFreetextAndStartRefinement(String string) {
        CommandList commandList = this.this$0.inputManager.getHousenumberScreenListener().getSetHousenumberFreetextWithAutoSelect(string);
        commandList.add(new AddressInputCityZipScreenWorkFlowManagerNAR$2$1(this, new StringBuffer().append(this.this$0.CLASS_NAME).append("#createAddHousenumberFreetextAndStartRefinement start refinement screen if necessary").toString()));
        return commandList;
    }

    private CommandList createAddHousenumberCommandList(String string, NavLocation navLocation) {
        boolean bl = this.this$0.spellerStack.containsContextID(65);
        CommandList commandList = this.this$0.commandListFactory.createCommandList();
        commandList.add(new AddStreetAndCityToHistoryCommand(navLocation, AddressInputCityZipScreenWorkFlowManagerNAR.access$000(this.this$0), this.this$0.commandListFactory, bl));
        commandList.add(this.this$0.inputManager.getHousenumberScreenListener().getStartCommandList());
        commandList.add(this.this$0.inputManager.getHousenumberScreenListener().getSetHousenumber(string));
        return commandList;
    }

    static /* synthetic */ AddressInputCityZipScreenWorkFlowManagerNAR access$100(AddressInputCityZipScreenWorkFlowManagerNAR$2 addressInputCityZipScreenWorkFlowManagerNAR$2) {
        return addressInputCityZipScreenWorkFlowManagerNAR$2.this$0;
    }
}

