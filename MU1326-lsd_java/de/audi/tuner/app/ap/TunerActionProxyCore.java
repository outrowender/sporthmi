/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.ap;

import de.audi.atip.log.LogChannel;
import de.audi.tuner.app.ap.TunerActionProxyListener;

public class TunerActionProxyCore {
    protected final LogChannel lc;
    protected final TunerActionProxyListener[] listeners;

    protected TunerActionProxyCore(LogChannel logChannel, TunerActionProxyListener[] tunerActionProxyListenerArray) {
        this.lc = logChannel;
        this.listeners = tunerActionProxyListenerArray;
    }

    public void hmiActivatedTuner(int n) {
        this.lc.log(1078071040, "[TunerActionProxy.hmiActivatedTuner]");
        for (int i2 = 0; i2 < this.listeners.length; ++i2) {
            this.listeners[i2].hmiActivatedTuner();
        }
    }

    public void hmiDeactivatedTuner(int n) {
        this.lc.log(1078071040, "[TunerActionProxy.hmiDeactivatedTuner]");
        for (int i2 = 0; i2 < this.listeners.length; ++i2) {
            this.listeners[i2].hmiDeactivatedTuner();
        }
    }

    public void stationListEntered(int n) {
        this.lc.log(1078071040, "[TunerActionProxy.stationListEntered]");
        for (int i2 = 0; i2 < this.listeners.length; ++i2) {
            this.listeners[i2].stationListEntered();
        }
    }

    public void taVolumeAdjustmentActivated(int n) {
        this.lc.log(1078071040, "[TunerActionProxy.taVolumeAdjustmentActivated]");
        for (int i2 = 0; i2 < this.listeners.length; ++i2) {
            this.listeners[i2].taVolumeAdjustmentActivated();
        }
    }

    public void taVolumeAdjustmentDeactivated(int n) {
        this.lc.log(1078071040, "[TunerActionProxy.taVolumeAdjustmentDeactivated]");
        for (int i2 = 0; i2 < this.listeners.length; ++i2) {
            this.listeners[i2].taVolumeAdjustmentDeactivated();
        }
    }

    public void tunerTempBandChangeEntered(int n) {
        this.lc.log(1078071040, "[TunerActionProxy.tunTmpBandChangeEntered]");
        for (int i2 = 0; i2 < this.listeners.length; ++i2) {
            this.listeners[i2].tunTmpBandChangeEntered();
        }
    }

    public void tunerTempBandChangeLeft(int n) {
        this.lc.log(1078071040, "[TunerActionProxy.tunTmpBandChangeLeft]");
        for (int i2 = 0; i2 < this.listeners.length; ++i2) {
            this.listeners[i2].tunTmpBandChangeLeft();
        }
    }

    public void tunerTempBandToggleLeftByTimer(int n) {
        this.lc.log(1078071040, "[TunerActionProxy.tunerListSearchLeft] is deprecated");
    }

    public void storeModeLeft(int n) {
        this.lc.log(1078071040, "[TunerActionProxy.storeModeLeft]");
        for (int i2 = 0; i2 < this.listeners.length; ++i2) {
            this.listeners[i2].storeModeLeft();
        }
    }

    public void tunerManualTuneLeft(int n) {
        this.lc.log(1078071040, "[TunerActionProxy.tunerManualTuneLeft]");
        for (int i2 = 0; i2 < this.listeners.length; ++i2) {
            this.listeners[i2].manualTuneLeft();
        }
    }

    public void tunerManualTuneEntered(int n) {
        this.lc.log(1078071040, "[TunerActionProxy.tunerManualTuneEntered]");
        for (int i2 = 0; i2 < this.listeners.length; ++i2) {
            this.listeners[i2].manualTuneEntered();
        }
    }

    public void tunerSeekLeft(int n) {
        this.lc.log(1078071040, "[TunerActionProxy.tunerSeekLeft]");
        for (int i2 = 0; i2 < this.listeners.length; ++i2) {
            this.listeners[i2].stationSeekLeft();
        }
    }

    public void tunerFavoritesEntered(int n) {
        this.lc.log(1078071040, "[TunerActionProxy.tunerFavoritesEntered]");
        for (int i2 = 0; i2 < this.listeners.length; ++i2) {
            this.listeners[i2].tunerFavoritesEntered();
        }
    }

    public void tunerFavoritesLeft(int n) {
        this.lc.log(1078071040, "[TunerActionProxy.tunerFavoritesLeft]");
        for (int i2 = 0; i2 < this.listeners.length; ++i2) {
            this.listeners[i2].tunerFavoritesLeft();
        }
    }

    public void tunerGuidedStoreLeft(int n) {
        this.lc.log(1078071040, "[TunerActionProxy.tunerGuidedStoreLeft]");
        for (int i2 = 0; i2 < this.listeners.length; ++i2) {
            this.listeners[i2].tunerGuidedStoreLeft();
        }
    }

    public void tunerAbortScan(int n) {
        this.lc.log(1078071040, "[TunerActionProxy.tunerAbortScan]");
        for (int i2 = 0; i2 < this.listeners.length; ++i2) {
            this.listeners[i2].tunerAbortScan();
        }
    }

    public void tunerSDARSManageAlertsLeft(int n) {
        this.lc.log(1078071040, "[TunerActionProxy.tunerSDARSManageAlertsLeft]");
        for (int i2 = 0; i2 < this.listeners.length; ++i2) {
            this.listeners[i2].tunerSDARSManageAlertsLeft();
        }
    }
}

