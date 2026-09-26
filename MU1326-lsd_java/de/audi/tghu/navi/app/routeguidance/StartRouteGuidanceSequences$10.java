/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.routeguidance.StartRouteGuidanceSequences;

class StartRouteGuidanceSequences$10
extends NavCommand {
    private final /* synthetic */ StartRouteGuidanceSequences this$0;

    StartRouteGuidanceSequences$10(StartRouteGuidanceSequences startRouteGuidanceSequences, String string) {
        this.this$0 = startRouteGuidanceSequences;
        super(string);
    }

    @Override
    public void execute() {
        this.env.getChoiceModel(170).setValue(0);
        this.getCommandList().commandFinished();
    }
}

