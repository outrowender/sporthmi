/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.tuner.app.TunerAudioMgmt;
import de.audi.tuner.app.sdars.SDARSVolumeLockHandler$DsiUpListener;
import de.audi.tuner.app.sdars.dsi.SDARSDsiUpInfo;
import de.esolutions.fw.util.commons.Buffer;

class SDARSVolumeLockHandler {
    final SDARSDsiUpInfo dsiUpListener = new SDARSVolumeLockHandler$DsiUpListener(this, null);
    private int selectStationStatus = 1;
    private final TunerAudioMgmt audio;
    private int detectedDevice = 0;
    private int audioStatus = 0;

    SDARSVolumeLockHandler(TunerAudioMgmt tunerAudioMgmt) {
        this.audio = tunerAudioMgmt;
    }

    void audioManagementJustBecameAvailable() {
        this.updateVolumeLock();
    }

    private void updateVolumeLock() {
        if (this.detectedDevice != 3 || this.selectStationStatus == 1 || this.audioStatus == 1) {
            Buffer buffer = new Buffer(100);
            buffer.append("sel run:").append(this.selectStationStatus == 1);
            buffer.append(" mute:").append(this.audioStatus == 1);
            buffer.append(" devType:").append(this.detectedDevice);
            this.audio.lockVolume(7, buffer);
        } else {
            this.audio.unlockVolume(7, null);
        }
    }

    static /* synthetic */ int access$100(SDARSVolumeLockHandler sDARSVolumeLockHandler) {
        return sDARSVolumeLockHandler.selectStationStatus;
    }

    static /* synthetic */ int access$102(SDARSVolumeLockHandler sDARSVolumeLockHandler, int n) {
        sDARSVolumeLockHandler.selectStationStatus = n;
        return sDARSVolumeLockHandler.selectStationStatus;
    }

    static /* synthetic */ void access$200(SDARSVolumeLockHandler sDARSVolumeLockHandler) {
        sDARSVolumeLockHandler.updateVolumeLock();
    }

    static /* synthetic */ int access$300(SDARSVolumeLockHandler sDARSVolumeLockHandler) {
        return sDARSVolumeLockHandler.detectedDevice;
    }

    static /* synthetic */ int access$302(SDARSVolumeLockHandler sDARSVolumeLockHandler, int n) {
        sDARSVolumeLockHandler.detectedDevice = n;
        return sDARSVolumeLockHandler.detectedDevice;
    }

    static /* synthetic */ int access$400(SDARSVolumeLockHandler sDARSVolumeLockHandler) {
        return sDARSVolumeLockHandler.audioStatus;
    }

    static /* synthetic */ int access$402(SDARSVolumeLockHandler sDARSVolumeLockHandler, int n) {
        sDARSVolumeLockHandler.audioStatus = n;
        return sDARSVolumeLockHandler.audioStatus;
    }
}

