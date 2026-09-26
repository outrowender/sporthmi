/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app;

import de.audi.atip.preset.ExecuteRequest;
import de.audi.tghu.navi.app.NaviPresetHandler;
import de.audi.tghu.navi.app.command.NavCommand;

class NaviPresetHandler$2
extends NavCommand {
    private final /* synthetic */ ExecuteRequest val$request;
    private final /* synthetic */ NaviPresetHandler this$0;

    NaviPresetHandler$2(NaviPresetHandler naviPresetHandler, ExecuteRequest executeRequest) {
        this.this$0 = naviPresetHandler;
        this.val$request = executeRequest;
    }

    @Override
    public void execute() {
        this.env.getLogChannel().log(10000, "%1#requestExecute() request=%2", (Object)"NaviPresetHandler", (Object)this.val$request);
        this.val$request.responseExecute(1);
        this.getCommandList().commandFinished();
    }
}

