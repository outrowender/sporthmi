/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.atip.sysapp.SpeedThresholdListener;
import de.audi.tuner.app.RadioTextHistory;
import de.audi.tuner.app.RadioTextHistory$1;

class RadioTextHistory$SpeedListener
implements SpeedThresholdListener {
    private final /* synthetic */ RadioTextHistory this$0;

    private RadioTextHistory$SpeedListener(RadioTextHistory radioTextHistory) {
        this.this$0 = radioTextHistory;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void exceedsUpperThreshold(int n) {
        if (n == 11) {
            this.this$0.models.getChoiceModel(2005467392).setValue(1);
        } else if (RadioTextHistory.access$1100(this.this$0) != 0) {
            Object object = RadioTextHistory.access$500(this.this$0);
            synchronized (object) {
                RadioTextHistory.access$1202(this.this$0, true);
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void belowLowerThreshold(int n) {
        if (n == 11) {
            this.this$0.models.getChoiceModel(2005467392).setValue(0);
        } else {
            Object object = RadioTextHistory.access$500(this.this$0);
            synchronized (object) {
                RadioTextHistory.access$400(this.this$0).cancel();
                RadioTextHistory.access$600(this.this$0);
                RadioTextHistory.access$1202(this.this$0, false);
            }
        }
    }

    /* synthetic */ RadioTextHistory$SpeedListener(RadioTextHistory radioTextHistory, RadioTextHistory$1 radioTextHistory$1) {
        this(radioTextHistory);
    }
}

