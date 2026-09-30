/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.device;

import de.audi.app.terminalmode.device.IActiveDeviceStateListener;
import de.audi.app.terminalmode.device.IDeviceManager;
import de.audi.app.terminalmode.device.TMDevice;
import de.audi.app.terminalmode.dsi.smartphoneintegration.ISmartphoneIntegrationDSIController;
import de.audi.atip.log.LogChannel;
import de.audi.tghu.command.Command;

public abstract class AbstractDeviceCommand
extends Command
implements IActiveDeviceStateListener {
    protected final ISmartphoneIntegrationDSIController dsiController;
    protected final TMDevice device;
    protected final IDeviceManager deviceManager;

    public AbstractDeviceCommand(LogChannel logChannel, String string, ISmartphoneIntegrationDSIController iSmartphoneIntegrationDSIController, TMDevice tMDevice, IDeviceManager iDeviceManager) {
        super(logChannel, string);
        this.dsiController = iSmartphoneIntegrationDSIController;
        this.device = tMDevice;
        this.deviceManager = iDeviceManager;
    }

    public void abort() {
        this.deviceManager.removeActiveDeviceListener(this);
        super.abort();
    }
}

