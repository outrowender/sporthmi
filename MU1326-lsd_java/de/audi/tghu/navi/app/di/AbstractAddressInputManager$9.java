/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.SetVehicleCountryLocationCommandListCommand;
import de.audi.tghu.navi.app.command.StreamToLocationCommand;
import de.audi.tghu.navi.app.di.AbstractAddressInputManager;

class AbstractAddressInputManager$9
extends NavCommand {
    private final /* synthetic */ AbstractAddressInputManager this$0;

    AbstractAddressInputManager$9(AbstractAddressInputManager abstractAddressInputManager, String string) {
        this.this$0 = abstractAddressInputManager;
        super(string);
    }

    @Override
    public void execute() {
        Object object = this.getCommandList().get("LOCATION_STREAM");
        if (!(object instanceof byte[]) || ((byte[])object).length == 0) {
            this.logger.log(-1601830656, "%1#execute() - object is null or not instance of byte[] or has no length", (Object)this.CLASS_NAME);
            this.getCommandList().commandFinished();
        } else {
            CommandList commandList = this.this$0.commandListFactory.createCommandList();
            commandList.add(new StreamToLocationCommand("LOCATION_STREAM"));
            commandList.add(new SetVehicleCountryLocationCommandListCommand("STREAMED_LOCATION"));
            this.getCommandList().commandFinishedWithPostSequence(commandList);
        }
    }
}

