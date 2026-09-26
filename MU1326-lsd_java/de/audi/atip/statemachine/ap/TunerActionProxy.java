/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.ap;

import de.audi.atip.statemachine.ActionProxy;

public interface TunerActionProxy
extends ActionProxy {
    default public void hmiActivatedTuner(int n) {
    }

    default public void hmiDeactivatedTuner(int n) {
    }

    default public void tunerTempBandChangeEntered(int n) {
    }

    default public void tunerTempBandChangeLeft(int n) {
    }

    default public void taVolumeAdjustmentActivated(int n) {
    }

    default public void taVolumeAdjustmentDeactivated(int n) {
    }

    default public void tunerManualTuneLeft(int n) {
    }

    default public void tunerSeekLeft(int n) {
    }

    default public void tunerManualTuneEntered(int n) {
    }

    default public void tunerListUpdateLeft(int n) {
    }

    default public void tunerFavoritesEntered(int n) {
    }

    default public void tunerGuidedStoreLeft(int n) {
    }

    default public void tunerFavoritesLeft(int n) {
    }

    default public void tunerAbortScan(int n) {
    }

    default public void tunerSDARSManageAlertsLeft(int n) {
    }
}

