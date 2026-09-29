/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.adb;

import de.audi.app.phone.core.adb.TelADBDownloadInquiryHandler;
import de.audi.app.phone.core.bluetooth.ITelBluetoothListener;
import org.dsi.ifc.bluetooth.TrustedDevice;

class TelADBDownloadInquiryHandler$BluetoothListener
implements ITelBluetoothListener {
    private final /* synthetic */ TelADBDownloadInquiryHandler this$0;

    TelADBDownloadInquiryHandler$BluetoothListener(TelADBDownloadInquiryHandler telADBDownloadInquiryHandler) {
        this.this$0 = telADBDownloadInquiryHandler;
    }

    @Override
    public void updateTrustedDevices(TrustedDevice[] trustedDeviceArray) {
        TelADBDownloadInquiryHandler.access$102(this.this$0, trustedDeviceArray);
        TelADBDownloadInquiryHandler.access$200(this.this$0);
    }
}

