/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm;

import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.HdTagging;
import de.audi.tuner.app.amfm.HdTagging$1;
import de.audi.tuner.app.amfm.dsi.AMFMDsiUpInfo;

class HdTagging$DsiUpListener
extends AMFMDsiUpInfo {
    private final /* synthetic */ HdTagging this$0;

    private HdTagging$DsiUpListener(HdTagging hdTagging) {
        this.this$0 = hdTagging;
    }

    @Override
    public void updateSelectedStation(AMFMStation aMFMStation) {
        HdTagging.access$700(this.this$0, aMFMStation);
    }

    /* synthetic */ HdTagging$DsiUpListener(HdTagging hdTagging, HdTagging$1 hdTagging$1) {
        this(hdTagging);
    }
}

