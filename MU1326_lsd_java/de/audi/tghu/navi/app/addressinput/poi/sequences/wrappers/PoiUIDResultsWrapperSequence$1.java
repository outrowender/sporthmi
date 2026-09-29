/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers;

import de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers.PoiUIDResultsWrapperSequence;
import de.audi.tghu.navi.app.command.NavCommand;

class PoiUIDResultsWrapperSequence$1
extends NavCommand {
    private final /* synthetic */ PoiUIDResultsWrapperSequence this$0;

    PoiUIDResultsWrapperSequence$1(PoiUIDResultsWrapperSequence poiUIDResultsWrapperSequence) {
        this.this$0 = poiUIDResultsWrapperSequence;
    }

    @Override
    public void execute() {
        this.this$0.initialSpellerState = this.dsiResponseContainer.getSpellerState();
        this.getCommandList().commandFinished();
    }
}

