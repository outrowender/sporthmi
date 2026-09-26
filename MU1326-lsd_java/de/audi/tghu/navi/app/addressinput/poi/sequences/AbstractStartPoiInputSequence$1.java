/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.navi.app.addressinput.poi.sequences.AbstractStartPoiInputSequence;
import de.audi.tghu.navi.app.command.NavCommand;

class AbstractStartPoiInputSequence$1
extends NavCommand {
    private final /* synthetic */ AbstractStartPoiInputSequence this$0;

    AbstractStartPoiInputSequence$1(AbstractStartPoiInputSequence abstractStartPoiInputSequence) {
        this.this$0 = abstractStartPoiInputSequence;
    }

    @Override
    public void execute() {
        this.this$0.initialSpellerState = this.dsiResponseContainer.getSpellerState();
        this.getCommandList().commandFinished();
    }
}

