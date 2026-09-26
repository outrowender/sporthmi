/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.disambiguation;

import de.audi.tghu.navi.app.addressinput.disambiguation.AddressDisambiguator;
import de.audi.tghu.navi.app.command.NavCommand;

class AddressDisambiguator$1
extends NavCommand {
    private final /* synthetic */ AddressDisambiguator this$0;

    AddressDisambiguator$1(AddressDisambiguator addressDisambiguator, String string) {
        this.this$0 = addressDisambiguator;
        super(string);
    }

    @Override
    public void execute() {
        this.this$0.getBestPointAndNearestHNr();
        this.this$0.setListModels(2);
        this.getCommandList().commandFinished();
    }
}

