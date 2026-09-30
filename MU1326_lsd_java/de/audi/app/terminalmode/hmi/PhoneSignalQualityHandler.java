/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.hmi;

import de.audi.app.terminalmode.IContext;
import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.device.IActiveDeviceStateListener;
import de.audi.app.terminalmode.device.TMDevice;
import de.audi.app.terminalmode.events.DefaultEventListener;
import de.audi.app.terminalmode.events.PhoneStateChangedEvent;
import de.audi.atip.hmi.modelaccess.ChoiceModelApp;
import de.audi.atip.log.LogChannel;
import de.audi.atip.utils.reactive.bindings.ModelBindings;
import de.audi.atip.utils.reactive.bindings.SilentModelBindings;
import de.audi.atip.utils.reactive.observables.Observables;
import de.audi.atip.utils.reactive.properties.LoggingPropertyFactory;
import de.audi.atip.utils.reactive.properties.Property;

public class PhoneSignalQualityHandler
extends DefaultEventListener
implements ITerminalModeComponent,
IActiveDeviceStateListener {
    private static final String LOGCLASS = "PhoneSignalQualityHandler";
    private static final int NO_INFO_AVAILABLE = 0;
    private final LogChannel logger;
    private final IContext context;
    private final Property<TMDevice> activeDevice;
    private final Property<PhoneStateChangedEvent> phoneStateChanged;
    private final ModelBindings models;
    private final LoggingPropertyFactory propertyFactory;

    public PhoneSignalQualityHandler(LogChannel logChannel, IContext iContext) {
        this.logger = logChannel;
        this.context = iContext;
        this.propertyFactory = LoggingPropertyFactory.create(this.logger, 10000000);
        this.models = SilentModelBindings.create();
        this.phoneStateChanged = this.propertyFactory.createProperty("phoneStateChanged");
        this.activeDevice = this.propertyFactory.createProperty("activeDevice");
    }

    public void init() {
        this.context.getDeviceManager().addActiveDeviceListener(this);
        this.context.getEventBus().registerListener(this);
        ChoiceModelApp choiceModelApp = this.context.getFramework().getHmiServiceApp().getChoiceModel(4638);
        this.phoneStateChanged.observe().combineWith(this.activeDevice.observe()).using(new Observables.Combinator<PhoneStateChangedEvent, TMDevice, Integer>(){

            @Override
            public Integer combine(PhoneStateChangedEvent phoneStateChangedEvent, TMDevice tMDevice) {
                if (tMDevice.isCarplayDevice()) {
                    return new Integer(phoneStateChangedEvent.getSignalStrength() + 1);
                }
                return new Integer(0);
            }

            @Override
            public /* synthetic */ Object combine(Object object, Object object2) {
                return this.combine((PhoneStateChangedEvent)object, (TMDevice)object2);
            }
        }).distinctUntilChanged().redirectTo(this.models.from(choiceModelApp).intValue());
    }

    public void deinit() {
        this.logger.log(100000000, "[%1.deinit]", (Object)LOGCLASS);
        this.context.getEventBus().unregisterListener(this);
        this.context.getDeviceManager().removeActiveDeviceListener(this);
    }

    public void updatePhoneState(PhoneStateChangedEvent phoneStateChangedEvent) {
        this.phoneStateChanged.accept(phoneStateChangedEvent);
    }

    public void updateActiveDeviceState(TMDevice tMDevice) {
        this.activeDevice.accept(tMDevice);
    }
}

