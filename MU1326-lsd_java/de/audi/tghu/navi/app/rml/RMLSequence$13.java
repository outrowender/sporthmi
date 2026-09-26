/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.rml;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.rml.RMLSequence;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.CombinedRouteListElement;

class RMLSequence$13
extends NavCommand {
    private final /* synthetic */ CombinedRouteListElement val$combinedRouteListElement;
    private final /* synthetic */ RMLSequence this$0;

    RMLSequence$13(RMLSequence rMLSequence, String string, CombinedRouteListElement combinedRouteListElement) {
        this.this$0 = rMLSequence;
        this.val$combinedRouteListElement = combinedRouteListElement;
        super(string);
    }

    @Override
    public void execute() {
        NavLocation navLocation = RMLSequence.access$200(this.this$0).getRoute().getRoutelist()[this.val$combinedRouteListElement.getDestinationIndex()].getRouteLocation();
        RMLSequence.access$500(this.this$0).onUpdateLocation(navLocation);
        this.getCommandList().commandFinished();
    }
}

