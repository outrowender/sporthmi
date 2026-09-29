/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.map.NaviInterface;
import org.dsi.ifc.global.NavLocation;

class NaviInterface$3
extends NavCommand {
    private final /* synthetic */ NavLocation val$destinationLocation;
    private final /* synthetic */ NaviInterface this$0;

    NaviInterface$3(NaviInterface naviInterface, NavLocation navLocation) {
        this.this$0 = naviInterface;
        this.val$destinationLocation = navLocation;
    }

    @Override
    public void execute() {
        NaviInterface.access$000(this.this$0).enterDetailsScreen(this.val$destinationLocation);
        this.getCommandList().commandFinished();
    }
}

