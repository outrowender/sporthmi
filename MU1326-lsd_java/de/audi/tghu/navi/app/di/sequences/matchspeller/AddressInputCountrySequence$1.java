/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.tghu.navi.app.addressinput.commands.LIStartSpellerCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputCountrySequence;
import de.audi.tghu.navi.app.util.Util;

class AddressInputCountrySequence$1
extends NavCommand {
    private final /* synthetic */ AddressInputCountrySequence this$0;

    AddressInputCountrySequence$1(AddressInputCountrySequence addressInputCountrySequence, String string) {
        this.this$0 = addressInputCountrySequence;
        super(string);
    }

    @Override
    public void execute() {
        if (Util.isHURegionNAR()) {
            this.getCommandList().commandFinishedWithPostCommand(new LIStartSpellerCommand(139, true, true, true));
        } else if (this.dsiResponseContainer.selectionCriterionAvailable(1)) {
            this.getCommandList().commandFinishedWithPostCommand(new LIStartSpellerCommand(1, true, true, true));
        } else {
            this.getCommandList().commandAborted("SELCRITDES_COUNTRY_STATE is not available as selection criteria");
        }
    }
}

