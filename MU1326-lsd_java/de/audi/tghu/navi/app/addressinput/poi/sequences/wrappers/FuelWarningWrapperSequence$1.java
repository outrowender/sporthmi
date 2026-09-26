/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.addressinput.poi.commands.LiGetStateCommand;
import de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers.FuelWarningWrapperSequence;
import de.audi.tghu.navi.app.command.NavCommand;

class FuelWarningWrapperSequence$1
extends NavCommand {
    private final /* synthetic */ FuelWarningWrapperSequence this$0;

    FuelWarningWrapperSequence$1(FuelWarningWrapperSequence fuelWarningWrapperSequence, String string) {
        this.this$0 = fuelWarningWrapperSequence;
        super(string);
    }

    @Override
    public void execute() {
        int n = this.dsiResponseContainer.getLispValueList().getList().length;
        this.this$0.logChannel.log(-2137614336, "FuelWarningWrapperSequence#start - valueListCount=%1", (long)n);
        if (n == 0) {
            this.env.getChoiceModel(-14940672).setValue(1);
            this.getCommandList().commandFinishedWithPostSequence(FuelWarningWrapperSequence.access$000(this.this$0, false, this.this$0.vicinityModelAccessBackup, this.this$0.maxResultsAlongRoute));
        } else {
            CommandList commandList = this.this$0.commandListFactory.createCommandList();
            commandList.add(new LiGetStateCommand());
            this.getCommandList().commandFinishedWithPostSequence(commandList);
        }
    }
}

