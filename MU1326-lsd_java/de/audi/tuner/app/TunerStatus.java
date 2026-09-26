/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.tuner.app.TunerModels;
import de.audi.tuner.app.TunerProxyManager;
import de.audi.tuner.app.TunerStatus$PowerEventListener;
import de.audi.tuner.app.TunerStatus$TunerActionProxyListenerExt;
import de.audi.tuner.app.ap.TunerActionProxyListener;
import de.esolutions.fw.util.commons.Buffer;

public class TunerStatus {
    public final TunerStatus$PowerEventListener powerEventListener = new TunerStatus$PowerEventListener(this, null);
    final TunerActionProxyListener actionProxyListener = new TunerStatus$TunerActionProxyListenerExt(this, null);
    private int[] activeScreen = new int[8];
    private boolean[] audioFocus = new boolean[8];
    private boolean taVolumeAdjustmentActive = false;
    private boolean displayStationNames = true;
    private boolean memoryListInitialized = false;
    private volatile boolean sdarsPresent = false;
    private volatile boolean ibocPresent = false;
    private boolean hdModeFmOn = false;
    private boolean hdModeAmOn = false;
    private boolean combiMemListActive = false;
    private boolean tunerVisible = true;
    private boolean tmpScreenActive = false;
    private boolean diagnosisActive = false;
    private boolean volumeLockFm = false;
    private boolean tiMode = false;
    private boolean ignoreAudioConnections = false;
    private boolean compoundAMBand = true;
    private int[] powerStates = new int[8];
    private boolean sdsActive;
    private final TunerModels models;
    private boolean porscheNameMode = true;

    TunerStatus(TunerModels tunerModels) {
        this.models = tunerModels;
        for (int i2 = 0; i2 < 8; ++i2) {
            this.powerStates[i2] = 2;
        }
    }

    void setAudioFocus(boolean bl, int n) {
        this.audioFocus[n] = bl;
        switch (n) {
            case 0: {
                this.audioFocus[1] = bl;
                break;
            }
            case 2: {
                this.audioFocus[3] = bl;
                this.audioFocus[4] = bl;
                break;
            }
            case 3: {
                this.audioFocus[2] = bl;
                this.audioFocus[4] = bl;
                break;
            }
            case 4: {
                this.audioFocus[2] = bl;
                this.audioFocus[3] = bl;
                break;
            }
        }
    }

    public boolean hasAudioFocus(int n) {
        if (this.ignoreAudioConnections) {
            return true;
        }
        return n == -1 ? false : this.audioFocus[n];
    }

    public boolean[] getAudioFocus() {
        return this.audioFocus;
    }

    public void setTaVolumeAdjustmentActive(boolean bl) {
        this.taVolumeAdjustmentActive = bl;
    }

    public boolean isTaVolumeAdjustmentActive() {
        return this.taVolumeAdjustmentActive;
    }

    public void setDisplayStationNames(boolean bl) {
        this.displayStationNames = bl;
    }

    public boolean isDisplayStationNames() {
        return this.displayStationNames;
    }

    public void setMemoryListInitialized(boolean bl) {
        this.memoryListInitialized = bl;
    }

    public boolean isMemoryListInitialized() {
        return this.memoryListInitialized;
    }

    public void setSdarsPresent(boolean bl) {
        this.sdarsPresent = bl;
    }

    public boolean isSdarsPresent() {
        return this.sdarsPresent;
    }

    public void setIbocPresent(boolean bl) {
        this.ibocPresent = bl;
    }

    public boolean isIbocPresent() {
        return this.ibocPresent;
    }

    public void setFmHdModeOn(boolean bl) {
        this.hdModeFmOn = bl;
    }

    public boolean isFmHdModeOn() {
        return this.hdModeFmOn;
    }

    public void setAmHdModeOn(boolean bl) {
        this.hdModeAmOn = bl;
    }

    public boolean isAmHdModeOn() {
        return this.hdModeAmOn;
    }

    public void setCombiMemListActive(boolean bl) {
        this.combiMemListActive = bl;
    }

