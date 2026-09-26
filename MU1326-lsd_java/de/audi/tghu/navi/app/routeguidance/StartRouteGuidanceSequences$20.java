/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.routeguidance.StartRouteGuidanceSequences;
import org.dsi.ifc.navigation.CalculatedRouteListElement;
import org.dsi.ifc.navigation.RouteOptions;

class StartRouteGuidanceSequences$20
extends NavCommand {
    private final /* synthetic */ int val$routeIndex;
    private final /* synthetic */ StartRouteGuidanceSequences this$0;

    StartRouteGuidanceSequences$20(StartRouteGuidanceSequences startRouteGuidanceSequences, String string, int n) {
        this.this$0 = startRouteGuidanceSequences;
        this.val$routeIndex = n;
        super(string);
    }

    @Override
    public void execute() {
        RouteOptions[] routeOptionsArray = this.this$0.routeCriteriaManager.getRouteCriteria().getRouteOptions(true);
        CalculatedRouteListElement[] calculatedRouteListElementArray = this.dsiResponseContainer.getCalculatedRoutes();
        if (calculatedRouteListElementArray.length > 0) {
            this.this$0.checkCalculatedRouteMatchesRouteCriteria(routeOptionsArray[this.val$routeIndex], calculatedRouteListElementArray[0]);
        } else {
            this.logger.log(-1601830656, "[RouteGuidance] StartRouteGuidanceSequences#CheckCalculatedRouteMatchesRouteCriteria#execute() no calculated routes avalibale");
        }
        this.getCommandList().commandFinished();
    }
}

