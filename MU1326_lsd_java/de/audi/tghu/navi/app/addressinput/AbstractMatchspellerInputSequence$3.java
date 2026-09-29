/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.addressinput.AbstractMatchspellerInputSequence;
import de.audi.tghu.navi.app.addressinput.commands.ModelUpdateSpellerAndResultListCommand;
import de.audi.tghu.navi.app.command.LIValueListWindowSizeCommand;
import de.audi.tghu.navi.app.command.NavCommand;

class AbstractMatchspellerInputSequence$3
extends NavCommand {
    private final /* synthetic */ AbstractMatchspellerInputSequence this$0;

    AbstractMatchspellerInputSequence$3(AbstractMatchspellerInputSequence abstractMatchspellerInputSequence, String string) {
        this.this$0 = abstractMatchspellerInputSequence;
        super(string);
    }

    @Override
    public void execute() {
        CommandList commandList = this.this$0.commandListFactory.createCommandList();
        if (this.dsiResponseContainer.getLispValueListCount() > 0L) {
            commandList.add(new ModelUpdateSpellerAndResultListCommand(this.this$0.modelAccess));
        } else {
            this.this$0.undoCharacter();
        }
        commandList.add(new LIValueListWindowSizeCommand(-1));
        this.getCommandList().commandFinishedWithPostSequence(commandList);
    }
}

