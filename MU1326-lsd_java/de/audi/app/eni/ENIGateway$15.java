/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.eni;

import de.audi.app.eni.ENIGateway;

class ENIGateway$15
implements Runnable {
    private final /* synthetic */ ENIGateway this$0;

    ENIGateway$15(ENIGateway eNIGateway) {
        this.this$0 = eNIGateway;
    }

    @Override
    public void run() {
        ENIGateway.access$2000(this.this$0, 2, true);
        ENIGateway.access$800(this.this$0).remoteProcessConfirmExpirationWarningForService(ENIGateway.access$2100(this.this$0));
    }
}

