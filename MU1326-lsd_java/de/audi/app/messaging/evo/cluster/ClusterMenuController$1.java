/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.cluster;

import de.audi.app.messaging.core.osgi.AbstractMessagingTrackerCustomizer;
import de.audi.app.messaging.evo.cluster.ClusterMenuController;
import de.audi.atip.interapp.combi.mmisync.MMICombiMenuStatesServiceListener;
import de.audi.atip.log.LogChannel;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

class ClusterMenuController$1
extends AbstractMessagingTrackerCustomizer {
    private final /* synthetic */ ClusterMenuController this$0;

    ClusterMenuController$1(ClusterMenuController clusterMenuController, LogChannel logChannel, BundleContext bundleContext) {
        this.this$0 = clusterMenuController;
        super(logChannel, bundleContext);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void addService(ServiceReference serviceReference, Object object) {
        Object object2 = ClusterMenuController.access$100(this.this$0);
        synchronized (object2) {
            ClusterMenuController.access$202(this.this$0, (MMICombiMenuStatesServiceListener)object);
            ClusterMenuController.access$400(this.this$0, ClusterMenuController.access$300(this.this$0));
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void removeService(ServiceReference serviceReference, Object object) {
        Object object2 = ClusterMenuController.access$100(this.this$0);
        synchronized (object2) {
            try {
                ClusterMenuController.access$400(this.this$0, ClusterMenuController.access$500(this.this$0));
            }
            finally {
                ClusterMenuController.access$202(this.this$0, null);
            }
        }
    }
}

