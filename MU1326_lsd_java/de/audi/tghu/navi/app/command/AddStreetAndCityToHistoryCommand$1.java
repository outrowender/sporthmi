/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.command.AddStreetAndCityToHistoryCommand;
import de.audi.tghu.navi.app.command.AddStreetAndCityToHistoryCommand$1$1;
import de.audi.tghu.navi.app.command.NavCommand;

class AddStreetAndCityToHistoryCommand$1
extends NavCommand {
    private final /* synthetic */ AddStreetAndCityToHistoryCommand this$0;

    AddStreetAndCityToHistoryCommand$1(AddStreetAndCityToHistoryCommand addStreetAndCityToHistoryCommand, String string) {
        this.this$0 = addStreetAndCityToHistoryCommand;
        super(string);
    }

    @Override
    public void execute() {
        if (this.dsiResponseContainer.getLiCurrentLD().isPositionValid()) {
            CommandList commandList = AddStreetAndCityToHistoryCommand.access$000(this.this$0).createCommandList();
            commandList.add(new AddStreetAndCityToHistoryCommand$1$1(this, new StringBuffer().append(this.CLASS_NAME).append("#getSelectListElementCommandList add striped location to history").toString()));
            this.getCommandList().commandFinishedWithPostSequence(commandList);
        } else {
            this.getCommandList().commandFinished();
        }
    }

    static /* synthetic */ AddStreetAndCityToHistoryCommand access$100(AddStreetAndCityToHistoryCommand$1 addStreetAndCityToHistoryCommand$1) {
        return addStreetAndCityToHistoryCommand$1.this$0;
    }
}

