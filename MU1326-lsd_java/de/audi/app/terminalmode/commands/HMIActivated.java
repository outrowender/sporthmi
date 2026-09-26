/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.statemachine.TMState
 */
package de.audi.app.terminalmode.commands;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.device.TMDevice;
import de.audi.app.terminalmode.statemachine.IRequestor;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.app.terminalmode.statemachine.Resource;
import de.audi.app.terminalmode.statemachine.ResourceOwner;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.app.terminalmode.statemachine.commands.AbstractStateHandlerCommand;
import de.audi.tghu.command.CommandList;

public class HMIActivated
extends AbstractStateHandlerCommand {
    private static final String LOGCLASS;

    public HMIActivated(IContext iContext, IStateHandler iStateHandler) {
        super(iContext.getLogger().main(), "HMIActivated", iContext, iStateHandler);
    }

    @Override
    public void execute() {
        this.logger.log(1078071040, "[%1.execute]", (Object)"HMIActivated");
        TMDevice tMDevice = this.context.getDeviceManager().getActiveDevice();
        if (null == tMDevice) {
            this.getCommandList().commandFinished();
            return;
        }
        TMState tMState = this.stateHandler.getCurrentState();
        tMState.setOwnerForResource(Resource.SCREEN, ResourceOwner.DEVICE);
        CommandList commandList = this.stateHandler.changeState(tMState, IRequestor.MAINUNIT, -1L);
        this.getCommandList().commandFinishedWithPostSequence(commandList);
    }
}

