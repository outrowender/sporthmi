/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi;

import de.audi.atip.power.PowerEventListener;

public interface IFocusManager {
    public int getFocusedTerminal();

    public PowerEventListener getPowerEventListener();

    public void setActiveApplication(int var1, int var2);
}

