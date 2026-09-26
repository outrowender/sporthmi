/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import de.audi.atip.hmi.model.DefaultButtonListener;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.routeguidance.PorscheStartRouteGuidanceDependentHMIListener;
import de.audi.tghu.navi.app.routeguidance.PorscheStartRouteGuidanceDependentHMIListener$1;
import de.audi.tghu.navi.app.routeguidance.PorscheStartRouteGuidanceDependentHMIListener$StartRouteGuidanceDependentButtonListener$1;

class PorscheStartRouteGuidanceDependentHMIListener$StartRouteGuidanceDependentButtonListener
extends DefaultButtonListener {
    private final /* synthetic */ PorscheStartRouteGuidanceDependentHMIListener this$0;

    private PorscheStartRouteGuidanceDependentHMIListener$StartRouteGuidanceDependentButtonListener(PorscheStartRouteGuidanceDependentHMIListener porscheStartRouteGuidanceDependentHMIListener) {
        this.this$0 = porscheStartRouteGuidanceDependentHMIListener;
    }

    @Override
    public void keyTyped(int n, int n2, int n3) {
        if (n == PorscheStartRouteGuidanceDependentHMIListener.access$100(this.this$0).getID()) {
            CommandList commandList = PorscheStartRouteGuidanceDependentHMIListener.access$200(this.this$0).createCommandList();
            commandList.add(new PorscheStartRouteGuidanceDependentHMIListener$StartRouteGuidanceDependentButtonListener$1(this, n, n3));
            this.this$0.addAsStopOver(this.this$0.env.getContainer().getLiCurrentLD(), -1, true, false, commandList);
        }
    }

    /* synthetic */ PorscheStartRouteGuidanceDependentHMIListener$StartRouteGuidanceDependentButtonListener(PorscheStartRouteGuidanceDependentHMIListener porscheStartRouteGuidanceDependentHMIListener, PorscheStartRouteGuidanceDependentHMIListener$1 porscheStartRouteGuidanceDependentHMIListener$1) {
        this(porscheStartRouteGuidanceDependentHMIListener);
    }
}

