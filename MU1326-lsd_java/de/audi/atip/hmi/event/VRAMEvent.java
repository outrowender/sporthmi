/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.event;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;

public class VRAMEvent
extends ATIPEvent {
    private static int id = 10901;

    public VRAMEvent(ATIPEventListener aTIPEventListener) {
        super(aTIPEventListener, id);
    }
}

