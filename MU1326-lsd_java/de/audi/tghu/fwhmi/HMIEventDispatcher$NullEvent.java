/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.fwhmi;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;

class HMIEventDispatcher$NullEvent
extends ATIPEvent {
    HMIEventDispatcher$NullEvent() {
        super((ATIPEventListener)null, 0);
    }
}

