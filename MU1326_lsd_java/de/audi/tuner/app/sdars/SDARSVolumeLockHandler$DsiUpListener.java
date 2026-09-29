/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.tuner.app.sdars.SDARSVolumeLockHandler;
import de.audi.tuner.app.sdars.SDARSVolumeLockHandler$1;
import de.audi.tuner.app.sdars.dsi.SDARSDsiUpInfo;
import org.dsi.ifc.sdars.ServiceStatus3;

class SDARSVolumeLockHandler$DsiUpListener
extends SDARSDsiUpInfo {
    private final /* synthetic */ SDARSVolumeLockHandler this$0;

    private SDARSVolumeLockHandler$DsiUpListener(SDARSVolumeLockHandler sDARSVolumeLockHandler) {
        this.this$0 = sDARSVolumeLockHandler;
    }

    @Override
    public void selectStationStatus(int n) {
        if (n != SDARSVolumeLockHandler.access$100(this.this$0)) {
            SDARSVolumeLockHandler.access$102(this.this$0, n);
            SDARSVolumeLockHandler.access$200(this.this$0);
        }
    }

    @Override
    public void updateDetectedDevice(int n) {
        if (n != SDARSVolumeLockHandler.access$300(this.this$0)) {
            SDARSVolumeLockHandler.access$302(this.this$0, n);
            SDARSVolumeLockHandler.access$200(this.this$0);
        }
    }

    @Override
    public void updateServiceStatus3(ServiceStatus3 serviceStatus3) {
        if (serviceStatus3.audioStatus != SDARSVolumeLockHandler.access$400(this.this$0)) {
            SDARSVolumeLockHandler.access$402(this.this$0, serviceStatus3.audioStatus);
            SDARSVolumeLockHandler.access$200(this.this$0);
        }
    }

    /* synthetic */ SDARSVolumeLockHandler$DsiUpListener(SDARSVolumeLockHandler sDARSVolumeLockHandler, SDARSVolumeLockHandler$1 sDARSVolumeLockHandler$1) {
        this(sDARSVolumeLockHandler);
    }
}

