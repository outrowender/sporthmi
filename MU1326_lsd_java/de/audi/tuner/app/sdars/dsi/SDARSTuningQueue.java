/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.dsi;

import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tuner.app.sdars.dsi.SDARSDSIDownManager;
import de.audi.tuner.app.sdars.dsi.SDARSDsiUpInfo;

public class SDARSTuningQueue {
    public final SDARSDsiUpInfo dsiUpListener = new DsiUpListener();
    private LogChannel log;
    private final Timer tuneWaitTimer;
    private final SDARSDSIDownManager downManager;
    private volatile boolean selectRunning;
    private final Object mutex;
    private int sId;

    public SDARSTuningQueue(LogChannel logChannel, SDARSDSIDownManager sDARSDSIDownManager, Object object) {
        this.log = logChannel;
        this.mutex = object;
        this.downManager = sDARSDSIDownManager;
        this.tuneWaitTimer = new Timer("TuneWaitTimer", 5, this.log, new TimerListener(), 5000L, true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void tuneStation(int n) {
        Object object = this.mutex;
        synchronized (object) {
            if (!this.selectRunning) {
                this.doTune(n);
            } else {
                this.log.log(1000000, "[SDARSTuningQueue.tuneStation] SDARSTuningQueue: enqueue sID:%1", (long)n);
                this.sId = n;
            }
        }
    }

    private void doTune(int n) {
        this.selectRunning = true;
        this.tuneWaitTimer.restart();
        this.log.log(10000000, "[SDARSTuningQueue.doTune] sId:%1 ", (long)n);
        this.downManager.selectStation(n);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void selectStationStatus(int n) {
        Object object = this.mutex;
        synchronized (object) {
            if (n == 1) {
                this.selectRunning = true;
            } else {
                this.tuneWaitTimer.cancel();
                if (this.sId != 0) {
                    this.doTune(this.sId);
                    this.sId = 0;
                    return;
                }
                this.selectRunning = false;
            }
        }
    }

    public boolean isTuneRunning() {
        return this.selectRunning;
    }

    private class DsiUpListener
    extends SDARSDsiUpInfo {
        private DsiUpListener() {
        }

        public void selectStationStatus(int n) {
            SDARSTuningQueue.this.selectStationStatus(n);
        }
    }

    private class TimerListener
    extends DefaultTimerListener {
        private TimerListener() {
        }

        /*
         * WARNING - Removed try catching itself - possible behaviour change.
         */
        public void fireTimer(Timer timer) {
            SDARSTuningQueue.this.log.log(10000, "[SDARSTuningQueue.fireTimer] Tune takes too long (timeout:%1)!", timer.getDelay());
            Object object = SDARSTuningQueue.this.mutex;
            synchronized (object) {
                SDARSTuningQueue.this.selectRunning = false;
                if (SDARSTuningQueue.this.sId != 0) {
                    SDARSTuningQueue.this.doTune(SDARSTuningQueue.this.sId);
                    SDARSTuningQueue.this.sId = 0;
                }
            }
        }
    }
}

