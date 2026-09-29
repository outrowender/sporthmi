/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.accounts;

import de.audi.app.messaging.core.osgi.AbstractMessagingTrackerCustomizer;
import de.audi.app.messaging.evo.accounts.PhoneRingMenuController;
import de.audi.atip.interapp.phone.ITelServiceMessaging;
import de.audi.atip.log.LogChannel;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

class PhoneRingMenuController$1
extends AbstractMessagingTrackerCustomizer {
    private final /* synthetic */ PhoneRingMenuController this$0;

    PhoneRingMenuController$1(PhoneRingMenuController phoneRingMenuController, LogChannel logChannel, BundleContext bundleContext) {
        this.this$0 = phoneRingMenuController;
        super(logChannel, bundleContext);
    }

    @Override
    public void addService(ServiceReference serviceReference, Object object) {
        PhoneRingMenuController.access$202(this.this$0, (ITelServiceMessaging)object);
    }

    @Override
    public void removeService(ServiceReference serviceReference, Object object) {
        PhoneRingMenuController.access$202(this.this$0, null);
    }
}

