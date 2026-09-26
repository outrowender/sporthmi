/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.tghu.navi.app.addressinput.commands.LIStartSpellerCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputCityZipSequenceNAR;

class AddressInputCityZipSequenceNAR$2
extends NavCommand {
    private final /* synthetic */ AddressInputCityZipSequenceNAR this$0;

    AddressInputCityZipSequenceNAR$2(AddressInputCityZipSequenceNAR addressInputCityZipSequenceNAR) {
        this.this$0 = addressInputCityZipSequenceNAR;
    }

    @Override
    public void execute() {
        if (this.dsiResponseContainer.selectionCriterionAvailable(2)) {
            boolean bl;
            boolean bl2 = bl = !this.this$0.spellerStack.containsContextID(65);
            if (this.dsiResponseContainer.selectionCriterionAvailable(6)) {
                this.this$0.logChannel.log(-2137614336, "%1#execute() - ZIP CODE and TOWN are available start multicriteria", (Object)this.CLASS_NAME);
                this.getCommandList().commandFinishedWithPostCommand(new LIStartSpellerCommand(2, 6, true, true, bl));
            } else {
                this.this$0.logChannel.log(-2137614336, "%1#execute() - only TOWN ist available. start with SELCRITDES_TOWN only", (Object)this.CLASS_NAME);
                this.getCommandList().commandFinishedWithPostCommand(new LIStartSpellerCommand(2, false, false, bl));
            }
        } else {
            this.getCommandList().commandAborted("SELCRITDES_TOWN ist not available as selection criteria");
        }
    }
}

