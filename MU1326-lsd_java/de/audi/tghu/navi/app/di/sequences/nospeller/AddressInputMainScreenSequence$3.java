/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.nospeller;

import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.nospeller.AddressInputMainScreenSequence;

class AddressInputMainScreenSequence$3
extends NavCommand {
    private final /* synthetic */ AddressInputMainScreenSequence this$0;

    AddressInputMainScreenSequence$3(AddressInputMainScreenSequence addressInputMainScreenSequence, String string) {
        this.this$0 = addressInputMainScreenSequence;
        super(string);
    }

    @Override
    public void execute() {
        AddressInputMainScreenSequence.access$002(this.this$0, true);
        this.getCommandList().commandFinished();
    }
}

