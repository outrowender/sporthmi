/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.dictation;

import de.audi.app.messaging.core.dictation.MessagingDictationService;
import de.audi.app.messaging.core.osgi.AbstractMessagingTrackerCustomizer;
import de.audi.atip.interapp.IMessagingDictationServiceListener;
import de.audi.atip.log.LogChannel;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

class MessagingDictationService$1
extends AbstractMessagingTrackerCustomizer {
    private final /* synthetic */ MessagingDictationService this$0;

    MessagingDictationService$1(MessagingDictationService messagingDictationService, LogChannel logChannel, BundleContext bundleContext) {
        this.this$0 = messagingDictationService;
        super(logChannel, bundleContext);
    }

    @Override
    public void addService(ServiceReference serviceReference, Object object) {
        MessagingDictationService.access$102(this.this$0, false);
        MessagingDictationService.access$202(this.this$0, false);
        MessagingDictationService.access$300(this.this$0, false);
        MessagingDictationService.access$402(this.this$0, (IMessagingDictationServiceListener)object);
    }

    @Override
    public void removeService(ServiceReference serviceReference, Object object) {
        MessagingDictationService.access$102(this.this$0, false);
        MessagingDictationService.access$202(this.this$0, false);
        MessagingDictationService.access$300(this.this$0, false);
        MessagingDictationService.access$402(this.this$0, null);
    }
}

