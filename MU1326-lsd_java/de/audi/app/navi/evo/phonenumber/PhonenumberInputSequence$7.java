/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.phonenumber;

import de.audi.app.navi.evo.phonenumber.PhonenumberInputSequence;
import de.audi.app.navi.evo.phonenumber.PhonenumberInputSequence$7$1;
import de.audi.app.navi.evo.phonenumber.PhonenumberInputSequence$7$2;
import de.audi.atip.interapp.NaviServiceListener;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.addressinput.commands.SetInputCommand;
import de.audi.tghu.navi.app.command.NavCommand;
import de.audi.tghu.navi.app.util.Util;

class PhonenumberInputSequence$7
extends NavCommand {
    private final /* synthetic */ String val$fullInput;
    private final /* synthetic */ String val$previousInput;
    private final /* synthetic */ NaviServiceListener val$naviServiceListener;
    private final /* synthetic */ PhonenumberInputSequence this$0;

    PhonenumberInputSequence$7(PhonenumberInputSequence phonenumberInputSequence, String string, String string2, String string3, NaviServiceListener naviServiceListener) {
        this.this$0 = phonenumberInputSequence;
        this.val$fullInput = string2;
        this.val$previousInput = string3;
        this.val$naviServiceListener = naviServiceListener;
        super(string);
    }

    @Override
    public void execute() {
        CommandList commandList = PhonenumberInputSequence.access$500(this.this$0).createCommandList();
        String string = this.dsiResponseContainer.getLispCurrentInput();
        String string2 = this.val$fullInput;
        if (Util.isEmpty(string2)) {
            string2 = "";
        }
        if (!this.dsiResponseContainer.isLispIsFullMatch() && Util.isEmpty(this.dsiResponseContainer.getLispValidCharacters()) && this.dsiResponseContainer.getLispValueListCount() == 0L || !string.startsWith(string2)) {
            commandList.add(new SetInputCommand(this.val$previousInput));
            commandList.add(new PhonenumberInputSequence$7$1(this, this.val$naviServiceListener));
        } else {
            commandList.add(new PhonenumberInputSequence$7$2(this, "Check whether SetInputCommand execute successfully"));
        }
        this.getCommandList().commandFinishedWithPostSequence(commandList);
    }

    static /* synthetic */ String access$600(PhonenumberInputSequence$7 phonenumberInputSequence$7) {
        return phonenumberInputSequence$7.val$previousInput;
    }

    static /* synthetic */ PhonenumberInputSequence access$700(PhonenumberInputSequence$7 phonenumberInputSequence$7) {
        return phonenumberInputSequence$7.this$0;
    }

    static /* synthetic */ NaviServiceListener access$800(PhonenumberInputSequence$7 phonenumberInputSequence$7) {
        return phonenumberInputSequence$7.val$naviServiceListener;
    }
}

