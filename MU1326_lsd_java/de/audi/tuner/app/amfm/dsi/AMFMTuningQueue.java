/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm.dsi;

import de.audi.atip.timer.Timer;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.amfm.dsi.AMFMDSIDownManager;
import de.audi.tuner.app.amfm.dsi.AMFMDsiUpInfo;
import de.audi.tuner.app.amfm.dsi.AMFMTuningQueue$DsiUpListener;
import de.audi.tuner.app.amfm.dsi.AMFMTuningQueue$TimerListener;

class AMFMTuningQueue {
    final AMFMDsiUpInfo dsiUpListener = new AMFMTuningQueue$DsiUpListener(this, null);
    private Logger logger;
    private int frequency;
    private int piCode;
    private int hdChannel;
    private boolean manualTune;
    private final Timer selectRunningTimer;
    private volatile boolean spsTuneRunning;
    private final Object globalAmFmLock;
    private final AMFMDSIDownManager downManager;

    AMFMTuningQueue(Logger logger, AMFMDSIDownManager aMFMDSIDownManager, Object object) {
        this.logger = logger;
        this.globalAmFmLock = object;
        this.downManager = aMFMDSIDownManager;
        this.selectRunningTimer = new Timer("TuneWaitTimer", 5, logger.timer, new AMFMTuningQueue$TimerListener(this, null), 0, true);
    }

    void tuneStation(int n, int n2, int n3, boolean bl) {
        if (!this.selectRunningTimer.isRunning() || this.spsTuneRunning) {
            this.doTune(n, n2, n3, bl);
        } else {
            this.logger.amfmDSI.log(1078071040, "AMFMTuningQueue: enqueue freq:%1 pi: %2", (long)n, (long)n2);
            this.frequency = n;
            this.piCode = n2;
            this.hdChannel = n3;
            this.manualTune = bl;
        }
    }

    private void doTune(int n, int n2, int n3, boolean bl) {
        this.selectRunningTimer.restart();
        if (bl) {
            this.logger.amfmDSI.log(-2137614336, "[AMFMTuningQueue.doTune] freq:%1", (long)n);
            this.downManager.selectFrequency(n);
            this.spsTuneRunning = false;
        } else {
            this.logger.amfmDSI.log(-2137614336, "[AMFMTuningQueue.doTune] freq:%2 pi:%1 Hd:%3", (Object)Integer.toHexString(n2), (long)n, (long)n3);
            this.downManager.selectStation(n, n2, n3);
            this.spsTuneRunning = n3 > 1;
        }
    }

    private void handleNewSelectStatus(int n, int n2) {
        if (n == n2) {
            if (!this.selectRunningTimer.isRunning()) {
                this.selectRunningTimer.restart();
            }
        } else {
            this.selectRunningTimer.cancel();
            if (this.frequency != 0) {
                this.doTune(this.frequency, this.piCode, this.hdChannel, this.manualTune);
                this.frequency = 0;
            }
        }
    }

    static /* synthetic */ Logger access$200(AMFMTuningQueue aMFMTuningQueue) {
        return aMFMTuningQueue.logger;
    }

    static /* synthetic */ Object access$300(AMFMTuningQueue aMFMTuningQueue) {
        return aMFMTuningQueue.globalAmFmLock;
    }

    static /* synthetic */ int access$400(AMFMTuningQueue aMFMTuningQueue) {
        return aMFMTuningQueue.frequency;
    }

    static /* synthetic */ int access$500(AMFMTuningQueue aMFMTuningQueue) {
        return aMFMTuningQueue.piCode;
    }

    static /* synthetic */ int access$600(AMFMTuningQueue aMFMTuningQueue) {
        return aMFMTuningQueue.hdChannel;
    }

    static /* synthetic */ boolean access$700(AMFMTuningQueue aMFMTuningQueue) {
        return aMFMTuningQueue.manualTune;
    }

    static /* synthetic */ void access$800(AMFMTuningQueue aMFMTuningQueue, int n, int n2, int n3, boolean bl) {
        aMFMTuningQueue.doTune(n, n2, n3, bl);
    }

    static /* synthetic */ int access$402(AMFMTuningQueue aMFMTuningQueue, int n) {
        aMFMTuningQueue.frequency = n;
        return aMFMTuningQueue.frequency;
    }

    static /* synthetic */ void access$900(AMFMTuningQueue aMFMTuningQueue, int n, int n2) {
        aMFMTuningQueue.handleNewSelectStatus(n, n2);
    }
}

