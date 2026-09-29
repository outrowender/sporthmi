/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.cluster;

import de.audi.app.messaging.core.cluster.ClusterManager;
import de.audi.app.messaging.core.util.Logs;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServiceMessaging;

class ClusterManager$3
implements Runnable {
    private final /* synthetic */ int val$smsStorageState;
    private final /* synthetic */ int val$numberOfNewSms;
    private final /* synthetic */ boolean val$simReady;
    private final /* synthetic */ CombiBAPServiceMessaging val$service;
    private final /* synthetic */ ClusterManager this$0;

    ClusterManager$3(ClusterManager clusterManager, int n, int n2, boolean bl, CombiBAPServiceMessaging combiBAPServiceMessaging) {
        this.this$0 = clusterManager;
        this.val$smsStorageState = n;
        this.val$numberOfNewSms = n2;
        this.val$simReady = bl;
        this.val$service = combiBAPServiceMessaging;
    }

    @Override
    public void run() {
        ClusterManager.access$800(this.this$0).log(1078071040, "[ClusterManager#dispatchUpdateSmsState] simReady = %3, smsStorageState = %1, numberOfNewSms = %2", (long)this.val$smsStorageState, (long)this.val$numberOfNewSms, this.val$simReady);
        try {
            this.val$service.updateSMSState(this.val$simReady, this.val$smsStorageState, this.val$numberOfNewSms);
        }
        catch (Exception exception) {
            Logs.logException(ClusterManager.access$900(this.this$0), exception, "[ClusterManager#dispatchUpdateSmsState]");
        }
    }
}

