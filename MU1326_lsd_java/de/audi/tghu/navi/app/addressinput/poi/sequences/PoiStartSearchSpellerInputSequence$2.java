/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiStartSearchSpellerInputSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.routeguidance.ILocationHandler;
import de.audi.tghu.navi.app.routeguidance.IStartGuidanceToDestinationSequence;
import org.dsi.ifc.global.NavLocation;

class PoiStartSearchSpellerInputSequence$2
extends NavCommand {
    private final /* synthetic */ IStartGuidanceToDestinationSequence val$startGuidanceSequence;
    private final /* synthetic */ ILocationHandler val$handler;
    private final /* synthetic */ PoiStartSearchSpellerInputSequence this$0;

    PoiStartSearchSpellerInputSequence$2(PoiStartSearchSpellerInputSequence poiStartSearchSpellerInputSequence, IStartGuidanceToDestinationSequence iStartGuidanceToDestinationSequence, ILocationHandler iLocationHandler) {
        this.this$0 = poiStartSearchSpellerInputSequence;
        this.val$startGuidanceSequence = iStartGuidanceToDestinationSequence;
        this.val$handler = iLocationHandler;
    }

    @Override
    public void execute() {
        NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
        if (navLocation.isPositionValid()) {
            this.logger.log(-2137614336, "[PoiInput] PoiStartSearchSpellerInputSequence#startGuidance() - starting route guidance.");
            this.getCommandList().commandFinishedWithPostSequence(this.val$startGuidanceSequence.getStartSequence(this.val$handler, navLocation));
        } else {
            this.getCommandList().commandAborted("Position for element is not valid");
        }
    }
}

