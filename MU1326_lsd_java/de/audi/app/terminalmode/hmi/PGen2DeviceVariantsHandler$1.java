/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.app.terminalmode.statemachine.TMState
 */
package de.audi.app.terminalmode.hmi;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.hmi.PGen2DeviceVariantsHandler;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.app.terminalmode.statemachine.TMState;
import de.audi.app.terminalmode.statemachine.commands.AbstractStateHandlerCommand;
import de.audi.atip.log.LogChannel;

class PGen2DeviceVariantsHandler$1
extends AbstractStateHandlerCommand {
    private final /* synthetic */ TMState val$newState;
    private final /* synthetic */ PGen2DeviceVariantsHandler this$0;

    PGen2DeviceVariantsHandler$1(PGen2DeviceVariantsHandler pGen2DeviceVariantsHandler, LogChannel logChannel, String string, IContext iContext, IStateHandler iStateHandler, TMState tMState) {
        this.this$0 = pGen2DeviceVariantsHandler;
        this.val$newState = tMState;
        super(logChannel, string, iContext, iStateHandler);
    }

    @Override
    public void execute() {
        this.stateHandler.updateState(this.val$newState);
        this.getCommandList().commandFinished();
    }
}

