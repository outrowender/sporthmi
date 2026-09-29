/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.eni;

import de.audi.app.eni.ENIGateway;
import de.audi.atip.interapp.eni.ENIMobileKeyListener;

class ENIGateway$7
implements Runnable {
    private final /* synthetic */ ENIMobileKeyListener val$eniMobileKeyListener;
    private final /* synthetic */ ENIGateway this$0;

    ENIGateway$7(ENIGateway eNIGateway, ENIMobileKeyListener eNIMobileKeyListener) {
        this.this$0 = eNIGateway;
        this.val$eniMobileKeyListener = eNIMobileKeyListener;
    }

    @Override
    public void run() {
        ENIGateway.access$1502(this.this$0, this.val$eniMobileKeyListener);
        if (ENIGateway.access$1600(this.this$0) != null) {
            this.val$eniMobileKeyListener.onMobileDeviceKeyCount(ENIGateway.access$1600(this.this$0));
        }
    }
}

