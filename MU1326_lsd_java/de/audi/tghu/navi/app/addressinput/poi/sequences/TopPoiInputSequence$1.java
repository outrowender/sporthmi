/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.navi.app.addressinput.poi.sequences.TopPoiInputSequence;
import de.audi.tghu.navi.app.command.NavCommand;

class TopPoiInputSequence$1
extends NavCommand {
    private final /* synthetic */ TopPoiInputSequence this$0;

    TopPoiInputSequence$1(TopPoiInputSequence topPoiInputSequence) {
        this.this$0 = topPoiInputSequence;
    }

    @Override
    public void execute() {
        this.this$0.initialSpellerState = this.dsiResponseContainer.getSpellerState();
        this.getCommandList().commandFinished();
    }
}

