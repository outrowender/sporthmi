/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.map.NaviInterface;

class NaviInterface$7
extends NavCommand {
    private final /* synthetic */ NaviInterface this$0;

    NaviInterface$7(NaviInterface naviInterface, String string) {
        this.this$0 = naviInterface;
        super(string);
    }

    @Override
    public void execute() {
        this.getDSINavigation().rgTriggerRCCIUpdate();
        this.getCommandList().commandFinished();
    }
}

