/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.util;

import de.audi.atip.log.LogChannel;
import de.audi.tuner.util.NullDSIService;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.radio.DSIUnifiedTuner;

public class NullDSIUnifiedTunerService
extends NullDSIService
implements DSIUnifiedTuner {
    public NullDSIUnifiedTunerService(LogChannel logChannel) {
        super(logChannel, "DSIUnifiedTuner");
    }

    @Override
    public void setNotification(int[] nArray, DSIListener dSIListener) {
        this.log();
    }

    @Override
    public void setNotification(int n, DSIListener dSIListener) {
        this.log();
    }

    @Override
    public void setNotification(DSIListener dSIListener) {
        this.log();
    }

    @Override
    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        this.log();
    }

    @Override
    public void clearNotification(int n, DSIListener dSIListener) {
        this.log();
    }

    @Override
    public void clearNotification(DSIListener dSIListener) {
        this.log();
    }

    @Override
    public void selectStation(int n, long l, int n2, int n3, int n4, int n5) {
        this.log();
    }

    @Override
    public void setStationFollowingMode(int n) {
        this.log();
    }

    @Override
    public void setListMode(int n) {
        this.log();
    }

    @Override
    public void enableRadioTextPlus(int[] nArray) {
        this.log();
    }

    @Override
    public void setSoftLinkSwitch(int n) {
        this.log();
    }

    @Override
    public void setRegMode(int n) {
        this.log();
    }

    @Override
    public void switchDeviceUsage(int n) {
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

