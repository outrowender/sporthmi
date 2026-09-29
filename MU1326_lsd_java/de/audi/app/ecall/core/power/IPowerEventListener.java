/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.ecall.core.power;

public interface IPowerEventListener {
    default public void notifyPowerListenerOnEnterState(int n) {
    }

    default public void notifyPowerListenerOnExitState(int n) {
    }

    default public void notifyPowerTriggerAction(int n) {
    }

    default public void updateClampState(boolean bl, boolean bl2, boolean bl3, boolean bl4) {
    }
}

