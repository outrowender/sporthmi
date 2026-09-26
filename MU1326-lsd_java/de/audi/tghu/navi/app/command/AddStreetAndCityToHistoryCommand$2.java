/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.command.AddStreetAndCityToHistoryCommand;
import de.audi.tghu.navi.app.command.AddStreetAndCityToHistoryCommand$2$1;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.sds.LIStripLocationCommand;

class AddStreetAndCityToHistoryCommand$2
extends NavCommand {
    private final /* synthetic */ AddStreetAndCityToHistoryCommand this$0;

    AddStreetAndCityToHistoryCommand$2(AddStreetAndCityToHistoryCommand addStreetAndCityToHistoryCommand, String string) {
        this.this$0 = addStreetAndCityToHistoryCommand;
        super(string);
    }

    @Override
    public void execute() {
        if (this.dsiResponseContainer.getLiCurrentLD().isPositionValid()) {
            CommandList commandList = AddStreetAndCityToHistoryCommand.access$000(this.this$0).createCommandList();
            commandList.add(new LIStripLocationCommand(this.dsiResponseContainer.getLiCurrentLD(), 14));
            commandList.add(new AddStreetAndCityToHistoryCommand$2$1(this, new StringBuffer().append(this.CLASS_NAME).append("#getSelectListElementCommandList add stiped location to history").toString()));
            this.getCommandList().commandFinishedWithPostSequence(commandList);
        } else {
            this.getCommandList().commandFinished();
        }
    }

    static /* synthetic */ AddStreetAndCityToHistoryCommand access$400(AddStreetAndCityToHistoryCommand$2 addStreetAndCityToHistoryCommand$2) {
        return addStreetAndCityToHistoryCommand$2.this$0;
    }
}

