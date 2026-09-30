/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.event;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;

public class EnablePartialPopupsEvent
extends ATIPEvent {
    private boolean status;

    public boolean getStatus() {
        return this.status;
    }

    public EnablePartialPopupsEvent(ATIPEventListener aTIPEventListener, boolean bl) {
        super(aTIPEventListener, 19001);
        this.setStatus(bl);
    }

    public final void setStatus(boolean bl) {
        this.status = bl;
    }

    public String toString() {
        return "EnablePartialPopupsEvent: status = " + this.status;
    }
}

