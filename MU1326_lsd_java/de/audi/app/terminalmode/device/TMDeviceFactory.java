/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.device;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.device.IDeviceVariantsHandling;
import de.audi.app.terminalmode.device.TMDevice;
import de.audi.app.terminalmode.device.TMDeviceControl;
import de.audi.app.terminalmode.device.TMDeviceControl$IDeviceControlToDeviceManager;
import de.audi.app.terminalmode.smartphone.IDSISmartphoneManager$ISmartphoneProperties;
import de.audi.app.terminalmode.statemachine.IStateHandler;
import de.esolutions.fw.util.commons.timeout.ITimeSource;

public class TMDeviceFactory {
    private IContext context;
    private IStateHandler stateHandler;
    private ITimeSource timeSource;
    private final IDeviceVariantsHandling deviceVariantsHandling;
    private final IDSISmartphoneManager$ISmartphoneProperties smartphoneProperties;

    public TMDeviceFactory(IContext iContext, IStateHandler iStateHandler, ITimeSource iTimeSource, IDeviceVariantsHandling iDeviceVariantsHandling, IDSISmartphoneManager$ISmartphoneProperties iDSISmartphoneManager$ISmartphoneProperties) {
        this.context = iContext;
        this.stateHandler = iStateHandler;
        this.timeSource = iTimeSource;
        this.deviceVariantsHandling = iDeviceVariantsHandling;
        this.smartphoneProperties = iDSISmartphoneManager$ISmartphoneProperties;
    }

    public TMDeviceControl createTMDeviceControl(TMDevice tMDevice, TMDeviceControl$IDeviceControlToDeviceManager tMDeviceControl$IDeviceControlToDeviceManager) {
        return new TMDeviceControl(this.context, tMDevice, tMDeviceControl$IDeviceControlToDeviceManager, this.stateHandler, this.timeSource, this.deviceVariantsHandling, this.smartphoneProperties);
    }
}

