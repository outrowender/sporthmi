/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.cluster;

import de.audi.app.messaging.core.cluster.ClusterManager;
import de.audi.app.messaging.core.util.Logs;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServiceMessaging;

class ClusterManager$4
implements Runnable {
    private final /* synthetic */ int val$emailStorageState;
    private final /* synthetic */ int val$numberOfNewEmails;
    private final /* synthetic */ CombiBAPServiceMessaging val$service;
    private final /* synthetic */ ClusterManager this$0;

    ClusterManager$4(ClusterManager clusterManager, int n, int n2, CombiBAPServiceMessaging combiBAPServiceMessaging) {
        this.this$0 = clusterManager;
        this.val$emailStorageState = n;
        this.val$numberOfNewEmails = n2;
        this.val$service = combiBAPServiceMessaging;
    }

    @Override
    public void run() {
        ClusterManager.access$1000(this.this$0).log(1078071040, "[ClusterManager#dispatchUpdateEmailState] emailStorageState = %1, numberOfNewEmails = %2", (long)this.val$emailStorageState, (long)this.val$numberOfNewEmails);
        try {
            this.val$service.updateEmailState(this.val$emailStorageState, this.val$numberOfNewEmails);
        }
        catch (Exception exception) {
            Logs.logException(ClusterManager.access$1100(this.this$0), exception, "[ClusterManager#dispatchUpdateEmailState]");
        }
    }
}

