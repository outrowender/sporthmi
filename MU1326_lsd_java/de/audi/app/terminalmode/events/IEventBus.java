/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.terminalmode.events;

import de.audi.app.terminalmode.events.IEventListener;

public interface IEventBus
extends IEventListener {
    public boolean registerListener(IEventListener var1);

    public boolean unregisterListener(IEventListener var1);
}

