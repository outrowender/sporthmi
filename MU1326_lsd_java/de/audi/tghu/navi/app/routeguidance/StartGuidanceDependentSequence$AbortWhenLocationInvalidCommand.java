/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.routeguidance.StartGuidanceDependentSequence;
import de.audi.tghu.navi.app.routeguidance.StartGuidanceDependentSequence$1;
import org.dsi.ifc.global.NavLocation;

class StartGuidanceDependentSequence$AbortWhenLocationInvalidCommand
extends NavCommand {
    private final NavLocation location;
    private boolean nullOnly;
    private final /* synthetic */ StartGuidanceDependentSequence this$0;

    private StartGuidanceDependentSequence$AbortWhenLocationInvalidCommand(StartGuidanceDependentSequence startGuidanceDependentSequence, NavLocation navLocation, boolean bl) {
        this.this$0 = startGuidanceDependentSequence;
        super("StartGuidanceDependentSequence check if location is ok");
        this.location = navLocation;
        this.nullOnly = bl;
    }

    @Override
    public void execute() {
        if (this.location == null) {
            this.getCommandList().commandAborted("StartGuidanceDependentSequence#AbortWhenInvalidCommand - The given NavLocation is null");
        } else if (!this.nullOnly && !this.location.isPositionValid()) {
            this.getCommandList().commandAborted("StartGuidanceDependentSequence#AbortWhenInvalidCommand - The given NavLocation is not valid");
        } else {
            this.getCommandList().commandFinished();
        }
    }

    /* synthetic */ StartGuidanceDependentSequence$AbortWhenLocationInvalidCommand(StartGuidanceDependentSequence startGuidanceDependentSequence, NavLocation navLocation, boolean bl, StartGuidanceDependentSequence$1 startGuidanceDependentSequence$1) {
        this(startGuidanceDependentSequence, navLocation, bl);
    }
}

