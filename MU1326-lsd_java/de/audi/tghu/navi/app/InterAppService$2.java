/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.tghu.navi.app.InterAppService;
import de.audi.tghu.navi.app.command.NavCommand;

class InterAppService$2
extends NavCommand {
    private final /* synthetic */ InterAppService this$0;

    InterAppService$2(InterAppService interAppService, String string) {
        this.this$0 = interAppService;
        super(string);
    }

    @Override
    public void execute() {
        this.this$0.getSDSHandler().storeNavigateToDestination(this.dsiResponseContainer.getTransformedLocation());
        if (this.dsiResponseContainer.getTransformedLocation().isPositionValid()) {
            this.dsiResponseContainer.setLiCurrentState(this.dsiResponseContainer.getTransformedLocation(), new int[0], new int[0]);
            this.getCommandList().commandFinished();
        } else {
            this.logger.log(-1601830656, "InterAppService#setLocation(OperatorCallResult) the transformed location is not valid");
            this.getCommandList().commandFinished();
        }
    }
}

