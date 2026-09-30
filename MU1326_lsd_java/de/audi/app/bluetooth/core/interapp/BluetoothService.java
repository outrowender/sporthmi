/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core.interapp;

import de.audi.app.bluetooth.core.IBluetoothApplication;
import de.audi.app.connectivity.core.IApplicationComponent;
import de.audi.atip.interapp.IBluetoothService;
import org.osgi.framework.ServiceRegistration;

public class BluetoothService
implements IBluetoothService,
IApplicationComponent {
    private final IBluetoothApplication bluetooth;
    private ServiceRegistration registration;
    static /* synthetic */ Class class$de$audi$atip$interapp$IBluetoothService;

    public BluetoothService(IBluetoothApplication iBluetoothApplication) {
        this.bluetooth = iBluetoothApplication;
    }

    public void activateBluetooth() {
        this.bluetooth.getAccessibility().activateBluetooth();
    }

    public void activateBluetoothAudio() {
        this.bluetooth.getAudio().requestSetA2DPUserSetting(true);
    }

    public void deactivateBluetoothAudio() {
        this.bluetooth.getAudio().requestSetA2DPUserSetting(false);
    }

    public void connectService(String string, int n, String string2, boolean bl) {
        this.bluetooth.getConnection().connectService(string, n, string2, bl);
    }

    public void disconnectService(String string, int n) {
        this.bluetooth.getConnection().disconnectService(string, n);
    }

    public void init() {
        this.registration = this.bluetooth.getBundleContext().registerService((class$de$audi$atip$interapp$IBluetoothService == null ? (class$de$audi$atip$interapp$IBluetoothService = BluetoothService.class$("de.audi.atip.interapp.IBluetoothService")) : class$de$audi$atip$interapp$IBluetoothService).getName(), (Object)this, null);
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

