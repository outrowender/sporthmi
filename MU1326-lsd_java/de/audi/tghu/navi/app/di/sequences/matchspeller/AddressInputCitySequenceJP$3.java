/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.sds.LIStripLocationCommand;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputCitySequenceJP;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputCitySequenceJP$3$1;
import org.dsi.ifc.global.NavLocation;

class AddressInputCitySequenceJP$3
extends NavCommand {
    private final /* synthetic */ AddressInputCitySequenceJP this$0;

    AddressInputCitySequenceJP$3(AddressInputCitySequenceJP addressInputCitySequenceJP, String string) {
        this.this$0 = addressInputCitySequenceJP;
        super(string);
    }

    @Override
    public void execute() {
        NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
        if (navLocation.isPositionValid()) {
            CommandList commandList = this.this$0.commandListFactory.createCommandList();
            commandList.add(new LIStripLocationCommand(navLocation, this.this$0.getStripLocationType()));
            commandList.add(new AddressInputCitySequenceJP$3$1(this));
            this.getCommandList().commandFinishedWithPostSequence(commandList);
        } else {
            this.getCommandList().commandFinished();
        }
    }
}

