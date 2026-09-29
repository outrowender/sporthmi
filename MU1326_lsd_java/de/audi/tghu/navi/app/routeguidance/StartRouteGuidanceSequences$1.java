/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.routeguidance.StartRouteGuidanceSequences;
import de.audi.tghu.navi.app.sds.ISDSController;
import de.audi.tghu.navi.app.util.RouteUtil;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.Route;

class StartRouteGuidanceSequences$1
extends NavCommand {
    private final /* synthetic */ NavLocation val$destination;
    private final /* synthetic */ ISDSController val$sdsController;
    private final /* synthetic */ int val$destinationIndex;
    private final /* synthetic */ boolean val$replace;
    private final /* synthetic */ StartRouteGuidanceSequences this$0;

    StartRouteGuidanceSequences$1(StartRouteGuidanceSequences startRouteGuidanceSequences, NavLocation navLocation, ISDSController iSDSController, int n, boolean bl) {
        this.this$0 = startRouteGuidanceSequences;
        this.val$destination = navLocation;
        this.val$sdsController = iSDSController;
        this.val$destinationIndex = n;
        this.val$replace = bl;
    }

    @Override
    public void execute() {
        Route route = this.navigation.getRouteManager().getRoute();
        this.logger.log(-2137614336, "StartRouteGuidanceSequences#getStartGuidance() - current route - %2, destination to add - %1 ", (Object)this.val$destination, (Object)RouteUtil.formatRouteShort(route));
        int n = RouteUtil.getRouteLength(route);
        boolean bl = this.dsiResponseContainer.isRgActive();
        if (n <= 0 || !bl) {
            this.logger.log(-2137614336, "StartRouteGuidanceSequences#getStartGuidance() - current route - %2, rgActive - %1  - start to single destination.", bl, (Object)RouteUtil.formatRouteShort(route));
            this.getCommandList().commandFinishedWithPostSequence(this.this$0.createStartGuidanceToSingleDestinationCommandList(this.val$destination, this.val$sdsController));
            return;
        }
        if (this.val$destinationIndex == -2) {
            this.getCommandList().commandFinishedWithPostSequence(this.this$0.createStartGuidanceToSingleDestinationCommandList(this.val$destination, this.val$sdsController));
        } else if (this.val$destinationIndex == -1) {
            int n2 = n - 1;
            if (this.val$replace) {
                this.getCommandList().commandFinishedWithPostSequence(this.this$0.createReplaceDestinationOfActiveRouteCommandList(this.val$destination, n2, this.val$sdsController));
            } else {
                this.getCommandList().commandFinishedWithPostSequence(this.this$0.createAddStopOverToActiveRouteCommandList(this.val$destination, n, this.val$sdsController));
            }
        } else if (this.val$replace) {
            int n3 = this.val$destinationIndex;
            if (this.val$destinationIndex >= n) {
                n3 = n - 1;
            }
            this.logger.log(-2137614336, "StartRouteGuidanceSequences#getStartGuidance() - replace destination %1 at index %2", (Object)this.val$destination, (long)n3);
            this.getCommandList().commandFinishedWithPostSequence(this.this$0.createReplaceDestinationOfActiveRouteCommandList(this.val$destination, n3, this.val$sdsController));
        } else {
            int n4 = this.val$destinationIndex;
            if (this.val$destinationIndex > n) {
                n4 = n;
            }
            this.logger.log(-2137614336, "StartRouteGuidanceSequences#getStartGuidance() - add at destination %1 at index %2", (Object)this.val$destination, (long)n4);
            this.getCommandList().commandFinishedWithPostSequence(this.this$0.createAddStopOverToActiveRouteCommandList(this.val$destination, n4, this.val$sdsController));
        }
    }
}

