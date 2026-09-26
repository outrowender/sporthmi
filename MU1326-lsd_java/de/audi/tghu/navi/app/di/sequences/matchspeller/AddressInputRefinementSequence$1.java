/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.addressinput.CmdNaviPreviewMapUpdate;
import de.audi.tghu.navi.app.addressinput.commands.UpdateAddressInputFormScreenModelsCommand;
import de.audi.tghu.navi.app.addressinput.country.SetBackupLocationForAddressInputFormCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputRefinementSequence;

class AddressInputRefinementSequence$1
extends NavCommand {
    private final /* synthetic */ AddressInputRefinementSequence this$0;

    AddressInputRefinementSequence$1(AddressInputRefinementSequence addressInputRefinementSequence) {
        this.this$0 = addressInputRefinementSequence;
    }

    @Override
    public void execute() {
        this.this$0.modelAccess.onElementSelected(this.dsiResponseContainer.getLiCurrentLD());
        CommandList commandList = this.this$0.commandListFactory.createCommandList();
        commandList.add(new UpdateAddressInputFormScreenModelsCommand(this.this$0.modelAccess));
        commandList.add(new CmdNaviPreviewMapUpdate(this.this$0.previewMap, 1, null, null));
        commandList.add(new SetBackupLocationForAddressInputFormCommand(this.this$0.inputManager));
        this.getCommandList().commandFinishedWithPostSequence(commandList);
    }
}

