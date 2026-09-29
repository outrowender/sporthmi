/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.atip.preset.ExecuteRequest;
import de.audi.tghu.navi.app.NaviPresetHandler;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

class NaviPresetHandler$1
extends NavCommand {
    private final /* synthetic */ ExecuteRequest val$request;
    private final /* synthetic */ NaviPresetHandler this$0;

    NaviPresetHandler$1(NaviPresetHandler naviPresetHandler, ExecuteRequest executeRequest) {
        this.this$0 = naviPresetHandler;
        this.val$request = executeRequest;
    }

    @Override
    public void execute() {
        this.this$0.startGuidanceToDestinationSequence.start((NavLocation)this.getCommandList().get("STREAMED_LOCATION"));
        this.val$request.responseExecute(0);
        NaviPresetHandler.access$000(this.this$0);
        this.getCommandList().commandFinished();
    }
}

