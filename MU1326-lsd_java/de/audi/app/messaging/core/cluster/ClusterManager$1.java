/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.cluster;

import de.audi.app.messaging.core.cluster.ClusterManager;
import de.audi.app.messaging.core.osgi.AbstractMessagingTrackerCustomizer;
import de.audi.atip.interapp.combi.bap.phone.CombiBAPServiceMessaging;
import de.audi.atip.log.LogChannel;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

class ClusterManager$1
extends AbstractMessagingTrackerCustomizer {
    private final /* synthetic */ ClusterManager this$0;

    ClusterManager$1(ClusterManager clusterManager, LogChannel logChannel, BundleContext bundleContext) {
        this.this$0 = clusterManager;
        super(logChannel, bundleContext);
    }

    @Override
    public void addService(ServiceReference serviceReference, Object object) {
        ClusterManager.access$202(this.this$0, (CombiBAPServiceMessaging)object);
        ClusterManager.access$300(this.this$0);
        ClusterManager.access$400(this.this$0);
        ClusterManager.access$500(this.this$0);
    }

    @Override
    public void removeService(ServiceReference serviceReference, Object object) {
        ClusterManager.access$202(this.this$0, null);
    }
}

