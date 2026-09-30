/*
 * Decompiled with CFR 0.152.
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
    private static final String LOGCLASS = "PhoneStateUpdate";
    private final boolean callActive;

    public PhoneStateUpdate(IContext iContext, boolean bl, IStateHandler iStateHandler) {
        super(iContext.getLogger().main(), LOGCLASS, iContext, iStateHandler);
        this.callActive = bl;
    }

    public void execute() {
        this.logger.log(1000000, "[%1.execute]", (Object)LOGCLASS);
        TMState tMState = this.stateHandler.getCurrentState();
        tMState.setOwnerForApplication(Application.PHONE, this.callActive ? ApplicationOwner.MAINUNIT : ApplicationOwner.NOBODY);
        this.stateHandler.updateState(tMState);
        this.getCommandList().commandFinished();
    }
}

