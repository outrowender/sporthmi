/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.event;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;

public class UnitChangedEvent
extends ATIPEvent {
    public UnitChangedEvent(ATIPEventListener[] aTIPEventListenerArray) {
        super(aTIPEventListenerArray, 19001);
    }
}

