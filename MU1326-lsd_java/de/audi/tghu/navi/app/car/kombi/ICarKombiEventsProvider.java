/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.car.kombi;

import de.audi.tghu.navi.app.car.kombi.ICarKombiObserver;

public interface ICarKombiEventsProvider {
    default public void registerListener(ICarKombiObserver iCarKombiObserver) {
    }

    default public void unregisterListener(ICarKombiObserver iCarKombiObserver) {
    }
}

