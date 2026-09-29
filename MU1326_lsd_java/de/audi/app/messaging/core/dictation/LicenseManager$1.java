/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dictation;

import de.audi.app.messaging.core.dictation.LicenseManager;
import de.audi.app.messaging.core.osgi.AbstractMessagingTrackerCustomizer;
import de.audi.atip.interapp.online.IOnlineService;
import de.audi.atip.log.LogChannel;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

class LicenseManager$1
extends AbstractMessagingTrackerCustomizer {
    private final /* synthetic */ LicenseManager this$0;

    LicenseManager$1(LicenseManager licenseManager, LogChannel logChannel, BundleContext bundleContext) {
        this.this$0 = licenseManager;
        super(logChannel, bundleContext);
    }

    @Override
    public void addService(ServiceReference serviceReference, Object object) {
        LicenseManager.access$300(this.this$0, (IOnlineService)object);
    }

    @Override
    public void removeService(ServiceReference serviceReference, Object object) {
        LicenseManager.access$400(this.this$0);
    }
}

