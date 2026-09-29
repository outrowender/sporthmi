/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultsGeneralInputSequence;
import de.audi.tghu.navi.app.command.NavCommand;

class PoiResultsGeneralInputSequence$5
extends NavCommand {
    private final /* synthetic */ PoiResultsGeneralInputSequence this$0;

    PoiResultsGeneralInputSequence$5(PoiResultsGeneralInputSequence poiResultsGeneralInputSequence) {
        this.this$0 = poiResultsGeneralInputSequence;
    }

    @Override
    public void execute() {
        PoiResultsGeneralInputSequence.access$002(this.this$0, this.dsiResponseContainer.getSpellerState());
        PoiResultsGeneralInputSequence.access$102(this.this$0, true);
        this.getCommandList().commandFinished();
    }
}

