/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.operatorcall;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.operatorcall.NaviOperatorCallService;
import org.dsi.ifc.online.OperatorCallResult;

class NaviOperatorCallService$2
extends NavCommand {
    private final /* synthetic */ OperatorCallResult val$operatorCallResult;
    private final /* synthetic */ NaviOperatorCallService this$0;

    NaviOperatorCallService$2(NaviOperatorCallService naviOperatorCallService, String string, OperatorCallResult operatorCallResult) {
        this.this$0 = naviOperatorCallService;
        this.val$operatorCallResult = operatorCallResult;
        super(string);
    }

    @Override
    public void execute() {
        NaviOperatorCallService.access$100(this.this$0).addToFavorites(this.dsiResponseContainer.getTransformedLocation(), this.val$operatorCallResult.getName());
        this.getCommandList().commandFinished();
    }
}

