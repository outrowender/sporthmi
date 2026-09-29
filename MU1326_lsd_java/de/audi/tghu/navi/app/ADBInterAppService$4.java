/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.tghu.navi.app.ADBInterAppService;
import de.audi.tghu.navi.app.addressinput.commands.LISetCurrentLDCommand;
import de.audi.tghu.navi.app.command.NavCommand;

class ADBInterAppService$4
extends NavCommand {
    private final /* synthetic */ ADBInterAppService this$0;

    ADBInterAppService$4(ADBInterAppService aDBInterAppService, String string) {
        this.this$0 = aDBInterAppService;
        super(string);
    }

    @Override
    public void execute() {
        this.getCommandList().commandFinishedWithPostCommand(new LISetCurrentLDCommand(this.dsiResponseContainer.getTryBestMatchResultData()[0].getLocation()));
    }
}

