/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.event;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;

public class RSEJointEvent
extends ATIPEvent {
    private int jointEvent;

    public RSEJointEvent(ATIPEventListener aTIPEventListener, int n) {
        super(aTIPEventListener, 19001);
        this.jointEvent = n;
    }

    public int getJointEvent() {
        return this.jointEvent;
    }

    public void setJointEvent(int n) {
        this.jointEvent = n;
    }
}

