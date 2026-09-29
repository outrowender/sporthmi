/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.interapp;

import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.interapp.RouteGuidanceInterAppService;
import de.audi.tghu.navi.app.interapp.RouteGuidanceInterAppService$7$1;
import de.audi.tghu.navi.app.interapp.RouteGuidanceInterAppService$7$2;
import org.dsi.ifc.global.NavLocation;

class RouteGuidanceInterAppService$7
extends NavCommand {
    private final /* synthetic */ NavLocation val$location;
    private final /* synthetic */ boolean val$forceStart;
    private final /* synthetic */ NaviServiceListener val$naviServiceListener;
    private final /* synthetic */ RouteGuidanceInterAppService this$0;

    RouteGuidanceInterAppService$7(RouteGuidanceInterAppService routeGuidanceInterAppService, String string, NavLocation navLocation, boolean bl, NaviServiceListener naviServiceListener) {
        this.this$0 = routeGuidanceInterAppService;
        this.val$location = navLocation;
        this.val$forceStart = bl;
        this.val$naviServiceListener = naviServiceListener;
        super(string);
    }

    @Override
    public void execute() {
        if (this.dsiResponseContainer.isRgActive() || this.dsiResponseContainer.isEtcDemoMode() || RouteGuidanceInterAppService.access$000(this.this$0)) {
            CommandList commandList = RouteGuidanceInterAppService.access$100(this.this$0).createCommandList();
            if (this.val$location.isPositionValid()) {
                commandList.add(RouteGuidanceInterAppService.access$200(this.this$0).getStartSequence(null, this.val$location, false, this.val$forceStart));
                commandList.add(new RouteGuidanceInterAppService$7$1(this, this.val$naviServiceListener));
            } else {
                commandList.add(new RouteGuidanceInterAppService$7$2(this, this.val$naviServiceListener));
            }
            this.getCommandList().commandFinishedWithPostSequence(commandList);
        } else {
            this.getCommandList().commandFinishedWithPostSequence(RouteGuidanceInterAppService.access$200(this.this$0).getStartSequence(null, this.val$location, false, this.val$forceStart));
        }
    }
}

