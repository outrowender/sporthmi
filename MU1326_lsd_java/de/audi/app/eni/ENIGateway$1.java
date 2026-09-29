/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.eni;

import de.audi.app.eni.ENIGateway;

class ENIGateway$1
implements Runnable {
    private final /* synthetic */ ENIGateway this$0;

    ENIGateway$1(ENIGateway eNIGateway) {
        this.this$0 = eNIGateway;
    }

    @Override
    public void run() {
        ENIGateway.access$000(this.this$0).log(-2137614336, "[ENIGateway#onCommunicationUp]");
        this.this$0.triggerGetServiceList();
        this.this$0.triggerGetDestinationList();
        ENIGateway.access$100(this.this$0);
    }
}

