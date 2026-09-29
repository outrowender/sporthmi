/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode;

import de.audi.app.terminalmode.AutomaticDeviceActivator$ActiveDeviceStateListener;
import de.audi.app.terminalmode.AutomaticDeviceActivator$EventListener;
import de.audi.app.terminalmode.AutomaticDeviceActivator$LastModeTracker;
import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.ITerminalModeConfiguration;
import de.audi.app.terminalmode.device.IDeviceManager;
import de.audi.app.terminalmode.device.TMDevice;
import de.audi.app.terminalmode.events.IEventBus;
import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.atip.utils.reactive.properties.Preference;
import de.audi.atip.utils.reactive.properties.StorageAccessPreferencesFactory;
import de.esolutions.fw.util.commons.job.DispatcherBase;

public class AutomaticDeviceActivator
implements ITerminalModeComponent {
    private static final String LOGCLASS;
    public static final long LASTMODE_TRACKING_DURATION;
    private static final String LASTMODE_ID_SEPARATOR_SYMBOL;
    private static final String NO_LASTMODE_ID;
    private final LogChannel logger;
    private final IDeviceManager deviceManager;
    private final ITerminalModeConfiguration configuration;
    private final AutomaticDeviceActivator$ActiveDeviceStateListener activeDeviceListener;
    private final IEventBus eventBus;
    private volatile TMDevice activeDevice = TMDevice.INVALID;
    private final AutomaticDeviceActivator$EventListener eventListener;
    private final AutomaticDeviceActivator$LastModeTracker lastModeEventListener;
    private final Preference activeDevicePreference;
    private final DispatcherBase dispatcher;

    public AutomaticDeviceActivator(LogChannel logChannel, ITerminalModeConfiguration iTerminalModeConfiguration, IDeviceManager iDeviceManager, IEventBus iEventBus, IStorageAccess iStorageAccess, DispatcherBase dispatcherBase) {
        this.logger = logChannel;
        this.deviceManager = iDeviceManager;
        this.configuration = iTerminalModeConfiguration;
        this.eventBus = iEventBus;
        this.activeDevicePreference = StorageAccessPreferencesFactory.create(logChannel, iStorageAccess).createStringPreference("activeDevicePreference", 1008, 3, "no_lastmode_id");
        this.dispatcher = dispatcherBase;
        this.activeDeviceListener = new AutomaticDeviceActivator$ActiveDeviceStateListener(this, null);
        this.eventListener = new AutomaticDeviceActivator$EventListener(this, null);
        this.lastModeEventListener = new AutomaticDeviceActivator$LastModeTracker(this, null);
    }

    @Override
    public void init() {
        this.deviceManager.addActiveDeviceListener(this.activeDeviceListener);
        if (!this.configuration.isAutoConnect()) {
            this.lastModeEventListener.startLastmodeTracking();
        } else {
            this.eventBus.registerListener(this.eventListener);
        }
    }

    @Override
    public void deinit() {
        this.lastModeEventListener.stopLastmodeTracking();
        this.deviceManager.removeActiveDeviceListener(this.activeDeviceListener);
        this.eventBus.unregisterListener(this.eventListener);
    }

    private String getLastModeId(TMDevice tMDevice, boolean bl) {
        if (bl) {
            return tMDevice.getUniqueID().address;
        }
        return new StringBuffer().append(tMDevice.getUniqueID().address).append("#").append(tMDevice.smartphoneType().ordinal()).toString();
    }

    static /* synthetic */ ITerminalModeConfiguration access$300(AutomaticDeviceActivator automaticDeviceActivator) {
        return automaticDeviceActivator.configuration;
    }

    static /* synthetic */ TMDevice access$400(AutomaticDeviceActivator automaticDeviceActivator) {
        return automaticDeviceActivator.activeDevice;
    }

    static /* synthetic */ Preference access$500(AutomaticDeviceActivator automaticDeviceActivator) {
        return automaticDeviceActivator.activeDevicePreference;
    }

    static /* synthetic */ String access$600(AutomaticDeviceActivator automaticDeviceActivator, TMDevice tMDevice, boolean bl) {
        return automaticDeviceActivator.getLastModeId(tMDevice, bl);
    }

    static /* synthetic */ LogChannel access$700(AutomaticDeviceActivator automaticDeviceActivator) {
        return automaticDeviceActivator.logger;
    }

    static /* synthetic */ IDeviceManager access$800(AutomaticDeviceActivator automaticDeviceActivator) {
        return automaticDeviceActivator.deviceManager;
    }

    static /* synthetic */ TMDevice access$402(AutomaticDeviceActivator automaticDeviceActivator, TMDevice tMDevice) {
        automaticDeviceActivator.activeDevice = tMDevice;
        return automaticDeviceActivator.activeDevice;
    }

    static /* synthetic */ IEventBus access$900(AutomaticDeviceActivator automaticDeviceActivator) {
        return automaticDeviceActivator.eventBus;
    }

    static /* synthetic */ AutomaticDeviceActivator$LastModeTracker access$1000(AutomaticDeviceActivator automaticDeviceActivator) {
        return automaticDeviceActivator.lastModeEventListener;
    }

    static /* synthetic */ DispatcherBase access$1400(AutomaticDeviceActivator automaticDeviceActivator) {
        return automaticDeviceActivator.dispatcher;
    }

    static /* synthetic */ AutomaticDeviceActivator$EventListener access$1500(AutomaticDeviceActivator automaticDeviceActivator) {
        return automaticDeviceActivator.eventListener;
    }
}

