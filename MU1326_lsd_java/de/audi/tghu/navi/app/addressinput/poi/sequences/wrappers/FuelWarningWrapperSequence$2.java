/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers;

import de.audi.tghu.navi.app.addressinput.poi.sequences.wrappers.FuelWarningWrapperSequence;
import de.audi.tghu.navi.app.command.NavCommand;

class FuelWarningWrapperSequence$2
extends NavCommand {
    private final /* synthetic */ FuelWarningWrapperSequence this$0;

    FuelWarningWrapperSequence$2(FuelWarningWrapperSequence fuelWarningWrapperSequence) {
        this.this$0 = fuelWarningWrapperSequence;
    }

    @Override
    public void execute() {
        FuelWarningWrapperSequence.access$102(this.this$0, this.dsiResponseContainer.getSpellerState());
        this.getCommandList().commandFinished();
    }
}

