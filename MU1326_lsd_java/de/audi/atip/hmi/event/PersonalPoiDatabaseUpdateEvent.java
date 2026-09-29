/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.event;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;

public class PersonalPoiDatabaseUpdateEvent
extends ATIPEvent {
    public PersonalPoiDatabaseUpdateEvent(ATIPEventListener aTIPEventListener, int n) {
        super(aTIPEventListener, n);
    }
}

