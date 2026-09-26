/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.eni;

import de.audi.app.eni.ENIGateway;

class ENIGateway$9
implements Runnable {
    private final /* synthetic */ ENIGateway this$0;

    ENIGateway$9(ENIGateway eNIGateway) {
        this.this$0 = eNIGateway;
    }

    @Override
    public void run() {
        this.this$0.handleEcallLicenceWarning();
    }
}

