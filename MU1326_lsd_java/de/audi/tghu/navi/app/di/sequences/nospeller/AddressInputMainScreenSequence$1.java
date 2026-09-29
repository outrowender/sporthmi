/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.di.sequences.nospeller;

import de.audi.tghu.navi.app.addressinput.commands.LISetCurrentLDCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.di.sequences.nospeller.AddressInputMainScreenSequence;

class AddressInputMainScreenSequence$1
extends NavCommand {
    private final /* synthetic */ AddressInputMainScreenSequence this$0;

    AddressInputMainScreenSequence$1(AddressInputMainScreenSequence addressInputMainScreenSequence, String string) {
        this.this$0 = addressInputMainScreenSequence;
        super(string);
    }

    @Override
    public void execute() {
        this.getCommandList().commandFinishedWithPostCommand(new LISetCurrentLDCommand(this.dsiResponseContainer.getTransformedLocation()));
    }
}

