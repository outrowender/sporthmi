/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.utils.eventbus;

import de.audi.atip.utils.Preconditions;
import de.audi.atip.utils.eventbus.EventMarker;

public class DeadEvent
implements EventMarker {
    private final Object source;
    private final Object event;

    public DeadEvent(Object object, Object object2) {
        Preconditions.checkNotNull(object);
        Preconditions.checkNotNull(object2);
        this.source = object;
        this.event = object2;
    }

    public Object getSource() {
        return this.source;
    }

    public Object getEvent() {
        return this.event;
    }
}

