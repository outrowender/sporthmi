/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.atip.diag.IDiagnosisApp;
import de.audi.tuner.app.BandListHandler;
import de.audi.tuner.app.Logger;
import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerDiagnosisApplication$ITunerDiagnosisSessionListener;
import de.audi.tuner.app.TunerModels;

public class TunerDiagnosisApplication
implements IDiagnosisApp {
    private final Logger logger;
    private final TunerModels models;
    private final BandListHandler bandList;
    private volatile TunerDiagnosisApplication$ITunerDiagnosisSessionListener[] diagnosisSessionListener = new TunerDiagnosisApplication$ITunerDiagnosisSessionListener[0];
    private int activeBandBeforeDiagSession;

    public TunerDiagnosisApplication(TunerBasics tunerBasics, BandListHandler bandListHandler) {
        this.logger = tunerBasics.getLogger();
        this.models = tunerBasics.getModels();
        this.bandList = bandListHandler;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void addTunerDiagnosisSessionListener(TunerDiagnosisApplication$ITunerDiagnosisSessionListener tunerDiagnosisApplication$ITunerDiagnosisSessionListener) {
        TunerDiagnosisApplication tunerDiagnosisApplication = this;
        synchronized (tunerDiagnosisApplication) {
            TunerDiagnosisApplication$ITunerDiagnosisSessionListener[] tunerDiagnosisApplication$ITunerDiagnosisSessionListenerArray = new TunerDiagnosisApplication$ITunerDiagnosisSessionListener[this.diagnosisSessionListener.length + 1];
            System.arraycopy((Object)this.diagnosisSessionListener, 0, (Object)tunerDiagnosisApplication$ITunerDiagnosisSessionListenerArray, 0, this.diagnosisSessionListener.length);
            tunerDiagnosisApplication$ITunerDiagnosisSessionListenerArray[this.diagnosisSessionListener.length] = tunerDiagnosisApplication$ITunerDiagnosisSessionListener;
            this.diagnosisSessionListener = tunerDiagnosisApplication$ITunerDiagnosisSessionListenerArray;
        }
    }

    @Override
    public void performAction(int n, Object object) {
        this.logger.main.log(1078071040, "[TDA.performAction] action:%2 param:%1", object, (long)n);
        if (n == 5) {
            this.switchBand((Integer)object);
        }
    }

    @Override
    public void updateDiagnosticValueChanged(int n, long l) {
        this.logger.main.log(1078071040, "[TDA.updateDiagnosticValueChanged] namespace:%1 key:%2", (long)n, l);
    }

    @Override
    public void startDiagSession() {
        this.logger.main.log(1078071040, "[TDA.startDiagSession");
        this.activeBandBeforeDiagSession = this.models.getActiveTuner();
        for (int i2 = 0; i2 < this.diagnosisSessionListener.length; ++i2) {
            this.diagnosisSessionListener[i2].diagnosisSessionStarted();
        }
    }

    @Override
    public void stopDiagSession() {
        this.logger.main.log(1078071040, "[TDA.stopDiagSession");
        for (int i2 = 0; i2 < this.diagnosisSessionListener.length; ++i2) {
            this.diagnosisSessionListener[i2].diagnosisSessionStopped();
        }
    }

    @Override
    public void switch2OriginSource(int n, int n2) {
        if (n2 == 0) {
            this.logger.main.log(1078071040, "[TDA.switch2OriginSource] app:%1 HT:%2", (long)n2, (long)n);
            this.bandList.switchBand(this.activeBandBeforeDiagSession, null, 0);
        }
    }

    private void switchBand(int n) {
        this.logger.main.log(1078071040, "[TDA.switchBand] band:%1", (long)n);
        switch (n) {
            case 1: {
                this.bandList.switchBand(4, null, 0);
                break;
            }
            case 0: {
                this.bandList.switchBand(1, null, 0);
                break;
            }
            case 2: {
                this.bandList.switchBand(5, null, 0);
                break;
            }
            case 3: {
                this.bandList.switchBand(7, null, 0);
                break;
            }
            default: {
                this.logger.main.log(10000, "[TDA.switchBand] Unknown band %1", (long)n);
            }
        }
    }
}

