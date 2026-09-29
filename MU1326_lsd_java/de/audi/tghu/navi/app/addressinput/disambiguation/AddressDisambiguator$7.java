/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.disambiguation;

import de.audi.tghu.navi.app.addressinput.disambiguation.AddressDisambiguator;
import de.audi.tghu.navi.app.command.NavCommand;

class AddressDisambiguator$7
extends NavCommand {
    private final /* synthetic */ AddressDisambiguator this$0;

    AddressDisambiguator$7(AddressDisambiguator addressDisambiguator, String string) {
        this.this$0 = addressDisambiguator;
        super(string);
    }

    @Override
    public void execute() {
        int n = (Integer)this.getCommandList().get(AddressDisambiguator.receivedSelcrit);
        if (136 == n) {
            this.this$0.setDisambiguationChoice(2);
            this.getCommandList().commandFinishedWithPostSequence(this.this$0.getHNrFreeMatchPopupCL(this.this$0.getHouseNrUserInput()));
        } else if ((Integer)this.getCommandList().get(AddressDisambiguator.receivedSelcrit) == -1) {
            this.this$0.setDisambiguationChoice(0);
            this.getCommandList().commandFinished();
        } else {
            this.getCommandList().commandFinishedWithPostSequence(this.this$0.getIncompleteOrInvalidCL());
        }
    }
}

