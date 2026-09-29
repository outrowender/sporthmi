/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.map.NaviInterface;

class NaviInterface$8
extends NavCommand {
    private final /* synthetic */ int val$source;
    private final /* synthetic */ NaviInterface this$0;

    NaviInterface$8(NaviInterface naviInterface, String string, int n) {
        this.this$0 = naviInterface;
        this.val$source = n;
        super(string);
    }

    @Override
    public void execute() {
        this.getDSINavigation().afaRepeat(this.val$source);
        this.getCommandList().commandFinished();
    }
}

