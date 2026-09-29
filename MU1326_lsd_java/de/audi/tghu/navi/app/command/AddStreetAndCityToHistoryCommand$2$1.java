/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.command;

import de.audi.tghu.navi.app.command.AddStreetAndCityToHistoryCommand;
import de.audi.tghu.navi.app.command.AddStreetAndCityToHistoryCommand$2;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

class AddStreetAndCityToHistoryCommand$2$1
extends NavCommand {
    private final /* synthetic */ AddStreetAndCityToHistoryCommand$2 this$1;

    AddStreetAndCityToHistoryCommand$2$1(AddStreetAndCityToHistoryCommand$2 addStreetAndCityToHistoryCommand$2, String string) {
        this.this$1 = addStreetAndCityToHistoryCommand$2;
        super(string);
    }

    @Override
    public void execute() {
        this.getCommandList().commandFinishedWithPostSequence(AddStreetAndCityToHistoryCommand.access$300(AddStreetAndCityToHistoryCommand$2.access$400(this.this$1)).addLastStreetCommandList((NavLocation)this.getCommandList().get("STRIPPED_LOCATION")));
    }
}

