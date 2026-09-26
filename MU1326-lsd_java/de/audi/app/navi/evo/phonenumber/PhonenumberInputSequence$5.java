/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.phonenumber;

import de.audi.app.navi.evo.phonenumber.PhonenumberInputSequence;
import de.audi.tghu.navi.app.command.NavCommand;

class PhonenumberInputSequence$5
extends NavCommand {
    private final /* synthetic */ String val$previousInput;
    private final /* synthetic */ PhonenumberInputSequence this$0;

    PhonenumberInputSequence$5(PhonenumberInputSequence phonenumberInputSequence, String string, String string2) {
        this.this$0 = phonenumberInputSequence;
        this.val$previousInput = string2;
        super(string);
    }

    @Override
    public void execute() {
        if (PhonenumberInputSequence.access$300(this.this$0, this.dsiResponseContainer, this.val$previousInput)) {
            PhonenumberInputSequence.access$400(this.this$0).log(-2137614336, "%1#addCharacter -- after reorganization input stack = %2", (Object)this.CLASS_NAME, (Object)PhonenumberInputSequence.access$000());
            this.getCommandList().commandFinished();
        } else {
            this.getCommandList().commandAborted("Unexcepted result");
        }
    }
}

