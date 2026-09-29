/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.tghu.navi.app.InterAppService;
import de.audi.tghu.navi.app.command.NavCommand;

class InterAppService$8
extends NavCommand {
    private final /* synthetic */ InterAppService this$0;

    InterAppService$8(InterAppService interAppService, String string) {
        this.this$0 = interAppService;
        super(string);
    }

    @Override
    public void execute() {
        this.getCommandList().commandFinishedWithPostSequence(this.navigation.getRouteManager().getStartRouteGuidanceToSingleDestinationSequence(this.dsiResponseContainer.getTransformedLocation()));
    }
}

