/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.operatorcall;

import de.audi.tghu.navi.app.addressinput.ReturnNavLocationToAddressbookSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.operatorcall.NaviOperatorCallService;

class NaviOperatorCallService$1
extends NavCommand {
    private final /* synthetic */ NaviOperatorCallService this$0;

    NaviOperatorCallService$1(NaviOperatorCallService naviOperatorCallService, String string) {
        this.this$0 = naviOperatorCallService;
        super(string);
    }

    @Override
    public void execute() {
        ReturnNavLocationToAddressbookSequence returnNavLocationToAddressbookSequence = new ReturnNavLocationToAddressbookSequence(NaviOperatorCallService.access$000(this.this$0));
        this.getCommandList().commandFinishedWithPostSequence(returnNavLocationToAddressbookSequence.getStartCommandListWithLocation(this.dsiResponseContainer.getTransformedLocation()));
    }
}

