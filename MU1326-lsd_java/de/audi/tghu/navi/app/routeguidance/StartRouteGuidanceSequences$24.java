/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.routeguidance.StartRouteGuidanceSequences;

class StartRouteGuidanceSequences$24
extends NavCommand {
    private final /* synthetic */ StartRouteGuidanceSequences this$0;

    StartRouteGuidanceSequences$24(StartRouteGuidanceSequences startRouteGuidanceSequences, String string) {
        this.this$0 = startRouteGuidanceSequences;
        super(string);
    }

    @Override
    public void execute() {
        this.this$0.alternativeRoutesHandler.setLastSelectedRouteIndex(0);
        this.getCommandList().commandFinished();
    }
}

