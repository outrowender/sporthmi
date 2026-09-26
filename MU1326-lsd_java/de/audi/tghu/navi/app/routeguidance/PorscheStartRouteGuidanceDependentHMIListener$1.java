/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.routeguidance.PorscheStartRouteGuidanceDependentHMIListener;
import de.audi.tghu.navi.app.routeguidance.StartRouteGuidanceSequences;

class PorscheStartRouteGuidanceDependentHMIListener$1
extends NavCommand {
    private final /* synthetic */ PorscheStartRouteGuidanceDependentHMIListener this$0;

    PorscheStartRouteGuidanceDependentHMIListener$1(PorscheStartRouteGuidanceDependentHMIListener porscheStartRouteGuidanceDependentHMIListener, String string) {
        this.this$0 = porscheStartRouteGuidanceDependentHMIListener;
        super(string);
    }

    @Override
    public void execute() {
        Integer n = (Integer)this.getCommandList().get(StartRouteGuidanceSequences.TRANSFORMED_INSERT_POS);
        PorscheStartRouteGuidanceDependentHMIListener.access$300(this.this$0).setLastAddedIndex(n);
        this.getCommandList().commandFinished();
    }
}

