/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.util;

import de.audi.atip.log.LogChannel;
import de.audi.tuner.util.NullDSIService;
import org.dsi.ifc.radio.DSIAMFMTuner;

public class NullDSIAMFMTunerService
extends NullDSIService
implements DSIAMFMTuner {
    public NullDSIAMFMTunerService(LogChannel logChannel) {
        super(logChannel, "DSIAMFMTuner");
    }

    public NullDSIAMFMTunerService(LogChannel logChannel, int n) {
        super(logChannel, n, "DSIAMFMTuner");
    }

    public void tuneFrequencySteps(int n) {
        this.log();
    }

    public void selectStation(int n, int n2, int n3) {
        this.log();
    }

    public void prepareTuning(int n, int n2, int n3) {
        this.log();
    }

    public void seekStation(int n) {
        this.log();
    }

    public void switchAF(boolean bl) {
        this.log();
    }

    public void switchME(boolean bl) {
        this.log();
    }

    public void switchREG(int n) {
        this.log();
    }

    public void switchLinkingDeviceUsage(int n) {
        this.log();
    }

    public void reset(int n) {
        this.log();
    }

    public void selectFrequency(int n) {
        this.log();
    }

    public void setAMBandRange(int n) {
        this.log();
    }

    public void isOnPreset(int n, int n2, int n3, String string) {
        this.log();
    }

    public void forceFMUpdate(int n) {
        this.log();
    }

    public void switchPiIgnore(boolean bl) {
        this.log();
    }

    public void freePreset(int n) {
        this.log();
    }

    public void forceAMUpdate(int n) {
        this.log();
    }

    public void switchRDSIgnore(boolean bl) {
        this.log();
    }

    public void enableRadiotextPlus(int[] nArray) {
        this.log();
    }

    public void setModeHD(int n) {
        this.log();
    }

    public void setERTPrefered(boolean bl) {
        this.log();
    }

    public void setERTDisplayable(boolean bl) {
        this.log();
    }

    public void profileChange(int n) {
        this.log();
    }

    public void profileCopy(int n, int n2) {
        this.log();
    }

    public void profileReset(int n) {
        this.log();
    }

    public void profileResetAll() {
        this.log();
    }
}

