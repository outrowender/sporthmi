/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.messaging.evo.readout;

import de.audi.app.messaging.core.osgi.AbstractMessagingTrackerCustomizer;
import de.audi.app.messaging.evo.readout.EvoReadableProvider;
import de.audi.atip.hmi.SDPromptTextAccess;
import de.audi.atip.log.LogChannel;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

class EvoReadableProvider$1
extends AbstractMessagingTrackerCustomizer {
    private final /* synthetic */ EvoReadableProvider this$0;

    EvoReadableProvider$1(EvoReadableProvider evoReadableProvider, LogChannel logChannel, BundleContext bundleContext) {
        this.this$0 = evoReadableProvider;
        super(logChannel, bundleContext);
    }

    @Override
    public void addService(ServiceReference serviceReference, Object object) {
        EvoReadableProvider.access$000(this.this$0, (SDPromptTextAccess)object);
    }

    @Override
    public void removeService(ServiceReference serviceReference, Object object) {
        EvoReadableProvider.access$000(this.this$0, null);
    }
}

