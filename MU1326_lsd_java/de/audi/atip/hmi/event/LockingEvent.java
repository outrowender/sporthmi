/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.event;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;

public class LockingEvent
extends ATIPEvent {
    private boolean lockingActive;

    public LockingEvent(ATIPEventListener aTIPEventListener, boolean bl) {
        super(aTIPEventListener, 0);
        this.lockingActive = bl;
    }

    public boolean isLockingActive() {
        return this.lockingActive;
    }
}

