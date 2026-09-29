/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.reactive.bindings;

import de.audi.atip.utils.reactive.bindings.ServiceBindings$IServiceWrappingStrategy;

final class ServiceBindings$1
implements ServiceBindings$IServiceWrappingStrategy {
    ServiceBindings$1() {
    }

    @Override
    public Object wrap(String string, Object object) {
        return object;
    }
}

