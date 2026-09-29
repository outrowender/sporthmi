/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.reactive.bindings;

import de.audi.atip.utils.collections.Predicate;
import de.audi.atip.utils.reactive.bindings.ServiceBindings;
import org.osgi.framework.ServiceReference;

class ServiceBindings$3
implements Predicate {
    private final /* synthetic */ ServiceBindings this$0;

    ServiceBindings$3(ServiceBindings serviceBindings) {
        this.this$0 = serviceBindings;
    }

    public boolean apply(ServiceReference serviceReference) {
        return true;
    }

    @Override
    public /* synthetic */ boolean apply(Object object) {
        return this.apply((ServiceReference)object);
    }
}

