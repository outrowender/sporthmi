/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.tghu.navi.app.InterAppService;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

class InterAppService$3
extends NavCommand {
    private final /* synthetic */ InterAppService this$0;

    InterAppService$3(InterAppService interAppService, String string) {
        this.this$0 = interAppService;
        super(string);
    }

    @Override
    public void execute() {
        NavLocation navLocation = this.dsiResponseContainer.getTransformedLocation();
        this.getCommandList().commandFinishedWithPostSequence(InterAppService.access$000(this.this$0).getStartSequence(navLocation));
    }
}

