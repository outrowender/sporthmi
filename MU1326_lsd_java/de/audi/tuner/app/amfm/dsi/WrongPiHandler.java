/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm.dsi;

import de.audi.atip.timer.Timer;
import de.audi.atip.timer.TimerListener;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.amfm.AMFMStation;

class WrongPiHandler
implements TimerListener {
    private static final int NORDS;
    private static final int RDS;
    private static final int WRONGPI;
    private final Logger logger;
    private final Timer timer;
    private final Object mutex;
    private int piListening;
    private boolean wrongPiDetected;
    private AMFMStation origStation;

    WrongPiHandler(TunerBasics tunerBasics) {
        this.logger = tunerBasics.getLogger();
        this.timer = new Timer("WrongPiHandlerTimer", 0, true, this);
        this.mutex = new Object();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    AMFMStation update(AMFMStation aMFMStation) {
        Object object = this.mutex;
        synchronized (object) {
            int n = this.getStatus(aMFMStation);
            if (n == 2) {
                return this.handleWrongPI(aMFMStation);
            }
            if (n == 1) {
                return this.handleRDS(aMFMStation);
            }
            if (n == 0) {
                this.reset(0);
            }
            return aMFMStation;
        }
    }

    private AMFMStation handleRDS(AMFMStation aMFMStation) {
        if (this.piListening != aMFMStation.pi) {
            this.reset(aMFMStation.pi);
        } else if (this.wrongPiDetected) {
            if (!this.timer.isRunning()) {
                this.logger.amfmDSI.log(1078071040, "[WPH.update] Original PI back -> start timer");
                this.timer.restart();
            }
            AMFMStation aMFMStation2 = new AMFMStation(aMFMStation);
            aMFMStation2.pi = 0;
            aMFMStation2.ptyCode = 0;
            aMFMStation2.rds = false;
            aMFMStation2.radioText = false;
            this.origStation = aMFMStation;
            this.logger.amfmDSI.log(1078071040, "[WPH.update] Original PI back %1", (Object)aMFMStation);
            return aMFMStation2;
        }
        return aMFMStation;
    }

    private AMFMStation handleWrongPI(AMFMStation aMFMStation) {
        this.timer.cancel();
        this.piListening = aMFMStation.pi;
        AMFMStation aMFMStation2 = new AMFMStation(aMFMStation);
        aMFMStation2.pi = 0;
        aMFMStation2.ptyCode = 0;
        aMFMStation2.radioText = false;
        this.wrongPiDetected = true;
        this.logger.amfmDSI.log(1078071040, "[WPH.update] WrongPI detected %1", (Object)aMFMStation);
        return aMFMStation2;
    }

    private void reset(int n) {
        this.origStation = null;
        this.wrongPiDetected = false;
        this.piListening = n;
        this.timer.cancel();
        this.logger.amfmDeepDebug.log(1078071040, "[WPH.reset] PI listening: 0x%1", (Object)Integer.toHexString(n));
    }

    private int getStatus(AMFMStation aMFMStation) {
        if (aMFMStation.pi != 0 && aMFMStation.rds && aMFMStation.name.length() != 0) {
            return 1;
        }
        if (aMFMStation.pi != 0 && !aMFMStation.rds && aMFMStation.name.length() == 0) {
            return 2;
        }
        return 0;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void fireTimer(Timer timer) {
        Object object = this.mutex;
        synchronized (object) {
            if (this.origStation != null) {
                this.logger.amfmDSI.log(1078071040, "[WPH.fireTimer] update to original PI %1", (Object)this.origStation);
                this.origStation = null;
            }
            this.wrongPiDetected = false;
        }
    }

    @Override
    public void cancelTimer(Timer timer) {
    }
}

