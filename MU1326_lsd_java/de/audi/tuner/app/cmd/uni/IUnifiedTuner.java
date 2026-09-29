/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tuner.app.cmd.uni;

import de.audi.tuner.app.uni.UnifiedStationExt;
import de.audi.tuner.ifc.IPrevNext;
import de.audi.tuner.ifc.ISimpleTuner;
import de.audi.tuner.ifc.IStationListHandler;

public interface IUnifiedTuner
extends ISimpleTuner {
    default public void selectStation(UnifiedStationExt unifiedStationExt, int n) {
    }

    default public UnifiedStationExt getActiveStation() {
    }

    default public void uniSelected(UnifiedStationExt unifiedStationExt, int n) {
    }

    default public IStationListHandler getStationListHandler() {
    }

    default public IPrevNext getPrevNextHandler() {
    }

    default public void reNotification(int n) {
    }

    default public void setSoftlinking(int n) {
    }
}

