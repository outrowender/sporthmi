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
    public void register(IStoreStationHandler var1);

    public boolean tuneById(long var1, int var3);

    public TunerObjectContainer[] getStationList();

    public void addUpdateListener(IUpdateListener var1);

    public void setSortAlgo(int var1);

    public RadioInfo getDsiUpListener();

    public RadioInfo getDsiDownListener();

    public IPrevNext getPrevNextHandler();

    public AMFMStation getActiveStation();

    public void init(TunerStorage var1);
}

