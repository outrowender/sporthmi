/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.sds.LIStripLocationCommand;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputProvinceSequenceAsia;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputProvinceSequenceAsia$1$1;
import org.dsi.ifc.global.NavLocation;

class AddressInputProvinceSequenceAsia$1
extends NavCommand {
    private final /* synthetic */ AddressInputProvinceSequenceAsia this$0;

    AddressInputProvinceSequenceAsia$1(AddressInputProvinceSequenceAsia addressInputProvinceSequenceAsia, String string) {
        this.this$0 = addressInputProvinceSequenceAsia;
        super(string);
    }

    @Override
    public void execute() {
        NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
        if (navLocation.isPositionValid()) {
            CommandList commandList = this.this$0.commandListFactory.createCommandList();
            commandList.add(new LIStripLocationCommand(navLocation, 1));
            commandList.add(new AddressInputProvinceSequenceAsia$1$1(this));
            this.getCommandList().commandFinishedWithPostSequence(commandList);
        } else {
            this.getCommandList().commandFinished();
        }
    }

    static /* synthetic */ AddressInputProvinceSequenceAsia access$000(AddressInputProvinceSequenceAsia$1 addressInputProvinceSequenceAsia$1) {
        return addressInputProvinceSequenceAsia$1.this$0;
    }
}

