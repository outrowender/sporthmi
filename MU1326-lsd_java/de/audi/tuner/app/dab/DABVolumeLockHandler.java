/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab;

import de.audi.tuner.app.TunerAudioMgmt;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.dab.DABDsiUpInfo;
import de.audi.tuner.app.dab.DABVolumeLockHandler$DsiUpListener;
import de.audi.tuner.app.dab.DabReceptionStatus;
import de.esolutions.fw.util.commons.Buffer;

class DABVolumeLockHandler {
    final DABDsiUpInfo dsiUpListener = new DABVolumeLockHandler$DsiUpListener(this, null);
    private int selectServiceStatus = 1;
    private boolean seekRunning = false;
    private DabReceptionStatus reception = new DabReceptionStatus(0, 0);
    private int listUpdateStatus = 0;
    private int detectedDevice = 0;
    private final TunerAudioMgmt audio;
    private final TunerModels models;

    DABVolumeLockHandler(TunerModels tunerModels, TunerAudioMgmt tunerAudioMgmt) {
        this.audio = tunerAudioMgmt;
        this.models = tunerModels;
    }

    void audioManagementJustBecameAvailable() {
        this.updateVolumeLock();
    }

    private void updateVolumeLock() {
        if (this.models.getActiveTuner() == 5) {
            if (this.detectedDevice != 3 || this.selectServiceStatus == 1 || this.seekRunning || this.listUpdateStatus == 1) {
                Buffer buffer = new Buffer(100);
                buffer.append("selServ:").append(this.selectServiceStatus == 1);
                buffer.append(" seek:").append(this.seekRunning);
                buffer.append(" listUpd:").append(this.listUpdateStatus == 1);
                buffer.append(" devType:").append(this.detectedDevice);
                this.audio.lockVolume(5, buffer);
            } else if (this.reception.linkStatus != 2 && this.reception.syncStatus != 4) {
                Buffer buffer = new Buffer(100);
                buffer.append("syncStatus:").append(this.reception.syncStatus);
                buffer.append(" linkStatus:").append(this.reception.linkStatus);
                this.audio.lockVolume(5, buffer);
            } else {
                this.audio.unlockVolume(5, null);
            }
        }
    }

    static /* synthetic */ DabReceptionStatus access$100(DABVolumeLockHandler dABVolumeLockHandler) {
        return dABVolumeLockHandler.reception;
    }

    static /* synthetic */ DabReceptionStatus access$102(DABVolumeLockHandler dABVolumeLockHandler, DabReceptionStatus dabReceptionStatus) {
        dABVolumeLockHandler.reception = dabReceptionStatus;
        return dABVolumeLockHandler.reception;
    }

    static /* synthetic */ void access$200(DABVolumeLockHandler dABVolumeLockHandler) {
        dABVolumeLockHandler.updateVolumeLock();
    }

    static /* synthetic */ int access$300(DABVolumeLockHandler dABVolumeLockHandler) {
        return dABVolumeLockHandler.selectServiceStatus;
    }

    static /* synthetic */ int access$302(DABVolumeLockHandler dABVolumeLockHandler, int n) {
        dABVolumeLockHandler.selectServiceStatus = n;
        return dABVolumeLockHandler.selectServiceStatus;
    }

    static /* synthetic */ boolean access$400(DABVolumeLockHandler dABVolumeLockHandler) {
        return dABVolumeLockHandler.seekRunning;
    }

    static /* synthetic */ boolean access$402(DABVolumeLockHandler dABVolumeLockHandler, boolean bl) {
        dABVolumeLockHandler.seekRunning = bl;
        return dABVolumeLockHandler.seekRunning;
    }

    static /* synthetic */ int access$500(DABVolumeLockHandler dABVolumeLockHandler) {
        return dABVolumeLockHandler.listUpdateStatus;
    }

    static /* synthetic */ int access$502(DABVolumeLockHandler dABVolumeLockHandler, int n) {
        dABVolumeLockHandler.listUpdateStatus = n;
        return dABVolumeLockHandler.listUpdateStatus;
    }

    static /* synthetic */ int access$600(DABVolumeLockHandler dABVolumeLockHandler) {
        return dABVolumeLockHandler.detectedDevice;
    }

    static /* synthetic */ int access$602(DABVolumeLockHandler dABVolumeLockHandler, int n) {
        dABVolumeLockHandler.detectedDevice = n;
        return dABVolumeLockHandler.detectedDevice;
    }
}

