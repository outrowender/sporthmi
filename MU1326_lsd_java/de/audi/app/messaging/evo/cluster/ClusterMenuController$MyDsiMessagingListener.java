/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.cluster;

import de.audi.app.messaging.core.dsi.messaging.DsiMessagingEmptyListener;
import de.audi.app.messaging.evo.cluster.ClusterMenuController;
import de.audi.app.messaging.evo.cluster.ClusterMenuController$1;
import org.dsi.ifc.messaging.MessagingAccount;

class ClusterMenuController$MyDsiMessagingListener
extends DsiMessagingEmptyListener {
    private final /* synthetic */ ClusterMenuController this$0;

    private ClusterMenuController$MyDsiMessagingListener(ClusterMenuController clusterMenuController) {
        this.this$0 = clusterMenuController;
    }

    @Override
    public void updateMessagingAccounts(MessagingAccount[] messagingAccountArray, int n) {
        int n2 = 0;
        if (messagingAccountArray != null) {
            ClusterMenuController.access$800(this.this$0).log(-2137614336, "[ClusterMenuController#updateMessagingAccounts] accounts.length = %1", (long)messagingAccountArray.length);
            for (int i2 = 0; i2 < messagingAccountArray.length; ++i2) {
                if (!messagingAccountArray[i2].isSupportsEMail()) continue;
                ++n2;
            }
        } else {
            ClusterMenuController.access$900(this.this$0).log(-1601830656, "[ClusterMenuController#updateMessagingAccounts] accounts[] is NULL");
        }
        ClusterMenuController.access$1002(this.this$0, n2);
        ClusterMenuController.access$400(this.this$0, ClusterMenuController.access$300(this.this$0));
    }

    /* synthetic */ ClusterMenuController$MyDsiMessagingListener(ClusterMenuController clusterMenuController, ClusterMenuController$1 clusterMenuController$1) {
        this(clusterMenuController);
    }
}

