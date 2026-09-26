/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.sdis;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.sdis.NaviTabletService;
import org.dsi.ifc.global.NavLocation;

class NaviTabletService$1
extends NavCommand {
    private final /* synthetic */ int val$index;
    private final /* synthetic */ NaviTabletService this$0;

    NaviTabletService$1(NaviTabletService naviTabletService, String string, int n) {
        this.this$0 = naviTabletService;
        this.val$index = n;
        super(string);
    }

    @Override
    public void execute() {
        NavLocation[] navLocationArray = (NavLocation[])this.getCommandList().get("NavLocationArray");
        navLocationArray[this.val$index] = this.dsiResponseContainer.getTransformedLocation();
        this.getCommandList().commandFinished();
    }
}

