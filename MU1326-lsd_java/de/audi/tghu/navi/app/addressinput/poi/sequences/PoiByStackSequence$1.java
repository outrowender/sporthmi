/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiByStackSequence;
import de.audi.tghu.navi.app.command.NavCommand;

class PoiByStackSequence$1
extends NavCommand {
    private final /* synthetic */ PoiByStackSequence this$0;

    PoiByStackSequence$1(PoiByStackSequence poiByStackSequence) {
        this.this$0 = poiByStackSequence;
    }

    @Override
    public void execute() {
        this.this$0.initialSpellerState = this.dsiResponseContainer.getSpellerState();
        this.getCommandList().commandFinished();
    }
}

