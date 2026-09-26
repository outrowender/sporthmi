/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm;

import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.FmRadioTextHistory;
import de.audi.tuner.app.amfm.FmRadioTextHistory$1;
import de.audi.tuner.app.amfm.dsi.AMFMDsiDownInfo;

class FmRadioTextHistory$DSIDownListener
extends AMFMDsiDownInfo {
    private final /* synthetic */ FmRadioTextHistory this$0;

    private FmRadioTextHistory$DSIDownListener(FmRadioTextHistory fmRadioTextHistory) {
        this.this$0 = fmRadioTextHistory;
    }

    @Override
    public void preTuneAction(AMFMStation aMFMStation, boolean bl) {
        FmRadioTextHistory.access$300(this.this$0, FmRadioTextHistory.access$200(aMFMStation));
        FmRadioTextHistory.access$402(this.this$0, aMFMStation);
    }

    /* synthetic */ FmRadioTextHistory$DSIDownListener(FmRadioTextHistory fmRadioTextHistory, FmRadioTextHistory$1 fmRadioTextHistory$1) {
        this(fmRadioTextHistory);
    }
}

