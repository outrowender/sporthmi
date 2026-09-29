/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.eni;

import de.audi.app.eni.ENIGateway;
import de.audi.atip.interapp.bap.eni.data.Service;

class ENIGateway$2
implements Runnable {
    private final /* synthetic */ Service[] val$services;
    private final /* synthetic */ ENIGateway this$0;

    ENIGateway$2(ENIGateway eNIGateway, Service[] serviceArray) {
        this.this$0 = eNIGateway;
        this.val$services = serviceArray;
    }

    @Override
    public void run() {
        ENIGateway.access$000(this.this$0).log(1078071040, "ENIGateway#onServiceList: received %1 services", this.val$services == null ? -1L : (long)this.val$services.length);
        if (ENIGateway.access$200(this.this$0) != null) {
            ENIGateway.access$200(this.this$0).onServiceList(this.val$services);
        }
        ENIGateway.access$300(this.this$0);
        this.this$0.handleEcallLicenceWarning();
        ENIGateway.access$400(this.this$0);
        ENIGateway.access$500(this.this$0);
    }
}

