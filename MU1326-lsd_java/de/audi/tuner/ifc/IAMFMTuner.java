/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.ifc;

import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.IDoTagging;
import de.audi.tuner.app.amfm.dsi.IAmFmDsiDownManager;
import de.audi.tuner.app.ap.TunerActionProxyListener;
import de.audi.tuner.ifc.IMemoryList;
import de.audi.tuner.ifc.ISimpleTuner;
import de.audi.tuner.ifc.listener.IUpdateListener;

public interface IAMFMTuner
extends ISimpleTuner {
    default public void changeWaveband(int n, TunerObjectContainer tunerObjectContainer, int n2) {
    }

    default public void tuneStation(AMFMStation aMFMStation, boolean bl, boolean bl2, int n) {
    }

    default public AMFMStation getActiveStation() {
    }

    default public AMFMStation getStationWanted() {
    }

    default public AMFMStation getActiveStation(int n) {
    }

    default public void switchAF(boolean bl) {
    }

    default public void switchReg(boolean bl) {
    }

    default public void abortSeek() {
    }

    default public boolean isSeekActive() {
    }

    default public IUpdateListener[] getUpdateListeners(IMemoryList iMemoryList) {
    }

    default public void reNotification(int n) {
    }

    default public TunerActionProxyListener[] getActionProxyListeners() {
    }

    default public IDoTagging getTagging() {
    }

    default public IAmFmDsiDownManager getDsiDownManager() {
    }

    default public void switchHD(boolean bl, boolean bl2) {
    }
}

