/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.statemachine.TMState
 */
package de.audi.app.terminalmode.statemachine;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.app.terminalmode.statemachine.commands.AbstractStateHandlerCommand;

public class LogOldAndNewState
extends AbstractStateHandlerCommand {
    private static final String LOGCLASS;
    private final TMState newState;

    public LogOldAndNewState(IContext iContext, TMState tMState, IStateHandler iStateHandler) {
        super(iContext.getLogger().state(), "LogOldAndNewState", iContext, iStateHandler);
        this.newState = tMState;
    }

    @Override
    public void execute() {
        this.logger.log(-2137614336, "[%1.execute] currentState=%2", (Object)"LogOldAndNewState", (Object)this.stateHandler.getCurrentState());
        this.logger.log(-2137614336, "[%1.execute] newState=%2", (Object)"LogOldAndNewState", (Object)this.newState);
        this.getCommandList().commandFinished();
    }
}

