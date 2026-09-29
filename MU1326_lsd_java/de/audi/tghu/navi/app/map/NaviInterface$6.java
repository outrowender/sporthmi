/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.command.poi.CalcRRDAndSendToCallBackCommand;
import de.audi.tghu.navi.app.map.NaviInterface;

class NaviInterface$6
extends NavCommand {
    private final /* synthetic */ CalcRRDAndSendToCallBackCommand val$calcRRDAndSendToCallBackCommand;
    private final /* synthetic */ NaviInterface this$0;

    NaviInterface$6(NaviInterface naviInterface, String string, CalcRRDAndSendToCallBackCommand calcRRDAndSendToCallBackCommand) {
        this.this$0 = naviInterface;
        this.val$calcRRDAndSendToCallBackCommand = calcRRDAndSendToCallBackCommand;
        super(string);
    }

    @Override
    public void execute() {
        this.val$calcRRDAndSendToCallBackCommand.resetRRDCalculationFlag();
    }
}

