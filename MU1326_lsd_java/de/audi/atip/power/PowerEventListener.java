/*
 * Decompiled with CFR 0.152.
 */
package de.audi.atip.power;

public interface PowerEventListener {
    default public void notifyPowerListenerOnEnterState(int n, int n2) {
    }

    default public void notifyPowerListenerOnExitState(int n, int n2) {
    }

    default public void notifyPowerTriggerAction(int n, int n2) {
    }

    default public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
    }
}

