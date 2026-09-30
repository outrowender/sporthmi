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

    public void setNotification(int[] nArray, DSIListener dSIListener) {
        this.log();
    }

    public void setNotification(int n, DSIListener dSIListener) {
        this.log();
    }

    public void setNotification(DSIListener dSIListener) {
        this.log();
    }

    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        this.log();
    }

    public void clearNotification(int n, DSIListener dSIListener) {
        this.log();
    }

    public void clearNotification(DSIListener dSIListener) {
        this.log();
    }

    public void selectStation(int n, long l, int n2, int n3, int n4, int n5) {
        this.log();
    }

    public void setStationFollowingMode(int n) {
        this.log();
    }

    public void setListMode(int n) {
        this.log();
    }

    public void enableRadioTextPlus(int[] nArray) {
        this.log();
    }

    public void setSoftLinkSwitch(int n) {
        this.log();
    }

    public void setRegMode(int n) {
        this.log();
    }

    public void switchDeviceUsage(int n) {
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

