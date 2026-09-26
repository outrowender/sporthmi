/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.navi.evo.phonenumber;

import de.audi.app.navi.evo.phonenumber.PhonenumberInputSequence;
import de.audi.app.navi.evo.phonenumber.PhonenumberInputSequence$8$1;
import de.audi.tghu.command.CommandList;
import de.audi.tghu.navi.app.addressinput.commands.SetInputCommand;
import de.audi.tghu.navi.app.command.NavCommand;

class PhonenumberInputSequence$8
extends NavCommand {
    private final /* synthetic */ PhonenumberInputSequence this$0;

    PhonenumberInputSequence$8(PhonenumberInputSequence phonenumberInputSequence, String string) {
        this.this$0 = phonenumberInputSequence;
        super(string);
    }

    @Override
    public void execute() {
        CommandList commandList = PhonenumberInputSequence.access$500(this.this$0).createCommandList();
        if (!PhonenumberInputSequence.access$000().isEmpty()) {
            String string = (String)PhonenumberInputSequence.access$000().pop();
            String string2 = this.this$0.getCurrentTelephoneNumber();
            String string3 = string2.substring(0, string2.length() - string.length());
            this.logger.log(-2137614336, "%1#deleteLastTelephoneNumberInput -- Input = %2", (Object)this.CLASS_NAME, (Object)string3);
            commandList.add(new SetInputCommand(string3));
            commandList.add(new PhonenumberInputSequence$8$1(this, "Check if SetInputCommand is executed correctly based on its result", string, string2));
        } else {
            commandList.add(new SetInputCommand(""));
        }
        this.getCommandList().commandFinishedWithPostSequence(commandList);
    }

    static /* synthetic */ PhonenumberInputSequence access$900(PhonenumberInputSequence$8 phonenumberInputSequence$8) {
        return phonenumberInputSequence$8.this$0;
    }
}

