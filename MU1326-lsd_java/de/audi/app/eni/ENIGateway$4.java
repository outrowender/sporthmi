/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.eni;

import de.audi.app.eni.ENIGateway;
import de.audi.atip.interapp.bap.eni.data.Destination;

class ENIGateway$4
implements Runnable {
    private final /* synthetic */ ENIGateway this$0;

    ENIGateway$4(ENIGateway eNIGateway) {
        this.this$0 = eNIGateway;
    }

    @Override
    public void run() {
        if (ENIGateway.access$600(this.this$0) == null || ENIGateway.access$600(this.this$0) != null && ENIGateway.access$600(this.this$0).length == 0) {
            ENIGateway.access$000(this.this$0).log(-1601830656, "ENIGateway#onDestinationList: given destinations NULL");
            return;
        }
        if (ENIGateway.access$600(this.this$0).length > 1) {
            ENIGateway.access$000(this.this$0).log(-1601830656, "ENIGateway#onDestinationList: given destinations > 1");
        }
        Destination destination = ENIGateway.access$600(this.this$0)[0];
        if (ENIGateway.access$700(this.this$0) != null) {
            ENIGateway.access$700(this.this$0).onDestination(destination);
            ENIGateway.access$000(this.this$0).log(1078071040, "ENIGateway#onDestinationList: Deleting given destination %1 on CGW", (Object)ENIGateway.access$600(this.this$0)[0]);
            ENIGateway.access$800(this.this$0).deleteDestination(destination);
        }
    }
}

