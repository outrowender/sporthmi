/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.statemachine.TMState
 */
package de.audi.app.terminalmode.commands;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.statemachine.IRequestor;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.app.terminalmode.statemachine.Resource;
import de.audi.app.terminalmode.statemachine.ResourceOwner;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.app.terminalmode.statemachine.commands.AbstractStateHandlerCommand;
import de.audi.tghu.command.CommandList;

public class HMIDeactivated
extends AbstractStateHandlerCommand {
    private static final String LOGCLASS;

    public HMIDeactivated(IContext iContext, IStateHandler iStateHandler) {
        super(iContext.getLogger().main(), "HMIDeactivated", iContext, iStateHandler);
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "[%1.execute]", (Object)"HMIDeactivated");
        TMState tMState = this.stateHandler.getCurrentState();
        if (tMState.isAccessRestricted(Resource.SCREEN)) {
            this.logger.log(1078071040, "[%1.execute: access is restricted, abort hmi deactivated]", (Object)"HMIDeactivated");
            this.getCommandList().commandFinished();
            return;
        }
        tMState.setOwnerForResource(Resource.SCREEN, ResourceOwner.MAINUNIT);
        CommandList commandList = this.stateHandler.changeState(tMState, IRequestor.MAINUNIT, -1L);
        this.getCommandList().commandFinishedWithPostSequence(commandList);
    }
}

