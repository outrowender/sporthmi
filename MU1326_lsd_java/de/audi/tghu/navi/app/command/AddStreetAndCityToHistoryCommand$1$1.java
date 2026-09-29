/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.command.AddStreetAndCityToHistoryCommand;
import de.audi.tghu.navi.app.command.AddStreetAndCityToHistoryCommand$1;
import de.audi.tghu.navi.app.command.NavCommand;

class AddStreetAndCityToHistoryCommand$1$1
extends NavCommand {
    private final /* synthetic */ AddStreetAndCityToHistoryCommand$1 this$1;

    AddStreetAndCityToHistoryCommand$1$1(AddStreetAndCityToHistoryCommand$1 addStreetAndCityToHistoryCommand$1, String string) {
        this.this$1 = addStreetAndCityToHistoryCommand$1;
        super(string);
    }

    @Override
    public void execute() {
        this.getCommandList().commandFinishedWithPostSequence(AddStreetAndCityToHistoryCommand.access$300(AddStreetAndCityToHistoryCommand$1.access$100(this.this$1)).addLastCityCommandList(this.dsiResponseContainer.getLiCurrentLD(), AddStreetAndCityToHistoryCommand.access$200(AddStreetAndCityToHistoryCommand$1.access$100(this.this$1))));
    }
}

