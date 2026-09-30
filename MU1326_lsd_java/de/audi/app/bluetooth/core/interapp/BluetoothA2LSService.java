/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core.interapp;

import de.audi.app.bluetooth.core.IBluetoothApplication;
import de.audi.app.connectivity.core.IApplicationComponent;
import de.audi.atip.interapp.IBluetoothA2LSService;
import org.osgi.framework.ServiceRegistration;

public class BluetoothA2LSService
implements IBluetoothA2LSService,
IApplicationComponent {
    private final IBluetoothApplication bluetooth;
    private ServiceRegistration registration;
    static /* synthetic */ Class class$de$audi$atip$interapp$IBluetoothA2LSService;

    public BluetoothA2LSService(IBluetoothApplication iBluetoothApplication) {
        this.bluetooth = iBluetoothApplication;
    }

    public void updateA2LSActive(boolean bl) {
        if (bl) {
            this.bluetooth.getReconnect().setAutomaticReconnect(false);
        } else {
            this.bluetooth.getReconnect().setAutomaticReconnect(true);
        }
    }

    public void init() {
        this.registration = this.bluetooth.getBundleContext().registerService((class$de$audi$atip$interapp$IBluetoothA2LSService == null ? (class$de$audi$atip$interapp$IBluetoothA2LSService = BluetoothA2LSService.class$("de.audi.atip.interapp.IBluetoothA2LSService")) : class$de$audi$atip$interapp$IBluetoothA2LSService).getName(), (Object)this, null);
    }

    public void deinit() {
        this.registration.unregister();
        this.registration = null;
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

