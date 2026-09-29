/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm;

import de.audi.tuner.app.RadioTextPlusStorage;
import de.audi.tuner.app.Utilities;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.FmRadioTextHistory;
import de.audi.tuner.app.amfm.FmRadioTextHistory$1;
import de.audi.tuner.app.amfm.dsi.AMFMDsiUpInfo;
import org.dsi.ifc.radio.AMFMRadioText;

class FmRadioTextHistory$DsiUpListener
extends AMFMDsiUpInfo {
    private final /* synthetic */ FmRadioTextHistory this$0;

    private FmRadioTextHistory$DsiUpListener(FmRadioTextHistory fmRadioTextHistory) {
        this.this$0 = fmRadioTextHistory;
    }

    @Override
    public void updateRadioText(AMFMRadioText aMFMRadioText) {
        FmRadioTextHistory.access$500(this.this$0, aMFMRadioText.text);
    }

    @Override
    public void updateRadioTextPlus(RadioTextPlusStorage radioTextPlusStorage) {
        FmRadioTextHistory.access$600(this.this$0, radioTextPlusStorage);
    }

    @Override
    public void updateSelectedStation(AMFMStation aMFMStation) {
        if (Utilities.isPiIgnore()) {
            if (aMFMStation.frequency != FmRadioTextHistory.access$400((FmRadioTextHistory)this.this$0).frequency || aMFMStation.serviceId != FmRadioTextHistory.access$400((FmRadioTextHistory)this.this$0).serviceId || !aMFMStation.rds && !aMFMStation.hd) {
                FmRadioTextHistory.access$700(this.this$0, FmRadioTextHistory.access$200(aMFMStation));
            }
        } else if (!aMFMStation.rds || aMFMStation.pi != FmRadioTextHistory.access$400((FmRadioTextHistory)this.this$0).pi) {
            FmRadioTextHistory.access$800(this.this$0, FmRadioTextHistory.access$200(aMFMStation));
        }
        FmRadioTextHistory.access$402(this.this$0, aMFMStation);
    }

    @Override
    public void seekStationStatus(boolean bl) {
        if (bl) {
            FmRadioTextHistory.access$900(this.this$0, false);
        }
    }

    /* synthetic */ FmRadioTextHistory$DsiUpListener(FmRadioTextHistory fmRadioTextHistory, FmRadioTextHistory$1 fmRadioTextHistory$1) {
        this(fmRadioTextHistory);
    }
}

