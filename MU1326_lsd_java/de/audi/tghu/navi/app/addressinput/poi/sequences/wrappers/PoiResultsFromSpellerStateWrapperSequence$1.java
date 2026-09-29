/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers;

import de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers.PoiResultsFromSpellerStateWrapperSequence;
import de.audi.tghu.navi.app.command.NavCommand;

class PoiResultsFromSpellerStateWrapperSequence$1
extends NavCommand {
    private final /* synthetic */ PoiResultsFromSpellerStateWrapperSequence this$0;

    PoiResultsFromSpellerStateWrapperSequence$1(PoiResultsFromSpellerStateWrapperSequence poiResultsFromSpellerStateWrapperSequence) {
        this.this$0 = poiResultsFromSpellerStateWrapperSequence;
    }

    @Override
    public void execute() {
        this.this$0.initialSpellerState = this.dsiResponseContainer.getSpellerState();
        this.getCommandList().commandFinished();
    }
}

