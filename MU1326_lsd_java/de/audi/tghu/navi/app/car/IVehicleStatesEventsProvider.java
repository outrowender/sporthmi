/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.car;

import de.audi.tghu.navi.app.car.IVehicleStatesObserver;

public interface IVehicleStatesEventsProvider {
    public void registerListener(IVehicleStatesObserver var1);

    public void unregisterListener(IVehicleStatesObserver var1);
}

