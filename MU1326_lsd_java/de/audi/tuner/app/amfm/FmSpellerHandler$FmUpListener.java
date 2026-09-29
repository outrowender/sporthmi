/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm;

import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.FmSpellerHandler;
import de.audi.tuner.app.amfm.FmSpellerHandler$1;
import de.audi.tuner.app.amfm.dsi.AMFMDsiUpInfo;

class FmSpellerHandler$FmUpListener
extends AMFMDsiUpInfo {
    private final /* synthetic */ FmSpellerHandler this$0;

    private FmSpellerHandler$FmUpListener(FmSpellerHandler fmSpellerHandler) {
        this.this$0 = fmSpellerHandler;
    }

    @Override
    public void updateStationListFM(AMFMStation[] aMFMStationArray) {
        this.this$0.buildHdPostfixMap(aMFMStationArray);
    }

    /* synthetic */ FmSpellerHandler$FmUpListener(FmSpellerHandler fmSpellerHandler, FmSpellerHandler$1 fmSpellerHandler$1) {
        this(fmSpellerHandler);
    }
}

