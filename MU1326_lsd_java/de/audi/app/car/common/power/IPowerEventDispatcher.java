/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.power;

import de.audi.app.car.common.power.IPowerEventListener;

public interface IPowerEventDispatcher {
    public void init();

    public void deinit();

    public void addPowerEventListener(IPowerEventListener var1);

    public void removePowerEventListener(IPowerEventListener var1);
}

