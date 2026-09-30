/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.sdars;

import de.audi.tuner.app.TunerAudioMgmt;
import de.audi.tuner.app.sdars.dsi.SDARSDsiUpInfo;
import de.esolutions.fw.util.commons.Buffer;
import org.dsi.ifc.sdars.ServiceStatus3;

class SDARSVolumeLockHandler {
    final SDARSDsiUpInfo dsiUpListener = new DsiUpListener();
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

    private class DsiUpListener
    extends SDARSDsiUpInfo {
        private DsiUpListener() {
        }

        public void selectStationStatus(int n) {
            if (n != SDARSVolumeLockHandler.this.selectStationStatus) {
                SDARSVolumeLockHandler.this.selectStationStatus = n;
                SDARSVolumeLockHandler.this.updateVolumeLock();
            }
        }

        public void updateDetectedDevice(int n) {
            if (n != SDARSVolumeLockHandler.this.detectedDevice) {
                SDARSVolumeLockHandler.this.detectedDevice = n;
                SDARSVolumeLockHandler.this.updateVolumeLock();
            }
        }

        public void updateServiceStatus3(ServiceStatus3 serviceStatus3) {
            if (serviceStatus3.audioStatus != SDARSVolumeLockHandler.this.audioStatus) {
                SDARSVolumeLockHandler.this.audioStatus = serviceStatus3.audioStatus;
                SDARSVolumeLockHandler.this.updateVolumeLock();
            }
        }
    }
}

