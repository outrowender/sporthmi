/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.cluster;

import de.audi.app.messaging.core.accounts.Accounts;
import de.audi.app.messaging.core.cluster.ClusterManager;
import de.audi.app.messaging.core.cluster.ClusterManager$1;
import de.audi.app.messaging.core.dsi.messaging.DsiMessagingEmptyListener;
import org.dsi.ifc.messaging.MessagingAccount;

class ClusterManager$MyDsiMessagingListener
extends DsiMessagingEmptyListener {
    private final /* synthetic */ ClusterManager this$0;

    private ClusterManager$MyDsiMessagingListener(ClusterManager clusterManager) {
        this.this$0 = clusterManager;
    }

    @Override
    public void updateMessagingAccounts(MessagingAccount[] messagingAccountArray, int n) {
        int n2;
        boolean bl;
        ClusterManager.access$1400(this.this$0).log(-2137614336, "[ClusterManager#updateMessagingAccounts]");
        boolean bl2 = false;
        boolean bl3 = false;
        for (bl = false; bl < messagingAccountArray.length; bl += 1) {
            MessagingAccount messagingAccount = messagingAccountArray[bl];
            n2 = Accounts.supportsSms(messagingAccount);
            if (n2 != 0) {
                bl2 = true;
            } else {
                bl3 = true;
            }
            if (bl2 && bl3) break;
        }
        bl = false;
        boolean bl4 = false;
        for (n2 = 0; n2 < messagingAccountArray.length; ++n2) {
            MessagingAccount messagingAccount = messagingAccountArray[n2];
            if (messagingAccount.getMemoryStatus() == 0) continue;
            boolean bl5 = Accounts.supportsSms(messagingAccount);
            if (bl5) {
                bl = true;
            } else {
                bl4 = true;
            }
            if (bl && bl4) break;
        }
        ClusterManager.access$1500(this.this$0, bl2, bl3, bl, bl4);
    }

    /* synthetic */ ClusterManager$MyDsiMessagingListener(ClusterManager clusterManager, ClusterManager$1 clusterManager$1) {
        this(clusterManager);
    }
}

