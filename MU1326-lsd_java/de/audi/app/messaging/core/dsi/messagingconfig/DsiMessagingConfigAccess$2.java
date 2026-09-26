/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dsi.messagingconfig;

import de.audi.app.messaging.core.dsi.messagingconfig.DsiMessagingConfigAccess;
import de.audi.app.messaging.core.osgi.AbstractMessagingTrackerCustomizer;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.messaging.DSIMessagingServiceConfiguration;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

class DsiMessagingConfigAccess$2
extends AbstractMessagingTrackerCustomizer {
    private final /* synthetic */ DsiMessagingConfigAccess this$0;

    DsiMessagingConfigAccess$2(DsiMessagingConfigAccess dsiMessagingConfigAccess, LogChannel logChannel, BundleContext bundleContext) {
        this.this$0 = dsiMessagingConfigAccess;
        super(logChannel, bundleContext);
    }

    @Override
    public void addService(ServiceReference serviceReference, Object object) {
        DsiMessagingConfigAccess.access$400(this.this$0, (DSIMessagingServiceConfiguration)object);
    }

    @Override
    public void removeService(ServiceReference serviceReference, Object object) {
        DsiMessagingConfigAccess.access$400(this.this$0, null);
    }
}

