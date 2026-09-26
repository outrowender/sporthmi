/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.di.nar.wfm;

import de.audi.app.navi.evo.di.nar.wfm.AddressInputStreetRefinementScreenWorkFlowManagerNAR;
import de.audi.tghu.navi.app.command.AddStreetAndCityToHistoryCommand;
import de.audi.tghu.navi.app.command.NavCommand;

class AddressInputStreetRefinementScreenWorkFlowManagerNAR$3
extends NavCommand {
    private final /* synthetic */ AddressInputStreetRefinementScreenWorkFlowManagerNAR this$0;

    AddressInputStreetRefinementScreenWorkFlowManagerNAR$3(AddressInputStreetRefinementScreenWorkFlowManagerNAR addressInputStreetRefinementScreenWorkFlowManagerNAR, String string) {
        this.this$0 = addressInputStreetRefinementScreenWorkFlowManagerNAR;
        super(string);
    }

    @Override
    public void execute() {
        this.env.getChoiceModel(-2027878912).setValue(0);
        this.getCommandList().commandFinishedWithPostCommand(new AddStreetAndCityToHistoryCommand(this.dsiResponseContainer.getLiCurrentLD(), AddressInputStreetRefinementScreenWorkFlowManagerNAR.access$000(this.this$0), this.this$0.commandListFactory, true));
    }
}

