/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab;

import de.audi.tuner.app.dab.DABDsiDownInfo;
import de.audi.tuner.app.dab.DABTuner;
import de.audi.tuner.app.dab.DABTuner$1;
import de.audi.tuner.app.dab.DabReceptionStatus;
import de.audi.tuner.app.dab.DabStation;

class DABTuner$DsiDownListener
extends DABDsiDownInfo {
    private final /* synthetic */ DABTuner this$0;

    private DABTuner$DsiDownListener(DABTuner dABTuner) {
        this.this$0 = dABTuner;
    }

    @Override
    public void preTuneAction(DabStation dabStation, DabReceptionStatus dabReceptionStatus, int n) {
        DABTuner.access$400(this.this$0, dabStation);
        if (n != 0) {
            DABTuner.access$500(this.this$0).abortAnnouncement();
        }
    }

    @Override
    public void postTuneAction(DabStation dabStation, int n) {
    }

    /* synthetic */ DABTuner$DsiDownListener(DABTuner dABTuner, DABTuner$1 dABTuner$1) {
        this(dABTuner);
    }
}

