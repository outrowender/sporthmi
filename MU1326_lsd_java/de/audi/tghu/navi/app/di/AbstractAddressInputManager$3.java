/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.addressinput.poi.commands.LIRestoreStateCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.AbstractAddressInputManager;
import de.audi.tghu.navi.app.li.SpellerStack$StackElement;

class AbstractAddressInputManager$3
extends NavCommand {
    private final /* synthetic */ AbstractAddressInputManager this$0;

    AbstractAddressInputManager$3(AbstractAddressInputManager abstractAddressInputManager, String string) {
        this.this$0 = abstractAddressInputManager;
        super(string);
    }

    @Override
    public void execute() {
        CommandList commandList = null;
        if (!this.this$0.spellerStack.isEmpty()) {
            commandList = this.this$0.commandListFactory.createCommandList();
            SpellerStack$StackElement spellerStack$StackElement = AbstractAddressInputManager.access$000(this.this$0);
            commandList.add(new LIRestoreStateCommand(spellerStack$StackElement));
        }
        this.getCommandList().commandFinishedWithPostSequence(commandList);
    }
}

