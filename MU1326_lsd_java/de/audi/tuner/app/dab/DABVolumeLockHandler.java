/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.dab;

import de.audi.tuner.app.TunerAudioMgmt;
import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.dab.DABDsiUpInfo;
import de.audi.tuner.app.dab.DabReceptionStatus;
import de.esolutions.fw.util.commons.Buffer;

class DABVolumeLockHandler {
    final DABDsiUpInfo dsiUpListener = new DsiUpListener();
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

    private class DsiUpListener
    extends DABDsiUpInfo {
        private DsiUpListener() {
        }

        public void updateReceptionStatus(DabReceptionStatus dabReceptionStatus) {
            if (!DABVolumeLockHandler.this.reception.equals(dabReceptionStatus)) {
                DABVolumeLockHandler.this.reception = dabReceptionStatus;
                DABVolumeLockHandler.this.updateVolumeLock();
            }
        }

        public void selectServiceStatus(int n) {
            if (n != DABVolumeLockHandler.this.selectServiceStatus) {
                DABVolumeLockHandler.this.selectServiceStatus = n;
                DABVolumeLockHandler.this.updateVolumeLock();
            }
        }

        public void seekServiceStatus(boolean bl) {
            if (DABVolumeLockHandler.this.seekRunning != bl) {
                DABVolumeLockHandler.this.seekRunning = bl;
                DABVolumeLockHandler.this.updateVolumeLock();
            }
        }

        public void forceLMUpdateStatus(int n) {
            if (n != DABVolumeLockHandler.this.listUpdateStatus) {
                DABVolumeLockHandler.this.listUpdateStatus = n;
                DABVolumeLockHandler.this.updateVolumeLock();
            }
        }

        public void updateDetectedDevice(int n) {
            if (n != DABVolumeLockHandler.this.detectedDevice) {
                DABVolumeLockHandler.this.detectedDevice = n;
                DABVolumeLockHandler.this.updateVolumeLock();
            }
        }
    }
}

