/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiStartSearchSpellerInputSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import org.dsi.ifc.global.NavLocation;

class PoiStartSearchSpellerInputSequence$1
extends NavCommand {
    private final /* synthetic */ IRouteManager val$routeManager;
    private final /* synthetic */ PoiStartSearchSpellerInputSequence this$0;

    PoiStartSearchSpellerInputSequence$1(PoiStartSearchSpellerInputSequence poiStartSearchSpellerInputSequence, IRouteManager iRouteManager) {
        this.this$0 = poiStartSearchSpellerInputSequence;
        this.val$routeManager = iRouteManager;
    }

    @Override
    public void execute() {
        NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
        if (navLocation.isPositionValid()) {
            this.logger.log(-2137614336, "[PoiInput] PoiStartSearchSpellerInputSequence#startGuidance() - starting route guidance.");
            this.getCommandList().commandFinishedWithPostSequence(this.val$routeManager.getStartRouteGuidanceToSingleDestinationSequence(navLocation));
        } else {
            this.getCommandList().commandAborted("Position for element is not valid");
        }
    }
}

