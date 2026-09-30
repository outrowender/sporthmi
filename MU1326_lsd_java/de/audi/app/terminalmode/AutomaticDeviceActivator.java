/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode;

import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.ITerminalModeConfiguration;
import de.audi.app.terminalmode.device.IActiveDeviceStateListener;
import de.audi.app.terminalmode.device.IDeviceManager;
import de.audi.app.terminalmode.device.TMDevice;
import de.audi.app.terminalmode.events.DefaultEventListener;
import de.audi.app.terminalmode.events.IEventBus;
import de.audi.atip.log.LogChannel;
import de.audi.atip.storage.IStorageAccess;
import de.audi.atip.utils.collections.Optional;
import de.audi.atip.utils.collections.Predicate;
import de.audi.atip.utils.generics.GList;
import de.audi.atip.utils.generics.Generics;
import de.audi.atip.utils.reactive.properties.Preference;
import de.audi.atip.utils.reactive.properties.StorageAccessPreferencesFactory;
import de.esolutions.fw.util.commons.job.DispatcherBase;
import de.esolutions.fw.util.commons.job.Job;

public class AutomaticDeviceActivator
implements ITerminalModeComponent {
    private static final String LOGCLASS = "AutomaticDeviceActivator";
    public static final long LASTMODE_TRACKING_DURATION = 20000L;
    private static final String LASTMODE_ID_SEPARATOR_SYMBOL = "#";
    private static final String NO_LASTMODE_ID = "no_lastmode_id";
    private final LogChannel logger;
    private final IDeviceManager deviceManager;
    private final ITerminalModeConfiguration configuration;
    private final ActiveDeviceStateListener activeDeviceListener;
    private final IEventBus eventBus;
    private volatile TMDevice activeDevice = TMDevice.INVALID;
    private final EventListener eventListener;
    private final LastModeTracker lastModeEventListener;
    private final Preference<String> activeDevicePreference;
    private final DispatcherBase dispatcher;

    public AutomaticDeviceActivator(LogChannel logChannel, ITerminalModeConfiguration iTerminalModeConfiguration, IDeviceManager iDeviceManager, IEventBus iEventBus, IStorageAccess iStorageAccess, DispatcherBase dispatcherBase) {
        this.logger = logChannel;
        this.deviceManager = iDeviceManager;
        this.configuration = iTerminalModeConfiguration;
        this.eventBus = iEventBus;
        this.activeDevicePreference = StorageAccessPreferencesFactory.create(logChannel, iStorageAccess).createStringPreference("activeDevicePreference", 1008, 3, NO_LASTMODE_ID);
        this.dispatcher = dispatcherBase;
        this.activeDeviceListener = new ActiveDeviceStateListener();
        this.eventListener = new EventListener();
        this.lastModeEventListener = new LastModeTracker();
    }

    public void init() {
        this.deviceManager.addActiveDeviceListener(this.activeDeviceListener);
        if (!this.configuration.isAutoConnect()) {
            this.lastModeEventListener.startLastmodeTracking();
        } else {
            this.eventBus.registerListener(this.eventListener);
        }
    }

    public void deinit() {
        this.lastModeEventListener.stopLastmodeTracking();
        this.deviceManager.removeActiveDeviceListener(this.activeDeviceListener);
        this.eventBus.unregisterListener(this.eventListener);
    }

    private String getLastModeId(TMDevice tMDevice, boolean bl) {
        if (bl) {
            return tMDevice.getUniqueID().address;
        }
        return new StringBuffer().append(tMDevice.getUniqueID().address).append(LASTMODE_ID_SEPARATOR_SYMBOL).append(tMDevice.smartphoneType().ordinal()).toString();
    }

    private final class EventListener
    extends DefaultEventListener {
        private EventListener() {
        }

        public void readyForActivation(TMDevice tMDevice) {
            boolean bl;
            boolean bl2 = bl = tMDevice.userAcceptState().is(TMDevice.UserAcceptState.DISCLAIMER_ACCEPTED) || AutomaticDeviceActivator.this.configuration.isAutoConnect();
            if (bl) {
                if (!AutomaticDeviceActivator.this.activeDevice.isValid()) {
                    String string;
                    String string2 = (String)AutomaticDeviceActivator.this.activeDevicePreference.get();
                    int n = string2.lastIndexOf(AutomaticDeviceActivator.LASTMODE_ID_SEPARATOR_SYMBOL);
                    String string3 = string = n == -1 ? string2 : string2.substring(0, n);
                    if (string2.equals(AutomaticDeviceActivator.NO_LASTMODE_ID) || !string.equals(tMDevice.getUniqueID().address) || string2.equals(AutomaticDeviceActivator.this.getLastModeId(tMDevice, false))) {
                        AutomaticDeviceActivator.this.logger.log(1000000, "<!> [%1.EventListener.readyForActivation] Activate known detected device %2 as %3", (Object)AutomaticDeviceActivator.LOGCLASS, (Object)tMDevice, (long)tMDevice.smartphoneType().ordinal());
                        AutomaticDeviceActivator.this.deviceManager.control(tMDevice).activateDevice();
                    }
                } else {
                    AutomaticDeviceActivator.this.logger.log(1000000, "[%1.EventListener.readyForActivation] already active - %2", (Object)AutomaticDeviceActivator.LOGCLASS, (Object)AutomaticDeviceActivator.this.activeDevice);
                    AutomaticDeviceActivator.this.logger.log(1000000, "<!> [%1.EventListener.readyForActivation] cannot be activated right now - %2", (Object)AutomaticDeviceActivator.LOGCLASS, (Object)tMDevice);
                    AutomaticDeviceActivator.this.deviceManager.control(tMDevice).deactivateDevice();
                }
            }
        }
    }

    private class LastModeTracker
    extends DefaultEventListener
    implements IActiveDeviceStateListener {
        private volatile Job lastModeTimer = new Job("");
        private final GList<TMDevice> devicesSkippedDuringLastmodeTracking = Generics.newArrayList();

        private LastModeTracker() {
        }

        public void updateActiveDeviceState(TMDevice tMDevice) {
            if (tMDevice.isActive()) {
                this.startNormalOperation();
            }
        }

        public void stopLastmodeTracking() {
            this.lastModeTimer.cancel();
            AutomaticDeviceActivator.this.eventBus.unregisterListener(this);
            AutomaticDeviceActivator.this.deviceManager.removeActiveDeviceListener(this);
            this.devicesSkippedDuringLastmodeTracking.clear();
        }

        public void startLastmodeTracking() {
            AutomaticDeviceActivator.this.deviceManager.addActiveDeviceListener(AutomaticDeviceActivator.this.lastModeEventListener);
            AutomaticDeviceActivator.this.eventBus.registerListener(AutomaticDeviceActivator.this.lastModeEventListener);
            this.lastModeTimer = AutomaticDeviceActivator.this.dispatcher.execute(new Runnable(){

                public void run() {
                    Optional<TMDevice> optional = LastModeTracker.this.devicesSkippedDuringLastmodeTracking.fluent().tryFind(new Predicate<TMDevice>(){

                        @Override
                        public boolean apply(TMDevice tMDevice) {
                            return tMDevice.connectionState().is(TMDevice.ConnectionState.ATTACHED) && tMDevice.userAcceptState().is(TMDevice.UserAcceptState.DISCLAIMER_ACCEPTED);
                        }

                        @Override
                        public /* synthetic */ boolean apply(Object object) {
                            return this.apply((TMDevice)object);
                        }
                    });
                    if (optional.exists()) {
                        AutomaticDeviceActivator.this.logger.log(1000000, "<!> [%1.LastModeHandler.lastModeTimer.run] Activate device which was skipped during lastmode tracking - %2", (Object)AutomaticDeviceActivator.LOGCLASS, optional);
                        AutomaticDeviceActivator.this.deviceManager.control(optional.get()).activateDevice();
                    }
                    AutomaticDeviceActivator.this.logger.log(1000000, "[%1.LastModeHandler.lastModeTimer.run] Last mode tracking is finished. Resuming normal operation.", (Object)AutomaticDeviceActivator.LOGCLASS);
                    LastModeTracker.this.startNormalOperation();
                }
            }, 20000L);
        }

        public void readyForActivation(TMDevice tMDevice) {
            boolean bl;
            boolean bl2 = bl = tMDevice.userAcceptState().is(TMDevice.UserAcceptState.DISCLAIMER_ACCEPTED) || AutomaticDeviceActivator.this.configuration.isAutoConnect();
            if (bl) {
                boolean bl3;
                String string = (String)AutomaticDeviceActivator.this.activeDevicePreference.get();
                String string2 = String.valueOf(tMDevice.smartphoneType().ordinal());
                int n = string.lastIndexOf(AutomaticDeviceActivator.LASTMODE_ID_SEPARATOR_SYMBOL);
                boolean bl4 = n == -1 || n != string.length() - string2.length() - 1;
                boolean bl5 = bl3 = string.equals(AutomaticDeviceActivator.this.getLastModeId(tMDevice, bl4)) || string.equals(AutomaticDeviceActivator.NO_LASTMODE_ID);
                if (bl3) {
                    AutomaticDeviceActivator.this.logger.log(1000000, "<!> [%1.LastModeHandler.readyForActivation] Activate lastmode device %2", (Object)AutomaticDeviceActivator.LOGCLASS, (Object)tMDevice);
                    AutomaticDeviceActivator.this.deviceManager.control(tMDevice).activateDevice();
                    this.startNormalOperation();
                } else {
                    AutomaticDeviceActivator.this.logger.log(1000000, "<!> [%1.LastModeHandler.readyForActivation] device ready, but we are waiting for lastmode (%2) - %3", (Object)AutomaticDeviceActivator.LOGCLASS, (Object)string, (Object)tMDevice);
                    this.devicesSkippedDuringLastmodeTracking.add(tMDevice);
                    AutomaticDeviceActivator.this.deviceManager.control(tMDevice).deactivateDevice();
                }
            }
        }

        private void startNormalOperation() {
            this.stopLastmodeTracking();
            AutomaticDeviceActivator.this.dispatcher.execute(new Runnable(){

                public void run() {
                    AutomaticDeviceActivator.this.eventBus.registerListener(AutomaticDeviceActivator.this.eventListener);
                }
            });
        }
    }

    private class ActiveDeviceStateListener
    implements IActiveDeviceStateListener {
        private ActiveDeviceStateListener() {
        }

        public void updateActiveDeviceState(TMDevice tMDevice) {
            AutomaticDeviceActivator.this.activeDevice = tMDevice;
            if (AutomaticDeviceActivator.this.activeDevice.isActive()) {
                AutomaticDeviceActivator.this.activeDevicePreference.store(AutomaticDeviceActivator.this.getLastModeId(tMDevice, false));
            }
        }
    }
}

