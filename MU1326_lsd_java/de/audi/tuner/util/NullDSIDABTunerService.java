/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.util;

import de.audi.atip.log.LogChannel;
import de.audi.tuner.util.NullDSIService;
import org.dsi.ifc.radio.DSIDABTuner;

public class NullDSIDABTunerService
extends NullDSIService
implements DSIDABTuner {
    public NullDSIDABTunerService(LogChannel logChannel) {
        super(logChannel, "DSIDABTuner");
    }

    public NullDSIDABTunerService(LogChannel logChannel, int n) {
        super(logChannel, n, "DSIDABTuner");
    }

    public void selectService(int n, long l, int n2, int n3, int n4, int n5, long l2) {
        this.log();
    }

    public void seekService(int n) {
        this.log();
    }

    public void tuneEnsemble(int n, int n2, int n3, long l) {
        this.log();
    }

    public void selectDataService(int n, int n2, long l, int n3) {
        this.log();
    }

    public void switchDRC(boolean bl) {
        this.log();
    }

    public void switchLinking(int n) {
        this.log();
    }

    public void switchLinkingDeviceUsage(int n) {
        this.log();
    }

    public void switchFrequencyTable(int n) {
        this.log();
    }

    public void reset(int n) {
        this.log();
    }

    public void forceLMUpdate(int n) {
        this.log();
    }

    public void prepareTuning(int n, long l, int n2, int n3, int n4, int n5) {
        this.log();
    }

    public void enableRadioTextPlus(int[] nArray) {
        this.log();
    }

    public void setEpgMode(int n) {
        this.log();
    }

    public void setSlideShowMode(int n) {
        this.log();
    }

    public void setIntellitextMode(int n) {
        this.log();
    }

    public void getEPGDetailData(int n, int n2, long l, int n3) {
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

