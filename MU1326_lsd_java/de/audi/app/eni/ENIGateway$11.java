/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.eni;

import de.audi.app.eni.ENIGateway;

class ENIGateway$11
implements Runnable {
    private final /* synthetic */ ENIGateway this$0;

    ENIGateway$11(ENIGateway eNIGateway) {
        this.this$0 = eNIGateway;
    }

    @Override
    public void run() {
        ENIGateway.access$800(this.this$0).remoteProcessDeleteUserList();
    }
}

