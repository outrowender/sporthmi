/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.hmi;

import de.audi.atip.power.PowerEventListener;

public interface IFocusManager {
    default public int getFocusedTerminal() {
    }

    default public PowerEventListener getPowerEventListener() {
    }

    default public void setActiveApplication(int n, int n2) {
    }
}

