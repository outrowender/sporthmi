/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.eni;

import de.audi.app.eni.ENIGateway;
import de.audi.atip.interapp.eni.ENIServiceOnlineListener;

class ENIGateway$6
implements Runnable {
    private final /* synthetic */ ENIServiceOnlineListener val$eniServiceOnlineListener;
    private final /* synthetic */ ENIGateway this$0;

    ENIGateway$6(ENIGateway eNIGateway, ENIServiceOnlineListener eNIServiceOnlineListener) {
        this.this$0 = eNIGateway;
        this.val$eniServiceOnlineListener = eNIServiceOnlineListener;
    }

    @Override
    public void run() {
        ENIGateway.access$000(this.this$0).log(1078071040, "ENIGateway#registerOnlineListener privacyModeSupported=%1", (long)ENIGateway.access$900(this.this$0));
        ENIGateway.access$202(this.this$0, this.val$eniServiceOnlineListener);
        if (ENIGateway.access$900(this.this$0) != -1) {
            this.val$eniServiceOnlineListener.updatePrivacyModeFeatureAvailable(ENIGateway.access$900(this.this$0) == 1);
        }
        if (ENIGateway.access$1000(this.this$0) != null) {
            ENIGateway.access$1100(this.this$0);
        }
        if (ENIGateway.access$1200(this.this$0) != null) {
            this.val$eniServiceOnlineListener.onUserList(ENIGateway.access$1200(this.this$0));
        }
        if (ENIGateway.access$1300(this.this$0) != null) {
            this.val$eniServiceOnlineListener.onServiceList(ENIGateway.access$1300(this.this$0));
        }
        if (ENIGateway.access$1400(this.this$0) != null) {
            this.val$eniServiceOnlineListener.onPrivacySetup(ENIGateway.access$1400(this.this$0));
        }
    }
}

