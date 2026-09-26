/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab;

import de.audi.tuner.app.dab.DABDsiUpInfo;
import de.audi.tuner.app.dab.DABTuner;
import de.audi.tuner.app.dab.DABTuner$1;
import de.audi.tuner.app.dab.DabReceptionStatus;
import de.audi.tuner.app.dab.DabStation;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.radio.FrequencyInfo;

class DABTuner$DsiUpListener
extends DABDsiUpInfo {
    private short quality;
    private FrequencyInfo frequency = new FrequencyInfo();
    private final /* synthetic */ DABTuner this$0;

    private DABTuner$DsiUpListener(DABTuner dABTuner) {
        this.this$0 = dABTuner;
    }

    @Override
    public void updateCurrentStation(DabStation dabStation, DabReceptionStatus dabReceptionStatus) {
        this.this$0.updateCurrentService(dabStation);
    }

    @Override
    public void updateSelectedFrequency(FrequencyInfo frequencyInfo) {
        this.frequency = frequencyInfo;
        this.updateDebugInfos();
    }

    @Override
    public void updateReceptionStatus(DabReceptionStatus dabReceptionStatus) {
        DABTuner.access$600(this.this$0, dabReceptionStatus);
    }

    @Override
    public void updateQuality(short s) {
        this.quality = s;
        this.updateDebugInfos();
    }

    @Override
    public void updateLinkingSwitchStatus(int n) {
        this.this$0.updateLinkingSwitchStatus(n);
    }

    @Override
    public void updateFrequencyTableSwitchStatus(int n) {
        this.this$0.updateFrequencyTableSwitchStatus(n);
    }

    @Override
    public void updateDetectedDevice(int n) {
        this.this$0.updateDetectedDevice(n);
    }

    @Override
    public void updateAvailability(int n) {
        DABTuner.access$700(this.this$0).setStatus(0);
        if (DABTuner.access$800(this.this$0) && n == 2 && DABTuner.access$900(this.this$0).hasAudioFocus(0) && DABTuner.access$1000(this.this$0).getActiveTuner() == 5) {
            this.this$0.dabSelected(null, 0);
        }
    }

    @Override
    public void seekServiceStatus(boolean bl) {
        DABTuner.access$1102(this.this$0, bl);
        this.this$0.propagateupdatedSeekStatus(bl);
    }

    @Override
    public void forceLMUpdateStatus(int n) {
        this.this$0.forceLMUpdateStatus(n);
    }

    void updateDebugInfos() {
        if (DABTuner.access$1200(this.this$0)) {
            Buffer buffer = new Buffer();
            buffer.append(this.frequency.label);
            buffer.append(": ");
            buffer.append(this.quality);
            DABTuner.access$1000(this.this$0).getLabelModel(416).setText(buffer.toString());
        }
    }

    /* synthetic */ DABTuner$DsiUpListener(DABTuner dABTuner, DABTuner$1 dABTuner$1) {
        this(dABTuner);
    }
}

