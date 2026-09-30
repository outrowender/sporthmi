/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.event;

import de.audi.tghu.navi.app.map.event.MapEventListener;

public interface IEventBroker {
    public void addListener(MapEventListener var1);

    public void fireEvent(int var1);

    public void fireEvent(int var1, int var2);
}

