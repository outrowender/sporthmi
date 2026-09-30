/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.smartphone.androidauto2;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.app.terminalmode.statemachine.commands.AbstractStateHandlerCommand;

public class SendUpdateResponse
extends AbstractStateHandlerCommand {
    private static final String LOGCLASS = "SendUpdateResponse";
    private final TMState state;

    public SendUpdateResponse(IContext iContext, IStateHandler iStateHandler, TMState tMState) {
        super(iContext.getLogger().main(), LOGCLASS, iContext, iStateHandler);
        this.state = tMState;
    }

    public void execute() {
        this.logger.log(1000000, "[%1.execute]", (Object)LOGCLASS);
        this.stateHandler.updateState(this.state);
        this.context.getSmartphoneDSIManager().responseUpdateMode(this.state, -1L);
        this.getCommandList().commandFinished();
    }
}

