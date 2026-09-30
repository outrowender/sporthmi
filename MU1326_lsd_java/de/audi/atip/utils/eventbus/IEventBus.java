/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.eventbus;

import de.esolutions.fw.util.commons.job.DispatcherBase;

public interface IEventBus {
    public void register(Object var1);

    public void register(Object var1, DispatcherBase var2);

    public void unregister(Object var1);

    public void post(Object var1);
}

