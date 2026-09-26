/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab;

import de.audi.tuner.app.dab.DABDsiUpInfo;
import de.audi.tuner.app.dab.DABVolumeLockHandler;
import de.audi.tuner.app.dab.DABVolumeLockHandler$1;
import de.audi.tuner.app.dab.DabReceptionStatus;

class DABVolumeLockHandler$DsiUpListener
extends DABDsiUpInfo {
    private final /* synthetic */ DABVolumeLockHandler this$0;

    private DABVolumeLockHandler$DsiUpListener(DABVolumeLockHandler dABVolumeLockHandler) {
        this.this$0 = dABVolumeLockHandler;
    }

    @Override
    public void updateReceptionStatus(DabReceptionStatus dabReceptionStatus) {
        if (!DABVolumeLockHandler.access$100(this.this$0).equals(dabReceptionStatus)) {
            DABVolumeLockHandler.access$102(this.this$0, dabReceptionStatus);
            DABVolumeLockHandler.access$200(this.this$0);
        }
    }

    @Override
    public void selectServiceStatus(int n) {
        if (n != DABVolumeLockHandler.access$300(this.this$0)) {
            DABVolumeLockHandler.access$302(this.this$0, n);
            DABVolumeLockHandler.access$200(this.this$0);
        }
    }

    @Override
    public void seekServiceStatus(boolean bl) {
        if (DABVolumeLockHandler.access$400(this.this$0) != bl) {
            DABVolumeLockHandler.access$402(this.this$0, bl);
            DABVolumeLockHandler.access$200(this.this$0);
        }
    }

    @Override
    public void forceLMUpdateStatus(int n) {
        if (n != DABVolumeLockHandler.access$500(this.this$0)) {
            DABVolumeLockHandler.access$502(this.this$0, n);
            DABVolumeLockHandler.access$200(this.this$0);
        }
    }

    @Override
    public void updateDetectedDevice(int n) {
        if (n != DABVolumeLockHandler.access$600(this.this$0)) {
            DABVolumeLockHandler.access$602(this.this$0, n);
            DABVolumeLockHandler.access$200(this.this$0);
        }
    }

    /* synthetic */ DABVolumeLockHandler$DsiUpListener(DABVolumeLockHandler dABVolumeLockHandler, DABVolumeLockHandler$1 dABVolumeLockHandler$1) {
        this(dABVolumeLockHandler);
    }
}

