/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.tuner.app.TunerBasics;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.sdars.SdarsSubscriptionMngr$DsiUpListener;
import de.audi.tuner.app.sdars.dsi.SDARSDsiUpInfo;

public class SdarsSubscriptionMngr {
    final SDARSDsiUpInfo dsiUpListener = new SdarsSubscriptionMngr$DsiUpListener(this, null);
    private final TunerModels models;

    public SdarsSubscriptionMngr(TunerBasics tunerBasics) {
        this.models = tunerBasics.getModels();
    }

    static /* synthetic */ TunerModels access$100(SdarsSubscriptionMngr sdarsSubscriptionMngr) {
        return sdarsSubscriptionMngr.models;
    }
}

