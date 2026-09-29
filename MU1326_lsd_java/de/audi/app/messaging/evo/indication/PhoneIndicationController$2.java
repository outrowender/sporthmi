/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.indication;

import de.audi.app.messaging.core.osgi.AbstractMessagingTrackerCustomizer;
import de.audi.app.messaging.evo.indication.PhoneIndicationController;
import de.audi.atip.interapp.phone.ITelServiceMessaging;
import de.audi.atip.log.LogChannel;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

class PhoneIndicationController$2
extends AbstractMessagingTrackerCustomizer {
    private final /* synthetic */ PhoneIndicationController this$0;

    PhoneIndicationController$2(PhoneIndicationController phoneIndicationController, LogChannel logChannel, BundleContext bundleContext) {
        this.this$0 = phoneIndicationController;
        super(logChannel, bundleContext);
    }

    @Override
    public void addService(ServiceReference serviceReference, Object object) {
        PhoneIndicationController.access$402(this.this$0, (ITelServiceMessaging)object);
        PhoneIndicationController.access$500(this.this$0);
    }

    @Override
    public void removeService(ServiceReference serviceReference, Object object) {
        PhoneIndicationController.access$402(this.this$0, null);
    }
}

