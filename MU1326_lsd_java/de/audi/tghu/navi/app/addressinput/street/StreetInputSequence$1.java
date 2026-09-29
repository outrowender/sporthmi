/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.street;

import de.audi.tghu.command.Command;
import de.audi.tghu.navi.app.addressinput.street.StreetInputSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

class StreetInputSequence$1
extends NavCommand {
    private final /* synthetic */ Command val$callback;
    private final /* synthetic */ StreetInputSequence this$0;

    StreetInputSequence$1(StreetInputSequence streetInputSequence, String string, Command command) {
        this.this$0 = streetInputSequence;
        this.val$callback = command;
        super(string);
    }

    @Override
    public void execute() {
        NavLocation navLocation = this.dsiResponseContainer.getSelectedLocation();
        this.logger.log(-2137614336, "Get NavLocation from Response Container - location=%1", (Object)navLocation);
        this.getCommandList().put("LocationToTest", navLocation);
        this.getCommandList().commandFinishedWithPostCommand(this.val$callback);
    }
}

