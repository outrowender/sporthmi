/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.cluster;

import de.audi.app.messaging.core.util.Logs;
import de.audi.app.messaging.evo.cluster.ClusterMenuController;
import de.audi.atip.interapp.combi.mmisync.MMICombiMenuStatesServiceListener;

class ClusterMenuController$2
implements Runnable {
    private final /* synthetic */ int val$officeMenuItemState;
    private final /* synthetic */ MMICombiMenuStatesServiceListener val$service;
    private final /* synthetic */ ClusterMenuController this$0;

    ClusterMenuController$2(ClusterMenuController clusterMenuController, int n, MMICombiMenuStatesServiceListener mMICombiMenuStatesServiceListener) {
        this.this$0 = clusterMenuController;
        this.val$officeMenuItemState = n;
        this.val$service = mMICombiMenuStatesServiceListener;
    }

    @Override
    public void run() {
        ClusterMenuController.access$600(this.this$0).log(1078071040, "[ClusterMenuController#dispatchOfficeMenuItemState] officeMenuItemState = %1", (long)this.val$officeMenuItemState);
        try {
            this.val$service.updateMenuState(13, this.val$officeMenuItemState);
        }
        catch (Exception exception) {
            Logs.logException(ClusterMenuController.access$700(this.this$0), exception, "[ClusterMenuController#dispatchOfficeMenuItemState]");
        }
    }
}

