/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.event;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;
import de.esolutions.fw.util.commons.Buffer;

public class ATIPNotifyEvent
extends ATIPEvent {
    public static final int FIRST_ID = 10601;
    public static final int TIMER_FIRED = 10601;
    public static final int TIMER_CANCELLED = 10602;
    public static final int BITMAP_PRELOADED = 10603;
    public static final int XY_ID = 10604;
    public static final int LAST_ID = 10604;

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

