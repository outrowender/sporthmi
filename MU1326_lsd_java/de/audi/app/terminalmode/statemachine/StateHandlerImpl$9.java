/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.statemachine.TMState
 */
package de.audi.app.terminalmode.statemachine;

import de.audi.app.terminalmode.audio.IAudioConnectionHandle;
import de.audi.app.terminalmode.audio.TMAudioConnection;
import de.audi.app.terminalmode.statemachine.IRequestor;
import de.audi.app.terminalmode.statemachine.IStateChangeAction;
import de.audi.app.terminalmode.statemachine.StateHandlerImpl;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.tghu.command.CommandList;

class StateHandlerImpl$9
implements IStateChangeAction {
    private final /* synthetic */ StateHandlerImpl this$0;

    StateHandlerImpl$9(StateHandlerImpl stateHandlerImpl) {
        this.this$0 = stateHandlerImpl;
    }

    @Override
    public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
        StateHandlerImpl.access$200(this.this$0).log(1078071040, "[%1.addRingtoneCommands] audio ringtone: device -> MU", (Object)"StateHandlerImpl");
        IAudioConnectionHandle iAudioConnectionHandle = StateHandlerImpl.access$500(this.this$0).createAudioConnectionHandle(TMAudioConnection.RINGTONE);
        StateHandlerImpl.access$400(this.this$0, commandList, iAudioConnectionHandle.createReleaseCommand(), true);
    }
}

