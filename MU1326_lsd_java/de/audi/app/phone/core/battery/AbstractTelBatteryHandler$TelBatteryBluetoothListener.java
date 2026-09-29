/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.battery;

import de.audi.app.phone.core.battery.AbstractTelBatteryHandler;
import de.audi.app.phone.core.battery.AbstractTelBatteryHandler$1;
import de.audi.app.phone.core.bluetooth.ITelBluetoothListener;
import java.util.LinkedList;
import org.dsi.ifc.bluetooth.TrustedDevice;

class AbstractTelBatteryHandler$TelBatteryBluetoothListener
implements ITelBluetoothListener {
    private final /* synthetic */ AbstractTelBatteryHandler this$0;

    private AbstractTelBatteryHandler$TelBatteryBluetoothListener(AbstractTelBatteryHandler abstractTelBatteryHandler) {
        this.this$0 = abstractTelBatteryHandler;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void updateTrustedDevices(TrustedDevice[] trustedDeviceArray) {
        if (trustedDeviceArray != null) {
            for (int i2 = 0; i2 < trustedDeviceArray.length; ++i2) {
                TrustedDevice trustedDevice = trustedDeviceArray[i2];
                if (trustedDevice == null) continue;
                boolean bl = AbstractTelBatteryHandler.access$100(trustedDevice);
                String string = trustedDevice.getDeviceAddress();
                if (bl) {
                    AbstractTelBatteryHandler.access$200(this.this$0).log(-2137614336, "[AbstractTelBatteryHandler.TelBatteryBluetoothListener#updateTrustedDevices] %1 connected via HFP or SAP", (Object)string);
                } else {
                    AbstractTelBatteryHandler.access$300(this.this$0).log(-2137614336, "[AbstractTelBatteryHandler.TelBatteryBluetoothListener#updateTrustedDevices] %1 not connected via HFP or SAP", (Object)string);
                }
                LinkedList linkedList = AbstractTelBatteryHandler.access$400(this.this$0);
                synchronized (linkedList) {
                    if (bl) {
                        if (!AbstractTelBatteryHandler.access$400(this.this$0).contains(string)) {
                            AbstractTelBatteryHandler.access$400(this.this$0).add(string);
                        }
                    } else if (AbstractTelBatteryHandler.access$400(this.this$0).contains(string)) {
                        AbstractTelBatteryHandler.access$400(this.this$0).remove(string);
                    }
                    continue;
                }
            }
        } else {
            AbstractTelBatteryHandler.access$500(this.this$0).log(10000, "AbstractTelBatteryHandler.TelBatteryBluetoothListener#updateTrustedDevices trustedDevices is null");
        }
    }

    /* synthetic */ AbstractTelBatteryHandler$TelBatteryBluetoothListener(AbstractTelBatteryHandler abstractTelBatteryHandler, AbstractTelBatteryHandler$1 abstractTelBatteryHandler$1) {
        this(abstractTelBatteryHandler);
    }
}

