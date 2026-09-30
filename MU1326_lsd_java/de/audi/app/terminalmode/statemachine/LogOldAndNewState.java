/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.statemachine;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.app.terminalmode.statemachine.commands.AbstractStateHandlerCommand;

public class LogOldAndNewState
extends AbstractStateHandlerCommand {
    private static final String LOGCLASS = "LogOldAndNewState";
    private final TMState newState;

    public LogOldAndNewState(IContext iContext, TMState tMState, IStateHandler iStateHandler) {
        super(iContext.getLogger().state(), LOGCLASS, iContext, iStateHandler);
        this.newState = tMState;
    }

    public void execute() {
        this.logger.log(10000000, "[%1.execute] currentState=%2", (Object)LOGCLASS, (Object)this.stateHandler.getCurrentState());
        this.logger.log(10000000, "[%1.execute] newState=%2", (Object)LOGCLASS, (Object)this.newState);
        this.getCommandList().commandFinished();
    }
}

