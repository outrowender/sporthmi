/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.event;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;

public class TimerEvent
extends ATIPEvent {
    private static final int EVENT_ID = 19001;

    public TimerEvent(ATIPEventListener aTIPEventListener) {
        super(aTIPEventListener, 19001);
    }
}

