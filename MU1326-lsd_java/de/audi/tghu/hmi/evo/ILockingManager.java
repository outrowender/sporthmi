/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.hmi.evo;

import de.audi.atip.hmi.event.LockingEvent;

public interface ILockingManager {
    default public void processLockingEvent(LockingEvent lockingEvent) {
    }
}

