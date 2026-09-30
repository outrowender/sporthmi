/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.base.eal.async;

import de.audi.atip.hmi.event.ATIPEvent;

public interface IUpdatableReceiver {
    public static final int RESOURCE_ASYNC_TEXTURE = 1;

    public void resourceLoadedCallback(int var1, Object var2, ATIPEvent var3);
}

