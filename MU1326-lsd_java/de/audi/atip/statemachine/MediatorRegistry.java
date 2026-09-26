/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine;

import de.audi.atip.statemachine.EventMediator;

public interface MediatorRegistry {
    default public void registerMediator(EventMediator eventMediator, int[] nArray) {
    }

    default public void unregisterMediator(EventMediator eventMediator, int[] nArray) {
    }
}

