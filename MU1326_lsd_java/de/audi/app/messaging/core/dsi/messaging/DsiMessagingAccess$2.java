/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dsi.messaging;

import de.audi.app.messaging.core.dsi.messaging.DsiMessagingAccess;
import de.audi.app.messaging.core.osgi.AbstractMessagingTrackerCustomizer;
import de.audi.atip.log.LogChannel;
import org.dsi.ifc.messaging.DSIMessaging;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

class DsiMessagingAccess$2
extends AbstractMessagingTrackerCustomizer {
    private final /* synthetic */ DsiMessagingAccess this$0;

    DsiMessagingAccess$2(DsiMessagingAccess dsiMessagingAccess, LogChannel logChannel, BundleContext bundleContext) {
        this.this$0 = dsiMessagingAccess;
        super(logChannel, bundleContext);
    }

    @Override
    public void addService(ServiceReference serviceReference, Object object) {
        DsiMessagingAccess.access$400(this.this$0, (DSIMessaging)object);
    }

    @Override
    public void removeService(ServiceReference serviceReference, Object object) {
        DsiMessagingAccess.access$400(this.this$0, null);
    }
}

