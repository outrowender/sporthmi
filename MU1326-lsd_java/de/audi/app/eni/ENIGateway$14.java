/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.eni;

import de.audi.app.eni.ENIGateway;

class ENIGateway$14
implements Runnable {
    private final /* synthetic */ ENIGateway this$0;

    ENIGateway$14(ENIGateway eNIGateway) {
        this.this$0 = eNIGateway;
    }

    @Override
    public void run() {
        ENIGateway.access$2000(this.this$0, 1, true);
        ENIGateway.access$800(this.this$0).remoteProcessConfirmExpirationWarningForService(ENIGateway.access$2100(this.this$0));
    }
}

