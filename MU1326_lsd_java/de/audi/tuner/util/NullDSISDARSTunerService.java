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

    @Override
    public void reset(int n) {
        this.log();
    }

    @Override
    public void selectStation(int n, int n2) {
        this.log();
    }

    @Override
    public void getTime() {
        this.log();
    }

    @Override
    public void setRadioText2Config(int n, int n2) {
        this.log();
    }

    @Override
    public void getEPG24Hour(int n) {
        this.log();
    }

    @Override
    public void getEPGDescription(int n, int n2) {
        this.log();
    }

    public void hmiReady() {
        this.log();
    }

    @Override
    public void notifyHMIReady(int n) {
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

