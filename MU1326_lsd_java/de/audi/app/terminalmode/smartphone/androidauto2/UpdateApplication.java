/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.smartphone.androidauto2;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.smartphone.androidauto2.SendUpdateResponse;
import de.audi.app.terminalmode.statemachine.Application;
import de.audi.app.terminalmode.statemachine.ApplicationOwner;
import de.audi.app.terminalmode.statemachine.IRequestor;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.app.terminalmode.statemachine.commands.AbstractStateHandlerCommand;
import de.audi.tghu.command.CommandList;

public class UpdateApplication
extends AbstractStateHandlerCommand {
    private static final String LOGCLASS = "UpdateApplication";
    private final Application application;
    private final ApplicationOwner applicationOwner;

    public UpdateApplication(IContext iContext, Application application, ApplicationOwner applicationOwner, IStateHandler iStateHandler) {
        super(iContext.getLogger().main(), LOGCLASS, iContext, iStateHandler);
        this.application = application;
        this.applicationOwner = applicationOwner;
    }

    public void execute() {
        TMState tMState = this.stateHandler.getCurrentState();
        tMState.setOwnerForApplication(this.application, this.applicationOwner);
        this.logger.log(1000000, "[%1.execute] new state=%2", (Object)LOGCLASS, (Object)tMState.toString());
        CommandList commandList = this.stateHandler.changeState(tMState, IRequestor.DEVICE, -1L);
        commandList.add(new SendUpdateResponse(this.context, this.stateHandler, tMState));
        this.getCommandList().commandFinishedWithPostSequence(commandList);
    }
}

