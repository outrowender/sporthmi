/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.map.event;

import de.audi.tghu.navi.app.map.event.MapEventListener;

public interface IEventBroker {
    default public void addListener(MapEventListener mapEventListener) {
    }

    default public void fireEvent(int n) {
    }

    default public void fireEvent(int n, int n2) {
    }
}

