/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.statemachine.TMState
 */
package de.audi.app.terminalmode.statemachine.commands;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.statemachine.Application;
import de.audi.app.terminalmode.statemachine.ApplicationOwner;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.app.terminalmode.statemachine.commands.AbstractCommand;

public class UpdateMainunitState
extends AbstractCommand {
    private static final String LOGCLASS;
    private final TMState newState;
    private final IStateHandler stateHandler;

    public UpdateMainunitState(TMState tMState, IContext iContext, IStateHandler iStateHandler) {
        super(iContext.getLogger().main(), "UpdateMainunitState", iContext);
        this.newState = tMState;
        this.stateHandler = iStateHandler;
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "[%1.execute]", (Object)"UpdateMainunitState");
        Application[] applicationArray = Application.values();
        for (int i2 = 0; i2 < applicationArray.length; ++i2) {
            if (this.newState.isAppOwnerMainUnit(applicationArray[i2])) {
                this.stateHandler.setOwnerForApplication(applicationArray[i2], ApplicationOwner.MAINUNIT);
                continue;
            }
            if (!this.newState.isAppFree(applicationArray[i2])) continue;
            this.stateHandler.setOwnerForApplication(applicationArray[i2], ApplicationOwner.NOBODY);
        }
        this.stateHandler.setSpeechMode(this.newState.getSpeechMode());
        this.getCommandList().commandFinished();
    }
}

