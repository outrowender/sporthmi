/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.amfm.stationlist;

import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.app.amfm.AMFMStation;
import de.audi.tuner.app.amfm.dsi.RadioInfo;
import de.audi.tuner.app.storage.TunerStorage;
import de.audi.tuner.ifc.IPrevNext;
import de.audi.tuner.ifc.IStoreStationHandler;
import de.audi.tuner.ifc.listener.IUpdateListener;

public interface IAmFmStationList {
    default public void register(IStoreStationHandler iStoreStationHandler) {
    }

    default public boolean tuneById(long l, int n) {
    }

    default public TunerObjectContainer[] getStationList() {
    }

    default public void addUpdateListener(IUpdateListener iUpdateListener) {
    }

    default public void setSortAlgo(int n) {
    }

    default public RadioInfo getDsiUpListener() {
    }

    default public RadioInfo getDsiDownListener() {
    }

    default public IPrevNext getPrevNextHandler() {
    }

    default public AMFMStation getActiveStation() {
    }

    default public void init(TunerStorage tunerStorage) {
    }
}

