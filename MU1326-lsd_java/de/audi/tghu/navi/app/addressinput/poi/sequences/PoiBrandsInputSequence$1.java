/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences;

import de.audi.tghu.navi.app.addressinput.poi.sequences.PoiBrandsInputSequence;
import de.audi.tghu.navi.app.command.NavCommand;

class PoiBrandsInputSequence$1
extends NavCommand {
    private final /* synthetic */ PoiBrandsInputSequence this$0;

    PoiBrandsInputSequence$1(PoiBrandsInputSequence poiBrandsInputSequence) {
        this.this$0 = poiBrandsInputSequence;
    }

    @Override
    public void execute() {
        this.this$0.initialSpellerState = this.dsiResponseContainer.getSpellerState();
        this.getCommandList().commandFinished();
    }
}

