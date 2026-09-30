/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.bap.sos;

import de.audi.app.ecall.core.AbstractEcallComponent;
import de.audi.app.ecall.core.IEcallApplication;
import de.audi.app.ecall.core.osgi.EcallServiceTracker;
import de.audi.atip.interapp.ecall.IEcallBluetoothService;
import de.audi.atip.interapp.ecall.NullEcallBluetoothService;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class EcallBluetoothHandler
extends AbstractEcallComponent
implements ServiceTrackerCustomizer {
    private IEcallBluetoothService ecallBluetoothService = new NullEcallBluetoothService(this.getLogger());
    private final EcallServiceTracker bluetoothServiceEcallTracker = new EcallServiceTracker(this.getApplication().getBundleContext(), (class$de$audi$atip$interapp$ecall$IEcallBluetoothService == null ? (class$de$audi$atip$interapp$ecall$IEcallBluetoothService = EcallBluetoothHandler.class$("de.audi.atip.interapp.ecall.IEcallBluetoothService")) : class$de$audi$atip$interapp$ecall$IEcallBluetoothService).getName(), (ServiceTrackerCustomizer)this, this.log);
    static /* synthetic */ Class class$de$audi$atip$interapp$ecall$IEcallBluetoothService;

    EcallBluetoothHandler(IEcallApplication iEcallApplication) {
        super(iEcallApplication, "App.Ecall.Main");
    }

    public void init() {
        this.bluetoothServiceEcallTracker.openTracker();
    }

    public void deinit() {
        this.bluetoothServiceEcallTracker.closeTracker();
    }

    public void switchOnBluetooth() {
        this.log.log(1000000, "EcallBluetoothHandler#switchOnBluetooth(): called");
        this.ecallBluetoothService.switchOnBluetooth();
    }

    public void switchOffBluetooth() {
        this.log.log(1000000, "EcallBluetoothHandler#switchOffBluetooth(): called");
        this.ecallBluetoothService.switchOffBluetooth();
    }

    public Object addingService(ServiceReference serviceReference) {
        Object object = this.getApplication().getBundleContext().getService(serviceReference);
        if (object instanceof IEcallBluetoothService) {
            this.ecallBluetoothService = (IEcallBluetoothService)object;
            return object;
        }
        this.getApplication().getBundleContext().ungetService(serviceReference);
        return null;
    }

    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    public void removedService(ServiceReference serviceReference, Object object) {
        if (object instanceof IEcallBluetoothService) {
            this.ecallBluetoothService = new NullEcallBluetoothService(this.log);
            this.getApplication().getBundleContext().ungetService(serviceReference);
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
}

