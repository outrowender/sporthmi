/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.eni;

import de.audi.app.eni.ENIGateway;
import de.audi.atip.interapp.bap.eni.data.Service;

class ENIGateway$13
implements Runnable {
    private final /* synthetic */ Service val$service;
    private final /* synthetic */ ENIGateway this$0;

    ENIGateway$13(ENIGateway eNIGateway, Service service) {
        this.this$0 = eNIGateway;
        this.val$service = service;
    }

    @Override
    public void run() {
        ENIGateway.access$800(this.this$0).disableService(this.val$service);
    }
}

