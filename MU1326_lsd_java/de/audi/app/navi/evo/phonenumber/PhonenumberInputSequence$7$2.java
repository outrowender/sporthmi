/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.phonenumber;

import de.audi.app.navi.evo.phonenumber.PhonenumberInputSequence;
import de.audi.app.navi.evo.phonenumber.PhonenumberInputSequence$7;
import de.audi.app.navi.evo.phonenumber.PhonenumberInputSequence$7$2$1;
import de.audi.app.navi.evo.phonenumber.PhonenumberInputSequence$7$2$2;
import de.audi.tghu.navi.app.command.NavCommand;

class PhonenumberInputSequence$7$2
extends NavCommand {
    private final /* synthetic */ PhonenumberInputSequence$7 this$1;

    PhonenumberInputSequence$7$2(PhonenumberInputSequence$7 phonenumberInputSequence$7, String string) {
        this.this$1 = phonenumberInputSequence$7;
        super(string);
    }

    @Override
    public void execute() {
        if (PhonenumberInputSequence.access$300(PhonenumberInputSequence$7.access$700(this.this$1), this.dsiResponseContainer, PhonenumberInputSequence$7.access$600(this.this$1))) {
            PhonenumberInputSequence.access$400(PhonenumberInputSequence$7.access$700(this.this$1)).log(-2137614336, "%1#inputTelephoneNumber -- input stack = %2", (Object)this.CLASS_NAME, (Object)PhonenumberInputSequence.access$000());
            this.getCommandList().commandFinishedWithPostCommand(new PhonenumberInputSequence$7$2$1(this, PhonenumberInputSequence$7.access$800(this.this$1)));
        } else {
            this.getCommandList().commandFinishedWithPostCommand(new PhonenumberInputSequence$7$2$2(this, PhonenumberInputSequence$7.access$800(this.this$1)));
        }
    }
}

