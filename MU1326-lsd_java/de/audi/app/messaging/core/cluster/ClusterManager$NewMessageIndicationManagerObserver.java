/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.cluster;

import de.audi.app.messaging.core.cluster.ClusterManager;
import de.audi.app.messaging.core.cluster.ClusterManager$1;
import de.audi.app.messaging.core.indication.INewMessageIndicationManagerObserver;

class ClusterManager$NewMessageIndicationManagerObserver
implements INewMessageIndicationManagerObserver {
    private final /* synthetic */ ClusterManager this$0;

    private ClusterManager$NewMessageIndicationManagerObserver(ClusterManager clusterManager) {
        this.this$0 = clusterManager;
    }

    @Override
    public void indicateIndicationStateChanged(int n) {
        ClusterManager.access$1200(this.this$0).log(-2137614336, "[ClusterManager#indicateIndicationStateChanged] stateAspect = %1", (long)n);
        if (n == 0) {
            ClusterManager.access$1300(this.this$0);
        }
    }

    /* synthetic */ ClusterManager$NewMessageIndicationManagerObserver(ClusterManager clusterManager, ClusterManager$1 clusterManager$1) {
        this(clusterManager);
    }
}

