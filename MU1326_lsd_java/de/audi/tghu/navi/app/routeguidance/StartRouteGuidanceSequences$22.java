/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.routeguidance.StartRouteGuidanceSequences;

class StartRouteGuidanceSequences$22
extends NavCommand {
    private final /* synthetic */ StartRouteGuidanceSequences this$0;

    StartRouteGuidanceSequences$22(StartRouteGuidanceSequences startRouteGuidanceSequences) {
        this.this$0 = startRouteGuidanceSequences;
    }

    @Override
    public void execute() {
        if (!this.dsiResponseContainer.isRgActive()) {
            this.getCommandList().commandAborted("no active rotue guidance, nothing to do.");
        } else {
            this.getCommandList().commandFinished();
        }
    }
}

