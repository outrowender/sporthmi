/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.uni;

import de.audi.tuner.app.TunerAudioMgmt;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.uni.UniDsiUpInfo;
import de.audi.tuner.app.uni.UniVolumeLockHandler$DsiUpListener;
import de.esolutions.fw.util.commons.Buffer;

class UniVolumeLockHandler {
    final UniDsiUpInfo dsiUpListener = new UniVolumeLockHandler$DsiUpListener(this, null);
    private boolean selectRunning = true;
    private final TunerAudioMgmt audio;
    private final TunerModels models;
    private int audioStatus = 1;
    private int detDevice = 1;

    UniVolumeLockHandler(TunerModels tunerModels, TunerAudioMgmt tunerAudioMgmt) {
        this.audio = tunerAudioMgmt;
        this.models = tunerModels;
    }

    void audioManagementJustBecameAvailable() {
        this.updateVolumeLock();
    }

    private void updateVolumeLock() {
        if (this.models.getActiveTuner() == 11) {
            if (this.detDevice != 3 || this.audioStatus == 3 || this.selectRunning) {
                Buffer buffer = new Buffer(100);
                buffer.append("selectRunning:").append(this.selectRunning);
                buffer.append(" lowReception:").append(this.audioStatus == 3);
                buffer.append(" devType:").append(this.detDevice);
                this.audio.lockVolume(5, buffer);
            } else {
                this.audio.unlockVolume(5, null);
            }
        }
    }

    static /* synthetic */ int access$102(UniVolumeLockHandler uniVolumeLockHandler, int n) {
        uniVolumeLockHandler.audioStatus = n;
        return uniVolumeLockHandler.audioStatus;
    }

    static /* synthetic */ void access$200(UniVolumeLockHandler uniVolumeLockHandler) {
        uniVolumeLockHandler.updateVolumeLock();
    }

    static /* synthetic */ boolean access$302(UniVolumeLockHandler uniVolumeLockHandler, boolean bl) {
        uniVolumeLockHandler.selectRunning = bl;
        return uniVolumeLockHandler.selectRunning;
    }

    static /* synthetic */ int access$402(UniVolumeLockHandler uniVolumeLockHandler, int n) {
        uniVolumeLockHandler.detDevice = n;
        return uniVolumeLockHandler.detDevice;
    }
}

