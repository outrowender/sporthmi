/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.reactive.bindings;

import de.audi.atip.utils.generics.Consumer;
import de.audi.atip.utils.reactive.bindings.ServiceBindings;
import org.osgi.util.tracker.ServiceTracker;

class ServiceBindings$4
implements Consumer {
    private final /* synthetic */ ServiceBindings this$0;

    ServiceBindings$4(ServiceBindings serviceBindings) {
        this.this$0 = serviceBindings;
    }

    public void accept(ServiceTracker serviceTracker) {
        serviceTracker.close();
    }

    @Override
    public /* synthetic */ void accept(Object object) {
        this.accept((ServiceTracker)object);
    }
}

