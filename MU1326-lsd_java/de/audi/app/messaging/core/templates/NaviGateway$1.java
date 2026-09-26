/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.templates;

import de.audi.app.messaging.core.osgi.AbstractMessagingTrackerCustomizer;
import de.audi.app.messaging.core.templates.NaviGateway;
import de.audi.atip.interapp.NaviService;
import de.audi.atip.log.LogChannel;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

class NaviGateway$1
extends AbstractMessagingTrackerCustomizer {
    private final /* synthetic */ NaviGateway this$0;

    NaviGateway$1(NaviGateway naviGateway, LogChannel logChannel, BundleContext bundleContext) {
        this.this$0 = naviGateway;
        super(logChannel, bundleContext);
    }

    @Override
    public void addService(ServiceReference serviceReference, Object object) {
        if (object instanceof NaviService) {
            this.this$0.setNaviService((NaviService)object);
        }
    }

    @Override
    public void removeService(ServiceReference serviceReference, Object object) {
        if (object instanceof NaviService) {
            this.this$0.setNaviService(null);
        }
    }
}

