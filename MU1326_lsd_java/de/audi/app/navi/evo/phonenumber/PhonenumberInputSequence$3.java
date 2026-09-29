/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.phonenumber;

import de.audi.app.navi.evo.phonenumber.PhonenumberInputSequence;
import de.audi.tghu.navi.app.addressinput.commands.SetInputCommand;
import de.audi.tghu.navi.app.command.NavCommand;

class PhonenumberInputSequence$3
extends NavCommand {
    private final /* synthetic */ PhonenumberInputSequence this$0;

    PhonenumberInputSequence$3(PhonenumberInputSequence phonenumberInputSequence, String string) {
        this.this$0 = phonenumberInputSequence;
        super(string);
    }

    @Override
    public void execute() {
        String string = this.dsiResponseContainer.getLispCurrentInput();
        this.getCommandList().put("PREVIOUS_PHONE_NUMBER", string);
        SetInputCommand setInputCommand = PhonenumberInputSequence.access$000().isEmpty() ? new SetInputCommand("") : new SetInputCommand(string.substring(0, string.length() - ((String)PhonenumberInputSequence.access$000().peek()).length()));
        this.getCommandList().commandFinishedWithPostCommand(setInputCommand);
    }
}

