/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.statemachine.TMState
 */
package de.audi.app.terminalmode.statemachine;

import de.audi.app.terminalmode.statemachine.IRequestor;
import de.audi.app.terminalmode.statemachine.IStateChangeAction;
import de.audi.app.terminalmode.statemachine.StateHandlerImpl;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.app.terminalmode.statemachine.commands.RestoreHMIScreen;
import de.audi.app.terminalmode.statemachine.commands.UpdatePhoneHMI;
import de.audi.tghu.command.CommandList;

class StateHandlerImpl$23
implements IStateChangeAction {
    private final /* synthetic */ StateHandlerImpl this$0;

    StateHandlerImpl$23(StateHandlerImpl stateHandlerImpl) {
        this.this$0 = stateHandlerImpl;
    }

    @Override
    public void execute(CommandList commandList, TMState tMState, IRequestor iRequestor, long l) {
        StateHandlerImpl.access$200(this.this$0).log(1078071040, "[%1.changeState] Screen: Device -> MU", (Object)"StateHandlerImpl");
        if (IRequestor.DEVICE == iRequestor) {
            StateHandlerImpl.access$400(this.this$0, commandList, new RestoreHMIScreen(StateHandlerImpl.access$300(this.this$0), this.this$0), false);
        } else if (IRequestor.DEVICE_WHILE_DISCONNECTING.equals(iRequestor)) {
            StateHandlerImpl.access$200(this.this$0).log(-2137614336, "[%1.changeState] Screen: Device -> MU, DEVICE_WHILE_DISCONNECTING, no RestoreHMIScreen command", (Object)"StateHandlerImpl");
        }
        StateHandlerImpl.access$400(this.this$0, commandList, new UpdatePhoneHMI(StateHandlerImpl.access$300(this.this$0), false), false);
    }
}

