/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.bluetooth.core.interapp;

import de.audi.app.bluetooth.core.IBluetoothApplication;
import de.audi.app.connectivity.core.IApplicationComponent;
import de.audi.atip.interapp.ecall.IEcallBluetoothService;
import org.osgi.framework.ServiceRegistration;

public class EcallBluetoothServiceImpl
implements IEcallBluetoothService,
IApplicationComponent {
    private final IBluetoothApplication bluetooth;
    private ServiceRegistration registration;
    static /* synthetic */ Class class$de$audi$atip$interapp$ecall$IEcallBluetoothService;

    public EcallBluetoothServiceImpl(IBluetoothApplication iBluetoothApplication) {
        this.bluetooth = iBluetoothApplication;
    }

    public void switchOnBluetooth() {
        this.bluetooth.getLogChannel().log(1000000, "EcallBluetoothServiceImpl#switchOnBluetooth(): called");
        this.bluetooth.getAccessibility().setAccessibleMode(3);
    }

    public void switchOffBluetooth() {
        this.bluetooth.getLogChannel().log(1000000, "EcallBluetoothServiceImpl#switchOffBluetooth(): called");
        this.bluetooth.getAccessibility().setAccessibleMode(2);
    }

    public void init() {
        this.registration = this.bluetooth.getBundleContext().registerService((class$de$audi$atip$interapp$ecall$IEcallBluetoothService == null ? (class$de$audi$atip$interapp$ecall$IEcallBluetoothService = EcallBluetoothServiceImpl.class$("de.audi.atip.interapp.ecall.IEcallBluetoothService")) : class$de$audi$atip$interapp$ecall$IEcallBluetoothService).getName(), (Object)this, null);
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

