/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.events;

import de.audi.app.terminalmode.events.IEventListener;

public interface IEventBus
extends IEventListener {
    default public boolean registerListener(IEventListener iEventListener) {
    }

    default public boolean unregisterListener(IEventListener iEventListener) {
    }
}

