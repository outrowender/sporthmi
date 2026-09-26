/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.event;

import de.audi.atip.hmi.event.ProximityEvent;

public interface ProximityEventListener {
    default public void triggerProximityEvent(ProximityEvent proximityEvent) {
    }
}

