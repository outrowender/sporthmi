/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.AbstractAddressInputManager;
import de.audi.tghu.navi.app.li.aih.AddressInputHandler;
import org.dsi.ifc.global.NavLocation;

class AbstractAddressInputManager$5
extends NavCommand {
    private final /* synthetic */ AddressInputHandler val$aih;
    private final /* synthetic */ NavLocation val$destination;
    private final /* synthetic */ AbstractAddressInputManager this$0;

    AbstractAddressInputManager$5(AbstractAddressInputManager abstractAddressInputManager, String string, AddressInputHandler addressInputHandler, NavLocation navLocation) {
        this.this$0 = abstractAddressInputManager;
        this.val$aih = addressInputHandler;
        this.val$destination = navLocation;
        super(string);
    }

    @Override
    public void execute() {
        CommandList commandList = this.this$0.commandListFactory.createCommandList();
        commandList.add(this.this$0.abortAddressInput(false));
        if (this.val$aih != null) {
            commandList.add(this.val$aih.handleCompleteLocation(this.val$destination, this.this$0.logChannel));
        }
        this.getCommandList().commandFinishedWithPostSequence(commandList);
    }
}

