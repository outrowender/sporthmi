/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultsGeneralInputSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.routeguidance.IRouteManager;
import org.dsi.ifc.global.NavLocation;

class PoiResultsGeneralInputSequence$2
extends NavCommand {
    private final /* synthetic */ IRouteManager val$routeManager;
    private final /* synthetic */ PoiResultsGeneralInputSequence this$0;

    PoiResultsGeneralInputSequence$2(PoiResultsGeneralInputSequence poiResultsGeneralInputSequence, IRouteManager iRouteManager) {
        this.this$0 = poiResultsGeneralInputSequence;
        this.val$routeManager = iRouteManager;
    }

    @Override
    public void execute() {
        NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
        if (navLocation.isPositionValid()) {
            this.getCommandList().commandFinishedWithPostSequence(this.val$routeManager.getStartRouteGuidanceToSingleDestinationSequence(navLocation));
        } else {
            this.getCommandList().commandAborted("Position for element is not valid");
        }
    }
}

