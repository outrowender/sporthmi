/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm;

import de.audi.atip.log.LogChannel;
import de.audi.tuner.app.TunerAudioMgmt;
import de.audi.tuner.app.amfm.AMFMVolumeLockHandler$DsiDownListener;
import de.audi.tuner.app.amfm.AMFMVolumeLockHandler$DsiUpListener;
import de.audi.tuner.app.amfm.dsi.AMFMDsiDownInfo;
import de.audi.tuner.app.amfm.dsi.AMFMDsiUpInfo;
import de.esolutions.fw.util.commons.Buffer;

class AMFMVolumeLockHandler {
    final AMFMDsiDownInfo dsiDownListener = new AMFMVolumeLockHandler$DsiDownListener(this, null);
    final AMFMDsiUpInfo dsiUpListener = new AMFMVolumeLockHandler$DsiUpListener(this, null);
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

    static /* synthetic */ int access$200(AMFMVolumeLockHandler aMFMVolumeLockHandler) {
        return aMFMVolumeLockHandler.waveband;
    }

    static /* synthetic */ int access$202(AMFMVolumeLockHandler aMFMVolumeLockHandler, int n) {
        aMFMVolumeLockHandler.waveband = n;
        return aMFMVolumeLockHandler.waveband;
    }

    static /* synthetic */ void access$300(AMFMVolumeLockHandler aMFMVolumeLockHandler) {
        aMFMVolumeLockHandler.updateVolumeLock();
    }

    static /* synthetic */ boolean access$400(AMFMVolumeLockHandler aMFMVolumeLockHandler) {
        return aMFMVolumeLockHandler.selectStationRunning;
    }

    static /* synthetic */ boolean access$500(AMFMVolumeLockHandler aMFMVolumeLockHandler) {
        return aMFMVolumeLockHandler.selectFrequencyRunning;
    }

    static /* synthetic */ boolean access$600(AMFMVolumeLockHandler aMFMVolumeLockHandler) {
        return aMFMVolumeLockHandler.seekStationsRunning;
    }

    static /* synthetic */ boolean access$700(AMFMVolumeLockHandler aMFMVolumeLockHandler) {
        return aMFMVolumeLockHandler.listUpdateRunning;
    }

    static /* synthetic */ int access$800(AMFMVolumeLockHandler aMFMVolumeLockHandler) {
        return aMFMVolumeLockHandler.audioStatus;
    }

    static /* synthetic */ LogChannel access$900(AMFMVolumeLockHandler aMFMVolumeLockHandler) {
        return aMFMVolumeLockHandler.log;
    }

    static /* synthetic */ boolean access$402(AMFMVolumeLockHandler aMFMVolumeLockHandler, boolean bl) {
        aMFMVolumeLockHandler.selectStationRunning = bl;
        return aMFMVolumeLockHandler.selectStationRunning;
    }

    static /* synthetic */ boolean access$502(AMFMVolumeLockHandler aMFMVolumeLockHandler, boolean bl) {
        aMFMVolumeLockHandler.selectFrequencyRunning = bl;
        return aMFMVolumeLockHandler.selectFrequencyRunning;
    }

    static /* synthetic */ boolean access$602(AMFMVolumeLockHandler aMFMVolumeLockHandler, boolean bl) {
        aMFMVolumeLockHandler.seekStationsRunning = bl;
        return aMFMVolumeLockHandler.seekStationsRunning;
    }

    static /* synthetic */ boolean access$702(AMFMVolumeLockHandler aMFMVolumeLockHandler, boolean bl) {
        aMFMVolumeLockHandler.listUpdateRunning = bl;
        return aMFMVolumeLockHandler.listUpdateRunning;
    }

    static /* synthetic */ int access$802(AMFMVolumeLockHandler aMFMVolumeLockHandler, int n) {
        aMFMVolumeLockHandler.audioStatus = n;
        return aMFMVolumeLockHandler.audioStatus;
    }

    static /* synthetic */ int access$1000(AMFMVolumeLockHandler aMFMVolumeLockHandler) {
        return aMFMVolumeLockHandler.detectedDevice;
    }

    static /* synthetic */ int access$1002(AMFMVolumeLockHandler aMFMVolumeLockHandler, int n) {
        aMFMVolumeLockHandler.detectedDevice = n;
        return aMFMVolumeLockHandler.detectedDevice;
    }
}

