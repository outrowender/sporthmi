/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.statemachine.TMState
 */
package de.audi.app.terminalmode.smartphone.androidauto2;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.app.terminalmode.statemachine.commands.AbstractStateHandlerCommand;

public class SendUpdateResponse
extends AbstractStateHandlerCommand {
    private static final String LOGCLASS;
    private final TMState state;

    public SendUpdateResponse(IContext iContext, IStateHandler iStateHandler, TMState tMState) {
        super(iContext.getLogger().main(), "SendUpdateResponse", iContext, iStateHandler);
        this.state = tMState;
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "[%1.execute]", (Object)"SendUpdateResponse");
        this.stateHandler.updateState(this.state);
        this.context.getSmartphoneDSIManager().responseUpdateMode(this.state, -1L);
        this.getCommandList().commandFinished();
    }
}

