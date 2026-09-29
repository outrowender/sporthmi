/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputStreetSequenceNAR;
import org.dsi.ifc.global.NavLocation;

class AddressInputStreetSequenceNAR$5
extends NavCommand {
    private final /* synthetic */ AddressInputStreetSequenceNAR this$0;

    AddressInputStreetSequenceNAR$5(AddressInputStreetSequenceNAR addressInputStreetSequenceNAR) {
        this.this$0 = addressInputStreetSequenceNAR;
    }

    @Override
    public void execute() {
        NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
        if (navLocation.isPositionValid()) {
            this.getCommandList().commandFinishedWithPostSequence(this.this$0.inputManager.handleAddressInputEvent(this.this$0.commandListFactory.createCommandList(), 30303));
        } else {
            CommandList commandList = this.this$0.inputManager.handleAddressInputEvent(this.this$0.commandListFactory.createCommandList(), 30304);
            this.getCommandList().commandFinishedWithPostSequence(commandList);
        }
    }
}

