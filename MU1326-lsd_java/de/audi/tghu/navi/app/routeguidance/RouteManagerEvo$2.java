/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.routeguidance.RouteManagerEvo;

class RouteManagerEvo$2
extends NavCommand {
    private final /* synthetic */ RouteManagerEvo this$0;

    RouteManagerEvo$2(RouteManagerEvo routeManagerEvo, String string) {
        this.this$0 = routeManagerEvo;
        super(string);
    }

    @Override
    public void execute() {
        this.env.getChoiceModel(136578560).setValue(1);
        this.getCommandList().commandFinished();
    }
}

