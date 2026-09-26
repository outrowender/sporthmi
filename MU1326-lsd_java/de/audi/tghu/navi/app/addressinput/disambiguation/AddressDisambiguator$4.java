/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.disambiguation;

import de.audi.tghu.navi.app.addressinput.disambiguation.AddressDisambiguator;
import de.audi.tghu.navi.app.command.NavCommand;

class AddressDisambiguator$4
extends NavCommand {
    private final /* synthetic */ AddressDisambiguator this$0;

    AddressDisambiguator$4(AddressDisambiguator addressDisambiguator, String string) {
        this.this$0 = addressDisambiguator;
        super(string);
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "Choose if [HNRSeq2ambig] or [HNRSeq3invalid] by inspecting values=>>%1<<", (Object)this.env.getContainer().getLispValueList());
        if (0 == this.env.getContainer().getLispValueList().list.length) {
            this.this$0.setListModels(4);
            this.getCommandList().commandFinishedWithPostSequence(AddressDisambiguator.access$000(this.this$0, false, true));
        } else {
            this.this$0.setListModels(5);
            this.getCommandList().commandFinishedWithPostSequence(AddressDisambiguator.access$000(this.this$0, true, false));
        }
    }
}

