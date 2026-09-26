/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.combi;

import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.dsi.AMFMDsiUpInfo;
import de.audi.tuner.app.combi.CombiBAPServiceHandler;
import de.audi.tuner.app.combi.CombiBAPServiceHandler$1;

class CombiBAPServiceHandler$DsiUpListener
extends AMFMDsiUpInfo {
    private final /* synthetic */ CombiBAPServiceHandler this$0;

    private CombiBAPServiceHandler$DsiUpListener(CombiBAPServiceHandler combiBAPServiceHandler) {
        this.this$0 = combiBAPServiceHandler;
    }

    @Override
    public void updateSeekStation(AMFMStation aMFMStation) {
        CombiBAPServiceHandler.access$200(this.this$0, aMFMStation);
    }

    /* synthetic */ CombiBAPServiceHandler$DsiUpListener(CombiBAPServiceHandler combiBAPServiceHandler, CombiBAPServiceHandler$1 combiBAPServiceHandler$1) {
        this(combiBAPServiceHandler);
    }
}

