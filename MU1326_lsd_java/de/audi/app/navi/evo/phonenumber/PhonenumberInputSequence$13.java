/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.phonenumber;

import de.audi.app.navi.evo.phonenumber.PhonenumberInputSequence;
import de.audi.tghu.navi.app.command.NavCommand;

class PhonenumberInputSequence$13
extends NavCommand {
    private final /* synthetic */ PhonenumberInputSequence this$0;

    PhonenumberInputSequence$13(PhonenumberInputSequence phonenumberInputSequence, String string) {
        this.this$0 = phonenumberInputSequence;
        super(string);
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "%1#spellerStack.pop()", (Object)this.CLASS_NAME);
        PhonenumberInputSequence.access$100(this.this$0).pop();
        this.getCommandList().commandFinished();
    }
}

