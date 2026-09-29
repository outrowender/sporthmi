/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.interapp.car;

import de.audi.atip.interapp.car.ICarRemainingRangeListener;

public interface CarSDSService {
    default public void addRemainingRangeListener(ICarRemainingRangeListener iCarRemainingRangeListener) {
    }

    default public void removeRemainingRangeListener(ICarRemainingRangeListener iCarRemainingRangeListener) {
    }
}

