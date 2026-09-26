/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm.dsi;

import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.dsi.AMFMDsiUpInfo;
import de.audi.tuner.app.amfm.dsi.RadioInfo;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.radio.DSIAMFMTuner;

public interface IAmFmDsiDownManager {
    default public void isOnPreset(int n, int n2, int n3, String string) {
    }

    default public void enableRadiotextPlus(int[] nArray) {
    }

    default public AMFMDsiUpInfo getDsiUpListener() {
    }

    default public void register(RadioInfo radioInfo) {
    }

    default public void forceAMUpdate(int n) {
    }

    default public void switchAF(boolean bl) {
    }

    default public void switchREG(int n) {
    }

    default public void tuneStation(AMFMStation aMFMStation, boolean bl, boolean bl2, int n) {
    }

    default public void clearNotification(int[] nArray, DSIListener dSIListener) {
    }

    default public void setNotification(int[] nArray, DSIListener dSIListener) {
    }

    default public void reNotification(int n) {
    }

    default public void switchRDSIgnore(boolean bl) {
    }

    default public boolean isDsiFound() {
    }

    default public void reset(int n) {
    }

    default public void seekStation(int n) {
    }

    default public void switchLinkingDeviceUsage(int n) {
    }

    default public void setDeviceService(DSIAMFMTuner dSIAMFMTuner) {
    }

    default public void setERTPrefered(boolean bl) {
    }

    default public void setERTDisplayable(boolean bl) {
    }

    default public void setModeHD(int n) {
    }
}

