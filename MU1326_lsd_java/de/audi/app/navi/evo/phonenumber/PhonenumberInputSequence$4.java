/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.phonenumber;

import de.audi.app.navi.evo.phonenumber.PhonenumberInputSequence;
import de.audi.tghu.navi.app.command.NavCommand;

class PhonenumberInputSequence$4
extends NavCommand {
    private final /* synthetic */ PhonenumberInputSequence this$0;

    PhonenumberInputSequence$4(PhonenumberInputSequence phonenumberInputSequence, String string) {
        this.this$0 = phonenumberInputSequence;
        super(string);
    }

    @Override
    public void execute() {
        PhonenumberInputSequence.access$200(this.this$0, (String)this.getCommandList().get("PREVIOUS_PHONE_NUMBER"), this.dsiResponseContainer.getLispCurrentInput());
        this.getCommandList().commandFinished();
    }
}

