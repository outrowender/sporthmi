/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.statemachine.ap;

import de.audi.atip.statemachine.ActionProxy;

public interface TunerActionProxy
extends ActionProxy {
    public void hmiActivatedTuner(int var1);

    public void hmiDeactivatedTuner(int var1);

    public void tunerTempBandChangeEntered(int var1);

    public void tunerTempBandChangeLeft(int var1);

    public void taVolumeAdjustmentActivated(int var1);

    public void taVolumeAdjustmentDeactivated(int var1);

    public void tunerManualTuneLeft(int var1);

    public void tunerSeekLeft(int var1);

    public void tunerManualTuneEntered(int var1);

    public void tunerListUpdateLeft(int var1);

    public void tunerFavoritesEntered(int var1);

    public void tunerGuidedStoreLeft(int var1);

    public void tunerFavoritesLeft(int var1);

    public void tunerAbortScan(int var1);

    public void tunerSDARSManageAlertsLeft(int var1);
}

