/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.readout;

import de.audi.app.messaging.core.osgi.AbstractMessagingTrackerCustomizer;
import de.audi.app.messaging.core.readout.MultipleMessageReadoutService;
import de.audi.atip.interapp.messaging.IMultipleMessageReadoutServiceListener;
import de.audi.atip.log.LogChannel;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

class MultipleMessageReadoutService$2
extends AbstractMessagingTrackerCustomizer {
    private final /* synthetic */ MultipleMessageReadoutService this$0;

    MultipleMessageReadoutService$2(MultipleMessageReadoutService multipleMessageReadoutService, LogChannel logChannel, BundleContext bundleContext) {
        this.this$0 = multipleMessageReadoutService;
        super(logChannel, bundleContext);
    }

    @Override
    public void addService(ServiceReference serviceReference, Object object) {
        MultipleMessageReadoutService.access$802(this.this$0, 0);
        MultipleMessageReadoutService.access$902(this.this$0, (IMultipleMessageReadoutServiceListener)object);
    }

    @Override
    public void removeService(ServiceReference serviceReference, Object object) {
        MultipleMessageReadoutService.access$802(this.this$0, 0);
        MultipleMessageReadoutService.access$902(this.this$0, null);
    }
}

