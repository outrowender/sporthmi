/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.map.NaviInterface;
import org.dsi.ifc.tmc.TmcMessage;

class NaviInterface$4
extends NavCommand {
    private final /* synthetic */ TmcMessage val$msg;
    private final /* synthetic */ NaviInterface this$0;

    NaviInterface$4(NaviInterface naviInterface, TmcMessage tmcMessage) {
        this.this$0 = naviInterface;
        this.val$msg = tmcMessage;
    }

    @Override
    public void execute() {
        NaviInterface.access$000(this.this$0).enterDetailsScreenTmc(this.val$msg);
        this.getCommandList().commandFinished();
    }
}

