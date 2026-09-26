/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.operatorcall;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.operatorcall.NaviOperatorCallService;

class NaviOperatorCallService$3
extends NavCommand {
    private final /* synthetic */ NaviOperatorCallService this$0;

    NaviOperatorCallService$3(NaviOperatorCallService naviOperatorCallService, String string) {
        this.this$0 = naviOperatorCallService;
        super(string);
    }

    @Override
    public void execute() {
        NaviOperatorCallService.access$200(this.this$0).onCreateEditHomeAddress(this.dsiResponseContainer.getTransformedLocation());
        this.getCommandList().commandFinished();
    }
}

