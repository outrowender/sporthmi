/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.util;

import de.audi.atip.log.LogChannel;
import de.audi.tuner.util.NullDSIService;
import org.dsi.ifc.sdars.DSISDARSTuner;

public class NullDSISDARSTunerService
extends NullDSIService
implements DSISDARSTuner {
    public NullDSISDARSTunerService(LogChannel logChannel) {
        super(logChannel, "DSISDARSTuner");
    }

    public void reset(int n) {
        this.log();
    }

    public void selectStation(int n, int n2) {
        this.log();
    }

    public void getTime() {
        this.log();
    }

    public void setRadioText2Config(int n, int n2) {
        this.log();
    }

    public void getEPG24Hour(int n) {
        this.log();
    }

    public void getEPGDescription(int n, int n2) {
        this.log();
    }

    public void hmiReady() {
        this.log();
    }

    public void notifyHMIReady(int n) {
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

