/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.interapp;

import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.device.TMDevice;
import de.audi.app.terminalmode.events.DefaultEventListener;
import de.audi.app.terminalmode.events.IEventBus;
import de.audi.app.terminalmode.osgi.IServiceManager;
import de.audi.app.terminalmode.osgi.IServiceTracker;
import de.audi.atip.interapp.IBluetoothService;
import de.audi.atip.log.LogChannel;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

public class BluetoothWaker
extends DefaultEventListener
implements ITerminalModeComponent {
    private static final String LOGCLASS = "BluetoothWaker";
    private final LogChannel logger;
    private volatile IBluetoothService bluetoothService = new NullBluetoothService();
    private final IServiceTracker serviceTracker;
    private final IEventBus eventBus;
    static /* synthetic */ Class class$de$audi$atip$interapp$IBluetoothService;

    public BluetoothWaker(final IServiceManager iServiceManager, IEventBus iEventBus, LogChannel logChannel) {
        this.eventBus = iEventBus;
        this.logger = logChannel;
        this.serviceTracker = iServiceManager.createServiceTracker(class$de$audi$atip$interapp$IBluetoothService == null ? (class$de$audi$atip$interapp$IBluetoothService = BluetoothWaker.class$("de.audi.atip.interapp.IBluetoothService")) : class$de$audi$atip$interapp$IBluetoothService, new ServiceTrackerCustomizer(){

            public void removedService(ServiceReference serviceReference, Object object) {
                BluetoothWaker.this.bluetoothService = new NullBluetoothService();
            }

            public void modifiedService(ServiceReference serviceReference, Object object) {
            }

            public Object addingService(ServiceReference serviceReference) {
                BluetoothWaker.this.bluetoothService = (IBluetoothService)iServiceManager.getService(serviceReference);
                return BluetoothWaker.this.bluetoothService;
            }
        });
    }

    public void init() {
        this.serviceTracker.open();
        this.eventBus.registerListener(this);
    }

    public void deinit() {
        this.serviceTracker.close();
        this.eventBus.unregisterListener(this);
    }

    public void deviceActivated(TMDevice tMDevice) {
        if (tMDevice.isAndroidAutoDevice()) {
            this.logger.log(1000000, "[%1.deviceActivated] AndroidAuto device active -> request activate bluetooth", (Object)LOGCLASS);
            this.bluetoothService.activateBluetooth();
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    private final class NullBluetoothService
    implements IBluetoothService {
        private NullBluetoothService() {
        }

        public void disconnectService(String string, int n) {
        }

        public void deactivateBluetoothAudio() {
        }

        public void connectService(String string, int n, String string2, boolean bl) {
        }

        public void activateBluetoothAudio() {
        }

        public void activateBluetooth() {
        }
    }
}

