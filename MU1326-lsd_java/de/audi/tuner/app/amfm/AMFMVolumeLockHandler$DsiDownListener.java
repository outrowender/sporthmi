/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm;

import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.AMFMVolumeLockHandler;
import de.audi.tuner.app.amfm.AMFMVolumeLockHandler$1;
import de.audi.tuner.app.amfm.dsi.AMFMDsiDownInfo;

class AMFMVolumeLockHandler$DsiDownListener
extends AMFMDsiDownInfo {
    private final /* synthetic */ AMFMVolumeLockHandler this$0;

    private AMFMVolumeLockHandler$DsiDownListener(AMFMVolumeLockHandler aMFMVolumeLockHandler) {
        this.this$0 = aMFMVolumeLockHandler;
    }

    @Override
    public void preTuneAction(AMFMStation aMFMStation, boolean bl) {
        if (aMFMStation.waveband != AMFMVolumeLockHandler.access$200(this.this$0)) {
            AMFMVolumeLockHandler.access$202(this.this$0, aMFMStation.waveband);
            AMFMVolumeLockHandler.access$300(this.this$0);
        }
    }

    /* synthetic */ AMFMVolumeLockHandler$DsiDownListener(AMFMVolumeLockHandler aMFMVolumeLockHandler, AMFMVolumeLockHandler$1 aMFMVolumeLockHandler$1) {
        this(aMFMVolumeLockHandler);
    }
}

