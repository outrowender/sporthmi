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
    public void selectStation(UnifiedStationExt var1, int var2);

    public UnifiedStationExt getActiveStation();

    public void uniSelected(UnifiedStationExt var1, int var2);

    public IStationListHandler getStationListHandler();

    public IPrevNext getPrevNextHandler();

    public void reNotification(int var1);

    public void setSoftlinking(int var1);
}

