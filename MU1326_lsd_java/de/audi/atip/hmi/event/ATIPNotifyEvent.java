/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.event;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;
import de.esolutions.fw.util.commons.Buffer;

public class ATIPNotifyEvent
extends ATIPEvent {
    public static final int FIRST_ID;
    public static final int TIMER_FIRED;
    public static final int TIMER_CANCELLED;
    public static final int BITMAP_PRELOADED;
    public static final int XY_ID;
    public static final int LAST_ID;

    public ATIPNotifyEvent(ATIPEventListener aTIPEventListener, int n) {
        super(aTIPEventListener, n);
    }

    private String type2Text() {
        switch (this.getID()) {
            case 10601: {
                return "TIMER_FIRED";
            }
            case 10602: {
                return "TIMER_CANCELLED";
            }
            case 10603: {
                return "BITMAP_PRELOADED";
            }
        }
        return "<UNKNOWN>";
    }

    public String toString() {
        return new Buffer().append("ATIPNotifyEvent: type = ").append(this.type2Text()).append('(').append(this.getID()).append(") receiver: ").append(this.getReceiver()).toString();
    }
}

