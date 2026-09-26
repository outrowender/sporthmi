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
import de.audi.app.terminalmode.statemachine.commands.ReleaseAudioConnection;
import de.audi.tghu.command.CommandList;

class StateHandlerImpl$7
implements IStateChangeAction {
    private final /* synthetic */ StateHandlerImpl this$0;

    StateHandlerImpl$7(StateHandlerImpl stateHandlerImpl) {
        this.this$0 = stateHandlerImpl;
    }

    @Override
    public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
        StateHandlerImpl.access$200(this.this$0).log(1078071040, "[%1.changeState] audio speech: device -> MU", (Object)"StateHandlerImpl");
        StateHandlerImpl.access$400(this.this$0, commandList, new ReleaseAudioConnection(TMAudioConnection.SPEECH, StateHandlerImpl.access$300(this.this$0)), true);
        StateHandlerImpl.access$400(this.this$0, commandList, new ReleaseAudioConnection(TMAudioConnection.SPEECH_INPUT, StateHandlerImpl.access$300(this.this$0)), true);
    }
}

