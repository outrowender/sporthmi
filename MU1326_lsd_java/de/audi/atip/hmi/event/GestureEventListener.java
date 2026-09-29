/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.event;

import de.audi.atip.hmi.event.GestureEvent;

public interface GestureEventListener {
    default public void triggerGestureEvent(GestureEvent gestureEvent) {
    }
}

