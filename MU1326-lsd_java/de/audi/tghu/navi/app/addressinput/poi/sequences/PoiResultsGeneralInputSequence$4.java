/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultsGeneralInputSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.routeguidance.ILocationHandler;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;
import org.dsi.ifc.global.NavLocation;

class PoiResultsGeneralInputSequence$4
extends NavCommand {
    private final /* synthetic */ IStartGuidanceToDestinationSequence val$startGuidanceSequence;
    private final /* synthetic */ ILocationHandler val$locationHandler;
    private final /* synthetic */ PoiResultsGeneralInputSequence this$0;

    PoiResultsGeneralInputSequence$4(PoiResultsGeneralInputSequence poiResultsGeneralInputSequence, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence, ILocationHandler iLocationHandler) {
        this.this$0 = poiResultsGeneralInputSequence;
        this.val$startGuidanceSequence = iStartGuidanceToDestinationSequence;
        this.val$locationHandler = iLocationHandler;
    }

    @Override
    public void execute() {
        NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
        if (navLocation.isPositionValid()) {
            this.getCommandList().commandFinishedWithPostSequence(this.val$startGuidanceSequence.getStartSequence(this.val$locationHandler, navLocation));
        } else {
            this.getCommandList().commandAborted("Position for element is not valid");
        }
    }
}

