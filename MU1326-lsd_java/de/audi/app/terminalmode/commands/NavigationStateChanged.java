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
import de.audi.app.terminalmode.statemachine.IRequestor;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.app.terminalmode.statemachine.commands.AbstractStateHandlerCommand;
import de.audi.tghu.command.CommandList;

public class NavigationStateChanged
extends AbstractStateHandlerCommand {
    private static final String LOGCLASS;
    private final boolean routeGuidanceRunning;

    public NavigationStateChanged(IContext iContext, boolean bl, IStateHandler iStateHandler) {
        super(iContext.getLogger().main(), "NavigationStateChanged", iContext, iStateHandler);
        this.routeGuidanceRunning = bl;
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "[%1.execute]", (Object)"NavigationStateChanged");
        TMState tMState = this.stateHandler.getCurrentState();
        ApplicationOwner applicationOwner = tMState.getOwnerForApplication(Application.NAVI);
        if (this.routeGuidanceRunning) {
            applicationOwner = ApplicationOwner.MAINUNIT;
        } else if (applicationOwner.is(ApplicationOwner.MAINUNIT)) {
            applicationOwner = ApplicationOwner.NOBODY;
        }
        tMState.setOwnerForApplication(Application.NAVI, applicationOwner);
        CommandList commandList = this.stateHandler.changeState(tMState, IRequestor.MAINUNIT, -1L);
        this.stateHandler.setOwnerForApplication(Application.NAVI, applicationOwner);
        this.getCommandList().commandFinishedWithPostSequence(commandList);
    }
}

