/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.interapp;

import de.audi.app.terminalmode.interapp.BluetoothWaker;
import de.audi.app.terminalmode.interapp.BluetoothWaker$NullBluetoothService;
import de.audi.app.terminalmode.osgi.IServiceManager;
import de.audi.atip.interapp.IBluetoothService;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class BluetoothWaker$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ IServiceManager val$serviceManager;
    private final /* synthetic */ BluetoothWaker this$0;

    BluetoothWaker$1(BluetoothWaker bluetoothWaker, IServiceManager iServiceManager) {
        this.this$0 = bluetoothWaker;
        this.val$serviceManager = iServiceManager;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        BluetoothWaker.access$102(this.this$0, new BluetoothWaker$NullBluetoothService(this.this$0, null));
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        BluetoothWaker.access$102(this.this$0, (IBluetoothService)this.val$serviceManager.getService(serviceReference));
        return BluetoothWaker.access$100(this.this$0);
    }
}

