/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.cluster;

import de.audi.app.messaging.core.cluster.ClusterManager;
import de.audi.app.messaging.core.util.Logs;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServiceMessaging;

class ClusterManager$2
implements Runnable {
    private final /* synthetic */ boolean val$smsStateSupported;
    private final /* synthetic */ boolean val$emailStateSupported;
    private final /* synthetic */ CombiBAPServiceMessaging val$service;
    private final /* synthetic */ ClusterManager this$0;

    ClusterManager$2(ClusterManager clusterManager, boolean bl, boolean bl2, CombiBAPServiceMessaging combiBAPServiceMessaging) {
        this.this$0 = clusterManager;
        this.val$smsStateSupported = bl;
        this.val$emailStateSupported = bl2;
        this.val$service = combiBAPServiceMessaging;
    }

    @Override
    public void run() {
        ClusterManager.access$600(this.this$0).log(1078071040, "[ClusterManager#dispatchUpdateMobileServiceSupport] smsStateSupported = %1, emailStateSupported = %2", this.val$smsStateSupported, this.val$emailStateSupported);
        try {
            this.val$service.updateMobileServiceSupport(this.val$smsStateSupported, this.val$emailStateSupported);
        }
        catch (Exception exception) {
            Logs.logException(ClusterManager.access$700(this.this$0), exception, "[ClusterManager#dispatchUpdateMobileServiceSupport]");
        }
    }
}

