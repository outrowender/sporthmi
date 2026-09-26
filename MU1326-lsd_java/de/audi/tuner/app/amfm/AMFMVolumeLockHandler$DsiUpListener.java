/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm;

import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.AMFMVolumeLockHandler;
import de.audi.tuner.app.amfm.AMFMVolumeLockHandler$1;
import de.audi.tuner.app.amfm.dsi.AMFMDsiUpInfo;
import de.esolutions.fw.util.commons.Buffer;

class AMFMVolumeLockHandler$DsiUpListener
extends AMFMDsiUpInfo {
    private final /* synthetic */ AMFMVolumeLockHandler this$0;

    private AMFMVolumeLockHandler$DsiUpListener(AMFMVolumeLockHandler aMFMVolumeLockHandler) {
        this.this$0 = aMFMVolumeLockHandler;
    }

    private void dumpError() {
        Buffer buffer = new Buffer(100);
        buffer.append("Band:").append(AMFMVolumeLockHandler.access$200(this.this$0) == 1 ? "FM" : "AM");
        buffer.append(" selSt:").append(AMFMVolumeLockHandler.access$400(this.this$0));
        buffer.append(" selFreq:").append(AMFMVolumeLockHandler.access$500(this.this$0));
        buffer.append(" seek:").append(AMFMVolumeLockHandler.access$600(this.this$0));
        buffer.append(" listUpd:").append(AMFMVolumeLockHandler.access$700(this.this$0));
        buffer.append(" HDMute:").append(AMFMVolumeLockHandler.access$800(this.this$0) == 3);
        AMFMVolumeLockHandler.access$900(this.this$0).log(10000, "VolumeLockHandler: wrong state: %1", (Object)buffer);
    }

    @Override
    public void selectStationStatus(int n) {
        boolean bl;
        boolean bl2 = bl = n == 1;
        if (bl != AMFMVolumeLockHandler.access$400(this.this$0)) {
            AMFMVolumeLockHandler.access$402(this.this$0, bl);
            if (bl && (AMFMVolumeLockHandler.access$500(this.this$0) || AMFMVolumeLockHandler.access$600(this.this$0))) {
                this.dumpError();
                AMFMVolumeLockHandler.access$502(this.this$0, false);
                AMFMVolumeLockHandler.access$602(this.this$0, false);
            }
            AMFMVolumeLockHandler.access$300(this.this$0);
        }
    }

    @Override
    public void selectFrequencyStatus(int n) {
        boolean bl;
        boolean bl2 = bl = n == 1;
        if (bl != AMFMVolumeLockHandler.access$500(this.this$0)) {
            AMFMVolumeLockHandler.access$502(this.this$0, bl);
            if (bl && (AMFMVolumeLockHandler.access$400(this.this$0) || AMFMVolumeLockHandler.access$600(this.this$0))) {
                this.dumpError();
                AMFMVolumeLockHandler.access$402(this.this$0, false);
                AMFMVolumeLockHandler.access$602(this.this$0, false);
            }
            AMFMVolumeLockHandler.access$300(this.this$0);
        }
    }

    @Override
    public void seekStationStatus(boolean bl) {
        if (bl != AMFMVolumeLockHandler.access$600(this.this$0)) {
            AMFMVolumeLockHandler.access$602(this.this$0, bl);
            if (bl && (AMFMVolumeLockHandler.access$400(this.this$0) || AMFMVolumeLockHandler.access$500(this.this$0))) {
                this.dumpError();
                AMFMVolumeLockHandler.access$402(this.this$0, false);
                AMFMVolumeLockHandler.access$502(this.this$0, false);
            }
            AMFMVolumeLockHandler.access$300(this.this$0);
        }
    }

    @Override
    public void forceAMUpdateStatus(int n) {
        boolean bl;
        boolean bl2 = bl = n == 1;
        if (bl != AMFMVolumeLockHandler.access$700(this.this$0)) {
            AMFMVolumeLockHandler.access$702(this.this$0, bl);
            if (bl && (AMFMVolumeLockHandler.access$400(this.this$0) || AMFMVolumeLockHandler.access$500(this.this$0) || AMFMVolumeLockHandler.access$600(this.this$0))) {
                this.dumpError();
                AMFMVolumeLockHandler.access$402(this.this$0, false);
                AMFMVolumeLockHandler.access$502(this.this$0, false);
                AMFMVolumeLockHandler.access$602(this.this$0, false);
            }
            AMFMVolumeLockHandler.access$300(this.this$0);
        }
    }

    @Override
    public void updateSelectedStation(AMFMStation aMFMStation) {
        if (aMFMStation.getAudioStatus() != AMFMVolumeLockHandler.access$800(this.this$0) || aMFMStation.waveband != AMFMVolumeLockHandler.access$200(this.this$0)) {
            AMFMVolumeLockHandler.access$802(this.this$0, aMFMStation.getAudioStatus());
            AMFMVolumeLockHandler.access$202(this.this$0, aMFMStation.waveband);
            AMFMVolumeLockHandler.access$300(this.this$0);
        }
    }

    @Override
    public void updateDetectedDevice(int n) {
        if (AMFMVolumeLockHandler.access$1000(this.this$0) != n) {
            AMFMVolumeLockHandler.access$1002(this.this$0, n);
            AMFMVolumeLockHandler.access$300(this.this$0);
        }
    }

    /* synthetic */ AMFMVolumeLockHandler$DsiUpListener(AMFMVolumeLockHandler aMFMVolumeLockHandler, AMFMVolumeLockHandler$1 aMFMVolumeLockHandler$1) {
        this(aMFMVolumeLockHandler);
    }
}

