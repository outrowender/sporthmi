/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.event;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;

public class SetFocusedScreenEvent
extends ATIPEvent {
    private int screen = 0;

    public int getScreen() {
        return this.screen;
    }

    public SetFocusedScreenEvent(ATIPEventListener aTIPEventListener, int n, int n2) {
        super(aTIPEventListener, n);
        this.screen = n2;
    }

    public String toString() {
        return new StringBuffer().append("SetFocusedScreenEvent [screen=").append(this.screen).append("]").toString();
    }
}

