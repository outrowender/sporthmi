/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app;

import de.audi.atip.interapp.def.NullService;
import de.audi.atip.log.LogChannel;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.dsi.AMFMDsiUpInfo;
import de.audi.tuner.app.amfm.dsi.IAmFmDsiDownManager;
import de.audi.tuner.app.amfm.dsi.RadioInfo;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.radio.DSIAMFMTuner;

class NullAmFmDsiDownManager
extends NullService
implements IAmFmDsiDownManager {
    NullAmFmDsiDownManager(LogChannel logChannel) {
        super(logChannel, "IAmFmDsiDownManager");
    }

    public void isOnPreset(int n, int n2, int n3, String string) {
        this.log();
    }

    public void enableRadiotextPlus(int[] nArray) {
        this.log();
    }

    public AMFMDsiUpInfo getDsiUpListener() {
        this.log();
        return null;
    }

    public void register(RadioInfo radioInfo) {
        this.log();
    }

    public void forceAMUpdate(int n) {
        this.log();
    }

    public void switchAF(boolean bl) {
        this.log();
    }

    public void switchREG(int n) {
        this.log();
    }

    public void tuneStation(AMFMStation aMFMStation, boolean bl, boolean bl2, int n) {
        this.log();
    }

    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        this.log();
    }

    public void setNotification(int[] nArray, DSIListener dSIListener) {
        this.log();
    }

    public void reNotification(int n) {
        this.log();
    }

    public void switchRDSIgnore(boolean bl) {
        this.log();
    }

    public boolean isDsiFound() {
        this.log();
        return false;
    }

    public void reset(int n) {
        this.log();
    }

    public void seekStation(int n) {
        this.log();
    }

    public void switchLinkingDeviceUsage(int n) {
        this.log();
    }

    public void setDeviceService(DSIAMFMTuner dSIAMFMTuner) {
        this.log();
    }

    public void setERTDisplayable(boolean bl) {
        this.log();
    }

    public void setModeHD(int n) {
        this.log();
    }

    public void setERTPrefered(boolean bl) {
        this.log();
    }
}

