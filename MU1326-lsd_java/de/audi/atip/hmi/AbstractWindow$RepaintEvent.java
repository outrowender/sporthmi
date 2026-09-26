/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi;

import de.audi.atip.hmi.AbstractWindow$1;
import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;

public class AbstractWindow$RepaintEvent
extends ATIPEvent {
    private static final int EVENT_ID;

    private AbstractWindow$RepaintEvent(ATIPEventListener aTIPEventListener) {
        super(aTIPEventListener, 10801);
    }

    /* synthetic */ AbstractWindow$RepaintEvent(ATIPEventListener aTIPEventListener, AbstractWindow$1 abstractWindow$1) {
        this(aTIPEventListener);
    }
}

