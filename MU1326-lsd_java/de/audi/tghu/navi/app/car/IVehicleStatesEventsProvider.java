/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.car;

import de.audi.tghu.navi.app.car.IVehicleStatesObserver;

public interface IVehicleStatesEventsProvider {
    default public void registerListener(IVehicleStatesObserver iVehicleStatesObserver) {
    }

    default public void unregisterListener(IVehicleStatesObserver iVehicleStatesObserver) {
    }
}

