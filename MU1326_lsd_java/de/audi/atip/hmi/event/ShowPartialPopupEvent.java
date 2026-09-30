/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.event;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;

public class ShowPartialPopupEvent
extends ATIPEvent {
    private int partialPopupID;

    public int getPartialPopupID() {
        return this.partialPopupID;
    }

    public ShowPartialPopupEvent(ATIPEventListener aTIPEventListener, int n) {
        super(aTIPEventListener, 19001);
        this.partialPopupID = n;
    }

    public void setPartialPopupID(int n) {
        this.partialPopupID = n;
    }

    public String toString() {
        return "ShowPartialPopupEvent: partialPopupID = " + this.partialPopupID;
    }
}

