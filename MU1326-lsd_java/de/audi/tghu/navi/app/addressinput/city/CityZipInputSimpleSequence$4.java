/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.city;

import de.audi.tghu.navi.app.addressinput.city.CityZipInputSimpleSequence;
import de.audi.tghu.navi.app.addressinput.commands.AddCityToHistoryCommand;
import de.audi.tghu.navi.app.command.NavCommand;

class CityZipInputSimpleSequence$4
extends NavCommand {
    private final /* synthetic */ CityZipInputSimpleSequence this$0;

    CityZipInputSimpleSequence$4(CityZipInputSimpleSequence cityZipInputSimpleSequence) {
        this.this$0 = cityZipInputSimpleSequence;
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

