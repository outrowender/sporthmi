/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.addressinput.CmdNaviPreviewMapUpdate;
import de.audi.tghu.navi.app.addressinput.commands.UpdateAddressInputFormScreenModelsCommand;
import de.audi.tghu.navi.app.addressinput.country.SetBackupLocationForAddressInputFormCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputStreetSequenceNAR;
import org.dsi.ifc.global.NavLocation;

class AddressInputStreetSequenceNAR$2
extends NavCommand {
    private final /* synthetic */ AddressInputStreetSequenceNAR this$0;

    AddressInputStreetSequenceNAR$2(AddressInputStreetSequenceNAR addressInputStreetSequenceNAR) {
        this.this$0 = addressInputStreetSequenceNAR;
    }

    @Override
    public void execute() {
        CommandList commandList = this.this$0.commandListFactory.createCommandList();
        NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
        if (navLocation.isPositionValid()) {
            this.this$0.modelAccess.onElementSelected(this.dsiResponseContainer.getLiCurrentLD());
            commandList.add(new UpdateAddressInputFormScreenModelsCommand(this.this$0.modelAccess));
            commandList.add(new CmdNaviPreviewMapUpdate(this.this$0.previewMap, 1, null, null));
            commandList.add(new SetBackupLocationForAddressInputFormCommand(this.this$0.inputManager));
            commandList.add(this.this$0.inputManager.handleAddressInputEvent(this.this$0.commandListFactory.createCommandList(), 30303));
        } else {
            this.this$0.modelAccess.onAmbiguousElementSelected();
            commandList.add(this.this$0.inputManager.handleAddressInputEvent(this.this$0.commandListFactory.createCommandList(), 30304));
        }
        this.getCommandList().commandFinishedWithPostSequence(commandList);
    }
}

