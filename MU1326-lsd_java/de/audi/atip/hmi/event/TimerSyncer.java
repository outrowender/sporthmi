/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi.event;

import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;
import de.audi.atip.hmi.event.ATIPNotifyEvent;
import de.audi.atip.hmi.event.EventDispatcher;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;

public class TimerSyncer
implements ATIPEventListener,
TimerListener {
    private TimerListener timerListener;
    private Timer timer;
    private static EventDispatcher eventSink;

    public TimerSyncer(TimerListener timerListener) {
        this.timerListener = timerListener;
    }

    public static void setEventSink(EventDispatcher eventDispatcher) {
        eventSink = eventDispatcher;
    }

    @Override
    public void processEvent(ATIPEvent aTIPEvent) {
        if (aTIPEvent.getID() == 10601) {
            this.timerListener.fireTimer(this.timer);
        } else if (aTIPEvent.getID() == 10602) {
            this.timerListener.cancelTimer(this.timer);
        }
    }

    @Override
    public void fireTimer(Timer timer) {
        this.timer = timer;
        eventSink.postEvent(new ATIPNotifyEvent(this, 10601));
    }

    @Override
    public void cancelTimer(Timer timer) {
        this.timer = timer;
        eventSink.postEvent(new ATIPNotifyEvent(this, 10602));
    }

    public String toString() {
        return new StringBuffer().append("TimerSyncer timer: ").append(this.timer.getName()).toString();
    }
}

