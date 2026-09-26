/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.media.hmi;

import de.audi.app.media.hmi.SyncedHMITimer$1;
import de.audi.app.media.hmi.SyncedHMITimer$2;
import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.event.ATIPEventListener;
import de.audi.atip.hmi.event.ATIPNotifyEvent;
import de.audi.atip.hmi.event.EventDispatcher;
import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.esolutions.fw.util.commons.Buffer;

public class SyncedHMITimer
extends Timer {
    private static final String LOGCLASS;
    private static final int STATE_IDLE;
    private static final int STATE_RUNNING;
    private static final int STATE_FIRED_PENDING;
    private static final int STATE_CANCEL_PENDING;
    private final Object mStateLock = new Object();
    private final EventDispatcher mEventDipatcher;
    private final TimerListener mSyncedListener;
    private final LogChannel logger;
    private final TimerListener mTimerListener = new SyncedHMITimer$1(this);
    private final ATIPEventListener mEventListener = new SyncedHMITimer$2(this);
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
    @Override
    public void start() {
        Object object = this.mStateLock;
        synchronized (object) {
            this.logger.log(1078071040, "[%1.start] [%2]", (Object)"SyncedHMITimer", (Object)this.getName());
            this.mState = 1;
            super.start();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void restart() {
        Object object = this.mStateLock;
        synchronized (object) {
            this.logger.log(1078071040, "[%1.restart] [%2]", (Object)"SyncedHMITimer", (Object)this.getName());
            this.mState = 1;
            super.restart();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean cancel() {
        Object object = this.mStateLock;
        synchronized (object) {
            switch (this.mState) {
                case 3: {
                    this.logger.log(1078071040, "[%1.cancel] [%2] STATE_CANCEL_PENDING", (Object)"SyncedHMITimer", (Object)this.getName());
                    return false;
                }
                case 2: {
                    this.logger.log(1078071040, "[%1.cancel] [%2] STATE_FIRED_PENDING", (Object)"SyncedHMITimer", (Object)this.getName());
                    this.mEventDipatcher.postEvent(new ATIPNotifyEvent(this.mEventListener, 10602));
                    this.mState = 3;
                    return true;
                }
                case 1: {
                    this.logger.log(1078071040, "[%1.cancel] [%2] STATE_RUNNING", (Object)"SyncedHMITimer", (Object)this.getName());
                    this.mEventDipatcher.postEvent(new ATIPNotifyEvent(this.mEventListener, 10602));
                    this.mState = 3;
                    super.cancel();
                    return true;
                }
                case 0: {
                    this.logger.log(1078071040, "[%1.cancel] [%2] STATE_IDLE", (Object)"SyncedHMITimer", (Object)this.getName());
                    return false;
                }
            }
            return false;
        }
    }

    @Override
    public String toString() {
        String string = "Synced";
        String string2 = super.toString();
        Buffer buffer = new Buffer(string.length() + string2.length());
        return buffer.append(string).append(string2).toString();
    }

    static /* synthetic */ Object access$000(SyncedHMITimer syncedHMITimer) {
        return syncedHMITimer.mStateLock;
    }

    static /* synthetic */ int access$100(SyncedHMITimer syncedHMITimer) {
        return syncedHMITimer.mState;
    }

    static /* synthetic */ LogChannel access$200(SyncedHMITimer syncedHMITimer) {
        return syncedHMITimer.logger;
    }

    static /* synthetic */ ATIPEventListener access$300(SyncedHMITimer syncedHMITimer) {
        return syncedHMITimer.mEventListener;
    }

    static /* synthetic */ EventDispatcher access$400(SyncedHMITimer syncedHMITimer) {
        return syncedHMITimer.mEventDipatcher;
    }

    static /* synthetic */ int access$102(SyncedHMITimer syncedHMITimer, int n) {
        syncedHMITimer.mState = n;
        return syncedHMITimer.mState;
    }

    static /* synthetic */ TimerListener access$500(SyncedHMITimer syncedHMITimer) {
        return syncedHMITimer.mSyncedListener;
    }
}

