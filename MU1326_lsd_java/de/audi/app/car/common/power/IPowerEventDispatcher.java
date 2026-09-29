/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.power;

import de.audi.app.car.common.power.IPowerEventListener;

public interface IPowerEventDispatcher {
    default public void init() {
    }

    default public void deinit() {
    }

    default public void addPowerEventListener(IPowerEventListener iPowerEventListener) {
    }

    default public void removePowerEventListener(IPowerEventListener iPowerEventListener) {
    }
}

