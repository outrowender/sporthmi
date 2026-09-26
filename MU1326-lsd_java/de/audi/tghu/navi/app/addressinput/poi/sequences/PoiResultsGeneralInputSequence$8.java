/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiResultsGeneralInputSequence;
import de.audi.tghu.navi.app.command.NavCommand;

class PoiResultsGeneralInputSequence$8
extends NavCommand {
    private final /* synthetic */ PoiResultsGeneralInputSequence this$0;

    PoiResultsGeneralInputSequence$8(PoiResultsGeneralInputSequence poiResultsGeneralInputSequence) {
        this.this$0 = poiResultsGeneralInputSequence;
    }

    @Override
    public void execute() {
        this.this$0.modelAccess.onStart(PoiResultsGeneralInputSequence.access$200(this.this$0));
        this.getCommandList().commandFinished();
    }
}

