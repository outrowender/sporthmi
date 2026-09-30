/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.power;

import de.audi.app.ecall.core.power.IPowerEventListener;

public interface IPowerEventDispatcher {
    public void init();

    public void deinit();

    public void addPowerEventListener(IPowerEventListener var1);

    public void removePowerEventListener(IPowerEventListener var1);
}

