/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.routeguidance.RouteManager;

class RouteManager$1
extends NavCommand {
    private final /* synthetic */ int val$numberOfRemainingDestinations;
    private final /* synthetic */ RouteManager this$0;

    RouteManager$1(RouteManager routeManager, int n) {
        this.this$0 = routeManager;
        this.val$numberOfRemainingDestinations = n;
    }

    @Override
    public void execute() {
        this.this$0.modelAccess.updateActiveDestinations(this.val$numberOfRemainingDestinations);
        this.getCommandList().commandFinished();
    }
}

