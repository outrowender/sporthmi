/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.country;

import de.audi.tghu.navi.app.addressinput.country.CountryInputSequence;
import de.audi.tghu.navi.app.command.LISetCountryForCityAndStreetHistoryCommand;
import de.audi.tghu.navi.app.command.NavCommand;

class CountryInputSequence$2
extends NavCommand {
    private final /* synthetic */ CountryInputSequence this$0;

    CountryInputSequence$2(CountryInputSequence countryInputSequence) {
        this.this$0 = countryInputSequence;
    }

    @Override
    public void execute() {
        this.getCommandList().commandFinishedWithPostCommand(new LISetCountryForCityAndStreetHistoryCommand(this.dsiResponseContainer.getLiCurrentLD().getCountryAbbreviation()));
    }
}

