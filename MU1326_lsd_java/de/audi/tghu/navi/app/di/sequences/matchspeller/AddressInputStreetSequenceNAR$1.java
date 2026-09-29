/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.matchspeller;

import de.audi.tghu.navi.app.addressinput.commands.LIStartSpellerCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.matchspeller.AddressInputStreetSequenceNAR;

class AddressInputStreetSequenceNAR$1
extends NavCommand {
    private final /* synthetic */ AddressInputStreetSequenceNAR this$0;

    AddressInputStreetSequenceNAR$1(AddressInputStreetSequenceNAR addressInputStreetSequenceNAR) {
        this.this$0 = addressInputStreetSequenceNAR;
    }

    @Override
    public void execute() {
        if (this.this$0.spellerStack.getActiveSC().getContextID() == 65) {
            this.getCommandList().commandFinishedWithPostCommand(new LIStartSpellerCommand(0xE800000, true, true, true));
        } else if (this.this$0.spellerStack.getActiveSC().getContextID() == 64) {
            this.getCommandList().commandFinishedWithPostCommand(new LIStartSpellerCommand(3, false, false, true));
        }
    }
}

