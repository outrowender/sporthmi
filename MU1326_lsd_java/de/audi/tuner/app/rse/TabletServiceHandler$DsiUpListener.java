/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.rse;

import de.audi.tuner.app.amfm.dsi.AMFMDsiUpInfo;
import de.audi.tuner.app.rse.TabletServiceHandler;
import de.audi.tuner.app.rse.TabletServiceHandler$1;
import org.dsi.ifc.radio.WavebandInfo;

class TabletServiceHandler$DsiUpListener
extends AMFMDsiUpInfo {
    private final /* synthetic */ TabletServiceHandler this$0;

    private TabletServiceHandler$DsiUpListener(TabletServiceHandler tabletServiceHandler) {
        this.this$0 = tabletServiceHandler;
    }

    @Override
    public void updateWavebandInfoList(WavebandInfo[] wavebandInfoArray) {
        this.this$0.updateWavebandInfoList(wavebandInfoArray);
    }

    /* synthetic */ TabletServiceHandler$DsiUpListener(TabletServiceHandler tabletServiceHandler, TabletServiceHandler$1 tabletServiceHandler$1) {
        this(tabletServiceHandler);
    }
}

