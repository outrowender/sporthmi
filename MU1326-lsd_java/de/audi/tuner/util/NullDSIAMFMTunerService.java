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

    @Override
    public void tuneFrequencySteps(int n) {
        this.log();
    }

    @Override
    public void selectStation(int n, int n2, int n3) {
        this.log();
    }

    @Override
    public void prepareTuning(int n, int n2, int n3) {
        this.log();
    }

    @Override
    public void seekStation(int n) {
        this.log();
    }

    @Override
    public void switchAF(boolean bl) {
        this.log();
    }

    @Override
    public void switchME(boolean bl) {
        this.log();
    }

    @Override
    public void switchREG(int n) {
        this.log();
    }

    @Override
    public void switchLinkingDeviceUsage(int n) {
        this.log();
    }

    @Override
    public void reset(int n) {
        this.log();
    }

    @Override
    public void selectFrequency(int n) {
        this.log();
    }

    @Override
    public void setAMBandRange(int n) {
        this.log();
    }

    @Override
    public void isOnPreset(int n, int n2, int n3, String string) {
        this.log();
    }

    @Override
    public void forceFMUpdate(int n) {
        this.log();
    }

    @Override
    public void switchPiIgnore(boolean bl) {
        this.log();
    }

    @Override
    public void freePreset(int n) {
        this.log();
    }

    @Override
    public void forceAMUpdate(int n) {
        this.log();
    }

    @Override
    public void switchRDSIgnore(boolean bl) {
        this.log();
    }

    @Override
    public void enableRadiotextPlus(int[] nArray) {
        this.log();
    }

    @Override
    public void setModeHD(int n) {
        this.log();
    }

    @Override
    public void setERTPrefered(boolean bl) {
        this.log();
    }

    @Override
    public void setERTDisplayable(boolean bl) {
        this.log();
    }

    @Override
    public void profileChange(int n) {
        this.log();
    }

    @Override
    public void profileCopy(int n, int n2) {
        this.log();
    }

    @Override
    public void profileReset(int n) {
        this.log();
    }

    @Override
    public void profileResetAll() {
        this.log();
    }
}

