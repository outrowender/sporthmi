/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.interapp;

import de.audi.app.terminalmode.ITerminalModeComponent;
import de.audi.app.terminalmode.device.TMDevice;
import de.audi.app.terminalmode.events.DefaultEventListener;
import de.audi.app.terminalmode.events.IEventBus;
import de.audi.app.terminalmode.interapp.BluetoothWaker$1;
import de.audi.app.terminalmode.interapp.BluetoothWaker$NullBluetoothService;
import de.audi.app.terminalmode.osgi.IServiceManager;
import de.audi.app.terminalmode.osgi.IServiceTracker;
import de.audi.atip.interapp.IBluetoothService;
import de.audi.atip.log.LogChannel;

public class BluetoothWaker
extends DefaultEventListener
implements ITerminalModeComponent {
    private static final String LOGCLASS;
    private final LogChannel logger;
    private volatile IBluetoothService bluetoothService = new BluetoothWaker$NullBluetoothService(this, null);
    private final IServiceTracker serviceTracker;
    private final IEventBus eventBus;
    static /* synthetic */ Class class$de$audi$atip$interapp$IBluetoothService;

    public BluetoothWaker(IServiceManager iServiceManager, IEventBus iEventBus, LogChannel logChannel) {
        this.eventBus = iEventBus;
        this.logger = logChannel;
        this.serviceTracker = iServiceManager.createServiceTracker(class$de$audi$atip$interapp$IBluetoothService == null ? (class$de$audi$atip$interapp$IBluetoothService = BluetoothWaker.class$("de.audi.atip.interapp.IBluetoothService")) : class$de$audi$atip$interapp$IBluetoothService, new BluetoothWaker$1(this, iServiceManager));
    }

    @Override
    public void init() {
        this.serviceTracker.open();
        this.eventBus.registerListener(this);
    }

    @Override
    public void deinit() {
        this.serviceTracker.close();
        this.eventBus.unregisterListener(this);
    }

    @Override
    public void deviceActivated(TMDevice tMDevice) {
        if (tMDevice.isAndroidAutoDevice()) {
            this.logger.log(1078071040, "[%1.deviceActivated] AndroidAuto device active -> request activate bluetooth", (Object)"BluetoothWaker");
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

    static /* synthetic */ IBluetoothService access$102(BluetoothWaker bluetoothWaker, IBluetoothService iBluetoothService) {
        bluetoothWaker.bluetoothService = iBluetoothService;
        return bluetoothWaker.bluetoothService;
    }

    static /* synthetic */ IBluetoothService access$100(BluetoothWaker bluetoothWaker) {
        return bluetoothWaker.bluetoothService;
    }
}

