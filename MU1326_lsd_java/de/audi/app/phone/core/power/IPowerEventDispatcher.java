/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.phone.core.power;

import de.audi.app.phone.core.power.IPowerEventListener;

public interface IPowerEventDispatcher {
    public void init();

    public void deinit();

    public void addPowerEventListener(IPowerEventListener var1);

    public void removePowerEventListener(IPowerEventListener var1);
}

