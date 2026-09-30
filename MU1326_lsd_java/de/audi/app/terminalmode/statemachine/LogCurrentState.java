/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.statemachine;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.app.terminalmode.statemachine.commands.AbstractStateHandlerCommand;

public class LogCurrentState
extends AbstractStateHandlerCommand {
    private static final String LOGCLASS = "LogCurrentState";

    public LogCurrentState(IContext iContext, IStateHandler iStateHandler) {
        super(iContext.getLogger().state(), LOGCLASS, iContext, iStateHandler);
    }

    public void execute() {
        this.logger.log(10000000, "[%1.execute] currentState=%2", (Object)LOGCLASS, (Object)this.stateHandler.getCurrentState());
        this.getCommandList().commandFinished();
    }
}

