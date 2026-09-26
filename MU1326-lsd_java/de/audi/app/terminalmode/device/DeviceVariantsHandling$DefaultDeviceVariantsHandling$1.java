/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.statemachine.TMState
 */
package de.audi.app.terminalmode.device;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.device.DeviceVariantsHandling$DefaultDeviceVariantsHandling;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.app.terminalmode.statemachine.commands.AbstractStateHandlerCommand;
import de.audi.atip.log.LogChannel;

class DeviceVariantsHandling$DefaultDeviceVariantsHandling$1
extends AbstractStateHandlerCommand {
    private final /* synthetic */ TMState val$newState;
    private final /* synthetic */ DeviceVariantsHandling$DefaultDeviceVariantsHandling this$1;

    DeviceVariantsHandling$DefaultDeviceVariantsHandling$1(DeviceVariantsHandling$DefaultDeviceVariantsHandling deviceVariantsHandling$DefaultDeviceVariantsHandling, LogChannel logChannel, String string, IContext iContext, IStateHandler iStateHandler, TMState tMState) {
        this.this$1 = deviceVariantsHandling$DefaultDeviceVariantsHandling;
        this.val$newState = tMState;
        super(logChannel, string, iContext, iStateHandler);
    }

    @Override
    public void execute() {
        this.stateHandler.updateState(this.val$newState);
        this.getCommandList().commandFinished();
    }
}

