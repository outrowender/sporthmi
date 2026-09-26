/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm;

import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.HdTagging;
import de.audi.tuner.app.amfm.HdTagging$1;
import de.audi.tuner.app.amfm.dsi.AMFMDsiDownInfo;

class HdTagging$DSIDownListener
extends AMFMDsiDownInfo {
    private final /* synthetic */ HdTagging this$0;

    private HdTagging$DSIDownListener(HdTagging hdTagging) {
        this.this$0 = hdTagging;
    }

    @Override
    public void preTuneAction(AMFMStation aMFMStation, boolean bl) {
        HdTagging.access$700(this.this$0, aMFMStation);
    }

    /* synthetic */ HdTagging$DSIDownListener(HdTagging hdTagging, HdTagging$1 hdTagging$1) {
        this(hdTagging);
    }
}

