/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.statemachine.TMState
 */
package de.audi.app.terminalmode.statemachine;

import de.audi.app.terminalmode.audio.TMAudioConnection;
import de.audi.app.terminalmode.statemachine.IRequestor;
import de.audi.app.terminalmode.statemachine.IStateChangeAction;
import de.audi.app.terminalmode.statemachine.StateHandlerImpl;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.app.terminalmode.statemachine.commands.RequestAudioFocus;
import de.audi.tghu.command.CommandList;

class StateHandlerImpl$2
implements IStateChangeAction {
    private final /* synthetic */ StateHandlerImpl this$0;

    StateHandlerImpl$2(StateHandlerImpl stateHandlerImpl) {
        this.this$0 = stateHandlerImpl;
    }

    @Override
    public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
        StateHandlerImpl.access$200(this.this$0).log(1078071040, "[%1.changeState] audio media: MU -> Device", (Object)"StateHandlerImpl");
        StateHandlerImpl.access$400(this.this$0, commandList, new RequestAudioFocus(StateHandlerImpl.access$300(this.this$0), this.this$0), false);
        StateHandlerImpl.access$400(this.this$0, commandList, StateHandlerImpl.access$500(this.this$0).createAudioConnectionRequest(TMAudioConnection.MEDIA, true), false);
    }
}

