/*
 * Decompiled with CFR 0.152.
 */
package de.audi.app.car.common.power;

public interface IPowerEventListener {
    public void notifyPowerListenerOnEnterState(int var1);

    public void notifyPowerListenerOnExitState(int var1);

    public void notifyPowerTriggerAction(int var1);

    public void updateClampState(boolean var1, boolean var2, boolean var3, boolean var4);
}

