/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.device;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.device.TMDeviceControl;
import de.audi.app.terminalmode.device.TMDeviceControl$SM;
import de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState;
import de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$DiscoveredState;
import de.audi.app.terminalmode.device.TMDeviceControl$SM$BaseState$DiscoveredState$Busy;
import de.audi.app.terminalmode.statemachine.commands.AbstractCommand;
import de.audi.atip.log.LogChannel;

class TMDeviceControl$SM$BaseState$DiscoveredState$Busy$1
extends AbstractCommand {
    private final /* synthetic */ TMDeviceControl$SM$BaseState$DiscoveredState$Busy this$4;

    TMDeviceControl$SM$BaseState$DiscoveredState$Busy$1(TMDeviceControl$SM$BaseState$DiscoveredState$Busy tMDeviceControl$SM$BaseState$DiscoveredState$Busy, LogChannel logChannel, String string, IContext iContext) {
        this.this$4 = tMDeviceControl$SM$BaseState$DiscoveredState$Busy;
        super(logChannel, string, iContext);
    }

    @Override
    public void execute() {
        TMDeviceControl.access$5500(TMDeviceControl$SM.access$500(TMDeviceControl$SM$BaseState.access$400(TMDeviceControl$SM$BaseState$DiscoveredState.access$2200(TMDeviceControl$SM$BaseState$DiscoveredState$Busy.access$3000(this.this$4))))).sendMessage(10);
        this.getCommandList().commandFinished();
    }
}

