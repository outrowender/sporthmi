/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.online.app.onlinedest;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.online.app.onlinedest.OnlineDestinationSequence;
import de.audi.tghu.online.app.onlinedest.commands.AbstractOnlineDestinationCommand;
import de.audi.tghu.online.app.onlinedest.commands.StoreAddressListInNavigation;

class OnlineDestinationSequence$1
extends AbstractOnlineDestinationCommand {
    private final /* synthetic */ OnlineDestinationSequence this$0;

    OnlineDestinationSequence$1(OnlineDestinationSequence onlineDestinationSequence) {
        this.this$0 = onlineDestinationSequence;
    }

    @Override
    public void execute() {
        this.this$0.log.log(10000, "OnlineDestinationSequence#errorCommand() an unknown error occured");
        this.this$0.application.getModelHandler().updateErrorStateModels(4);
        CommandList commandList = this.this$0.application.createCommandList();
        commandList.add(new StoreAddressListInNavigation(this.this$0.log, null));
        commandList.execute("OnlineDestinationSequence execute error command. empty list to navigation");
    }
}

