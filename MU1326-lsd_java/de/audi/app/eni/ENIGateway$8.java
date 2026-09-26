/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.eni;

import de.audi.app.eni.ENIGateway;
import de.audi.atip.interapp.eni.ENIMobileKeyStatusDisplayListener;

class ENIGateway$8
implements Runnable {
    private final /* synthetic */ ENIMobileKeyStatusDisplayListener val$eniMobileKeyStatusDisplayListener;
    private final /* synthetic */ ENIGateway this$0;

    ENIGateway$8(ENIGateway eNIGateway, ENIMobileKeyStatusDisplayListener eNIMobileKeyStatusDisplayListener) {
        this.this$0 = eNIGateway;
        this.val$eniMobileKeyStatusDisplayListener = eNIMobileKeyStatusDisplayListener;
    }

    @Override
    public void run() {
        ENIGateway.access$1702(this.this$0, this.val$eniMobileKeyStatusDisplayListener);
        this.val$eniMobileKeyStatusDisplayListener.onFleetModeAvailability(ENIGateway.access$1800(this.this$0));
        if (ENIGateway.access$1900(this.this$0) != null) {
            this.val$eniMobileKeyStatusDisplayListener.onMobDevKeySetup(ENIGateway.access$1900(this.this$0));
        }
        if (ENIGateway.access$1600(this.this$0) != null) {
            this.val$eniMobileKeyStatusDisplayListener.onMobileDeviceKeyCount(ENIGateway.access$1600(this.this$0));
        }
    }
}

