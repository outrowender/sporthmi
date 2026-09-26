/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.routeguidance.RouteManager;

class RouteManager$2
extends NavCommand {
    private final /* synthetic */ RouteManager this$0;

    RouteManager$2(RouteManager routeManager, String string) {
        this.this$0 = routeManager;
        super(string);
    }

    @Override
    public void execute() {
        this.env.getLogChannel().log(-2137614336, "StartRgWithPressRoute#execute");
        this.getCommandList().commandFinishedWithPostSequence(this.navigation.getRouteManager().getStartGuidanceSequence(true));
    }
}

