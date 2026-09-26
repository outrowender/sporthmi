/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.routeguidance.PorscheStartRouteGuidanceDependentHMIListener$StartRouteGuidanceDependentButtonListener;

class PorscheStartRouteGuidanceDependentHMIListener$StartRouteGuidanceDependentButtonListener$1
extends NavCommand {
    private final /* synthetic */ int val$modelID;
    private final /* synthetic */ int val$terminalID;
    private final /* synthetic */ PorscheStartRouteGuidanceDependentHMIListener$StartRouteGuidanceDependentButtonListener this$1;

    PorscheStartRouteGuidanceDependentHMIListener$StartRouteGuidanceDependentButtonListener$1(PorscheStartRouteGuidanceDependentHMIListener$StartRouteGuidanceDependentButtonListener porscheStartRouteGuidanceDependentHMIListener$StartRouteGuidanceDependentButtonListener, int n, int n2) {
        this.this$1 = porscheStartRouteGuidanceDependentHMIListener$StartRouteGuidanceDependentButtonListener;
        this.val$modelID = n;
        this.val$terminalID = n2;
    }

    @Override
    public void execute() {
        this.env.fireModelEvent(this.val$modelID, this.val$terminalID);
        this.getCommandList().commandFinished();
    }
}

