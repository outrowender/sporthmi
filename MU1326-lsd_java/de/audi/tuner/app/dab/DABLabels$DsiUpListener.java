/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab;

import de.audi.tuner.app.dab.DABDsiUpInfo;
import de.audi.tuner.app.dab.DABLabels;
import de.audi.tuner.app.dab.DABLabels$1;
import de.audi.tuner.app.dab.DabReceptionStatus;
import de.audi.tuner.app.dab.DabStation;
import org.dsi.ifc.radio.FrequencyInfo;

class DABLabels$DsiUpListener
extends DABDsiUpInfo {
    FrequencyInfo freq = new FrequencyInfo();
    private final /* synthetic */ DABLabels this$0;

    private DABLabels$DsiUpListener(DABLabels dABLabels) {
        this.this$0 = dABLabels;
    }

    @Override
    public void updateCurrentStation(DabStation dabStation, DabReceptionStatus dabReceptionStatus) {
        DABLabels.access$202(this.this$0, dabStation);
        DABLabels.access$302(this.this$0, dabReceptionStatus);
        DABLabels.access$400(this.this$0, dabStation, dabReceptionStatus);
    }

    @Override
    public void ensembleSeekIsRunning(String string) {
        DABLabels.access$500(this.this$0, string);
    }

    @Override
    public void updateFrequencyList(FrequencyInfo[] frequencyInfoArray) {
        DABLabels.access$602(this.this$0, frequencyInfoArray);
        DABLabels.access$700(this.this$0).getRangeModel(931660032).setLimits(0, frequencyInfoArray.length - 1, 1);
        DABLabels.access$800(this.this$0, this.freq);
    }

    @Override
    public void updateSelectedFrequency(FrequencyInfo frequencyInfo) {
        this.freq = frequencyInfo;
        DABLabels.access$800(this.this$0, frequencyInfo);
    }

    /* synthetic */ DABLabels$DsiUpListener(DABLabels dABLabels, DABLabels$1 dABLabels$1) {
        this(dABLabels);
    }
}

