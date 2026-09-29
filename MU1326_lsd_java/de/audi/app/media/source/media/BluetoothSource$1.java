/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.source.media;

import de.audi.app.media.source.media.BluetoothSource;
import de.audi.atip.interapp.IBluetoothService;
import org.osgi.framework.ServiceReference;
import org.osgi.util.tracker.ServiceTrackerCustomizer;

class BluetoothSource$1
implements ServiceTrackerCustomizer {
    private final /* synthetic */ BluetoothSource this$0;

    BluetoothSource$1(BluetoothSource bluetoothSource) {
        this.this$0 = bluetoothSource;
    }

    @Override
    public void removedService(ServiceReference serviceReference, Object object) {
        BluetoothSource.access$000(this.this$0).main().log(1078071040, "[%1.removedService] Bluetooth service removed.", (Object)"BluetoothSource");
        this.this$0.getTerminal().getServiceManager().releaseService(serviceReference);
        BluetoothSource.access$102(this.this$0, null);
        BluetoothSource.access$202(this.this$0, null);
    }

    @Override
    public Object addingService(ServiceReference serviceReference) {
        IBluetoothService iBluetoothService = (IBluetoothService)this.this$0.getTerminal().getServiceManager().getService(serviceReference);
        BluetoothSource.access$300(this.this$0).main().log(1078071040, "[%1.addingService] '%2'.", (Object)"BluetoothSource", (Object)iBluetoothService);
        BluetoothSource.access$102(this.this$0, iBluetoothService);
        return iBluetoothService;
    }

    @Override
    public void modifiedService(ServiceReference serviceReference, Object object) {
    }
}

