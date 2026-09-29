/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.eni;

import de.audi.app.eni.ENIGateway;
import de.audi.atip.interapp.bap.eni.data.PrivacySetup;

class ENIGateway$5
implements Runnable {
    private final /* synthetic */ PrivacySetup val$privacySetup;
    private final /* synthetic */ ENIGateway this$0;

    ENIGateway$5(ENIGateway eNIGateway, PrivacySetup privacySetup) {
        this.this$0 = eNIGateway;
        this.val$privacySetup = privacySetup;
    }

    @Override
    public void run() {
        ENIGateway.access$000(this.this$0).log(1078071040, "ENIGateway#onPrivacySetup: received %1 ", (Object)this.val$privacySetup.toString());
        if (ENIGateway.access$200(this.this$0) != null) {
            ENIGateway.access$200(this.this$0).onPrivacySetup(this.val$privacySetup);
        }
    }
}

