/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.nar.wfm;

import de.audi.app.navi.evo.di.nar.wfm.AddressInputStreetRefinementScreenWorkFlowManagerNAR;
import de.audi.tghu.navi.app.command.NavCommand;

class AddressInputStreetRefinementScreenWorkFlowManagerNAR$2
extends NavCommand {
    private final /* synthetic */ AddressInputStreetRefinementScreenWorkFlowManagerNAR this$0;

    AddressInputStreetRefinementScreenWorkFlowManagerNAR$2(AddressInputStreetRefinementScreenWorkFlowManagerNAR addressInputStreetRefinementScreenWorkFlowManagerNAR, String string) {
        this.this$0 = addressInputStreetRefinementScreenWorkFlowManagerNAR;
        super(string);
    }

    @Override
    public void execute() {
        if (this.dsiResponseContainer.getLiCurrentLD().positionValid) {
            this.env.getChoiceModel(-2027878912).setValue(0);
            this.getCommandList().commandFinished();
            return;
        }
        if (this.dsiResponseContainer.refinementCriterionAvailable(125)) {
            this.env.getChoiceModel(-2027878912).setValue(2);
            this.getCommandList().commandFinishedWithPostSequence(this.this$0.inputManager.getHousenumberScreenListener().getSetHousenumberByAdditionalCriteria());
        } else {
            this.getCommandList().commandAborted("SELCRITDES_REFINEBYADDITONALCRITERIA is not available");
        }
    }
}

