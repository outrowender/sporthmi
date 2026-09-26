/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.city;

import de.audi.tghu.navi.app.addressinput.city.CityZipInputSimpleSequence;
import de.audi.tghu.navi.app.addressinput.commands.LIStartSpellerCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.Util;

class CityZipInputSimpleSequence$2
extends NavCommand {
    private final /* synthetic */ CityZipInputSimpleSequence this$0;

    CityZipInputSimpleSequence$2(CityZipInputSimpleSequence cityZipInputSimpleSequence, String string) {
        this.this$0 = cityZipInputSimpleSequence;
        super(string);
    }

    @Override
    public void execute() {
        if (Util.isHURegionKR() && this.env.getInputModeManager().isSdsActive()) {
            this.logger.log(-2137614336, "%1#createStartCommandList - Region is Korea and SDS is active -> Skip validity checks for selection criteria and start town speller.", (Object)this.CLASS_NAME);
            this.getCommandList().commandFinishedWithPostCommand(new LIStartSpellerCommand(2, true, true, true));
            return;
        }
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
            this.logger.log(1078071040, "CityZipInputSimpleSequence#availableSelectionCriteria = %1 currentLD = %2", (Object)this.dsiResponseContainer.getLiAvailableSelectionCriteria(), (Object)this.dsiResponseContainer.getLiCurrentLD());
            this.getCommandList().commandAborted("Neither SELCRITDES_TOWN nor SELCRITDES_ZIP_CODE are available as selection criteria");
        }
    }
}

