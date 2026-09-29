/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab;

import de.audi.tuner.app.RadioTextPlusStorage;
import de.audi.tuner.app.dab.DABDsiUpInfo;
import de.audi.tuner.app.dab.DabRadioTextHistory;
import de.audi.tuner.app.dab.DabRadioTextHistory$1;
import de.audi.tuner.app.dab.DabReceptionStatus;
import de.audi.tuner.app.dab.DabStation;
import org.dsi.ifc.radio.DABRadioText;

class DabRadioTextHistory$DsiUpListener
extends DABDsiUpInfo {
    private final /* synthetic */ DabRadioTextHistory this$0;

    private DabRadioTextHistory$DsiUpListener(DabRadioTextHistory dabRadioTextHistory) {
        this.this$0 = dabRadioTextHistory;
    }

    @Override
    public void updateRadioText(DABRadioText dABRadioText) {
        DabRadioTextHistory.access$300(this.this$0, dABRadioText.text);
    }

    @Override
    public void updateRadioTextPlusInfo(RadioTextPlusStorage radioTextPlusStorage) {
        DabRadioTextHistory.access$400(this.this$0, radioTextPlusStorage);
    }

    @Override
    public void seekServiceStatus(boolean bl) {
        if (bl) {
            DabRadioTextHistory.access$500(this.this$0, false);
        }
    }

    @Override
    public void updateCurrentStation(DabStation dabStation, DabReceptionStatus dabReceptionStatus) {
        int n = DabRadioTextHistory.access$600(this.this$0).getChoiceModel(227016960).getValue();
        if (n == 2 || n == 4) {
            DabRadioTextHistory.access$700(this.this$0, true);
        }
    }

    /* synthetic */ DabRadioTextHistory$DsiUpListener(DabRadioTextHistory dabRadioTextHistory, DabRadioTextHistory$1 dabRadioTextHistory$1) {
        this(dabRadioTextHistory);
    }
}

