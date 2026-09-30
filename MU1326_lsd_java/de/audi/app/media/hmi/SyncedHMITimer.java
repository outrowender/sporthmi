/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.hmi;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;
import de.audi.atip.hmi.event.ATIPNotifyEvent;
import de.audi.atip.hmi.event.EventDispatcher;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.esolutions.fw.util.commons.Buffer;

public class SyncedHMITimer
extends Timer {
    private static final String LOGCLASS = "SyncedHMITimer";
    private static final int STATE_IDLE = 0;
    private static final int STATE_RUNNING = 1;
    private static final int STATE_FIRED_PENDING = 2;
    private static final int STATE_CANCEL_PENDING = 3;
    private final Object mStateLock = new Object();
    private final EventDispatcher mEventDipatcher;
    private final TimerListener mSyncedListener;
    private final LogChannel logger;
    private final TimerListener mTimerListener = new TimerListener(){

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void fireTimer(Timer timer) {
            Object object = SyncedHMITimer.this.mStateLock;
            synchronized (object) {
                if (SyncedHMITimer.this.mState != 1) {
                    SyncedHMITimer.this.logger.log(1000000, "[%1.fireTimer] [%2]", (Object)SyncedHMITimer.LOGCLASS, (Object)SyncedHMITimer.this.getName());
                    return;
                }
                SyncedHMITimer.this.logger.log(1000000, "[%1.fireTimer] [%2] Post event", (Object)SyncedHMITimer.LOGCLASS, (Object)SyncedHMITimer.this.getName());
                SyncedHMITimer.this.mEventDipatcher.postEvent(new ATIPNotifyEvent(SyncedHMITimer.this.mEventListener, 10601));
                SyncedHMITimer.this.mState = 2;
            }
        }

        public void cancelTimer(Timer timer) {
        }
    };
    private final ATIPEventListener mEventListener = new ATIPEventListener(){

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void processEvent(ATIPEvent aTIPEvent) {
            Object object = SyncedHMITimer.this.mStateLock;
            synchronized (object) {
                switch (aTIPEvent.getID()) {
                    case 10601: {
                        if (SyncedHMITimer.this.mState != 2) {
                            SyncedHMITimer.this.logger.log(1000000, "[%1.processEvent] [%2] TIMER_FIRED", (Object)SyncedHMITimer.LOGCLASS, (Object)SyncedHMITimer.this.getName());
                            return;
                        }
                        SyncedHMITimer.this.logger.log(1000000, "[%1.processEvent] [%2] TIMER_FIRED, notify", (Object)SyncedHMITimer.LOGCLASS, (Object)SyncedHMITimer.this.getName());
                        SyncedHMITimer.this.mSyncedListener.fireTimer(SyncedHMITimer.this);
                        SyncedHMITimer.this.mState = 0;
                        break;
                    }
                    case 10602: {
                        if (SyncedHMITimer.this.mState != 3) {
                            SyncedHMITimer.this.logger.log(1000000, "[%1.processEvent] [%2] TIMER_CANCELED", (Object)SyncedHMITimer.LOGCLASS, (Object)SyncedHMITimer.this.getName());
                            return;
                        }
                        SyncedHMITimer.this.logger.log(1000000, "[%1.processEvent] [%2] TIMER_CANCELED, Notify", (Object)SyncedHMITimer.LOGCLASS, (Object)SyncedHMITimer.this.getName());
                        SyncedHMITimer.this.mSyncedListener.cancelTimer(SyncedHMITimer.this);
                        SyncedHMITimer.this.mState = 0;
                        break;
                    }
                }
            }
        }
    };
    private int mState;

    public SyncedHMITimer(String string, long l, TimerListener timerListener, IFrameworkAccess iFrameworkAccess) {
        super(string, l, true, timerListener);
        this.logger = iFrameworkAccess.getLogChannel("App.Media.Timer");
        this.mEventDipatcher = iFrameworkAccess.getHMIService().getEventDispatcher();
        this.mState = 0;
        this.mSyncedListener = timerListener;
        this.setTimerListener(this.mTimerListener);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void start() {
        Object object = this.mStateLock;
        synchronized (object) {
            this.logger.log(1000000, "[%1.start] [%2]", (Object)LOGCLASS, (Object)this.getName());
            this.mState = 1;
            super.start();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void restart() {
        Object object = this.mStateLock;
        synchronized (object) {
            this.logger.log(1000000, "[%1.restart] [%2]", (Object)LOGCLASS, (Object)this.getName());
            this.mState = 1;
            super.restart();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean cancel() {
        Object object = this.mStateLock;
        synchronized (object) {
            switch (this.mState) {
                case 3: {
                    this.logger.log(1000000, "[%1.cancel] [%2] STATE_CANCEL_PENDING", (Object)LOGCLASS, (Object)this.getName());
                    return false;
                }
                case 2: {
                    this.logger.log(1000000, "[%1.cancel] [%2] STATE_FIRED_PENDING", (Object)LOGCLASS, (Object)this.getName());
                    this.mEventDipatcher.postEvent(new ATIPNotifyEvent(this.mEventListener, 10602));
                    this.mState = 3;
                    return true;
                }
                case 1: {
                    this.logger.log(1000000, "[%1.cancel] [%2] STATE_RUNNING", (Object)LOGCLASS, (Object)this.getName());
                    this.mEventDipatcher.postEvent(new ATIPNotifyEvent(this.mEventListener, 10602));
                    this.mState = 3;
                    super.cancel();
                    return true;
                }
                case 0: {
                    this.logger.log(1000000, "[%1.cancel] [%2] STATE_IDLE", (Object)LOGCLASS, (Object)this.getName());
                    return false;
                }
            }
            return false;
        }
    }

    public String toString() {
        String string = "Synced";
        String string2 = super.toString();
        Buffer buffer = new Buffer(string.length() + string2.length());
        return buffer.append(string).append(string2).toString();
    }
}

