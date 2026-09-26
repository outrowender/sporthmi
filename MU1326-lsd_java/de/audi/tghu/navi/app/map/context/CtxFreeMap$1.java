/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.context;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.map.context.CtxFreeMap;
import org.dsi.ifc.global.NavLocation;

class CtxFreeMap$1
extends NavCommand {
    private final /* synthetic */ NavLocation val$location;
    private final /* synthetic */ String val$url1;
    private final /* synthetic */ CtxFreeMap this$0;

    CtxFreeMap$1(CtxFreeMap ctxFreeMap, String string, NavLocation navLocation, String string2) {
        this.this$0 = ctxFreeMap;
        this.val$location = navLocation;
        this.val$url1 = string2;
        super(string);
    }

    @Override
    public void execute() {
        this.navigation.getNaviMapConnector().showMapDestination(this.val$location, this.val$url1);
        this.getCommandList().commandFinished();
    }
}

