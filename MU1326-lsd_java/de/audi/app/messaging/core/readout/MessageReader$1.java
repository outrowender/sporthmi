/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.core.readout;

import de.audi.app.messaging.core.osgi.AbstractMessagingTrackerCustomizer;
import de.audi.app.messaging.core.readout.MessageReader;
import de.audi.atip.interapp.tts.TTSSessionBasedService;
import de.audi.atip.log.LogChannel;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

class MessageReader$1
extends AbstractMessagingTrackerCustomizer {
    private final /* synthetic */ MessageReader this$0;

    MessageReader$1(MessageReader messageReader, LogChannel logChannel, BundleContext bundleContext) {
        this.this$0 = messageReader;
        super(logChannel, bundleContext);
    }

    @Override
    public void addService(ServiceReference serviceReference, Object object) {
        MessageReader.access$300(this.this$0, (TTSSessionBasedService)object);
    }

    @Override
    public void removeService(ServiceReference serviceReference, Object object) {
        MessageReader.access$400(this.this$0);
    }
}

