/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars.dsi;

import de.audi.atip.log.LogChannel;
import de.audi.atip.timer.Timer;
import de.audi.tuner.app.sdars.dsi.SDARSDSIDownManager;
import de.audi.tuner.app.sdars.dsi.SDARSDsiUpInfo;
import de.audi.tuner.app.sdars.dsi.SDARSTuningQueue$DsiUpListener;
import de.audi.tuner.app.sdars.dsi.SDARSTuningQueue$TimerListener;

public class SDARSTuningQueue {
    public final SDARSDsiUpInfo dsiUpListener = new SDARSTuningQueue$DsiUpListener(this, null);
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
        this.tuneWaitTimer = new Timer("TuneWaitTimer", 5, this.log, new SDARSTuningQueue$TimerListener(this, null), 0, true);
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
                this.log.log(1078071040, "[SDARSTuningQueue.tuneStation] SDARSTuningQueue: enqueue sID:%1", (long)n);
                this.sId = n;
            }
        }
    }

    private void doTune(int n) {
        this.selectRunning = true;
        this.tuneWaitTimer.restart();
        this.log.log(-2137614336, "[SDARSTuningQueue.doTune] sId:%1 ", (long)n);
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

    static /* synthetic */ LogChannel access$200(SDARSTuningQueue sDARSTuningQueue) {
        return sDARSTuningQueue.log;
    }

    static /* synthetic */ Object access$300(SDARSTuningQueue sDARSTuningQueue) {
        return sDARSTuningQueue.mutex;
    }

    static /* synthetic */ boolean access$402(SDARSTuningQueue sDARSTuningQueue, boolean bl) {
        sDARSTuningQueue.selectRunning = bl;
        return sDARSTuningQueue.selectRunning;
    }

    static /* synthetic */ int access$500(SDARSTuningQueue sDARSTuningQueue) {
        return sDARSTuningQueue.sId;
    }

    static /* synthetic */ void access$600(SDARSTuningQueue sDARSTuningQueue, int n) {
        sDARSTuningQueue.doTune(n);
    }

    static /* synthetic */ int access$502(SDARSTuningQueue sDARSTuningQueue, int n) {
        sDARSTuningQueue.sId = n;
        return sDARSTuningQueue.sId;
    }
}

