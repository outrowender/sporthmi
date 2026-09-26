/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.phonenumber;

import de.audi.app.navi.evo.phonenumber.PhonenumberInputSequence;
import de.audi.app.navi.evo.phonenumber.PhonenumberInputSequence$8;
import de.audi.tghu.navi.app.command.NavCommand;

class PhonenumberInputSequence$8$1
extends NavCommand {
    private final /* synthetic */ String val$lastInput;
    private final /* synthetic */ String val$currentInput;
    private final /* synthetic */ PhonenumberInputSequence$8 this$1;

    PhonenumberInputSequence$8$1(PhonenumberInputSequence$8 phonenumberInputSequence$8, String string, String string2, String string3) {
        this.this$1 = phonenumberInputSequence$8;
        this.val$lastInput = string2;
        this.val$currentInput = string3;
        super(string);
    }

    @Override
    public void execute() {
        PhonenumberInputSequence.access$200(PhonenumberInputSequence$8.access$900(this.this$1), this.val$lastInput, this.val$currentInput);
        this.getCommandList().commandFinished();
    }
}

