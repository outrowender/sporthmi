/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm;

import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.GUIHandlerAMFM;
import de.audi.tuner.app.amfm.GUIHandlerAMFM$1;
import de.audi.tuner.app.amfm.dsi.AMFMDsiDownInfo;

class GUIHandlerAMFM$DsiDownListener
extends AMFMDsiDownInfo {
    private final /* synthetic */ GUIHandlerAMFM this$0;

    private GUIHandlerAMFM$DsiDownListener(GUIHandlerAMFM gUIHandlerAMFM) {
        this.this$0 = gUIHandlerAMFM;
    }

    @Override
    public void preTuneAction(AMFMStation aMFMStation, boolean bl) {
        if (Utilities.isAfAutoResetActivated() && aMFMStation.waveband == 1 && GUIHandlerAMFM.access$300(this.this$0) != aMFMStation.frequency && GUIHandlerAMFM.access$400(this.this$0).getChoiceModel(780665088).getValue() == 0) {
            GUIHandlerAMFM.access$500((GUIHandlerAMFM)this.this$0).amfmDSI.log(1078071040, "[GUIHandlerAMFM] auto enable AF");
            GUIHandlerAMFM.access$600(this.this$0).itemSelected(780665088, 1, 0, 0);
        }
    }

    @Override
    public void switchHdOn(AMFMStation aMFMStation) {
        if (aMFMStation.waveband == 1 && GUIHandlerAMFM.access$400(this.this$0).getChoiceModel(-544734976).getValue() == 0) {
            GUIHandlerAMFM.access$600(this.this$0).itemSelected(-544734976, 1, 0, 0);
        } else if (aMFMStation.waveband == 3 && GUIHandlerAMFM.access$400(this.this$0).getChoiceModel(-561512192).getValue() == 0) {
            GUIHandlerAMFM.access$600(this.this$0).itemSelected(-561512192, 1, 0, 0);
        }
    }

    /* synthetic */ GUIHandlerAMFM$DsiDownListener(GUIHandlerAMFM gUIHandlerAMFM, GUIHandlerAMFM$1 gUIHandlerAMFM$1) {
        this(gUIHandlerAMFM);
    }
}

