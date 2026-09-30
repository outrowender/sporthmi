/*
 * Decompiled with CFR 0.152.
 */
package de.audi.tghu.navi.app.car.kombi;

import de.audi.tghu.navi.app.car.kombi.ICarKombiObserver;

public interface ICarKombiEventsProvider {
    public void registerListener(ICarKombiObserver var1);

    public void unregisterListener(ICarKombiObserver var1);
}

