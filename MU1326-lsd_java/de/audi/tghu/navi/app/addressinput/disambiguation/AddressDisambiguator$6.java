/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.disambiguation;

import de.audi.tghu.navi.app.addressinput.commands.LIStartSpellerCommand;
import de.audi.tghu.navi.app.addressinput.disambiguation.AddressDisambiguator;
import de.audi.tghu.navi.app.command.NavCommand;

class AddressDisambiguator$6
extends NavCommand {
    private final /* synthetic */ AddressDisambiguator this$0;

    AddressDisambiguator$6(AddressDisambiguator addressDisambiguator, String string) {
        this.this$0 = addressDisambiguator;
        super(string);
    }

    @Override
    public void execute() {
        if ((Integer)this.getCommandList().get(AddressDisambiguator.receivedSelcrit) == -1) {
            this.getCommandList().commandFinishedWithPostSequence(this.navigation.getStartGuidanceDependantSequence().getStartSequence(this.dsiResponseContainer.getLiCurrentLD()));
        } else {
            int n = (Integer)this.getCommandList().get(AddressDisambiguator.receivedSelcrit);
            this.getCommandList().commandFinishedWithPostCommand(new LIStartSpellerCommand(n, false, false, false));
        }
    }
}

