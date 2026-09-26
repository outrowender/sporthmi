/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.InterAppService;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.presentationmode.RgSetGuidanceMode;

class InterAppService$7
extends NavCommand {
    private final /* synthetic */ InterAppService this$0;

    InterAppService$7(InterAppService interAppService, String string) {
        this.this$0 = interAppService;
        super(string);
    }

    @Override
    public void execute() {
        CommandList commandList = this.navigation.getDemoModeManager().getCommandListToTurnDemoMode(true, this.dsiResponseContainer.getTransformedLocation());
        commandList.add(new RgSetGuidanceMode(3));
        this.getCommandList().commandFinishedWithPostSequence(commandList);
    }
}

