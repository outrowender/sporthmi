/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.tghu.navi.app.addressinput.commands.AddCityToHistoryCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputCityZipSimpleSequence;

class AddressInputCityZipSimpleSequence$3
extends NavCommand {
    private final /* synthetic */ AddressInputCityZipSimpleSequence this$0;

    AddressInputCityZipSimpleSequence$3(AddressInputCityZipSimpleSequence addressInputCityZipSimpleSequence) {
        this.this$0 = addressInputCityZipSimpleSequence;
    }

    @Override
    public void execute() {
        if (this.dsiResponseContainer.getLispCurrentSelectionCriterion() == 2) {
            this.getCommandList().commandFinishedWithPostCommand(new AddCityToHistoryCommand(this.this$0.cityHistory));
        } else {
            this.getCommandList().commandFinished();
        }
    }
}

