/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm.dsi;

import de.audi.atip.timer.DefaultTimerListener;
import de.audi.atip.timer.Timer;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.amfm.dsi.AMFMDSIDownManager;
import de.audi.tuner.app.amfm.dsi.AMFMDsiUpInfo;

class AMFMTuningQueue {
    final AMFMDsiUpInfo dsiUpListener = new DsiUpListener();
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
        this.selectRunningTimer = new Timer("TuneWaitTimer", 5, logger.timer, new TimerListener(), 5000L, true);
    }

    void tuneStation(int n, int n2, int n3, boolean bl) {
        if (!this.selectRunningTimer.isRunning() || this.spsTuneRunning) {
            this.doTune(n, n2, n3, bl);
        } else {
            this.logger.amfmDSI.log(1000000, "AMFMTuningQueue: enqueue freq:%1 pi: %2", (long)n, (long)n2);
            this.frequency = n;
            this.piCode = n2;
            this.hdChannel = n3;
            this.manualTune = bl;
        }
    }

    private void doTune(int n, int n2, int n3, boolean bl) {
        this.selectRunningTimer.restart();
        if (bl) {
            this.logger.amfmDSI.log(10000000, "[AMFMTuningQueue.doTune] freq:%1", (long)n);
            this.downManager.selectFrequency(n);
            this.spsTuneRunning = false;
        } else {
            this.logger.amfmDSI.log(10000000, "[AMFMTuningQueue.doTune] freq:%2 pi:%1 Hd:%3", (Object)Integer.toHexString(n2), (long)n, (long)n3);
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

    private class DsiUpListener
    extends AMFMDsiUpInfo {
        private DsiUpListener() {
        }

        public void selectStationStatus(int n) {
            AMFMTuningQueue.this.handleNewSelectStatus(n, 1);
        }

        public void selectFrequencyStatus(int n) {
            AMFMTuningQueue.this.handleNewSelectStatus(n, 1);
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
            ((AMFMTuningQueue)AMFMTuningQueue.this).logger.amfmDSI.log(10000, "[AMFMTuningQueue.fireTimer] Tune takes too long (timeout:%1)!", timer.getDelay());
            Object object = AMFMTuningQueue.this.globalAmFmLock;
            synchronized (object) {
                if (AMFMTuningQueue.this.frequency != 0) {
                    AMFMTuningQueue.this.doTune(AMFMTuningQueue.this.frequency, AMFMTuningQueue.this.piCode, AMFMTuningQueue.this.hdChannel, AMFMTuningQueue.this.manualTune);
                    AMFMTuningQueue.this.frequency = 0;
                }
            }
        }
    }
}

