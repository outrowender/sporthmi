/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.statemachine.TMState
 */
package de.audi.app.terminalmode.smartphone.carlife;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.smartphone.TMRequestModeChangeCallback;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.app.terminalmode.statemachine.commands.AbstractStateHandlerCommand;

public class SendUpdateCarlifeResponse
extends AbstractStateHandlerCommand {
    private static final String LOGCLASS;
    private final TMState state;
    private final TMRequestModeChangeCallback tmRequestModeChangeCallback;

    public SendUpdateCarlifeResponse(IContext iContext, IStateHandler iStateHandler, TMState tMState, TMRequestModeChangeCallback tMRequestModeChangeCallback) {
        super(iContext.getLogger().main(), "SendUpdateResponse", iContext, iStateHandler);
        this.state = tMState;
        this.tmRequestModeChangeCallback = tMRequestModeChangeCallback;
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "[%1.execute]", (Object)"SendUpdateResponse");
        this.stateHandler.updateState(this.state);
        this.tmRequestModeChangeCallback.modeChanged(this.state);
        this.getCommandList().commandFinished();
    }
}

