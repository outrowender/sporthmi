/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.statemachine.TMState
 */
package de.audi.app.terminalmode.smartphone.androidauto2;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.smartphone.androidauto2.SendUpdateResponse;
import de.audi.app.terminalmode.statemachine.IRequestor;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.app.terminalmode.statemachine.Resource;
import de.audi.app.terminalmode.statemachine.ResourceOwner;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.app.terminalmode.statemachine.commands.AbstractStateHandlerCommand;
import de.audi.tghu.command.CommandList;

public class UpdateResource
extends AbstractStateHandlerCommand {
    private static final String LOGCLASS;
    private final Resource resource;
    private final ResourceOwner resourceOwner;

    public UpdateResource(IContext iContext, Resource resource, ResourceOwner resourceOwner, IStateHandler iStateHandler) {
        super(iContext.getLogger().main(), "UpdateResource", iContext, iStateHandler);
        this.resource = resource;
        this.resourceOwner = resourceOwner;
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "[%1.execute]", (Object)"UpdateResource");
        TMState tMState = this.stateHandler.getCurrentState();
        tMState.setOwnerForResource(this.resource, this.resourceOwner);
        this.logger.log(1078071040, "[%1.execute] new state=%2", (Object)"UpdateResource", (Object)tMState.toString());
        CommandList commandList = this.stateHandler.changeState(tMState, IRequestor.DEVICE, -1L);
        commandList.add(new SendUpdateResponse(this.context, this.stateHandler, tMState));
        this.getCommandList().commandFinishedWithPostSequence(commandList);
    }
}

