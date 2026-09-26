/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm;

import de.audi.tuner.app.amfm.AMFMLabels;
import de.audi.tuner.app.amfm.AMFMLabels$1;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.dsi.AMFMDsiUpInfo;

class AMFMLabels$DsiUpListener
extends AMFMDsiUpInfo {
    private final /* synthetic */ AMFMLabels this$0;

    private AMFMLabels$DsiUpListener(AMFMLabels aMFMLabels) {
        this.this$0 = aMFMLabels;
    }

    @Override
    public void updateSelectedStation(AMFMStation aMFMStation) {
        AMFMLabels.access$200(this.this$0, aMFMStation, false);
    }

    @Override
    public void updateSeekStation(AMFMStation aMFMStation) {
        AMFMLabels.access$200(this.this$0, aMFMStation, false);
    }

    /* synthetic */ AMFMLabels$DsiUpListener(AMFMLabels aMFMLabels, AMFMLabels$1 aMFMLabels$1) {
        this(aMFMLabels);
    }
}

