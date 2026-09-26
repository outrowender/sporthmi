/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.addressinput.CmdNaviPreviewMapUpdate;
import de.audi.tghu.navi.app.addressinput.commands.UpdateAddressInputFormScreenModelsCommand;
import de.audi.tghu.navi.app.addressinput.country.SetBackupLocationForAddressInputFormCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputStreetSequenceCN;
import org.dsi.ifc.global.NavLocation;

class AddressInputStreetSequenceCN$2
extends NavCommand {
    private final /* synthetic */ AddressInputStreetSequenceCN this$0;

    AddressInputStreetSequenceCN$2(AddressInputStreetSequenceCN addressInputStreetSequenceCN) {
        this.this$0 = addressInputStreetSequenceCN;
    }

    @Override
    public void execute() {
        NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
        if (navLocation.isPositionValid()) {
            this.this$0.modelAccess.onElementSelected(this.dsiResponseContainer.getLiCurrentLD());
            CommandList commandList = this.this$0.commandListFactory.createCommandList();
            commandList.add(new UpdateAddressInputFormScreenModelsCommand(this.this$0.modelAccess));
            commandList.add(new CmdNaviPreviewMapUpdate(this.this$0.previewMap, 1, null, null));
            commandList.add(new SetBackupLocationForAddressInputFormCommand(this.this$0.inputManager));
            this.getCommandList().commandFinishedWithPostSequence(commandList);
        } else {
            this.this$0.modelAccess.onAmbiguousElementSelected();
        }
        this.getCommandList().commandFinished();
    }
}

