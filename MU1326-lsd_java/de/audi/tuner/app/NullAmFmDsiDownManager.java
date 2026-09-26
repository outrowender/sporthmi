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

    @Override
    public void isOnPreset(int n, int n2, int n3, String string) {
        this.log();
    }

    @Override
    public void enableRadiotextPlus(int[] nArray) {
        this.log();
    }

    @Override
    public AMFMDsiUpInfo getDsiUpListener() {
        this.log();
        return null;
    }

    @Override
    public void register(RadioInfo radioInfo) {
        this.log();
    }

    @Override
    public void forceAMUpdate(int n) {
        this.log();
    }

    @Override
    public void switchAF(boolean bl) {
        this.log();
    }

    @Override
    public void switchREG(int n) {
        this.log();
    }

    @Override
    public void tuneStation(AMFMStation aMFMStation, boolean bl, boolean bl2, int n) {
        this.log();
    }

    @Override
    public void clearNotification(int[] nArray, DSIListener dSIListener) {
        this.log();
    }

    @Override
    public void setNotification(int[] nArray, DSIListener dSIListener) {
        this.log();
    }

    @Override
    public void reNotification(int n) {
        this.log();
    }

    @Override
    public void switchRDSIgnore(boolean bl) {
        this.log();
    }

    @Override
    public boolean isDsiFound() {
        this.log();
        return false;
    }

    @Override
    public void reset(int n) {
        this.log();
    }

    @Override
    public void seekStation(int n) {
        this.log();
    }

    @Override
    public void switchLinkingDeviceUsage(int n) {
        this.log();
    }

    @Override
    public void setDeviceService(DSIAMFMTuner dSIAMFMTuner) {
        this.log();
    }

    @Override
    public void setERTDisplayable(boolean bl) {
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
}

