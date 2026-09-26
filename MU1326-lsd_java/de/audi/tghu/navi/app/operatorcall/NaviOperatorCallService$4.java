/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.operatorcall;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.operatorcall.NaviOperatorCallService;

class NaviOperatorCallService$4
extends NavCommand {
    private final /* synthetic */ NaviOperatorCallService this$0;

    NaviOperatorCallService$4(NaviOperatorCallService naviOperatorCallService, String string) {
        this.this$0 = naviOperatorCallService;
        super(string);
    }

    @Override
    public void execute() {
        NaviOperatorCallService.access$300(this.this$0).startStoringAddress(this.dsiResponseContainer.getTransformedLocation());
        this.getCommandList().commandFinished();
    }
}

