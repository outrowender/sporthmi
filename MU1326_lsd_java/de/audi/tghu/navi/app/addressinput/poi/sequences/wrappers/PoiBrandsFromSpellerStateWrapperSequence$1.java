/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers;

import de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers.PoiBrandsFromSpellerStateWrapperSequence;
import de.audi.tghu.navi.app.command.NavCommand;

class PoiBrandsFromSpellerStateWrapperSequence$1
extends NavCommand {
    private final /* synthetic */ PoiBrandsFromSpellerStateWrapperSequence this$0;

    PoiBrandsFromSpellerStateWrapperSequence$1(PoiBrandsFromSpellerStateWrapperSequence poiBrandsFromSpellerStateWrapperSequence) {
        this.this$0 = poiBrandsFromSpellerStateWrapperSequence;
    }

    @Override
    public void execute() {
        PoiBrandsFromSpellerStateWrapperSequence.access$002(this.this$0, this.dsiResponseContainer.getSpellerState());
        this.getCommandList().commandFinished();
    }
}

