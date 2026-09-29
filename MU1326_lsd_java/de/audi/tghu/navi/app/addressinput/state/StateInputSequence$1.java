/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.addressinput.state;

import de.audi.tghu.navi.app.addressinput.state.StateInputSequence;
import de.audi.tghu.navi.app.command.LISetHistoryCommand;
import de.audi.tghu.navi.app.command.NavCommand;

class StateInputSequence$1
extends NavCommand {
    private final /* synthetic */ StateInputSequence this$0;

    StateInputSequence$1(StateInputSequence stateInputSequence, String string) {
        this.this$0 = stateInputSequence;
        super(string);
    }

    @Override
    public void execute() {
        this.getCommandList().commandFinishedWithPostCommand(new LISetHistoryCommand(this.dsiResponseContainer.getLiCurrentLD()));
    }
}

