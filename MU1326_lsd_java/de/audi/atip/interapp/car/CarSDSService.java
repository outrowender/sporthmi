/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.car;

import de.audi.atip.interapp.car.ICarRemainingRangeListener;

public interface CarSDSService {
    public void addRemainingRangeListener(ICarRemainingRangeListener var1);

    public void removeRemainingRangeListener(ICarRemainingRangeListener var1);
}

