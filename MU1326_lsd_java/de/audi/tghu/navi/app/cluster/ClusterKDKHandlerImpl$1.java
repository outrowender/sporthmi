/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.cluster;

import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tghu.navi.app.cluster.ClusterKDKHandlerImpl;

class ClusterKDKHandlerImpl$1
extends DefaultTimerListener {
    private final /* synthetic */ ClusterKDKHandlerImpl this$0;

    ClusterKDKHandlerImpl$1(ClusterKDKHandlerImpl clusterKDKHandlerImpl) {
        this.this$0 = clusterKDKHandlerImpl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void fireTimer(Timer timer) {
        Object object = ClusterKDKHandlerImpl.access$000(this.this$0);
        synchronized (object) {
            if (ClusterKDKHandlerImpl.access$100(this.this$0) != ClusterKDKHandlerImpl.access$200(this.this$0)) {
                ClusterKDKHandlerImpl.access$300(this.this$0).log(-1601830656, "ClusterKDKHandler - did not get request from Kombi in time... setting expected KDK visibility: %1", ClusterKDKHandlerImpl.access$100(this.this$0));
                this.this$0.setKDKVisibility(ClusterKDKHandlerImpl.access$100(this.this$0));
            }
        }
    }
}

