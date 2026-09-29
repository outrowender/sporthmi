/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.routeguidance;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.routeguidance.StartGuidanceDependentSequence;
import de.audi.tghu.navi.app.routeguidance.StartGuidanceDependentSequence$1;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.Route;

class StartGuidanceDependentSequence$UpdateModelAccessCommand
extends NavCommand {
    private final NavLocation location;
    private final /* synthetic */ StartGuidanceDependentSequence this$0;

    private StartGuidanceDependentSequence$UpdateModelAccessCommand(StartGuidanceDependentSequence startGuidanceDependentSequence, NavLocation navLocation) {
        this.this$0 = startGuidanceDependentSequence;
        super("StartGuidanceDependentSequence update model Access");
        this.location = navLocation;
    }

    @Override
    public void execute() {
        if (this.location != null) {
            Route route = this.navigation.getRouteManager().getRoute();
            this.this$0.modelAccess.onStart(route, this.location, this.dsiResponseContainer.isRgActive());
        }
        this.getCommandList().commandFinished();
    }

    /* synthetic */ StartGuidanceDependentSequence$UpdateModelAccessCommand(StartGuidanceDependentSequence startGuidanceDependentSequence, NavLocation navLocation, StartGuidanceDependentSequence$1 startGuidanceDependentSequence$1) {
        this(startGuidanceDependentSequence, navLocation);
    }
}

