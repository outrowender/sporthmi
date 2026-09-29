/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiDetailsSequence;
import de.audi.tghu.navi.app.command.NavCommand;
import org.dsi.ifc.global.NavLocation;

class PoiDetailsSequence$1
extends NavCommand {
    private final /* synthetic */ PoiDetailsSequence this$0;

    PoiDetailsSequence$1(PoiDetailsSequence poiDetailsSequence) {
        this.this$0 = poiDetailsSequence;
    }

    @Override
    public void execute() {
        NavLocation navLocation = this.dsiResponseContainer.getLiCurrentLD();
        if (navLocation.isPositionValid()) {
            this.getCommandList().commandFinished();
        } else {
            this.getCommandList().commandAborted("Position for element is not valid");
        }
    }
}