    public boolean isCombiMemListActive() {
        return this.combiMemListActive;
    }

    public boolean isPowerStateON() {
        return this.powerStates[0] == 0;
    }

    public void setTunerVisible(boolean bl) {
        this.tunerVisible = bl;
    }

    public boolean isTunerVisible() {
        return this.tunerVisible;
    }

    public void setTmpScreenActive(boolean bl) {
        this.tmpScreenActive = bl;
    }

    public boolean isTmpScreenActive() {
        return this.tmpScreenActive;
    }

    public void setDiagnosisActive(boolean bl) {
        this.diagnosisActive = bl;
    }

    public boolean isDiagnosisActive() {
        return this.diagnosisActive;
    }

    public void setVolumeLockFm(boolean bl) {
        this.volumeLockFm = bl;
    }

    public boolean isVolumeLockFm() {
        return this.volumeLockFm;
    }

    public void setTiMode(boolean bl) {
        this.tiMode = bl;
    }

    public boolean isTiMode() {
        return this.tiMode;
    }

    public void setIgnoreAudioConnection(boolean bl) {
        this.ignoreAudioConnections = bl;
    }

    public boolean isIgnoreAudioConnection() {
        return this.ignoreAudioConnections;
    }

    public void setCompoundAMBand(boolean bl) {
        this.compoundAMBand = bl;
    }

    public boolean isCompoundAMBand() {
        return this.compoundAMBand;
    }

    public void setPowerState(int n, int n2) {
        if (n2 < 8) {
            this.powerStates[n2] = n;
        }
    }

    public int getPowerState(int n) {
        if (n < 8) {
            return this.powerStates[n];
        }
        return 2;
    }

    public String toString() {
        Buffer buffer = new Buffer(400);
        buffer.append("combiMemListActive: ");
        buffer.append(this.combiMemListActive);
        buffer.append('\n');
        buffer.append("hasAudioFocus: ");
        for (int i2 = 0; i2 < this.audioFocus.length; ++i2) {
            buffer.append(this.audioFocus[i2]);
            buffer.append(' ');
        }
        buffer.append('\n');
        buffer.append("memoryListInitialized: ");
        buffer.append(this.memoryListInitialized);
        buffer.append('\n');
        buffer.append("tunerVisible: ");
        buffer.append(this.tunerVisible);
        buffer.append('\n');
        buffer.append("bandChangeAllowed: ");
        buffer.append(this.powerStates[0] == 0);
        buffer.append('\n');
        buffer.append("activeScreen: ");
        buffer.append(this.activeScreen);
        buffer.append('\n');
        buffer.append("getActiveStation: ");
        buffer.append(TunerProxyManager.getInstance().getAmFmTuner().getActiveStation().toString());
        buffer.append('\n');
        buffer.append("getActiveStationAM: ");
        buffer.append(TunerProxyManager.getInstance().getAmFmTuner().getActiveStation(4).toString());
        buffer.append('\n');
        buffer.append("getActiveStationFM: ");
        buffer.append(TunerProxyManager.getInstance().getAmFmTuner().getActiveStation(1).toString());
        buffer.append('\n');
        buffer.append("tiMode: ");
        buffer.append(this.tiMode);
        buffer.append('\n');
        buffer.append("activeScreen Main: ");
        buffer.append(this.activeScreen[0]);
        buffer.append('\n');
        return buffer.toString();
    }

    public int getSleepScreenActivationTime() {
        return 0;
    }

    public void setSDSActive(boolean bl) {
        this.sdsActive = bl;
    }

    public boolean isSDSActive() {
        return this.sdsActive;
    }

    public void setPorscheNameMode(boolean bl) {
        this.porscheNameMode = bl;
    }

    public boolean isPorscheNameMode() {
        return this.porscheNameMode;
    }

    static /* synthetic */ TunerModels access$200(TunerStatus tunerStatus) {
        return tunerStatus.models;
    }

    static /* synthetic */ int[] access$300(TunerStatus tunerStatus) {
        return tunerStatus.powerStates;
    }
}

