/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.statemachine.TMState
 */
package de.audi.app.terminalmode.commands;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.statemachine.Application;
import de.audi.app.terminalmode.statemachine.ApplicationOwner;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.app.terminalmode.statemachine.commands.AbstractStateHandlerCommand;

public class PhoneStateUpdate
extends AbstractStateHandlerCommand {
    private static final String LOGCLASS;
    private final boolean callActive;

    public PhoneStateUpdate(IContext iContext, boolean bl, IStateHandler iStateHandler) {
        super(iContext.getLogger().main(), "PhoneStateUpdate", iContext, iStateHandler);
        this.callActive = bl;
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "[%1.execute]", (Object)"PhoneStateUpdate");
        TMState tMState = this.stateHandler.getCurrentState();
        tMState.setOwnerForApplication(Application.PHONE, this.callActive ? ApplicationOwner.MAINUNIT : ApplicationOwner.NOBODY);
        this.stateHandler.updateState(tMState);
        this.getCommandList().commandFinished();
    }
}

