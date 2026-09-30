/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.ifc;

import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.ifc.IPowerEvent;
import de.audi.tuner.ifc.IStationListHandler;
import de.audi.tuner.ifc.IStoreStationHandler;

public interface ITunerGUIHandler {
    public IStationListHandler getStationListHandler();

    public IPowerEvent getPoPowerStateListener();

    public boolean tuneById(long var1, int var3);

    public TunerObjectContainer[] getStationList();

    public TunerObjectContainer[] getStationList(int var1);

    public TunerObjectContainer getCurrentStation();

    public void register(IStoreStationHandler var1);
}

