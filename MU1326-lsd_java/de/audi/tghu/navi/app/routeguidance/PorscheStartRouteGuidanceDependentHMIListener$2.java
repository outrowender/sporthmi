/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.routeguidance.PorscheStartRouteGuidanceDependentHMIListener;
import de.audi.tghu.navi.app.util.RouteUtil;
import org.dsi.ifc.navigation.Route;

class PorscheStartRouteGuidanceDependentHMIListener$2
extends NavCommand {
    private final /* synthetic */ boolean val$isPoiFuelWarning;
    private final /* synthetic */ boolean val$replace;
    private final /* synthetic */ CommandList val$clAdd;
    private final /* synthetic */ PorscheStartRouteGuidanceDependentHMIListener this$0;

    PorscheStartRouteGuidanceDependentHMIListener$2(PorscheStartRouteGuidanceDependentHMIListener porscheStartRouteGuidanceDependentHMIListener, String string, boolean bl, boolean bl2, CommandList commandList) {
        this.this$0 = porscheStartRouteGuidanceDependentHMIListener;
        this.val$isPoiFuelWarning = bl;
        this.val$replace = bl2;
        this.val$clAdd = commandList;
        super(string);
    }

    @Override
    public void execute() {
        int n;
        Route route = PorscheStartRouteGuidanceDependentHMIListener.access$400(this.this$0).getRoute();
        int n2 = n = this.val$isPoiFuelWarning ? 1 : 0;
        if (this.val$replace || RouteUtil.getRouteLength(route) < 9 + n) {
            this.getCommandList().commandFinishedWithPostSequence(this.val$clAdd);
        } else {
            if (PorscheStartRouteGuidanceDependentHMIListener.access$500(this.this$0) != 0) {
                this.env.getLogChannel().log(-2137614336, "PorscheStartRouteGuidanceDependentHMIListener.addAsStopOver - maximum number of stopovers reached - showPopup = %1", (long)PorscheStartRouteGuidanceDependentHMIListener.access$500(this.this$0));
                this.env.getHMIService().showPartialPopup(0, PorscheStartRouteGuidanceDependentHMIListener.access$500(this.this$0));
            }
            this.getCommandList().commandFinished();
        }
    }
}

