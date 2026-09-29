/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.tghu.navi.app.addressinput.commands.LIStartSpellerCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputCityZipSimpleSequence;

class AddressInputCityZipSimpleSequence$2
extends NavCommand {
    private final /* synthetic */ AddressInputCityZipSimpleSequence this$0;

    AddressInputCityZipSimpleSequence$2(AddressInputCityZipSimpleSequence addressInputCityZipSimpleSequence) {
        this.this$0 = addressInputCityZipSimpleSequence;
    }

    @Override
    public void execute() {
        if (this.this$0.inputCriteria == 4 && (this.dsiResponseContainer.selectionCriterionAvailable(133) || this.dsiResponseContainer.selectionCriterionAvailable(6))) {
            if (this.dsiResponseContainer.selectionCriterionAvailable(133) && this.dsiResponseContainer.selectionCriterionAvailable(6)) {
                this.getCommandList().commandFinishedWithPostCommand(new LIStartSpellerCommand(133, 6, true, true, true));
            } else if (this.dsiResponseContainer.selectionCriterionAvailable(133)) {
                this.getCommandList().commandFinishedWithPostCommand(new LIStartSpellerCommand(133, true, true, true));
            } else if (this.dsiResponseContainer.selectionCriterionAvailable(6)) {
                this.getCommandList().commandFinishedWithPostCommand(new LIStartSpellerCommand(6, true, true, true));
            }
        } else if ((this.this$0.inputCriteria == -1 || this.this$0.inputCriteria == 3) && this.dsiResponseContainer.selectionCriterionAvailable(133) && this.dsiResponseContainer.selectionCriterionAvailable(6)) {
            this.getCommandList().commandFinishedWithPostCommand(new LIStartSpellerCommand(2, 6, true, true, true));
        } else if ((this.this$0.inputCriteria == -1 || this.this$0.inputCriteria == 1) && this.dsiResponseContainer.selectionCriterionAvailable(2)) {
            this.getCommandList().commandFinishedWithPostCommand(new LIStartSpellerCommand(2, true, true, true));
        } else if ((this.this$0.inputCriteria == -1 || this.this$0.inputCriteria == 2) && this.dsiResponseContainer.selectionCriterionAvailable(6)) {
            this.getCommandList().commandFinishedWithPostCommand(new LIStartSpellerCommand(6, true, true, true));
        } else {
            this.getCommandList().commandAborted("Neither SELCRITDES_TOWN nor SELCRITDES_ZIP_CODE are available as selection criteria");
        }
    }
}

