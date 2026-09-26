/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm;

import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.AmSpellerHandler;
import de.audi.tuner.app.amfm.AmSpellerHandler$1;
import de.audi.tuner.app.amfm.dsi.AMFMDsiUpInfo;

class AmSpellerHandler$AmUpListener
extends AMFMDsiUpInfo {
    private final /* synthetic */ AmSpellerHandler this$0;

    private AmSpellerHandler$AmUpListener(AmSpellerHandler amSpellerHandler) {
        this.this$0 = amSpellerHandler;
    }

    @Override
    public void updateStationListAM(AMFMStation[] aMFMStationArray) {
        this.this$0.buildHdPostfixMap(aMFMStationArray);
    }

    /* synthetic */ AmSpellerHandler$AmUpListener(AmSpellerHandler amSpellerHandler, AmSpellerHandler$1 amSpellerHandler$1) {
        this(amSpellerHandler);
    }
}

