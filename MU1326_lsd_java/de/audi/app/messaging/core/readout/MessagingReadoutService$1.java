/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.readout;

import de.audi.app.messaging.core.osgi.AbstractMessagingTrackerCustomizer;
import de.audi.app.messaging.core.readout.MessagingReadoutService;
import de.audi.atip.interapp.IMessagingReadoutServiceListener;
import de.audi.atip.log.LogChannel;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

class MessagingReadoutService$1
extends AbstractMessagingTrackerCustomizer {
    private final /* synthetic */ MessagingReadoutService this$0;

    MessagingReadoutService$1(MessagingReadoutService messagingReadoutService, LogChannel logChannel, BundleContext bundleContext) {
        this.this$0 = messagingReadoutService;
        super(logChannel, bundleContext);
    }

    @Override
    public void addService(ServiceReference serviceReference, Object object) {
        MessagingReadoutService.access$202(this.this$0, 0);
        MessagingReadoutService.access$302(this.this$0, 0);
        MessagingReadoutService.access$402(this.this$0, (IMessagingReadoutServiceListener)object);
    }

    @Override
    public void removeService(ServiceReference serviceReference, Object object) {
        MessagingReadoutService.access$202(this.this$0, 0);
        MessagingReadoutService.access$302(this.this$0, 0);
        MessagingReadoutService.access$402(this.this$0, null);
    }
}

