/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  de.audi.atip.utils.reactive.properties.LoggingPropertyFactory
 */
package de.audi.app.terminalmode.hmi;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.device.IActiveDeviceStateListener;
import de.audi.app.terminalmode.device.TMDevice;
import de.audi.app.terminalmode.events.DefaultEventListener;
import de.audi.app.terminalmode.events.PhoneStateChangedEvent;
import de.audi.app.terminalmode.hmi.PhoneSignalQualityHandler$1;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.utils.reactive.bindings.ModelBindings;
import de.audi.atip.utils.reactive.bindings.SilentModelBindings;
import de.audi.atip.utils.reactive.properties.LoggingPropertyFactory;
import de.audi.atip.utils.reactive.properties.Property;

public class PhoneSignalQualityHandler
extends DefaultEventListener
implements ITerminalModeComponent,
IActiveDeviceStateListener {
    private static final String LOGCLASS;
    private static final int NO_INFO_AVAILABLE;
    private final LogChannel logger;
    private final IContext context;
    private final Property activeDevice;
    private final Property phoneStateChanged;
    private final ModelBindings models;
    private final LoggingPropertyFactory propertyFactory;

    public PhoneSignalQualityHandler(LogChannel logChannel, IContext iContext) {
        this.logger = logChannel;
        this.context = iContext;
        this.propertyFactory = LoggingPropertyFactory.create((LogChannel)this.logger, (int)-2137614336);
        this.models = SilentModelBindings.create();
        this.phoneStateChanged = this.propertyFactory.createProperty("phoneStateChanged");
        this.activeDevice = this.propertyFactory.createProperty("activeDevice");
    }

    @Override
    public void init() {
        this.context.getDeviceManager().addActiveDeviceListener(this);
        this.context.getEventBus().registerListener(this);
        ChoiceModelApp choiceModelApp = this.context.getFramework().getHmiServiceApp().getChoiceModel(4638);
        this.phoneStateChanged.observe().combineWith(this.activeDevice.observe()).using(new PhoneSignalQualityHandler$1(this)).distinctUntilChanged().redirectTo(this.models.from(choiceModelApp).intValue());
    }

    @Override
    public void deinit() {
        this.logger.log(14808325, "[%1.deinit]", (Object)"PhoneSignalQualityHandler");
        this.context.getEventBus().unregisterListener(this);
        this.context.getDeviceManager().removeActiveDeviceListener(this);
    }

    @Override
    public void updatePhoneState(PhoneStateChangedEvent phoneStateChangedEvent) {
        this.phoneStateChanged.accept(phoneStateChangedEvent);
    }

    @Override
    public void updateActiveDeviceState(TMDevice tMDevice) {
        this.activeDevice.accept(tMDevice);
    }
}

