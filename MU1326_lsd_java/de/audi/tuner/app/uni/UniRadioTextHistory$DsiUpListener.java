/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.uni;

import de.audi.tuner.app.RadioTextPlusStorage;
import de.audi.tuner.app.uni.UniDsiUpInfo;
import de.audi.tuner.app.uni.UniRadioTextHistory;
import de.audi.tuner.app.uni.UniRadioTextHistory$1;
import de.audi.tuner.app.uni.UnifiedStationExt;
import org.dsi.ifc.radio.UnifiedRadioText;

class UniRadioTextHistory$DsiUpListener
extends UniDsiUpInfo {
    private final /* synthetic */ UniRadioTextHistory this$0;

    private UniRadioTextHistory$DsiUpListener(UniRadioTextHistory uniRadioTextHistory) {
        this.this$0 = uniRadioTextHistory;
    }

    @Override
    public void updateRadioText(UnifiedRadioText unifiedRadioText) {
        UniRadioTextHistory.access$500(this.this$0, unifiedRadioText.radioText);
    }

    @Override
    public void updateRadioTextPlus(RadioTextPlusStorage radioTextPlusStorage) {
        UniRadioTextHistory.access$600(this.this$0, radioTextPlusStorage);
    }

    @Override
    public void updateSelectedStation(UnifiedStationExt unifiedStationExt) {
        if (!unifiedStationExt.rds && unifiedStationExt.ensId == 0 || unifiedStationExt.piSId != UniRadioTextHistory.access$400((UniRadioTextHistory)this.this$0).piSId) {
            UniRadioTextHistory.access$700(this.this$0, UniRadioTextHistory.access$200(unifiedStationExt));
        }
        UniRadioTextHistory.access$402(this.this$0, unifiedStationExt);
    }

    /* synthetic */ UniRadioTextHistory$DsiUpListener(UniRadioTextHistory uniRadioTextHistory, UniRadioTextHistory$1 uniRadioTextHistory$1) {
        this(uniRadioTextHistory);
    }
}

