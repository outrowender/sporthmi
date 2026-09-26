/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.routeguidance.StartRouteGuidanceSequences;

class StartRouteGuidanceSequences$21
extends NavCommand {
    private final /* synthetic */ int val$routeIndex;
    private final /* synthetic */ StartRouteGuidanceSequences this$0;

    StartRouteGuidanceSequences$21(StartRouteGuidanceSequences startRouteGuidanceSequences, String string, int n) {
        this.this$0 = startRouteGuidanceSequences;
        this.val$routeIndex = n;
        super(string);
    }

    @Override
    public void execute() {
        this.this$0.alternativeRoutesHandler.setLastSelectedRouteIndex(this.val$routeIndex);
        this.getCommandList().commandFinished();
    }
}

