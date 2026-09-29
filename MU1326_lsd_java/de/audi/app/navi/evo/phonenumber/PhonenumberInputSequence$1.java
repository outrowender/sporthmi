/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.phonenumber;

import de.audi.app.navi.evo.phonenumber.PhonenumberInputSequence;
import de.audi.tghu.navi.app.command.NavCommand;

class PhonenumberInputSequence$1
extends NavCommand {
    private final /* synthetic */ PhonenumberInputSequence this$0;

    PhonenumberInputSequence$1(PhonenumberInputSequence phonenumberInputSequence, String string) {
        this.this$0 = phonenumberInputSequence;
        super(string);
    }

    @Override
    public void execute() {
        PhonenumberInputSequence.access$000().clear();
        this.getCommandList().commandFinished();
    }
}

