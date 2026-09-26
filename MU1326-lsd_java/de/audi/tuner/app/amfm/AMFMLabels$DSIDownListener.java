/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm;

import de.audi.tuner.app.amfm.AMFMLabels;
import de.audi.tuner.app.amfm.AMFMLabels$1;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.dsi.AMFMDsiDownInfo;

class AMFMLabels$DSIDownListener
extends AMFMDsiDownInfo {
    private final /* synthetic */ AMFMLabels this$0;

    private AMFMLabels$DSIDownListener(AMFMLabels aMFMLabels) {
        this.this$0 = aMFMLabels;
    }

    @Override
    public void preTuneAction(AMFMStation aMFMStation, boolean bl) {
        AMFMLabels.access$200(this.this$0, aMFMStation, true);
    }

    /* synthetic */ AMFMLabels$DSIDownListener(AMFMLabels aMFMLabels, AMFMLabels$1 aMFMLabels$1) {
        this(aMFMLabels);
    }
}

