/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.InterAppService;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

class InterAppService$4
extends NavCommand {
    private final /* synthetic */ boolean val$isRGForced;
    private final /* synthetic */ InterAppService this$0;

    InterAppService$4(InterAppService interAppService, String string, boolean bl) {
        this.this$0 = interAppService;
        this.val$isRGForced = bl;
        super(string);
    }

    @Override
    public void execute() {
        NavLocation navLocation = this.dsiResponseContainer.getTransformedLocation();
        CommandList commandList = InterAppService.access$000(this.this$0).getStartSequence(null, navLocation, false, this.val$isRGForced);
        this.getCommandList().commandFinishedWithPostSequence(commandList);
    }
}

