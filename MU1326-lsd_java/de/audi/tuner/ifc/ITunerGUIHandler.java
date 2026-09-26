/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.ifc;

import de.audi.tuner.app.TunerObjectContainer;
import de.audi.tuner.ifc.IPowerEvent;
import de.audi.tuner.ifc.IStationListHandler;
import de.audi.tuner.ifc.IStoreStationHandler;

public interface ITunerGUIHandler {
    default public IStationListHandler getStationListHandler() {
    }

    default public IPowerEvent getPoPowerStateListener() {
    }

    default public boolean tuneById(long l, int n) {
    }

    default public TunerObjectContainer[] getStationList() {
    }

    default public TunerObjectContainer[] getStationList(int n) {
    }

    default public TunerObjectContainer getCurrentStation() {
    }

    default public void register(IStoreStationHandler iStoreStationHandler) {
    }
}

