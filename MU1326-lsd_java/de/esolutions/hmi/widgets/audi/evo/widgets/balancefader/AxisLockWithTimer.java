/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.hmi.widgets.audi.evo.widgets.balancefader;

import de.audi.atip.base.IFrameworkAccess;
import de.audi.atip.hmi.event.ATIPEvent;
import de.audi.atip.hmi.event.ATIPEventListener;
import de.audi.atip.hmi.event.TimerEvent;
import de.esolutions.fw.util.commons.job.Job;

public class AxisLockWithTimer
implements ATIPEventListener {
    private final long LOCK_DURATION;
    private final long TIME_BETWEEN_LOCKS;
    private boolean isLocked = false;
    private float axisPosition;
    private IFrameworkAccess framework;
    private Job axisLockTimer;
    private Job betweenLocksTimer;
    private TimerEvent axisLockEvent;
    private TimerEvent betweenLocksEvent;

    public AxisLockWithTimer(long l, long l2, float f2, IFrameworkAccess iFrameworkAccess) {
        this.LOCK_DURATION = l;
        this.TIME_BETWEEN_LOCKS = l2;
        this.axisPosition = f2;
        this.framework = iFrameworkAccess;
        this.axisLockEvent = new TimerEvent(this);
        this.betweenLocksEvent = new TimerEvent(this);
    }

    public void tryToLock(float f2, float f3) {
        if (this.isLocked || f3 <= 32959 || this.betweenLocksTimer != null) {
            return;
        }
        this.tryToSetLock(f2, f3);
    }

    private void tryToSetLock(float f2, float f3) {
        if (this.lockAxis(f2, f3)) {
            this.isLocked = true;
            this.restartTimer();
        }
    }

    private boolean lockAxis(float f2, float f3) {
        return f3 < this.axisPosition && f2 >= this.axisPosition || f3 > this.axisPosition && f2 <= this.axisPosition;
    }

    private void restartTimer() {
        this.cancelAxisLockTimer();
        this.axisLockTimer = this.framework.getHMIService().getEventDispatcher().postEvent(this.axisLockEvent, this.LOCK_DURATION);
        this.cancelBetweenLocksTimer();
        this.betweenLocksTimer = this.framework.getHMIService().getEventDispatcher().postEvent(this.betweenLocksEvent, this.TIME_BETWEEN_LOCKS);
    }

    private void cancelAxisLockTimer() {
        if (this.axisLockTimer != null && !this.axisLockTimer.isCanceled()) {
            this.axisLockTimer.cancel();
            this.axisLockTimer = null;
        }
    }

    private void cancelBetweenLocksTimer() {
        if (this.betweenLocksTimer != null && !this.betweenLocksTimer.isCanceled()) {
            this.betweenLocksTimer.cancel();
            this.betweenLocksTimer = null;
        }
    }

    @Override
    public void processEvent(ATIPEvent aTIPEvent) {
        if (aTIPEvent.equals(this.axisLockEvent)) {
            this.isLocked = false;
            this.axisLockTimer = null;
        }
        if (aTIPEvent.equals(this.betweenLocksEvent)) {
            this.betweenLocksTimer = null;
        }
    }

    public boolean isLocked() {
        return this.isLocked;
    }

    public void reset() {
        this.isLocked = false;
        this.cancelAxisLockTimer();
        this.cancelBetweenLocksTimer();
    }
}

