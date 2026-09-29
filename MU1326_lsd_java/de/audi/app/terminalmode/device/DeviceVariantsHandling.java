/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.device;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.device.DeviceVariantsHandling$DefaultDeviceVariantsHandling;
import de.audi.app.terminalmode.device.IDeviceVariantsHandling;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.CommandList;

public class DeviceVariantsHandling
implements IDeviceVariantsHandling,
ITerminalModeComponent {
    private volatile IDeviceVariantsHandling deviceVariantsHandling;
    private final IDeviceVariantsHandling defaultDeviceVariantsHandling;

    public DeviceVariantsHandling() {
        this.deviceVariantsHandling = this.defaultDeviceVariantsHandling = new DeviceVariantsHandling$DefaultDeviceVariantsHandling(this, null);
    }

    @Override
    public void init() {
        this.deviceVariantsHandling = this.defaultDeviceVariantsHandling;
    }

    @Override
    public void deinit() {
        this.deviceVariantsHandling = this.defaultDeviceVariantsHandling;
    }

    @Override
    public CommandList cleanupAfterDeviceDisconnected(IContext iContext, IStateHandler iStateHandler, LogChannel logChannel, String string) {
        if (null != this.deviceVariantsHandling) {
            return this.deviceVariantsHandling.cleanupAfterDeviceDisconnected(iContext, iStateHandler, logChannel, string);
        }
        return new CommandList(iContext.getCommandListManager());
    }

    @Override
    public void setDeviceVariantsHandler(IDeviceVariantsHandling iDeviceVariantsHandling) {
        this.deviceVariantsHandling = iDeviceVariantsHandling;
    }
}

