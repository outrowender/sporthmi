/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.addressinput.CmdNaviPreviewMapUpdate;
import de.audi.tghu.navi.app.addressinput.commands.UpdateAddressInputFormScreenModelsCommand;
import de.audi.tghu.navi.app.addressinput.country.SetBackupLocationForAddressInputFormCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputTownStreetSequence;
import org.dsi.ifc.global.NavLocation;

class AddressInputTownStreetSequence$3
extends NavCommand {
    private final /* synthetic */ AddressInputTownStreetSequence this$0;

    AddressInputTownStreetSequence$3(AddressInputTownStreetSequence addressInputTownStreetSequence) {
        this.this$0 = addressInputTownStreetSequence;
    }

    @Override
    public void execute() {
        NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
        if (navLocation.isPositionValid()) {
            CommandList commandList = this.this$0.commandListFactory.createCommandList();
            commandList.add(new UpdateAddressInputFormScreenModelsCommand(this.this$0.modelAccess));
            commandList.add(new CmdNaviPreviewMapUpdate(this.this$0.previewMap, 1, null, null));
            commandList.add(new SetBackupLocationForAddressInputFormCommand(this.this$0.inputManager));
            this.getCommandList().commandFinishedWithPostSequence(commandList);
        } else {
            this.logger.log(-2137614336, "Selected item is not a valid position!");
        }
        this.getCommandList().commandFinished();
    }
}

