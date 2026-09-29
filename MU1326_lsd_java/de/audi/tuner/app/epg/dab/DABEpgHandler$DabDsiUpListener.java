/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.epg.dab;

import de.audi.tuner.app.dab.DABDsiUpInfo;
import de.audi.tuner.app.dab.DabReceptionStatus;
import de.audi.tuner.app.dab.DabStation;
import de.audi.tuner.app.epg.dab.DABEpgHandler;
import de.audi.tuner.app.epg.dab.DABEpgHandler$1;
import de.audi.tuner.app.epg.dab.EPGShortInfoExt;
import org.dsi.ifc.radio.EPGFullInfo;

class DABEpgHandler$DabDsiUpListener
extends DABDsiUpInfo {
    private final /* synthetic */ DABEpgHandler this$0;

    private DABEpgHandler$DabDsiUpListener(DABEpgHandler dABEpgHandler) {
        this.this$0 = dABEpgHandler;
    }

    @Override
    public void setEPGList(EPGShortInfoExt[] ePGShortInfoExtArray) {
        this.this$0.setEPGList(ePGShortInfoExtArray);
    }

    @Override
    public void setEPGDetailData(EPGFullInfo ePGFullInfo) {
        this.this$0.setEPGDetailData(ePGFullInfo);
    }

    @Override
    public void updateCurrentStation(DabStation dabStation, DabReceptionStatus dabReceptionStatus) {
        DABEpgHandler.access$900(this.this$0, dabStation);
    }

    /* synthetic */ DABEpgHandler$DabDsiUpListener(DABEpgHandler dABEpgHandler, DABEpgHandler$1 dABEpgHandler$1) {
        this(dABEpgHandler);
    }
}

