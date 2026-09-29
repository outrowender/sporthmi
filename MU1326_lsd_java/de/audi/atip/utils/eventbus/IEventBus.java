/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.eventbus;

import de.esolutions.fw.util.commons.job.DispatcherBase;

public interface IEventBus {
    default public void register(Object object) {
    }

    default public void register(Object object, DispatcherBase dispatcherBase) {
    }

    default public void unregister(Object object) {
    }

    default public void post(Object object) {
    }
}

