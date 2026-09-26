/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.rml;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.rml.RMLSequence;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.navigation.CombinedRouteListElement;

class RMLSequence$16
extends NavCommand {
    private final /* synthetic */ CombinedRouteListElement val$combinedRouteListElement;
    private final /* synthetic */ RMLSequence this$0;

    RMLSequence$16(RMLSequence rMLSequence, String string, CombinedRouteListElement combinedRouteListElement) {
        this.this$0 = rMLSequence;
        this.val$combinedRouteListElement = combinedRouteListElement;
        super(string);
    }

    @Override
    public void execute() {
        NavLocation navLocation = this.dsiResponseContainer.getRMLPOILocation();
        this.logger.log(-2137614336, "RMLSequence#focusPOI rmlpoiLocation = %1", (Object)navLocation);
        this.this$0.modelAccess.onPoiFocused(navLocation, this.val$combinedRouteListElement);
        this.getCommandList().commandFinished();
    }
}

