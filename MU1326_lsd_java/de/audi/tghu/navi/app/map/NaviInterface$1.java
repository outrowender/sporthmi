/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.map.AbstractMap;
import de.audi.tghu.navi.app.map.NaviInterface;

class NaviInterface$1
extends NavCommand {
    private final /* synthetic */ AbstractMap val$naviMap;
    private final /* synthetic */ int val$index;
    private final /* synthetic */ NaviInterface this$0;

    NaviInterface$1(NaviInterface naviInterface, String string, AbstractMap abstractMap, int n) {
        this.this$0 = naviInterface;
        this.val$naviMap = abstractMap;
        this.val$index = n;
        super(string);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "NaviInterface#requestOnlineResultFlagDetails#execute()");
        this.val$naviMap.getMapInterface().updateOnlineResultFlagDetails(this.val$index);
        this.getCommandList().commandFinished();
    }
}

