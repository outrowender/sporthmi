/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.nar.wfm;

import de.audi.app.navi.evo.di.nar.wfm.AddressInputCityZipScreenWorkFlowManagerNAR;
import de.audi.tghu.navi.app.command.AddStreetAndCityToHistoryCommand;
import de.audi.tghu.navi.app.command.NavCommand;

class AddressInputCityZipScreenWorkFlowManagerNAR$1
extends NavCommand {
    private final /* synthetic */ AddressInputCityZipScreenWorkFlowManagerNAR this$0;

    AddressInputCityZipScreenWorkFlowManagerNAR$1(AddressInputCityZipScreenWorkFlowManagerNAR addressInputCityZipScreenWorkFlowManagerNAR, String string) {
        this.this$0 = addressInputCityZipScreenWorkFlowManagerNAR;
        super(string);
    }

    @Override
    public void execute() {
        if (!this.dsiResponseContainer.getLiCurrentLD().isPositionValid() && this.dsiResponseContainer.selectionCriterionAvailable(127)) {
            this.this$0.logChannel.log(-2137614336, "AddressInputCityZipScreenWorkFlowManagerNAR.createCitySelectForStreetFirstWorkFlow().new NavCommand() {...}#execute() - Refinement is nessesary.");
            this.env.getChoiceModel(-2027878912).setValue(1);
            this.getCommandList().commandFinishedWithPostSequence(this.this$0.inputManager.getStreetRefinementScreenListener().getStartCommandList());
        } else {
            this.this$0.logChannel.log(-2137614336, "AddressInputCityZipScreenWorkFlowManagerNAR.createCitySelectForStreetFirstWorkFlow().new NavCommand() {...}#execute() - NO REFINEMENT --> Add City to History");
            this.env.getChoiceModel(-2027878912).setValue(0);
            boolean bl = this.this$0.spellerStack.containsContextID(65);
            this.getCommandList().commandFinishedWithPostCommand(new AddStreetAndCityToHistoryCommand(this.dsiResponseContainer.getLiCurrentLD(), AddressInputCityZipScreenWorkFlowManagerNAR.access$000(this.this$0), this.this$0.commandListFactory, bl));
        }
    }
}

