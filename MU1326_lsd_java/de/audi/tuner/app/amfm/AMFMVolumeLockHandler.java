/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm;

import de.audi.atip.log.LogChannel;
import de.audi.tuner.app.TunerAudioMgmt;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.dsi.AMFMDsiDownInfo;
import de.audi.tuner.app.amfm.dsi.AMFMDsiUpInfo;
import de.esolutions.fw.util.commons.Buffer;

class AMFMVolumeLockHandler {
    final AMFMDsiDownInfo dsiDownListener = new DsiDownListener();
    final AMFMDsiUpInfo dsiUpListener = new DsiUpListener();
    private final TunerAudioMgmt audio;
    private final LogChannel log;
    private boolean selectStationRunning = true;
    private boolean selectFrequencyRunning = false;
    private boolean seekStationsRunning;
    private boolean listUpdateRunning = false;
    private int audioStatus = 0;
    private int waveband = 0;
    private int detectedDevice = 1;

    AMFMVolumeLockHandler(TunerAudioMgmt tunerAudioMgmt, LogChannel logChannel) {
        this.audio = tunerAudioMgmt;
        this.log = logChannel;
    }

    void audioManagementJustBecameAvailable() {
        this.updateVolumeLock();
    }

    private void updateVolumeLock() {
        boolean bl;
        boolean bl2 = bl = this.detectedDevice == 3 || this.detectedDevice == 4;
        if (this.selectStationRunning || this.selectFrequencyRunning || this.seekStationsRunning || this.listUpdateRunning || !bl || this.audioStatus == 3) {
            Buffer buffer = new Buffer(100);
            buffer.append("Band:").append(this.waveband == 1 ? "FM" : "AM");
            buffer.append(" selSt:").append(this.selectStationRunning);
            buffer.append(" selFreq:").append(this.selectFrequencyRunning);
            buffer.append(" seek:").append(this.seekStationsRunning);
            buffer.append(" listUpd:").append(this.listUpdateRunning);
            buffer.append(" detectedDevice:").append(this.detectedDevice);
            buffer.append(" HDMute:").append(this.audioStatus == 3);
            this.audio.lockVolume(this.waveband == 1 ? 1 : 4, buffer);
        } else {
            this.audio.unlockVolume(this.waveband == 1 ? 1 : 4, null);
        }
    }

    private class DsiUpListener
    extends AMFMDsiUpInfo {
        private DsiUpListener() {
        }

        private void dumpError() {
            Buffer buffer = new Buffer(100);
            buffer.append("Band:").append(AMFMVolumeLockHandler.this.waveband == 1 ? "FM" : "AM");
            buffer.append(" selSt:").append(AMFMVolumeLockHandler.this.selectStationRunning);
            buffer.append(" selFreq:").append(AMFMVolumeLockHandler.this.selectFrequencyRunning);
            buffer.append(" seek:").append(AMFMVolumeLockHandler.this.seekStationsRunning);
            buffer.append(" listUpd:").append(AMFMVolumeLockHandler.this.listUpdateRunning);
            buffer.append(" HDMute:").append(AMFMVolumeLockHandler.this.audioStatus == 3);
            AMFMVolumeLockHandler.this.log.log(10000, "VolumeLockHandler: wrong state: %1", (Object)buffer);
        }

        public void selectStationStatus(int n) {
            boolean bl;
            boolean bl2 = bl = n == 1;
            if (bl != AMFMVolumeLockHandler.this.selectStationRunning) {
                AMFMVolumeLockHandler.this.selectStationRunning = bl;
                if (bl && (AMFMVolumeLockHandler.this.selectFrequencyRunning || AMFMVolumeLockHandler.this.seekStationsRunning)) {
                    this.dumpError();
                    AMFMVolumeLockHandler.this.selectFrequencyRunning = false;
                    AMFMVolumeLockHandler.this.seekStationsRunning = false;
                }
                AMFMVolumeLockHandler.this.updateVolumeLock();
            }
        }

        public void selectFrequencyStatus(int n) {
            boolean bl;
            boolean bl2 = bl = n == 1;
            if (bl != AMFMVolumeLockHandler.this.selectFrequencyRunning) {
                AMFMVolumeLockHandler.this.selectFrequencyRunning = bl;
                if (bl && (AMFMVolumeLockHandler.this.selectStationRunning || AMFMVolumeLockHandler.this.seekStationsRunning)) {
                    this.dumpError();
                    AMFMVolumeLockHandler.this.selectStationRunning = false;
                    AMFMVolumeLockHandler.this.seekStationsRunning = false;
                }
                AMFMVolumeLockHandler.this.updateVolumeLock();
            }
        }

        public void seekStationStatus(boolean bl) {
            if (bl != AMFMVolumeLockHandler.this.seekStationsRunning) {
                AMFMVolumeLockHandler.this.seekStationsRunning = bl;
                if (bl && (AMFMVolumeLockHandler.this.selectStationRunning || AMFMVolumeLockHandler.this.selectFrequencyRunning)) {
                    this.dumpError();
                    AMFMVolumeLockHandler.this.selectStationRunning = false;
                    AMFMVolumeLockHandler.this.selectFrequencyRunning = false;
                }
                AMFMVolumeLockHandler.this.updateVolumeLock();
            }
        }

        public void forceAMUpdateStatus(int n) {
            boolean bl;
            boolean bl2 = bl = n == 1;
            if (bl != AMFMVolumeLockHandler.this.listUpdateRunning) {
                AMFMVolumeLockHandler.this.listUpdateRunning = bl;
                if (bl && (AMFMVolumeLockHandler.this.selectStationRunning || AMFMVolumeLockHandler.this.selectFrequencyRunning || AMFMVolumeLockHandler.this.seekStationsRunning)) {
                    this.dumpError();
                    AMFMVolumeLockHandler.this.selectStationRunning = false;
                    AMFMVolumeLockHandler.this.selectFrequencyRunning = false;
                    AMFMVolumeLockHandler.this.seekStationsRunning = false;
                }
                AMFMVolumeLockHandler.this.updateVolumeLock();
            }
        }

        public void updateSelectedStation(AMFMStation aMFMStation) {
            if (aMFMStation.getAudioStatus() != AMFMVolumeLockHandler.this.audioStatus || aMFMStation.waveband != AMFMVolumeLockHandler.this.waveband) {
                AMFMVolumeLockHandler.this.audioStatus = aMFMStation.getAudioStatus();
                AMFMVolumeLockHandler.this.waveband = aMFMStation.waveband;
                AMFMVolumeLockHandler.this.updateVolumeLock();
            }
        }

        public void updateDetectedDevice(int n) {
            if (AMFMVolumeLockHandler.this.detectedDevice != n) {
                AMFMVolumeLockHandler.this.detectedDevice = n;
                AMFMVolumeLockHandler.this.updateVolumeLock();
            }
        }
    }

    private class DsiDownListener
    extends AMFMDsiDownInfo {
        private DsiDownListener() {
        }

        public void preTuneAction(AMFMStation aMFMStation, boolean bl) {
            if (aMFMStation.waveband != AMFMVolumeLockHandler.this.waveband) {
                AMFMVolumeLockHandler.this.waveband = aMFMStation.waveband;
                AMFMVolumeLockHandler.this.updateVolumeLock();
            }
        }
    }
}

