/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.tghu.navi.app.command.LISetCountryForCityAndStreetHistoryCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputCountrySequence;

class AddressInputCountrySequence$2
extends NavCommand {
    private final /* synthetic */ AddressInputCountrySequence this$0;

    AddressInputCountrySequence$2(AddressInputCountrySequence addressInputCountrySequence) {
        this.this$0 = addressInputCountrySequence;
    }

    @Override
    public void execute() {
        this.getCommandList().commandFinishedWithPostCommand(new LISetCountryForCityAndStreetHistoryCommand(this.dsiResponseContainer.getLiCurrentLD().getCountryAbbreviation()));
    }
}

