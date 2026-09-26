/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.country;

import de.audi.tghu.navi.app.addressinput.commands.LIStartSpellerCommand;
import de.audi.tghu.navi.app.addressinput.country.CountryInputSequence;
import de.audi.tghu.navi.app.command.NavCommand;

class CountryInputSequence$1
extends NavCommand {
    private final /* synthetic */ CountryInputSequence this$0;

    CountryInputSequence$1(CountryInputSequence countryInputSequence) {
        this.this$0 = countryInputSequence;
    }

    @Override
    public void execute() {
        if (this.dsiResponseContainer.selectionCriterionAvailable(1)) {
            this.getCommandList().commandFinishedWithPostCommand(new LIStartSpellerCommand(1, true, true, true));
        } else {
            this.getCommandList().commandAborted("SELCRITDES_COUNTRY is not available as selection criteria");
        }
    }
}

